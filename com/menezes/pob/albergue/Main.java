package com.menezes.pob.albergue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		List<Cliente> clientes = new ArrayList<>();
		List<Vaga> vagas = new ArrayList<>();
		List<Reserva> reservas = new ArrayList<>();
		
		int escolha = 0;
		
		do {
			escolha = menu();
			
			switch (escolha) {
				
				case 1:
					clientes.add(cadastrarCliente());
					break;
					
				case 2:
					vagas.add(cadastrarVaga());
					break;
					
				case 3:
					reservas.add(cadastrarReserva(clientes, vagas));
					break;
					
				case 4:
					listar(clientes);
					break;
					
				case 5:
					listar(vagas);
					break;
					
				case 6:
					listar(reservas);
					break;
					
				case 7:
					removerCliente(clientes, reservas);
					break;
					
				case 8:
					removerVaga(vagas, reservas);
					break;
					
				case 9:
					removerReserva(reservas);
					break;
					
				case 10:
					escolha = -1;
					break;
					
				default:
					System.out.println("\nEscolha indisponivel.");
					break;
			}
		}while (escolha != -1);
	}
	
	public static Cliente cadastrarCliente() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite o nome completo do cliente: ");
		String nome = scanner.nextLine();
		
		System.out.println("Digite o CPF do cliente: ");
		String cpf = scanner.nextLine();
		
		System.out.println("Digite o E-Mail do cliente: ");
		String email = scanner.nextLine();
		
		System.out.println("Digite o telefone do cliente: ");
		String telefone = scanner.nextLine();
		
		System.out.println("Digite o endereço do cliente: ");
		String endereco = scanner.nextLine();
		
		return new Cliente(nome, cpf, email, telefone, endereco);
	}
	
	public static Vaga cadastrarVaga() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Informe a posição da vaga: ");
		String posicao = scanner.nextLine();
		
		System.out.println("Informe o status da vaga: ");
		String status = scanner.nextLine();
		
		System.out.println("Informe o tipo de cama da vaga: ");
		String tipoCama = scanner.nextLine();
		
		System.out.println("Informe o número do quarto onde está localizada a vaga: ");
		int numQuarto = scanner.nextInt();
		
		return new Vaga(posicao, status, tipoCama, numQuarto, true);
	}
	
	public static Reserva cadastrarReserva(List<Cliente> clientes, List<Vaga> vagas) {
		
		Scanner scanner = new Scanner(System.in);

		Cliente[] clientesEncontrados = new Cliente[1];
		Cliente clienteEncontrado = null;
		Vaga vagaEncontrada = null;
		
		String identificacao, posicao;
		int numQuarto, i = 0;
		boolean error = true;
		
		do {
			System.out.println("Informe o nome ou CPF do cliente: ");
			identificacao = scanner.nextLine();
			
			System.out.println("Informe o número do quarto: ");
			numQuarto = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Informe a posição da vaga: ");
			posicao = scanner.nextLine();
			
			for (Vaga vaga: vagas) {
				if ((vaga.getNumQuarto() == numQuarto) && (vaga.getPosicao().equals(posicao)) && (vaga.isDisponivel() == false)) {
					System.out.println("\nCama indisponivel, tente outra.");
				} else {
					error = false;
					vagaEncontrada = vaga;
				}
			}
			
		}while(error == true);
		
		for (Cliente cliente : clientes) {
			if (cliente.getNome().equals(identificacao) || cliente.getCpf().equals(identificacao)) {
				if (i == clientesEncontrados.length) {
					clientesEncontrados = Arrays.copyOf(clientesEncontrados, clientesEncontrados.length + 1);
					clientesEncontrados[i] = cliente;
					i++;
				} else {
					clientesEncontrados[i] = cliente;
					i++;
				}
			}
		}
	
		if (clientesEncontrados[0] == null) {
			System.out.println("Cliente não encontrado.");
			return null;
		} else {
			
			if (clientesEncontrados.length > 1) {
				System.out.println(Arrays.toString(clientesEncontrados));
				
				System.out.println("\nInforme o CPF de qual cliente será atrelado a vaga: ");
				String cpfEscolhido = scanner.nextLine();
				
				for (Cliente cliente : clientesEncontrados) {
					if (cliente.getCpf().equals(cpfEscolhido)) {
						clienteEncontrado = cliente;
					}
				}
			} else {
				clienteEncontrado = clientesEncontrados[0];
			}
		}
		return new Reserva(clienteEncontrado.getId(), vagaEncontrada.getId(), clientes, vagas);
	}
	
	public static <T>void listar(List<T> lista) {
		System.out.println("\n" + Arrays.toString(lista.toArray()));
	}
	
	public static void removerCliente(List<Cliente> clientes, List<Reserva> reservas) {
		
		Scanner scanner = new Scanner(System.in);
		String cpf;
		boolean achado = false;
		boolean reservado = false;
		
		Cliente clienteAchado = null;
		
		do {
			System.out.println("Informe o CPF do cliente: ");
			cpf = scanner.nextLine();
			
			if (cpf.equals("sair")) {
				break;
			}
			
			for (Cliente cliente : clientes) {
				if (cliente.getCpf().equals(cpf)) {
					achado = true;
					
					clienteAchado = cliente;
					
					for (Reserva reserva : reservas) {
						if (reserva.getCpfCliente().equals(cpf)) {
							reservado = true;
						}
					}
					break;
				} 
			}
			
			if (!achado) {
				System.out.println("CPF não encontrado na lista de cadastros. Tente novamente.");
			} else {
				if (reservado) {
					System.out.println("Este CPF está em uma reserva, remova a reserva primeiro.");
				} else {
					System.out.println("Cliente removido.");
					clientes.remove(clienteAchado);
				}
			}
			
		}while(!achado || reservado);
	}
	
	public static void removerVaga(List<Vaga> vagas, List<Reserva> reservas) {
		
		Scanner scanner = new Scanner(System.in);
		
		String posicao;
		int numQuarto;
		boolean achado = false;
		boolean reservado = false;
		
		Vaga vagaAchada = null;
		
		do {
			System.out.println("Informe o número de quarto: ");
			numQuarto = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Informe a posição da cama");
			posicao = scanner.nextLine();
			
			if (posicao.equals("sair")) {
				break;
			}
			
			for (Vaga vaga : vagas) {
				if ((vaga.getNumQuarto() == numQuarto) && (vaga.getPosicao().equals(posicao))) {
					achado = true;
					
					vagaAchada = vaga;
					
					for (Reserva reserva : reservas) {
						if ((reserva.getVagaNumQuarto() == numQuarto) && (reserva.getVagaPosicao().equals(posicao))) {
							reservado = true;
						}
					}
				}
			}
			
			if (!achado) {
				System.out.println("Vaga não encontrada na lista de vagas. Tente novamente.");
			} else {
				if (reservado) {
					System.out.println("Está vaga está reservada, remova a reserva primeiro.");
				} else {
					System.out.println("Vaga removida.");
					vagas.remove(vagaAchada);
				}	
			}
			
		}while (!achado);
	}
	
	public static void removerReserva(List<Reserva> reservas) {
		
		Scanner scanner = new Scanner(System.in);
		
		String posicao, cpf;
		int numQuarto;
		boolean achado = false;
		
		Reserva reservaEncontrada = null;
		
		do {
			System.out.println("Informe o CPF do cliente: ");
			cpf = scanner.nextLine();
			
			System.out.println("Informe o número do quarto:");
			numQuarto = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println("Informe a posição da cama: ");
			posicao = scanner.nextLine();
			
			if ((posicao.equals("sair")) || (cpf.equals("sair"))) {
				break;
			}
			
			for (Reserva reserva : reservas) {
				if ((reserva.getCpfCliente().equals(cpf)) && (reserva.getVagaNumQuarto() == numQuarto) && (reserva.getVagaPosicao().equals(posicao))) {
					reservaEncontrada = reserva;
					achado = true;
					break;
				}
			}
			
			if (!achado) {
				System.out.println("Reserva não encontrada na lista de reservas. Tente novamente.");
			} else {
				System.out.println("Reserva removida.");
				reservas.remove(reservaEncontrada);
			}
		}while (!achado);
	}
	
	private static int menu() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\n1 - Cadastrar Cliente");
		System.out.println("2 - Cadastrar Vaga");
		System.out.println("3 - Cadastrar Reserva");
		System.out.println("4 - Listar Clientes");
		System.out.println("5 - Listar Vagas");
		System.out.println("6 - Listar Reservas");
		System.out.println("7 - Remover Cliente");
		System.out.println("8 - Remover Vaga");
		System.out.println("9 - Remover Reserva");
		System.out.println("10 - Sair");
		
		return scanner.nextInt();
	}
}
