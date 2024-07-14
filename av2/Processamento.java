package com.menezes.pob.av2;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Processamento {

	public String[][] lerArquivo (String caminhoArquivo) {
		
		List<String[]> linhas = new ArrayList<>();
		
		File arquivo = new File(caminhoArquivo);
		
		try (Scanner scanner = new Scanner(arquivo)) {
			while (scanner.hasNextLine()) {
				
				String linha = scanner.nextLine();
				
				if (linha.equals("nome;cpf;email;endereco;cep")) {
					continue;
				}
				
				String[] dados = linha.split(";");
				linhas.add(dados);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return linhas.toArray(new String[0][0]);
	}
	
	public void incluirClientesPorArquivo () {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		try {
			Connection connection = connectionFactory.createConnection();
			Scanner scanner = new Scanner(System.in);
			
			String[][] dados;
			
			System.out.println("Insira a localização do arquivo(exemplo: C:\\caminho\\do\\arquivo.txt)");
			String caminhoArquivo = scanner.nextLine();
			
			dados = lerArquivo(caminhoArquivo);
			
			for (String[] linha : dados) {
				
				String sql = "INSERT INTO clientes (nome, cpf, email, endereco, cep) VALUES (?, ?, ?, ?, ?)";
				
				try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
					
					pstmt.setString(1, linha[0]);
					pstmt.setString(2, linha[1]);
					pstmt.setString(3, linha[2]);
					pstmt.setString(4, linha[3]);
					pstmt.setString(5, linha[4]);
					pstmt.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void incluirCliente() {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		try {
			Connection connection = connectionFactory.createConnection();
			Scanner scanner = new Scanner(System.in);
			
			String[] dados = new String[5];
			
			System.out.println("Informe o nome do cliente: ");
			dados[0] = scanner.nextLine();
			
			System.out.println("\nInforme o CPF do cliente: ");
			dados[1] = scanner.nextLine();
			
			System.out.println("\nInforme o E-Mail do cliente: ");
			dados[2] = scanner.nextLine();
			
			System.out.println("\nInforme o endereco do cliente: ");
			dados[3] = scanner.nextLine();
			
			System.out.println("\nInforme o CEP do cliente: ");
			dados[4] = scanner.nextLine();
			
			String sql = "INSERT INTO clientes VALUES (?, ?, ?, ?, ?)";
			
			try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
				pstmt.setString(1, dados[0]);
				pstmt.setString(2, dados[1]);
				pstmt.setString(3, dados[2]);
				pstmt.setString(4, dados[3]);
				pstmt.setString(5, dados[4]);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarCliente() {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		Scanner scanner = new Scanner(System.in);
		
		String cpf, escolha = null;
		do {
			System.out.println("Informe o CPF do cliente: ");
			cpf = scanner.nextLine();
			
			String sql = "SELECT nome FROM clientes where id = ?";
			String nome = null;
			
			try {
				Connection connection = connectionFactory.createConnection();
				PreparedStatement pstmt = connection.prepareStatement(sql);
				
				pstmt.setString(1, cpf);
				ResultSet resultSet = pstmt.executeQuery();
				
				if (resultSet.next()) {
					nome = resultSet.getString("nome");
				}
				
				System.out.printf("O cliente com o CPF (%s) se chama %s, deseja continuar? (S/N)", cpf, nome);
				escolha = scanner.nextLine().toUpperCase();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}while (!escolha.equalsIgnoreCase("S"));
		
		int opcao;
		
		do {
			System.out.println("Informe o que deseja alterar no cliente\n"
					+ "1 - Alterar nome\n"
					+ "2 - Alterar CPF\n"
					+ "3 - Alterar E-Mail\n"
					+ "4 - Alterar endereço\n"
					+ "5 - Alterar CEP"
					+ "0 - Sair");
				
			opcao = Integer.parseInt(scanner.nextLine());
			
			switch (opcao) {
			
			case 0:
				break;
				
			case 1:
				System.out.println("Informe o novo nome:");
				String novoNome = scanner.nextLine();
				
				try {
					Connection connection = connectionFactory.createConnection();
					
					String sql = "UPDATE clientes SET nome = ? WHERE cpf = ?";
					
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, novoNome);
					pstmt.setString(2, cpf);
					pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case 2:
				System.out.println("Mudar o CPF fará com que volte para o menu.");
				System.out.println("Informe o novo CPF:");
				String novoCpf = scanner.nextLine();
				
				try {
					Connection connection = connectionFactory.createConnection();
					
					String sql = "UPDATE clientes SET cpf = ? WHERE cpf = ?";
					
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, novoCpf);
					pstmt.setString(2, cpf);
					pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				opcao = 0;
				break;
				
			case 3:	
				System.out.println("Informe o novo E-Mail:");
				String novoEmail = scanner.nextLine();
				
				try {
					Connection connection = connectionFactory.createConnection();
					
					String sql = "UPDATE clientes SET email = ? WHERE cpf = ?";
					
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, novoEmail);
					pstmt.setString(2, cpf);
					pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case 4:
				System.out.println("Informe o novo endereço:");
				String novoEndereco = scanner.nextLine();
				
				try {
					Connection connection = connectionFactory.createConnection();
					
					String sql = "UPDATE clientes SET endereco = ? WHERE cpf = ?";
					
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, novoEndereco);
					pstmt.setString(2, cpf);
					pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case 5:
				System.out.println("Informe o novo CEP:");
				String novoCep = scanner.nextLine();
				
				try {
					Connection connection = connectionFactory.createConnection();
					
					String sql = "UPDATE clientes SET cep = ? WHERE cpf = ?";
					
					PreparedStatement pstmt = connection.prepareStatement(sql);
					pstmt.setString(1, novoCep);
					pstmt.setString(2, cpf);
					pstmt.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
		}while(opcao != 0);
	}
	
	public void excluirCliente() {
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe o CPF do cliente:");
		String cpf = scanner.nextLine();
		
		try {
			Connection connection = connectionFactory.createConnection();
			
			String sql = "DELETE FROM clientes WHERE cpf = ?";
			
			PreparedStatement pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, sql);
			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listarClientes() {
		
		List<String[]> dados = new ArrayList<>();
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		try {
			Connection connection = connectionFactory.createConnection();
			Statement stmt = connection.createStatement();
			
			String sql = "SELECT id, nome, cpf, email, endereco, cep FROM clientes";
			
			ResultSet resultSet = stmt.executeQuery(sql);
			
			while (resultSet.next()) {
				
				String[] dado = {String.valueOf(resultSet.getInt("id")), resultSet.getString("nome"), resultSet.getString("cpf"), resultSet.getString("email"), resultSet.getString("endereco"), resultSet.getString("cep")};
				dados.add(dado);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String[][] clientes = dados.toArray(new String[0][0]);
		
		for (String[] cliente : clientes) {
			System.out.printf("\nID: %s", cliente[0]);
			System.out.printf("\nNome: %s", cliente[1]);
			System.out.printf("\nCPF: %s", cliente[2]);
			System.out.printf("\nE-Mail: %s", cliente[3]);
			System.out.printf("\nEndereço: %s", cliente[4]);
			System.out.printf("\nCEP: %s\n", cliente[5]);
		}
	}
}

