package com.menezes.pob.albergue;

import java.util.UUID;

public class Cliente {
	
	private UUID id;
	
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String endereco; 
	
	public Cliente(String nome, String cpf, String email, String telefone, String endereco) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}
	
	public String toString() {
		
		return "Dados do cliente" + "\nID: " + id + "\nNome: " + nome + "\nCPF: " + cpf + "\nE-Mail: " + email + "\nTelefone: " + telefone + "\nEndereço: " + endereco;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}
