package com.menezes.pob.albergue;

import java.util.UUID;

public class Vaga {
	
	private UUID id;
	
	private String posicao;
	private String status;
	private String tipoCama;
	
	private int numQuarto;
	
	private boolean disponivel;
	
	public Vaga(String posicao, String status, String tipoCama, int numQuarto, boolean disponivel) {
		this.id = UUID.randomUUID();
		this.posicao = posicao;
		this.status = status;
		this.tipoCama = tipoCama;
		this.numQuarto = numQuarto;
		this.disponivel = disponivel;
	}
	
	public String toString() {
		
		return "Dados da vaga" + "\nID: " + id + "\nPosição: " + posicao + "\nStatus: " + status + "\nTipo da cama: " + tipoCama + "\nNúmero do quarto: " + numQuarto + "\nDisponibilidade do quarto: " + disponivel;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTipoCama() {
		return tipoCama;
	}

	public void setTipoCama(String tipoCama) {
		this.tipoCama = tipoCama;
	}

	public int getNumQuarto() {
		return numQuarto;
	}

	public void setNumQuarto(int numQuarto) {
		this.numQuarto = numQuarto;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponinilidade(boolean disponivel) {
		this.disponivel = disponivel;
	}
	
	
}
