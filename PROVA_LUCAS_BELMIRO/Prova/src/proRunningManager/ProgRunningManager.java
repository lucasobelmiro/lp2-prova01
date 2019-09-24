package proRunningManager;

public class ProgRunningManager {
	
	Corrida[] corridas;

	public ProgRunningManager() {
		this.corridas = new Corrida[50];
	}

	public void cadastrarCorrida(String nomeCorrida, String data, int qtdParticipantes) {
		Corrida corrida = new Corrida(data, nomeCorrida, qtdParticipantes);
		for (int i = 0; i < corridas.length; i++) {
			if(corridas[i] == null) {
				corridas[i] = corrida;
			}
		}
	}
	
	public int cadastrarChipCorrida(String nomeCorrida) {
		int id = 0;
		for (int i = 0; i < corridas.length; i++) {
			if(corridas[i].getNomeCorrida().equals(nomeCorrida)) {
				id = corridas[i].cadastrarChip();
			}
		}
		return id;
	}
	
	public String listarCorrida(String nomeCorrida) {
		String nome = "";
		for (int i = 0; i < corridas.length; i++) {
			if(corridas[i].getNomeCorrida().equals(nomeCorrida)) {
				nome = corridas[i].toString();
			}
		}
		return nome;
	}
	
	public int contarChipsCorrida(String nomeCorrida) {
		int cont = 0;
		for (int i = 0; i < corridas.length; i++) {
			if(corridas[i].getNomeCorrida().equals(nomeCorrida)){
				cont = corridas[i].contarChips();
			}
		}
		return cont;
	}
	
	public String exibirCorredor(String nomeCorrida, int codigoChip) {
		String nome = "";
		for (int i = 0; i < corridas.length; i++) {
			if(corridas[i].getNomeCorrida().equals(nomeCorrida)) {
				nome = corridas[i].exibeCorredor(codigoChip);
			}
		}
		return nome;
	}
	
	public void atualizaChipDistanciaTempo(String nomeCorrida, int codigoChip, int distanciaKm, int tempoMin) {
		for (int i = 0; i < corridas.length; i++) {
			if(corridas[i].getNomeCorrida().equals(nomeCorrida)) {
				corridas[i].atualizaChipDistanciaTempo(codigoChip, distanciaKm, tempoMin);
			}
		}
	}
	
	public void finalizaCorrida(String nomeCorrida) {
		for (int i = 0; i < corridas.length; i++) {
			if(corridas[i].equals(nomeCorrida)) {
				corridas[i].finalizaCorrida();
			}
		}
	}
	
	public int menorTempoCorrida(String nomeCorrida) {
		int menorTempo = 0;
		for (int i = 0; i < corridas.length; i++) {
			if(corridas[i].getNomeCorrida().equals(nomeCorrida)) {
				menorTempo = corridas[i].menorTempo();
			}
		}
		return menorTempo;
	}
	
	public int vencedorCorrida(String nomeCorrida) {
		int saida = -1;
		for (int i = 0; i < corridas.length; i++) {
			if(corridas[i].getNomeCorrida().equals(nomeCorrida)) {
				if(corridas[i].getStatus().equals("NAO_CONCLUIDA")) {
					saida = -1;
				}
				else {
					saida = corridas[i].vencedorCorrida();
				}
			}
		}
		return saida;
	}
}
