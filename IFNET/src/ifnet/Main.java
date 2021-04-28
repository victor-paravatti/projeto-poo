package ifnet;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		//cria os ArrayList onde as classes ficaram salvas
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		ArrayList<Conteudo> conteudos = new ArrayList<Conteudo>();
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		ArrayList<Grupo> grupoAlt;
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		
		Scanner leitura = new Scanner(System.in);
		
		Usuario usuarioAtual = null;
		boolean comecar = true, sair = true, voltar = true, entrou = false;
		String opcao = "", prontuario, senha, nome, tipo, titulo;	
		int posicao, semestre, semestres;
	
		while(comecar) {
			
			do {
				//p�gina principal do sistema
				System.out.println("Bem vindo ao IFNET");
				System.out.println("1.Entrar\n2.Criar nova conta\nS.Sair");
				opcao = leitura.nextLine();
				
				switch(opcao) {
				
					case "1":
						
						do {
							
							//recebe o prontuário
							System.out.print("Informe o prontuario: ");
							prontuario = leitura.nextLine();
							
							//recebe a senha
							System.out.print("Informe a senha: ");
							senha = leitura.nextLine();
					
							usuarioAtual = Usuario.loginUsuario(usuarios, prontuario, senha);
							if(usuarioAtual  != null) {
								entrou = true;
								sair = false;
							} else {
								System.out.println("O e-mail e a senha fornecidos não correspondem as "
										+ "informações em nossos registros. Verifique-as e tente novamente.");
							}
						}while(usuarioAtual == null);
						
						break;
					case "2":
						
						do {
							System.out.println("Você é Aluno ou Professor?\n1 - Aluno\n2 - Professor");
							opcao = leitura.nextLine();
						} while(!opcao.equals("1") && !opcao.equals("2"));
						
						System.out.print("Informe o nome: ");
						nome = leitura.nextLine();
						
						System.out.print("Informe o prontuário: ");
						prontuario = leitura.nextLine();
						
						System.out.print("Informe a senha: ");
						senha = leitura.nextLine();
						
						if(opcao.equals("2")) {
							
							System.out.print("Informe a área: ");
							String area = leitura.nextLine();
							
							System.out.print("Informe a disciplina: ");
							String disciplina = leitura.nextLine();
							
							usuarios.add(new Professor(nome, prontuario, senha,
									new Area(area), new Disciplina(disciplina)));
						} else {
							
							System.out.print("Informe o e-mail: ");
							String email = leitura.nextLine();
							
							System.out.print("Informe o curso: ");
							String curso = leitura.nextLine();
							
							usuarios.add(new Aluno(nome, prontuario, senha, email, new Curso(curso)));
						}
						
						System.out.println("Cadastro realizado com sucesso!");
						
						break;
					case "S":
						comecar = sair = false;
						break;
					default:
						System.out.println("Opção inválida");
				}
			}while(sair);
			
			sair = true;
			
			if(entrou) {
				
				do {
						
					voltar = true;
					
					System.out.println(usuarioAtual.getNome());
					System.out.println("1.Conteudo\n2.Amizade\n3.Grupo\n4.Conta");
					if(usuarioAtual.getClass() == Aluno.class) System.out.println("5.Disciplina\n6.Curso");
					System.out.println("S.Sair");
					opcao = leitura.nextLine();
				
					switch(opcao) {
					
						case "1":
							
							do {								
								System.out.println("Conteudo");
								System.out.println("1.Publicar Conte�do\n2.Excluir Conteudo\nV.Voltar");
								opcao = leitura.nextLine();
								
								switch(opcao) {
									case "1":
										
										System.out.println("Informe o titulo do contéudo");
										titulo = leitura.nextLine();

										System.out.println("Informe O tipo de conteudo que deseja adicionar");
										tipo = leitura.nextLine();	
									
										conteudos.add(new Conteudo(titulo, tipo, usuarioAtual));
										
										System.out.println("Conteúdo publicado");
										break;
									case "2":
										
										System.out.println("Conteúdos");
										
										for(Conteudo conteudo:conteudos) {
											System.out.println(conteudo.getTitulo());
										}
										
										System.out.println("Informe o número do conteudo desejado: ");
										posicao = Integer.parseInt(leitura.nextLine());
										
										do {
											
											System.out.println("Você tem certeza que deseja excluir o conteudo? "
													+ "Essa ação não pode ser desfeita\n1.Sim\n2.Não");
											opcao = leitura.nextLine();
											
											switch(opcao) {
											
												case "1":
													conteudos.remove(conteudos.get(posicao));
													System.out.println("Conteudo excluído");
												case "2":
													System.out.println("Conteudo não excluído");
													break;
												default:
													System.out.println("Opção invàlida");
											}
										}while(!opcao.equals("1") && !opcao.equals("2"));

										break;
									case "V":
										voltar = false;
									default:
										System.out.println("Opção inválida");
								}
							}while(voltar);
						
							break;
						case "2":
							
							do {
								
								System.out.println("Amizade");
								System.out.println("1.Enviar pedido de amizade\n2.Definir grau de confiabilidade"
										+ "\n3.Consultar usu�rio com mais relacionamentos\nV.Voltar");
								opcao = leitura.nextLine();
								
								switch(opcao) {
									case "1":
										System.out.println("Pedido de amizade enviado");
										break;
									case "2":
										System.out.println("Grau de amizade definido");
										break;
									case "3":
										System.out.println("Consultado usu�rios com mais relacionamentos");
										break;
									case "V":
										voltar = false;
										break;
									default:
										System.out.println("Opção inválida");
								}
								
							}while(voltar);
							
							break;
						case "3":
							
							do {
								
								System.out.println("Grupo");
								System.out.println("1.Consultar Grupo de Pesquisa por Disciplina\n2.Consultar Grupos com Mais Usuarios");
								if(usuarioAtual.getClass() == Professor.class) System.out.println("3.Criar Grupo\n4.Excluir Grupo");
								System.out.println("V.Volta");
								opcao = leitura.nextLine();
								
								switch(opcao) {
									case "1":
										
										
										System.out.println("Consultar Grupo de Pesquisa por Disciplina");
										
										System.out.println("Disciplinas");
										
										for(Disciplina disciplina:disciplinas) {
											posicao = disciplinas.indexOf(disciplina);
											System.out.println(posicao + ". " + disciplina.getNome());
										}
										
										System.out.println("Informe o número da disciplina: ");
										posicao = Integer.parseInt(leitura.nextLine());
										
										grupoAlt = Grupo.consultarGpPesquisaPorDisciplina(grupos, disciplinas.get(posicao));
										
										if(grupoAlt == null) {
											System.out.println("Não existe nenhum grupo com a disciplina escolhida");
										}else {
											System.out.println("Grupos da disciplina " + disciplinas.get(posicao));
											for(Grupo grupo:grupos) System.out.println(grupo.getNome());
										}
										

										break;
										
									case "2":
										
										System.out.println("TOP 10 Grupos com mais usuários");
										
										for(Grupo grupo:Grupo.consultarGrupoMaisUsuarios(grupos)) {
											System.out.println("Nome: " + grupo.getNome() + 
													"Quantidade de usuários: " + grupo.getUsuariosGrupo().size());
										}
										
										break;
								}
								
								if(usuarioAtual.getClass() == Professor.class) {
									switch(opcao) {
										case "3":
											
											System.out.println("Criar Grupo");
											
											System.out.println("Informe o nome do grupo: ");
											nome = leitura.nextLine();
											
											System.out.println("Tipo do grupo\n1. Pesquisa\n2. Trabalho");
											tipo = leitura.nextLine();
											
											if(tipo.equals("1")) tipo = "Pesquisa";
											else tipo = "Trabalho";
											
											System.out.println("Disciplina");
											
											for(Disciplina disciplina:disciplinas) {
												posicao = disciplinas.indexOf(disciplina);
												System.out.println(posicao + ". " + disciplina.getNome());
											}
											
											System.out.println("Informe o número da disciplina desejada: ");
											posicao = Integer.parseInt(leitura.nextLine());
												
											grupos.add(new Grupo(nome, disciplinas.get(posicao), usuarioAtual, tipo));
											
											System.out.println("Grupo criado!");
											
											break;
										case "4":
											
											System.out.println("Grupos");
											
											for(Grupo grupo:grupos) {
												posicao = grupos.indexOf(grupo);
												System.out.println(posicao + ": " + grupo.getNome());
											}
											
											System.out.println("Informe o número da grupo desejado: ");
											posicao = Integer.parseInt(leitura.nextLine());
											
											do {
												
												System.out.println("Você tem certeza que deseja excluir o grupo? "
														+ "Essa ação não pode ser desfeita\n1.Sim\n2.Não");
												opcao = leitura.nextLine();
												
												switch(opcao) {
												
													case "1":
														if(grupos.get(posicao).getCriador() == usuarioAtual) {
															grupos.remove(posicao);
															System.out.println("Grupo excluído");
														} else System.out.println("Você não tem permissão para excluir esse grupo,"
																+ "somente o criador do grupo pode excluí-lo");
													case "2":
														System.out.println("Grupo não excluído");
														break;
													default:
														System.out.println("Opção invàlida");
												}
											}while(!opcao.equals("1") && !opcao.equals("2"));
												
											break;
									}	
								}
								
								switch(opcao) {
									case "V":
										voltar = false;
										break;
									default:
										System.out.println("Opção inválida");
								}
								
							}while(voltar);
							
							break;
						
						case "4":
							
							do {
								
								System.out.println("Conta");
								System.out.println("1.Mudar Nome\n2.Mudar Senha\n3.Excluir Conta\nV.voltar");
								opcao = leitura.nextLine();
								
								switch(opcao) {
									case "1":
										System.out.println("Nome Atual: " + usuarioAtual.getNome());
										System.out.print("Novo nome: ");
										nome = leitura.nextLine();
										usuarioAtual.setNome(nome);
										System.out.println("Nome alterado");
										break;
									case "2":
										System.out.println("Senha Atual: " + usuarioAtual.getSenha());
										System.out.print("Novo senha: ");
										senha = leitura.nextLine();
										usuarioAtual.setSenha(senha);
										System.out.println("Senha alterado");
										break;
									case "3":
										
										boolean excluido = false;
										
										do {
											
											System.out.println("Você tem certeza que deseja excluir a sua conta? "
													+ "Essa ação não pode ser desfeita\n1.Sim\n2.Não");
											opcao = leitura.nextLine();
											
											switch(opcao) {
											
												case "1":
													usuarios.remove(usuarioAtual);
													excluido = true;
													System.out.println("Conta excluída");
												case "2":
													excluido = false;
													System.out.println("Conta não excluída");
													break;
												default:
													System.out.println("Opção invàlida");
											}
											
										}while(!opcao.equals("1") && !opcao.equals("2"));
										
										if(excluido) {
											sair = false;
											entrou = false;
										}
										
										break;
									case "V":
										voltar = false;
										break;
									default:
										System.out.println("Opção inválida");
										
								}
					
							}while(voltar);
					
							break;
					}	
					
					if(usuarioAtual.getClass() == Aluno.class) {
						
						switch(opcao) {
							
						case "5":
							
							do {
								
								System.out.println("Disciplina");
								System.out.println("1.Cadastrar Disciplina\n2.Excluir Disciplina\nV.Voltar");
								opcao = leitura.nextLine();
								
								switch(opcao) {
									case "1":
										
										do {

											System.out.println("Informe O nome da Diciplina que deseja adicionar");
											nome = leitura.nextLine();
											
											disciplinas.add(new Disciplina(nome));
											
											System.out.println("Disciplina cadastrada");
											
											System.out.println("Deseja cadastrar outra disciplina no curso?\n1. Sim\n2. Não");
											opcao = leitura.nextLine();
											
										}while(!opcao.equals("1"));
										
										break;
									case "2":
										
										System.out.println("Disciplinas");
										
										for(Disciplina disciplina:disciplinas) {
											posicao = disciplinas.indexOf(disciplina);
											System.out.println(posicao + ". " + disciplina.getNome());
										}
										
										System.out.println("Informe o número da disciplina desejada: ");
										posicao = Integer.parseInt(leitura.nextLine());
										
										do {
											
											System.out.println("Você tem certeza que deseja excluir o curso? "
													+ "Essa ação não pode ser desfeita\n1.Sim\n2.Não");
											opcao = leitura.nextLine();
											
											switch(opcao) {
											
												case "1":
													disciplinas.remove(posicao);
													System.out.println("Disciplina excluído");
												case "2":
													System.out.println("Disciplina não excluído");
													break;
												default:
													System.out.println("Opção invàlida");
											}
										}while(!opcao.equals("1") && !opcao.equals("2"));
										
										break;
									case "V":
										voltar = false;
										break;
									default:
										System.out.println("Opção inválida");
								}
								
							}while(voltar);
							
							break;
						
						case "6":
							
							do {
								
								System.out.println("Curso");
								System.out.println("1.Cadastrar Curso\n2.Excluir Curso\nV.Voltar");
								opcao = leitura.nextLine();
								
								switch(opcao) {
									case "1":
										
										do {
											
											System.out.println("Cadastrar Curso");
											
											System.out.println("Informe o nome do curso: ");
											nome = leitura.next();
											
											System.out.println("Informe a quantidade de semestres do curso: ");
											semestres = Integer.parseInt(leitura.next());
											
											do {
												
												System.out.println("Disciplina");
												
												for(Disciplina disciplina:disciplinas) {
													posicao = disciplinas.indexOf(disciplina);
													System.out.println(posicao + ". " + disciplina.getNome());
												}
												
												System.out.println("Informe o número da disciplina desejada: ");
												posicao = Integer.parseInt(leitura.nextLine());
												
												System.out.println("Informe o semetre da disciplina");
												semestre = Integer.parseInt(leitura.nextLine());
												
												System.out.println("Deseja cadastrar outra disciplina no curso?\n1. Sim\n2. Não");
												opcao = leitura.nextLine();
												
											}while(!opcao.equals("2"));
											
											cursos.add(new Curso(nome, semestres, semestre, disciplinas.get(posicao)));
											
											System.out.println("Curso cadastrado");
											
											System.out.println("Deseja cadastrar outro curso?\n1.Sim\n2.Não");
											opcao = leitura.next();
											
											if(!opcao.equals("1") && !opcao.equals("2")) System.out.println("Opção inválida");
										
										}while(!opcao.equals("1") && !opcao.equals("2"));
				
										break;
									case "2":
										
										System.out.println("Cursos");
										
										for(Curso curso:cursos) {
											posicao = cursos.indexOf(curso);
											System.out.println(posicao + ". " + curso.getNome());
										}
										
										System.out.println("Informe o número do curso desejada: ");
										posicao = Integer.parseInt(leitura.nextLine());
										
										do {
											
											System.out.println("Você tem certeza que deseja excluir o curso? "
													+ "Essa ação não pode ser desfeita\n1.Sim\n2.Não");
											opcao = leitura.nextLine();
											
											switch(opcao) {
											
												case "1":
													cursos.remove(posicao);
													System.out.println("Curso excluído");
												case "2":
													System.out.println("Curso não excluído");
													break;
												default:
													System.out.println("Opção invàlida");
											}
											
										}while(!opcao.equals("1") && !opcao.equals("2"));
									
										break;
									case "V":
										voltar = false;
										break;
									default:
										System.out.println("Opção inválida");
								}
								
							}while(voltar);
							
							break;
						}
					}
					
					switch (opcao){
						case "S":
							sair = false;
							entrou = false;
							break;
						default:
							System.out.println("Opção inválida");
					}
				}while(sair);	
			}
		}			
	}				
}					
		