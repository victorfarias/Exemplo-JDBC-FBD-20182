package br.ufc.quixada.entity;

public class Contato {
	private int id;
	private String cpf;
	
	public Contato(int id, String cpf) {
		this.id = id;
		this.cpf = cpf;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
