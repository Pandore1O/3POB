package com.menezes.pob.albergue;

import java.util.List;
import java.util.UUID;

public class Reserva {
	
	private UUID id;
	private UUID idCliente;
	private UUID idVaga;
	
	private String nomeCliente;
	private String cpfCliente;
	
	private int vagaNumQuarto;
	private String vagaPosicao;
	
	public Reserva(UUID idCliente, UUID idVaga, List<Cliente> clientes, List<Vaga> vagas) {
		this.id = UUID.randomUUID();
		this.idCliente = idCliente;
		this.idVaga = idVaga;
		
		for (Cliente cliente : clientes) {
			if (cliente.getId().equals(idCliente)) {
				nomeCliente = cliente.getNome();
				cpfCliente = cliente.getCpf();
			}
		}
		
		for (Vaga vaga : vagas) {
			if (vaga.getId().equals(idVaga)) {
				vagaNumQuarto = vaga.getNumQuarto();
				vagaPosicao = vaga.getPosicao();
			}
		}
	}

	public String toString() {
		return "Dados da reserva" + "\nID: " + id + "\n\nidCliente: " + idCliente + "\nNome do cliente: " + nomeCliente + "\nCPF do cliente: " + cpfCliente + "\n\nidVaga: " + idVaga + "\nNúmero do quarto: " + vagaNumQuarto + "\nPosição da vaga: " + vagaPosicao;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(UUID idCliente) {
		this.idCliente = idCliente;
	}

	public UUID getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(UUID idVaga) {
		this.idVaga = idVaga;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public int getVagaNumQuarto() {
		return vagaNumQuarto;
	}

	public void setVagaNumQuarto(int vagaNumQuarto) {
		this.vagaNumQuarto = vagaNumQuarto;
	}

	public String getVagaPosicao() {
		return vagaPosicao;
	}

	public void setVagaPosicao(String vagaPosicao) {
		this.vagaPosicao = vagaPosicao;
	}
	
	
}
