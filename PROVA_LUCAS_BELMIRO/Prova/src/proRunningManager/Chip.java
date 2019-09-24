package proRunningManager;

public class Chip {
	
	private int id;
	private int distancia;
	private int tempo;
	
	public Chip(int id) {
		this.id = id;
		this.distancia = 0;
		this.tempo = 0;
	}
	
	public int velocidadeMedia() {
		return this.distancia / this.tempo;
	}
	
	@Override
	public String toString() {
		return this.id + " - " + this.distancia + " - " + this.tempo;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getTempo() {
		return this.tempo;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public void setTempo (int tempo) {
		this.tempo = tempo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Chip other = (Chip) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
