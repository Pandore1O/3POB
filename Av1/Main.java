package com.menezes.pob.av1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<Produto> produtos = new ArrayList<>();
		
		Scanner scanner = new Scanner(System.in);
		
		int escolha = 0;
		
		do {
			switch(menu()) {
			
				case 1:
					produtos.add(incluirProduto(produtos));
					break;
				
				case 2:
					alterarProduto(produtos);
					break;
					
				case 3:
					excluirProduto(produtos);
					break;
					
				case 4:
					listar(false, produtos);
					break;
					
				case 5:
					listar(true, produtos);
					break;
					
				case 0:
					escolha = -1;
					break;
					
				default:
					System.out.println("Escolha indisponivel, tente novamente.");
					break;
			}
			
		}while(escolha != -1);
		

	}

	public static Produto incluirProduto(List<Produto> produtos) {
		
		//Declaração do Scanner.
		Scanner scanner = new Scanner(System.in);
		
		//Primeira declaração de variaveis.
		int ID;
		String sku, codigoDeBarras;
		
		System.out.println("Informe o ID do produto: ");
		ID = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Informe o SKU do produto(20): ");
		sku = scanner.nextLine();
		
		System.out.println("Informe o código de barras do produto(15): ");
		codigoDeBarras = scanner.nextLine();
		
		//Teste para verificar se já existe um produto com alguma das informações fornecidas.
		for (Produto produto : produtos) {
			if ((produto.getID() == ID) || (produto.getSku().equals(sku)) || (produto.getCodigoDeBarras().equals(codigoDeBarras))) {
				System.out.println("Um dos atributos informados já existe em outro produto. Tente novamente.");
				return null;
			}
		}
		
		//Declaração de variaveis caso tenha passado do teste.
		String nome, descricao, categoria, fabricante;
		double preco, peso;
		
		System.out.println("Informe o nome do produto(50): ");
		nome = scanner.nextLine();
		
		System.out.println("Informe a descrição do produto(200): ");
		descricao = scanner.nextLine();
		
		System.out.println("Informe a categoria do produto(20): ");
		categoria = scanner.nextLine();
		
		System.out.println("Informe o fabricante do produto(50): ");
		fabricante = scanner.nextLine();

		System.out.println("Informe o preço do produto: ");
		preco = scanner.nextDouble();
		
		System.out.println("Informe o peso do produto: ");
		peso = scanner.nextDouble();
		
		return new Produto(ID, codigoDeBarras, sku, nome, descricao, categoria, fabricante, preco, peso);
	}
	
	public static void alterarProduto(List<Produto> produtos) {
		
		//Declaração do scanner.
		Scanner scanner = new Scanner(System.in);
		
		//Declaração de variaveis.
		String sku, escolha;
		Produto produtoEncontrado = null;
		int opcao;
		boolean erro = false;
		
		do {
			System.out.println("Informe o SKU do produto: ");
			sku = scanner.nextLine();
			
			for (Produto produto : produtos) {
				if (produto.getSku().equals(sku)) {
					produtoEncontrado = produto;
				}
			}
			
			System.out.println("O produto encontrado pelo SKU(" + sku + ") é: ");
			System.out.println(produtoEncontrado);
			
			System.out.println("\nDeseja alterar os atributos deste produto? (S/N)");
			escolha = scanner.nextLine();
			
			escolha.toUpperCase();
			
			if (!(escolha.equals("S")) || !(escolha.equals("N"))) {
				System.out.println("Opção indisponivel, tente novamente.");
			}
			
		}while(!escolha.equals("S"));
		
		if (produtoEncontrado == null) {
			System.out.println("Não existe produto com o SKU informado. Tente novamente.");
		}
		else {
			
			do {
				System.out.println("Informe o que deseja alterar no produto\n"
						+ "1 - Código de barras do produto\n"
						+ "2 - Nome do produto\n"
						+ "3 - Descrição do produto\n"
						+ "4 - Categoria do produto\n"
						+ "5 - Fabricante do produto\n"
						+ "6 - Preço do produto\n"
						+ "7 - Peso do produto\n"
						+ "0 - Sair");
				
				opcao = scanner.nextInt();
				
				switch(opcao) {
					case 1:
						String novoCodigoDeBarras;
					
						do {
							System.out.println("Informe o código de barras novo: ");
							novoCodigoDeBarras = scanner.nextLine();
						
							for (Produto produto : produtos) {
								if (produto.getCodigoDeBarras().equals(novoCodigoDeBarras)) {
									System.out.println("Código de barras informado já existe em outro produto. Tente novamente.");
									erro = true;
									break;
								}
							}
						}while(!erro);
					
						produtoEncontrado.setCodigoDeBarras(novoCodigoDeBarras);
						break;
				
					case 2:
						
						String novoNome, decisao;
						
						do {
							System.out.println("Informe o nome novo: ");
							novoNome = scanner.nextLine();
							
							for (Produto produto : produtos) {
								if (produto.getNome().equals(novoNome)) {
									System.out.println("O nome informado ja existe em outro produto, deseja continuar mesmo assim? (S/N)");
									decisao = scanner.nextLine().toUpperCase();
									
									do {
										if (!(decisao.equals("S")) || !(decisao.equals("N"))) {
											System.out.println("Opção invalida, tente novamente.");
										}
										else {
											if (decisao.equals("N")) {
												break;
											}
										}
									
									}while(!(decisao.equals("S")));
									break;
								}
							}
							
						}while(!erro);
						
						produtoEncontrado.setNome(novoNome);
						break;
					
					case 3:
						
						String novaDescricao;
						
						System.out.println("Informe a nova descrição: ");
						novaDescricao = scanner.nextLine();
						
						produtoEncontrado.setDescricao(novaDescricao);
						break;
					
					case 4:
						
						String novaCategoria;
						
						System.out.println("Informe a nova categoria: ");
						novaCategoria = scanner.nextLine();
						
						produtoEncontrado.setCategoria(novaCategoria);
						break;
						
					case 5:
						
						String novoFabricante;
						
						System.out.println("Informe o novo fabricante: ");
						novoFabricante = scanner.nextLine();
						
						produtoEncontrado.setFabricante(novoFabricante);
						break;
						
					case 6:
						
						double novoPreco;
						
						System.out.println("Informe o novo preço: ");
						novoPreco = scanner.nextDouble();
						
						produtoEncontrado.setPreco(novoPreco);
						break;
						
					case 7:
						
						double novoPeso;
						
						System.out.println("Informe o novo peso: ");
						novoPeso = scanner.nextDouble();
						
						produtoEncontrado.setPeso(novoPeso);
						break;
					
					case 0:
						opcao = 0;
						break;
						
					default:
						System.out.println("Opção invalida, tente novamente.");
						break;
					
				}
			}while(opcao != 0);
		}
	}
	
	public static void excluirProduto(List<Produto> produtos) {
		
		Scanner scanner = new Scanner(System.in);
		
		String sku;
		int index;
		boolean removido = false;
		
		do {
			System.out.println("Informe o SKU do produto a ser removido(Ou 'Sair' para retornar ao menu): ");
			sku = scanner.nextLine();
			
			for (Produto produto : produtos) {
				if (produto.getSku().equals(sku)) {
					index = produtos.indexOf(produto);
					produtos.remove(index);
					removido = true;
					break;
				}
			}
			
			if (removido) {
				System.out.println("Produto removido com sucesso.");
			}
			else {
				System.out.println("SKU informado não existe na lista de produtos.");
			}
			
		}while(!(sku.toUpperCase().equals("SAIR")) && (!removido));
		
	}
	
	public static void listar(boolean unico, List<Produto> produtos) {
		
		
		if (unico) {
			
			Scanner scanner = new Scanner(System.in);
			
			String sku;
			
			System.out.println("Informe o SKU do produto a ser exibido: ");
			sku = scanner.nextLine();
			
			for (Produto produto : produtos) {
				if (produto.getSku().equals(sku)) {
					System.out.println(produto);
					break;
				}
			}
		}
		else {
			System.out.println(Arrays.toString(produtos.toArray()));
		}
	}
	
	private static int menu() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1 - Incluir produto");
		System.out.println("2 - Alterar produto");
		System.out.println("3 - Excluir produto");
		System.out.println("4 - Listar todos os produtos");
		System.out.println("5 - Listar um produto");
		System.out.println("0 - Sair");
		
		return scanner.nextInt();
	}
}
