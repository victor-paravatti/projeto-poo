package ifnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import excecoes.OpcaoInexistenteException;

public class Main {

	public static void main(String[] args) {
		
		//cria os ArrayList onde as classes ficaram salvas
		
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		disciplinas.add(new Disciplina("Algoritimo"));
		disciplinas.add(new Disciplina("Engenharia de Software"));
		disciplinas.add(new Disciplina("Mátematica Básica"));
		disciplinas.add(new Disciplina("Linguagem e Programação I"));
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Analise e Desenvolvimento de Sistemas"));
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Aluno("Demetrios", "BP3007685", "creed159", "pantaleao15@hotmail.com", cursos.get(0)));
		usuarios.add(new Professor("David", "BP3009658", "prof123", new Area("Tecnologia"), disciplinas.get(3)));
		usuarios.add(new Professor("Roberto", "BP3009679", "prof321", new Area("Mátematica"), disciplinas.get(2)));
		ArrayList<Conteudo> conteudos = new ArrayList<Conteudo>();
		conteudos.add(new Conteudo("Principos da Programação", "Livro", usuarios.get(1)));
		conteudos.add(new Conteudo("Video Aula de Estatistica", "Video", usuarios.get(0)));
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		grupos.add(new Grupo("Pré Projeto TCC", disciplinas.get(0), usuarios.get(1), "Trabalho"));
		grupos.add(new Grupo("Praticar Mátematica", disciplinas.get(2), usuarios.get(2), "Pesquisa"));
		grupos.add(new Grupo("Aulas de Mátematica", disciplinas.get(2), usuarios.get(2), "Trabalho"));
		ArrayList<Grupo> grupoAlt;
		Map<Integer, Disciplina> disciplinasPorSemestre = new HashMap<Integer, Disciplina>();
		
		Scanner leitura = new Scanner(System.in);
		
		Usuario usuarioAtual = null;
		boolean comecar = true, sair = true, voltar = true, entrou = false, prosseguir = false;
		String opcao = "", prontuario, senha, nome, tipo, titulo;	
		int posicao = -1, semestre, semestres;
	
		while(comecar) {
			
			do {
				//pagina principal do sistema
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
								System.out.println("O prontuário e a senha fornecidos não correspondem as "
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
								
								if(conteudos.size() > 0) {
									
									do {
										
										System.out.println("Contéudos");
										
										for(Conteudo conteudo:conteudos) {
											System.out.println(conteudos.indexOf(conteudo) +". " + conteudo.getTitulo());
										}
										
										System.out.println("Informe o número do conteúdo desejado: ");
										
										try {
											
											posicao = Integer.parseInt(leitura.nextLine());
											
											if(posicao >= conteudos.size()) {
												throw new OpcaoInexistenteException();
											}
											
											prosseguir = true;
											
										} catch (NumberFormatException excecao) {
											System.out.println("O valor informado não é um número inteiro");
										} catch (OpcaoInexistenteException excecao) {
											System.out.println(excecao.getMessage());
										}
										
									}while(!prosseguir);
									
								}
								
								System.out.println("Título: " + conteudos.get(posicao).getTitulo());
								System.out.println("Tipo: " + conteudos.get(posicao).getTipoConteudo());
								System.out.println("Publicador: " + conteudos.get(posicao).getPublicador().getNome());
								
								System.out.println("1.Publicar Conteúdo\n2.Excluir Conteúdo\nV.Voltar");
								opcao = leitura.nextLine();
								
								prosseguir = false;
								
								switch(opcao) {
									case "1":
										
										System.out.println("Informe o titulo do conteúdo");
										titulo = leitura.nextLine();

										System.out.println("Informe o tipo de conteúdo que deseja adicionar");
										tipo = leitura.nextLine();	
									
										conteudos.add(new Conteudo(titulo, tipo, usuarioAtual));
										
										System.out.println("Conteúdo publicado");
										break;
									case "2":
										
										if(conteudos.get(posicao).getPublicador().equals(usuarioAtual)) {
											
											do {
												
												System.out.println("Você tem certeza que deseja excluir o conteúdo? "
														+ "Essa ação não pode ser desfeita\n1.Sim\n2.Não");
												opcao = leitura.nextLine();
												
												switch(opcao) {
												
													case "1":
														conteudos.remove(conteudos.get(posicao));
														System.out.println("Conteúdo excluído");
														break;
													case "2":
														System.out.println("Conteúdo não excluído");
														break;
													default:
														System.out.println("Opção invàlida");
												}
											}while(!opcao.equals("1") && !opcao.equals("2"));
											
										} else System.out.println("Ação negada, somente o publicador do contéudo tem permissão para excluí-lo");
										
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
										+ "\n3.Consultar usuário com mais relacionamentos\nV.Voltar");
								opcao = leitura.nextLine();
								
								switch(opcao) {
									case "1":
										System.out.println("Pedido de amizade enviado");
										break;
									case "2":
										System.out.println("Grau de amizade definido");
										break;
									case "3":
										System.out.println("Consultado usuários com mais relacionamentos");
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
										
										do {
											
											System.out.println("Consultar Grupo de Pesquisa por Disciplina");
											
											System.out.println("Disciplinas");
											
											for(Disciplina disciplina:disciplinas) {
												posicao = disciplinas.indexOf(disciplina);
												System.out.println(posicao + ". " + disciplina.getNome());
											}
											
											System.out.println("Informe o número da disciplina: ");
											
											try {
												
												posicao = Integer.parseInt(leitura.nextLine());
												
												if(posicao >= disciplinas.size()) {
													throw new OpcaoInexistenteException("O valor informado não é um número inteiro");
												}
												
												prosseguir = true;
												
											} catch(NumberFormatException excecoes) {
												System.out.println();
											} catch(OpcaoInexistenteException excecoes) {
												System.out.println(excecoes.getMessage());
											}
										
										}while(prosseguir);
										
										grupoAlt = Grupo.consultarGpPesquisaPorDisciplina(grupos, disciplinas.get(posicao));
										
										if(grupoAlt == null) {
											System.out.println("Não existe nenhum grupo com a disciplina escolhida");
										}else {
											System.out.println("Grupos da disciplina " + disciplinas.get(posicao).getNome());
											for(Grupo grupo:grupoAlt) System.out.println(grupo.getNome());
										}
										
										prosseguir = false;

										break;
										
									case "2":
										
										Grupo.consultarGrupoMaisUsuarios(grupos);
										
										System.out.println("TOP 10 Grupos com mais usuários");
										
										for(Grupo grupo:grupos) {
											System.out.println("Nome: " + grupo.getNome() + 
													" Quantidade de usuários: " + grupo.getUsuariosGrupo().size());
											if(grupos.indexOf(grupo) == 9) break;
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
											
											do {
												
												System.out.println("Disciplina");
												
												for(Disciplina disciplina:disciplinas) {
													posicao = disciplinas.indexOf(disciplina);
													System.out.println(posicao + ". " + disciplina.getNome());
												}
												
												System.out.println("Informe o número da disciplina desejada: ");
												
												try {
													
													posicao = Integer.parseInt(leitura.nextLine());
													
													if(posicao >= conteudos.size()) {
														throw new OpcaoInexistenteException();
													}
													
													prosseguir = true;
													
												} catch (NumberFormatException excecao) {
													System.out.println("O valor informado não é um número inteiro");
												} catch (OpcaoInexistenteException excecao) {
													System.out.println(excecao.getMessage());
												}
												
											}while(!prosseguir);
												
											grupos.add(new Grupo(nome, disciplinas.get(posicao), usuarioAtual, tipo));
											
											System.out.println("Grupo criado!");
											
											prosseguir = false;
											
											break;
										case "4":
											
											do {
												
												System.out.println("Grupos");
												
												for(Grupo grupo:grupos) {
													posicao = grupos.indexOf(grupo);
													System.out.println(posicao + ": " + grupo.getNome());
												}
												
												System.out.println("Informe o número da grupo desejado: ");
												
												try {
													posicao = Integer.parseInt(leitura.nextLine());
													
													if(posicao >= grupos.size()) {
														throw new OpcaoInexistenteException();
													}
													
												}catch(NumberFormatException excesoes) {
													System.out.println("O valor informado não é um número inteiro");
												}catch (OpcaoInexistenteException excecao) {
													System.out.println(excecao.getMessage());
												}
												
											}while(prosseguir);
											
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
				
										do{
											
											System.out.println("Disciplinas");
											
											for(Disciplina disciplina:disciplinas) {
												posicao = disciplinas.indexOf(disciplina);
												System.out.println(posicao + ". " + disciplina.getNome());
											}
											
											System.out.println("Informe o número da disciplina desejada: ");
											
											
											try {
												
												posicao = Integer.parseInt(leitura.nextLine());
												
												if(posicao >= disciplinas.size()) {
													throw new OpcaoInexistenteException();
												}
												
												prosseguir = true;
											}catch(NumberFormatException excecoes) {
												System.out.println("O valor informado não é um número inteiro");
											}catch (OpcaoInexistenteException excecao) {
												System.out.println(excecao.getMessage());
											}
								
										}while(!prosseguir);
										
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
										
										prosseguir = false;
										
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
												
												do {
												
													System.out.println("Disciplina");
													
													for(Disciplina disciplina:disciplinas) {
														posicao = disciplinas.indexOf(disciplina);
														System.out.println(posicao + ". " + disciplina.getNome());
													}
													
													System.out.println("Informe o número da disciplina desejada: ");
													
													try {
														posicao = Integer.parseInt(leitura.nextLine());
														
														if(posicao >= disciplinas.size()) {
															throw new OpcaoInexistenteException();
														}
														
														prosseguir = true;
														
													}catch(NumberFormatException excecoes) {
														System.out.println("O valor informado não é um número inteiro");
													}catch (OpcaoInexistenteException excecao) {
														System.out.println(excecao.getMessage());
													}
												
												}while(prosseguir);
										
												
												System.out.println("Informe o semetre da disciplina");
												semestre = Integer.parseInt(leitura.nextLine());
												
												disciplinasPorSemestre.put(semestre, disciplinas.get(posicao));
												
												do {
													System.out.println("Deseja cadastrar outra disciplina no curso?\n1. Sim\n2. Não");
													opcao = leitura.nextLine();
													
													if(!opcao.equals("1") && !opcao.equals("2")) System.out.println("Opção inválida");
														
												}while(!opcao.equals("1") && !opcao.equals("2"));
																							
											}while(opcao.equals("1"));
											
											cursos.add(new Curso(nome, semestres, disciplinasPorSemestre));
											
											System.out.println("Curso cadastrado");
											
											
											do {
												
												System.out.println("Deseja cadastrar outro curso?\n1.Sim\n2.Não");
												opcao = leitura.next();
												
												if(!opcao.equals("1") && !opcao.equals("2")) System.out.println("Opção inválida");
												
											}while(!opcao.equals("1") && !opcao.equals("2"));
											
										}while(opcao.equals("1"));
										
										prosseguir = false;
				
										break;
									case "2":
										
										do {
											
											System.out.println("Cursos");
											
											for(Curso curso:cursos) {
												posicao = cursos.indexOf(curso);
												System.out.println(posicao + ". " + curso.getNome());
											}
											
											System.out.println("Informe o número do curso desejada: ");
											
											try {
												posicao = Integer.parseInt(leitura.nextLine());
												
												if(posicao >= disciplinas.size()) {
													throw new OpcaoInexistenteException();
												}
												
												prosseguir = true;
												
											}catch(NumberFormatException excecoes) {
												System.out.println("O valor informado não é um número inteiro");
											}catch (OpcaoInexistenteException excecao) {
												System.out.println(excecao.getMessage());
											}
											
										}while(prosseguir);
										
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
										
										prosseguir = false;
									
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
		