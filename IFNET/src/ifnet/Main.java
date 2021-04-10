package ifnet;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Scanner leitura = new Scanner(System.in);
		Usuario novoUsuario, usuarioAtual = null;
		Boolean contem, continuar = false;
		
		int opcao = 0;
		
		boolean comecar = true;
		
		while(comecar) {
			
			do {
				System.out.println("Bem vindo");
				System.out.println("1.Entrar\n2.Criar nova conta\n3.Sair");
				opcao = Integer.parseInt(leitura.nextLine());
			
				switch(opcao) {
				
					case 1:
						usuarioAtual = Usuario.loginUsuario(usuarios);
						contem = usuarios.contains(usuarioAtual);
						continuar = true;
						break;
					case 2:
						novoUsuario = usuarioAtual = Usuario.cadastrarUsuario();
						usuarios.add(novoUsuario);
						break;
					default:
						System.out.println("Opção inválida");
				}
			}while(continuar);
			
			if(usuarioAtual.getClass() == Aluno.class){
				
				System.out.println(usuarioAtual.getNome());
				System.out.println("1.Conteudo\n2.Amizade\n3.Disciplina\n4.Curso"
						+ "\n5.Consultar Grupo de Pesquisa por Disciplina\n6.Sair");
				opcao = Integer.parseInt(leitura.nextLine());
			
				switch(opcao) {
				
					case 1:
						System.out.println("Conteudo");
						System.out.println("1.Postar Conteudo\n2.Escluir Conteudo\n3.Sair");
						opcao = Integer.parseInt(leitura.nextLine());
						
						switch(opcao) {
							case 1:
								break;
							case 2:
								break;
							default:
								System.out.println("Opção inválida");
						}
							
						break;
					case 2:
						System.out.println("Amizade");
						System.out.println("1.Enviar pedido de amizade\n2.Definir grau de confiabilidade"
								+ "\n3.Consultar usuario com mais relacionamentos\n4.Sair");
						opcao = Integer.parseInt(leitura.nextLine());
						
						switch(opcao) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								break;
							default:
								System.out.println("Opção inválida");
						}
						
						break;
					case 3:
						System.out.println("Disciplina");
						System.out.println("1.Cadastrar Disciplina\n2.Escluir Disciplina\n3.Sair");
						opcao = Integer.parseInt(leitura.nextLine());
						
						switch(opcao) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							default:
								System.out.println("Opção inválida");
						}
						
						break;
					case 4:
						System.out.println("Curso");
						System.out.println("1.Cadastrar Curso\n2.Escluir Curso\n3.Sair");
						opcao = Integer.parseInt(leitura.nextLine());
						
						switch(opcao) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							default:
								System.out.println("Opção inválida");
						}
						
						break;
					case 5:
						//CONSULTAR GRUPO DE PESQUISA POR DISCIPLINA
						break;
					case 6:
						//VOLTAR AO MENU ANTERIOR
						break;
					default:
						System.out.println("Opção inválida");
				}
			}else {
				
				System.out.println(usuarioAtual.getNome());
				System.out.println("1.Conteudo\n2.Amizade\n3.Grupo\n4.Sair");
				opcao = Integer.parseInt(leitura.nextLine());
			
				switch(opcao) {
				
					case 1:
						System.out.println("Conteudo");
						System.out.println("1.Postar Conteudo\n2.Escluir Conteudo\n3.Sair");
						opcao = Integer.parseInt(leitura.nextLine());
						
						switch(opcao) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							default:
								System.out.println("Opção inválida");
						}
						
						break;
					case 2:
						System.out.println("Amizade");
						System.out.println("1.Enviar pedido de amizade\n2.Definir grau de confiabilidade"
								+ "\n3.Consultar usuario com mais relacionamentos\n4.Sair");
						opcao = Integer.parseInt(leitura.nextLine());
						
						switch(opcao) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								break;
							default:
								System.out.println("Opção inválida");
						}
						
						break;
					case 3:
						System.out.println("Grupo");
						System.out.println("1.Criar Grupo\n2.Escluir Grupo\n3.Consultar Grupos com Mais Usuarios\n"
								+ "5.Consultar Grupo de Pesquisa por Disciplina\n6.Sair");
						opcao = Integer.parseInt(leitura.nextLine());
						
						switch(opcao) {
							case 1:
								break;
							case 2:
								break;
							case 3:
								break;
							case 4:
								break;
							case 5:
								break;
							case 6:
								 break;
							default:
								System.out.println("Opção inválida");
						}
						
						break;
					case 4:
						//VOLTAR AO MENU ANTERIOR
						break;
					default:
						System.out.println("Opção inválida");
				}
			}
			
		}
		
		
	}
}
