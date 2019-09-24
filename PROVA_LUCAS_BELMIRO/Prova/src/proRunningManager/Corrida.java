package proRunningManager;

public class Corrida {

	private String data;
	private String nomeCorrida;
	private int qtdParticipantes;
	private String status;
	private Chip[] chips;

	public Corrida(String data, String nome, int qtdParticipantes) {
		super();
		this.data = data;
		this.nomeCorrida = nome;
		this.chips = new Chip[qtdParticipantes];
		this.status = "NAO_CONCLUIDA";
	}

	private String mensagem() {
		String lista = "";
		for (Chip chip : chips) {
			lista += "\n" + chip.getId();
		}
		if (lista.equals("")) {
			return "Sem chips cadastrados";
		} else {
			return lista;
		}
	}

	public int cadastrarChip() {
		int id = 0;
		for (int i = 0; i < chips.length; i++) {
			if (chips[i] == null) {
				id = i + 1;
				chips[i] = new Chip(id);
			}
		}
		return id;
	}

	public int contarChips() {
		int cont = 0;
		for (int i = 0; i < chips.length; i++) {
			if (chips[i] != null) {
				cont++;
			}
		}
		return cont;
	}

	public String exibeCorredor(int id) {
		String exibe = "";
		for (int i = 0; i < chips.length; i++) {
			if (chips[i].getId() == id) {
				exibe = chips[i].toString();
			}
		}
		return exibe;
	}

	public String getNomeCorrida() {
		return this.nomeCorrida;
	}

	public void atualizaChipDistanciaTempo(int codigoChip, int distanciaKm, int tempoMin) {
		for (int i = 0; i < chips.length; i++) {
			if (chips[i].getId() == codigoChip) {
				chips[i].setDistancia(distanciaKm);
				chips[i].setTempo(tempoMin);
			}
		}
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void finalizaCorrida() {
		this.status = "CONCLUIDA";
	}

	@Override
	public String toString() {
		mensagem();
		return this.nomeCorrida + " - " + this.data + " - " + this.status + this.mensagem();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeCorrida == null) ? 0 : nomeCorrida.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Corrida other = (Corrida) obj;
		if (nomeCorrida == null) {
			if (other.nomeCorrida != null)
				return false;
		} else if (!nomeCorrida.equals(other.nomeCorrida))
			return false;
		return true;
	}

	public int vencedorCorrida() {
		int vencedor = 0;
		for (int i = 0; i < chips.length; i++) {
			int menorTempo = 1000;
			if (chips[i].getTempo() < menorTempo) {
				menorTempo = chips[i].getTempo();
				vencedor = chips[i].getId();
			}
		}
		return vencedor;
	}

	public int menorTempo() {
		int menorTempo = 1000;
		for (int i = 0; i < chips.length; i++) {
			if (chips[i].getTempo() < menorTempo) {
				menorTempo = chips[i].getTempo();
			}
		}
		return menorTempo;
	}
	
}
