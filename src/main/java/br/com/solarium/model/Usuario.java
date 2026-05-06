package br.com.solarium.model;

public class Usuario {
	
	private int id;
	private String nome;
	private String email;
	
	public Usuario(int id, String nome, String email) {
		this.id = id;
		this.email = email;
		this.nome = nome;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}

}
