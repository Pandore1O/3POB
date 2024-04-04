package br.com.pob;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String nome;
		String matricula;
		String cpf;
		String email;
		
		Aluno aluno = new Aluno("Felipe", "23104708360029", "13334456789", "felipe@email.com");
		Aluno aluno2 = new Aluno("", "", "", "");
		
		Disciplina disciplina = new Disciplina("Programação orientada a objetos basica", "3POB", "40", "3");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Olá, mundo");
		
		System.out.println("\nDados do aluno: ");
		System.out.println(aluno.getNome());
		System.out.println(aluno.getMatricula());
		System.out.println(aluno.getCpf());
		System.out.println(aluno.getEmail());
		
		System.out.println("\nDados da disciplina:");
		
		System.out.println(disciplina.getNome());
		System.out.println(disciplina.getSigla());
		System.out.println(disciplina.getCargaHoraria());
		System.out.println(disciplina.getSemestre());
		
		System.out.println("\nDigite o nome do aluno: ");
		aluno2.setNome(scanner.next());
		
		System.out.println("\nDigite a matricula do aluno: ");
		aluno2.setMatricula(scanner.next());
		
		System.out.println("\nDigite o cpf do aluno: ");
		aluno2.setCpf(scanner.next());
		
		System.out.println("\nDigite o email do aluno: ");
		aluno2.setEmail(scanner.next());
		
		System.out.println("\nDados do segundo aluno: ");
		System.out.println(aluno2.getNome());
		System.out.println(aluno2.getMatricula());
		System.out.println(aluno2.getCpf());
		System.out.println(aluno2.getEmail());
	}

}
