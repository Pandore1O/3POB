package com.menezes.pob.av2;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		Scanner scanner = new Scanner(System.in);
		Processamento processamento = new Processamento();
		int opcao = 0;
		
		do {
			System.out.println("Escolha uma opção:\n"
					+ "1 - Incluir cliente via arquivo\n"
					+ "2 - Incluir cliente\n"
					+ "3 - Alterar cliente\n"
					+ "4 - Excluir cliente\n"
					+ "5 - Listar clientes\n"
					+ "0 - Sair");
			
			opcao = Integer.parseInt(scanner.nextLine());
			
			switch (opcao) {
			
			case 1:
				processamento.incluirClientesPorArquivo();
				break;
				
			case 2:
				processamento.incluirCliente();
				break;
			
			case 3:
				processamento.alterarCliente();
				break;
				
			case 4:
				processamento.excluirCliente();
				break;
				
			case 5:
				processamento.listarClientes();
				break;
				
			case 0:
				break;
			}
			
		} while (opcao != 0);
		
		
	}
}
