package br.com.solarium.model;

public class Anuncio {
	private int idAnuncio;
	private int idUsuario;
	private String titulo;
	private double preco;
	private String imagem;
	private String tipo;
	
	public Anuncio(int idAnuncio, int idUsuario, String titulo, double preco, String imagem, String tipo) {
		this.idAnuncio = idAnuncio;
		this.idUsuario = idUsuario;
		this.titulo = titulo;
		this.preco = preco;
		this.imagem = imagem;
		this.tipo = tipo;
	}
	
	public int getIdAnuncio() {
		return idAnuncio;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public double getPreco() {
		return preco;
	}
	public String getImagem() {
		return imagem;
	}
	
	public String getTipo() {
		return tipo;
	}
}
