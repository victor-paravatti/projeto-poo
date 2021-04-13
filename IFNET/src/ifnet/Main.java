package ifnet;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		ArrayList<Conteudo> conteudos = new ArrayList<Conteudo>();
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		ArrayList<Curso> curso = new ArrayList<Curso>();
		
		Scanner leitura = new Scanner(System.in);
		
		Usuario novoUsuario, usuarioAtual = null;
		boolean comecar = true, sair = true, voltar = true, entrou = false;
		int opcao = 0;			
	
		while(comecar) {
			
			do {
				System.out.println("Bem vindo ao IFNET");
				System.out.println("1.Entrar\n2.Criar nova conta\n3.Sair");
				opcao = Integer.parseInt(leitura.nextLine());
			
				switch(opcao) {
				
					case 1:
						
						do {
							usuarioAtual = Usuario.loginUsuario(usuarios);
							if(usuarioAtual  != null) {
								entrou = true;
								sair = false;
							} else {
								System.out.println("O e-mail e a senha fornecidos não correspondem às "
										+ "informações em nossos registros. Verifique-as e tente novamente.");
							}
						}while(usuarioAtual == null);
						
						break;
					case 2:
						novoUsuario = usuarioAtual = Usuario.cadastrarUsuario();
						usuarios.add(novoUsuario);
						break;
					case 3:
						comecar = sair = false;
						break;
					default:
						System.out.println("Opção Inválida");
				}
			}while(sair);
			
			sair = true;
			
			if(entrou) {
				
				if(usuarioAtual.getClass() == Aluno.class){
					
					do {
						
						voltar = true;
						
						System.out.println(usuarioAtual.getNome());
						System.out.println("1.Conteudo\n2.Amizade\n3.Disciplina\n4.Curso"
								+ "\n5.Consultar Grupo de Pesquisa por Disciplina\n6.Sair");
						opcao = Integer.parseInt(leitura.nextLine());
					
						switch(opcao) {
						
							case 1:
								
								do {
									
									System.out.println("Conteudo");
									System.out.println("1.Publicar Conteúdo\n2.Excluir Conteudo\n3.Voltar");
									opcao = Integer.parseInt(leitura.nextLine());
									
									switch(opcao) {
										case 1:
											System.out.println("Conteúdo publicado");
											break;
										case 2:
										System.out.println("Conteúdo excluido");
											break;
										case 3:
											voltar = false;
										default:
											System.out.println("Opção invàlida");
									}
								}while(voltar);
							
								break;
							case 2:
								
								do {
									
									System.out.println("Amizade");
									System.out.println("1.Enviar pedido de amizade\n2.Definir grau de confiabilidade"
											+ "\n3.Consultar usuário com mais relacionamentos\n4.Voltar");
									opcao = Integer.parseInt(leitura.nextLine());
									
									switch(opcao) {
										case 1:
											System.out.println("Pedido de amizade enviado");
											break;
										case 2:
											System.out.println("Grau de amizade definido");
											break;
										case 3:
											System.out.println("Consultado usuários com mais relacionamentos");
											break;
										case 4:
											voltar = false;
											break;
										default:
											System.out.println("Opção invàlida");
									}
									
								}while(voltar);
								
								break;
							case 3:
								
								do {
									
									System.out.println("Disciplina");
									System.out.println("1.Cadastrar Disciplina\n2.Excluir Disciplina\n3.Voltar");
									opcao = Integer.parseInt(leitura.nextLine());
									
									switch(opcao) {
										case 1:
											System.out.println("Disciplina cadastrada");
											break;
										case 2:
											System.out.println("Disciplina excluida");
											break;
										case 3:
											voltar = false;
											break;
										default:
											System.out.println("Opção invàlida");
									}
									
								}while(voltar);
								
								break;
							case 4:
								
								do {
									
									System.out.println("Curso");
									System.out.println("1.Cadastrar Curso\n2.Excluir Curso\n3.Voltar");
									opcao = Integer.parseInt(leitura.nextLine());
									
									switch(opcao) {
										case 1:
											System.out.println("Curso cadastrado");
											break;
										case 2:
											System.out.println("Curso excluido");
											break;
										case 3:
											voltar = false;
											break;
										default:
											System.out.println("Opção invàlida");
									}
									
								}while(voltar);
								
								break;
							case 5:
								System.out.println("Consultado grupo de pesquisa por disciplina");
								break;
							case 6:
								sair = false;
								entrou = false;
								break;
							default:
								System.out.println("Opção invàlida");
						}
						
					}while(sair);
					
					sair = true;
					
				}else if(usuarioAtual.getClass() == Professor.class) {
					
					do {
						
						voltar = true;
					
						System.out.println(usuarioAtual.getNome());
						System.out.println("1.Conteúdo\n2.Amizade\n3.Grupo\n4.Sair");
						opcao = Integer.parseInt(leitura.nextLine());
					
						switch(opcao) {
						
							case 1:
								
								do {
									
									System.out.println("Conteudo");
									System.out.println("1.Postar Conteúdo\n2.Excluir Conteúdo\n3.Voltar");
									opcao = Integer.parseInt(leitura.nextLine());
									
									switch(opcao) {
										case 1:
											System.out.println("Publicar conteúdo");
											break;
										case 2:
											System.out.println("Excluir conteúdo");
											break;
										case 3:
											voltar = false;
											break;
										default:
											System.out.println("Opção invàlida");
									}
									
								}while(voltar);
								
								break;
							case 2:
								
								do {
									
									System.out.println("Amizade");
									System.out.println("1.Enviar pedido de amizade\n2.Definir grau de confiabilidade"
											+ "\n3.Consultar usuário com mais relacionamentos\n4.Voltar");
									opcao = Integer.parseInt(leitura.nextLine());
									
									switch(opcao) {
										case 1:
											System.out.println("Pedido de amizade enviado");
											break;
										case 2:
											System.out.println("Grau de confiabilidade definido");
											break;
										case 3:
											System.out.println("Usuário com mais realacionamentos consultado");
											break;
										case 4:
											voltar = false;
											break;
										default:
											System.out.println("Opção invàlida");
									}	
									
								}while(voltar);
								
								break;
							case 3:
								
								do {
									
									System.out.println("Grupo");
									System.out.println("1.Criar Grupo\n2.Excluir Grupo\n3.Consultar Grupos com Mais Usuarios\n"
											+ "4.Consultar Grupo de Pesquisa por Disciplina\n5.Voltar");
									opcao = Integer.parseInt(leitura.nextLine());
									
									switch(opcao) {
										case 1:
											System.out.println("Grupo criado");
											break;
										case 2:
											System.out.println("Grupo excluido");
											break;
										case 3:
											System.out.println("Grupo com mais usuarios consultado");
											break;
										case 4:
											System.out.println("Consultado grupo de pesquisa por disciplina");
											break;
										case 5:
											voltar = false;
											 break;
										default:
											System.out.println("Opção invàlida");
									}	
									
								}while(voltar);
								
								break;
							case 4:
								entrou = false;
								sair = false;
								//VOLTAR AO MENU ANTERIOR
								break;
							default:
								System.out.println("Opção invàlida");
						}
					}while(sair);		
				}	
			}
		}
	}
}
