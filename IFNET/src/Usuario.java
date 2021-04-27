package ifnet;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Usuario {
	
	private String nome;
	private String prontuario;
	private String senha;
	
	static Scanner leitura = new Scanner(System.in);
	
	public Usuario(String nome, String prontuario, String senha) {
		this.nome = nome;
		this.prontuario = prontuario;
		this.senha = senha;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome() {
		
		String nome;
		
		System.out.println("Nome Atual: " + this.getNome());
		System.out.print("Novo nome: ");
		nome = leitura.nextLine();
		
		System.out.println("Nome alterado");
		
		this.nome = nome;
	}
	
	public String getProntuario() {
		return prontuario;
	}
	
	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}
	
	public String getSenha() {
		return senha;	
	}

	public void setSenha() {
		
		String senha;
		
		System.out.println("Senha Atual: " + this.getSenha());
		System.out.print("Novo senha: ");
		senha = leitura.nextLine();
		
		this.senha = senha;
		
	}
	
	/*
	realiza o cadastro do usuário, a partir do inserção das 
	informações do usuário, dependendo do tipo do usuário
	*/
	public static Usuario cadastrarUsuario() {
		
		Usuario novoUsuario;
		String nome, prontuario, senha, area, disciplina, email, curso;
		int tipo = 0;
		
		do {
			System.out.println("Você é Aluno ou Professor?\n1 - Aluno\n2 - Professor");
			tipo = Integer.parseInt(leitura.nextLine());
		} while(tipo != 1 && tipo != 2);
		
		System.out.print("Informe o nome: ");
		nome = leitura.nextLine();
		
		System.out.print("Informe o prontuário: ");
		prontuario = leitura.nextLine();
		
		System.out.print("Informe a senha: ");
		senha = leitura.nextLine();
		
		if(tipo == 2) {
			
			System.out.print("Informe a área: ");
			area = leitura.nextLine();
			
			System.out.print("Informe a disciplina: ");
			disciplina = leitura.nextLine();
			
			novoUsuario = new Professor(nome, prontuario, senha,
					new Area(area), new Disciplina(disciplina));
		} else {
			
			System.out.print("Informe o e-mail: ");
			email = leitura.nextLine();
			
			System.out.print("Informe o curso: ");
			curso = leitura.nextLine();
			
			novoUsuario = new Aluno(nome, prontuario, senha, email, new Curso(curso));
		}
		
		System.out.println("Cadastro realizado com sucesso!");
		
		return novoUsuario;
	}
	
	//excluir o usuário a partir do recebimento do array de usuários e o usuário a ser excluido
	public static boolean excluirUsuario(ArrayList<Usuario> usuarios, Usuario usuario) {
		
		boolean excluido = false;
		int opcao;
		
		do {
			
			System.out.println("Você tem certeza que deseja excluir a sua conta? "
					+ "Essa ação não pode ser desfeita\n1.Sim\n2.Não");
			opcao = Integer.parseInt(leitura.nextLine());
			
			switch(opcao) {
			
				case 1:
					usuarios.remove(usuario);
					excluido = true;
					System.out.println("Conta excluída");
				case 2:
					excluido = false;
					System.out.println("Conta não excluída");
					break;
				default:
					System.out.println("Opção invàlida");
			}
			
		}while(opcao != 1 && opcao != 2);
		
		return excluido;
		
	}
	
	//faz o login do usuário, recebendo o array de usuários
	public static Usuario loginUsuario(ArrayList<Usuario> usuarios) {
		
		String prontuario, senha;
		
		//recebe o prontuário
		System.out.print("Informe o prontuario: ");
		prontuario = leitura.nextLine();
		
		//recebe a senha
		System.out.print("Informe a senha: ");
		senha = leitura.nextLine();
		
		//verifica se o prontuario e a senha constam no cadastro de algum usuário
		for(Usuario usuario: usuarios) {
			if(usuario.getProntuario().equals(prontuario)) {
				if(usuario.getSenha().equals(senha)) {
					return usuario;
				}
			}		
		}
		return null;
	}
	
}
