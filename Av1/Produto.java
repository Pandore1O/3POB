package com.menezes.pob.av1;

public class Produto {
	
	private int ID;
	private String codigoDeBarras;
	private String sku;
	private String nome;
	private String descricao;
	private String categoria;
	private String fabricante;
	private double preco;
	private double peso;
	
	public Produto(int iD, String codigoDeBarras, String sku, String nome, String descricao, String categoria, String fabricante, double preco, double peso) {
	
		ID = iD;
		this.codigoDeBarras = codigoDeBarras;
		this.sku = sku;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.fabricante = fabricante;
		this.preco = preco;
		this.peso = peso;
	}
	
	public String toString() {
		return 	"\nID: " + this.ID + 
				"\nSKU: " + this.sku + 
				"\nNome: " + this.nome + 
				"\nDescrição: " + this.descricao + 
				"\nCategoria: " + this.categoria + 
				"\nFabricante: " + this.fabricante + 
				"\nPreço: R$" + this.preco + 
				"\nPeso: " + this.peso + "KG\n";
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}
}
