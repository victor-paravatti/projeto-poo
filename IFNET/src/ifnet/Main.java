package ifnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import excecoes.OpcaoInexistenteException;
import excecoes.UsuarioCadastradoException;

public class Main {

	public static void main(String[] args) {
		
		//cria os ArrayList onde as classes ficaram salvas
		ArrayList<Area> areas = new ArrayList<Area>();
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
		ArrayList<Grupo> grupoAlt = new ArrayList<Grupo>();
		ArrayList<Conteudo> conteudoAlt = new ArrayList<Conteudo>();
		ArrayList<Disciplina> disciplinaAlt = new ArrayList<Disciplina>();
		ArrayList<Usuario> usuarioAlt = new ArrayList<Usuario>();
		ArrayList<Curso> cursoAlt = new ArrayList<Curso>();
		
		Scanner leitura = new Scanner(System.in);
		
		Curso cur = null;
		Disciplina disc = null;
		Grupo grup = null;
		Conteudo cont = null;
		Disciplina disciplinaCadastro;
		Curso cursoCadastro;
		Area areaCadastro;
		Usuario usuarioAtual = null;
		boolean comecar = true, sair = true, voltar = true, entrou = false, prosseguir = false, cadastro = false;
		String opcao = "", prontuario = "", senha, nome, tipo, titulo;	
		int posicao = -1, semestre, semestres;
	
		while(comecar) {
			
			do {
				//pagina principal do sistema
				System.out.println("Bem vindo ao IFNET");
				System.out.println("1.Entrar\n2.Criar nova conta\nS.Sair");
				opcao = leitura.nextLine().toUpperCase();
				
				switch(opcao) {
				
					case "1":
						
						do {
							
							//recebe o prontuário
							System.out.print("Informe o prontuario: ");
							prontuario = leitura.nextLine().toUpperCase();
							
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
						
						System.out.println("Cadastre-se");
						
						try {
							
							System.out.print("Informe o prontuário: ");
							prontuario = leitura.nextLine().toUpperCase();
							
							if(Usuario.usuarioExistente(usuarios, prontuario)) {
								throw new UsuarioCadastradoException();
							}
							
						} catch (UsuarioCadastradoException excecao) {
							System.out.println(excecao.getMessage());
							break;
						} 
						
						System.out.print("Informe o nome: ");
						nome = leitura.nextLine();
							
						System.out.print("Informe a senha: ");
						senha = leitura.nextLine();
						
						do {
							
							System.out.println("Você é Aluno ou Professor?\n1 - Aluno\n2 - Professor");
							opcao = leitura.nextLine();
					
							switch(opcao) {
							
								case "1":
									
									System.out.print("Informe o e-mail: ");
									String email = leitura.nextLine();
									
									System.out.print("Informe o curso: ");
									String curso = leitura.nextLine();
									
									cursoCadastro = new Curso(curso);
									
									cursos.add(cursoCadastro);
									
									usuarios.add(new Aluno(nome, prontuario, senha, email, cursoCadastro));
									
									cadastro = true;
									
									System.out.println("Cadastro realizado com sucesso!");
									
								case "2":
									
									System.out.print("Informe a área: ");
									String area = leitura.nextLine();
									
									System.out.print("Informe a disciplina: ");
									String disciplina = leitura.nextLine();
									
									disciplinaCadastro = new Disciplina(disciplina);
									areaCadastro = new Area(area);
									
									disciplinas.add(disciplinaCadastro);
									areas.add(areaCadastro);
									
									usuarios.add(new Professor(nome, prontuario, senha,
											new Area(area), new Disciplina(disciplina)));
									
									cadastro = true;
									
									System.out.println("Cadastro realizado com sucesso!");
									
								default:
									System.out.println("Opção inválida");
							}
							
						} while(!cadastro);
			
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
					opcao = leitura.nextLine().toUpperCase();
				
					switch(opcao) {
					
						case "1":
							
							do {
								
								if(conteudos.size() > 0) {
									
									do {
										
										if(conteudoAlt.size() == 0) {
											conteudoAlt = new ArrayList<Conteudo>(conteudos);
											System.out.println("Contéudos");
										}else System.out.println("Resultado da busca");
										
										for(Conteudo conteudo:conteudoAlt) {
											System.out.println(conteudoAlt.indexOf(conteudo) +". " + conteudo.getTitulo());
										}
										
										System.out.println("Informe o número do conteúdo desejado: ");
										
										try {
											
											posicao = Integer.parseInt(leitura.nextLine());
											
											if(posicao >= conteudoAlt.size()) {
												throw new OpcaoInexistenteException();
											}
											
											prosseguir = true;
											cont = conteudoAlt.get(posicao);
											
										} catch (NumberFormatException excecao) {
											System.out.println("O valor informado não é um número inteiro");
										} catch (OpcaoInexistenteException excecao) {
											System.out.println(excecao.getMessage());
											conteudoAlt.clear();
										}
										
									}while(!prosseguir);
									
									System.out.println("Título: " + conteudoAlt.get(posicao).getTitulo());
									System.out.println("Tipo: " + conteudoAlt.get(posicao).getTipoConteudo());
									System.out.println("Publicador: " + conteudoAlt.get(posicao).getPublicador().getNome());
								}
								
								System.out.println("1.Pesquisar Conteúdo\n2.Publicar Conteúdo\n3.Excluir Conteúdo\nV.Voltar");
								opcao = leitura.nextLine().toUpperCase();
								
								conteudoAlt.clear();
								prosseguir = false;
								
								switch(opcao) {
								
									case "1":
										
										System.out.println("Informe o título do conteúdo: ");
										titulo = leitura.nextLine();
										
										conteudoAlt = Conteudo.pesquisarConteudos(conteudos, titulo);
										
										if(conteudoAlt.size() == 0) System.out.println("Não foi encontrado nenhum conteudo com o título informado");
										
										break;
									case "2":
										
										System.out.println("Informe o titulo do conteúdo");
										titulo = leitura.nextLine();

										System.out.println("Informe o tipo de conteúdo que deseja adicionar");
										tipo = leitura.nextLine();	
									
										conteudos.add(new Conteudo(titulo, tipo, usuarioAtual));
										
										System.out.println("Conteúdo publicado");
										break;
									case "3":
										
										if(conteudos.size() > 0) {
											
											if(cont.getPublicador().equals(usuarioAtual)) {
												
												do {
													
													System.out.println("Você tem certeza que deseja excluir o conteúdo? "
															+ "Essa ação não pode ser desfeita\n1.Sim\n2.Não");
													opcao = leitura.nextLine();
													
													switch(opcao) {
													
														case "1":
															conteudos.remove(cont);
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
							
										}else System.out.println("Ação negada, não existem conteúdos cadastrados.");
							
										break;
									case "V":
										voltar = false;
										break;
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
								opcao = leitura.nextLine().toUpperCase();
								
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
								
								if(grupos.size() > 0) {
									
									do {
										
										if(grupoAlt.size() == 0) {
											grupoAlt = new ArrayList<Grupo>(grupos);
											System.out.println("Grupos");
										}else System.out.println("Resultado da busca");
										
										for(Grupo grupo:grupoAlt) {
											System.out.println(grupoAlt.indexOf(grupo) +". " + grupo.getNome());
										}
										
										System.out.println("Informe o número do conteúdo desejado: ");
										
										try {
											
											posicao = Integer.parseInt(leitura.nextLine());
											
											if(posicao >= grupoAlt.size()) {
												throw new OpcaoInexistenteException();
											}
											
											prosseguir = true;
											grup = grupoAlt.get(posicao);
											
										} catch (NumberFormatException excecao) {
											System.out.println("O valor informado não é um número inteiro");
										} catch (OpcaoInexistenteException excecao) {
											System.out.println(excecao.getMessage());
											grupoAlt.clear();
										}
										
									}while(!prosseguir);
									
									System.out.println("Nome: " + grupoAlt.get(posicao).getNome());
									System.out.println("Disciplina: " + grupoAlt.get(posicao).getDisciplina().getNome());
									System.out.println("Criador: " + grupoAlt.get(posicao).getCriador().getNome());
									System.out.println("Quantidade de Usuários: " + grupoAlt.get(posicao).getUsuariosGrupo().size());
									System.out.println("Tipo: " + grupoAlt.get(posicao).getTipo());
									
								}
								
								System.out.println("Grupo");
								System.out.println("1.Pesquisar Grupo\n2.Consultar Grupo de Pesquisa por Disciplina\n"
										+ "3.Consultar Grupos com Mais Usuarios\n4.Entrar no Grupo");
								if(usuarioAtual.getClass() == Professor.class) 
									System.out.println("5.Criar Grupo\n6.Excluir Grupo");
								System.out.println("V.Volta");
								opcao = leitura.nextLine().toUpperCase();
								
								grupoAlt.clear();
								prosseguir = false;
								
								switch(opcao) {
								
									case "1":
										
										System.out.println("Pesquisar Grupo");
										
										System.out.println("Informe o nome do grupo: ");
										nome = leitura.nextLine();
										
										grupoAlt = Grupo.pesquisarGrupos(grupos, nome);
										
										if(grupoAlt.size() == 0) System.out.println("Não foi encontrado nenhum grupo com o nome informado");
										
										break;
									case "2":
										
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
												grupoAlt.clear();
											}
										
										}while(!prosseguir);
										
										grupoAlt = Grupo.consultarGpPesquisaPorDisciplina(grupos, disciplinas.get(posicao));
										
										if(grupoAlt.size() == 0) System.out.println("Não foi encontrado nenhum grupo de pesquisa com a disciplina informada");
									
										prosseguir = false;

										break;
										
									case "3":
										
										Grupo.consultarGrupoMaisUsuarios(grupos);
										
										System.out.println("TOP 10 Grupos com mais usuários");
										
										for(Grupo grupo:grupos) {
											System.out.println("Nome: " + grupo.getNome() + 
													" Quantidade de usuários: " + grupo.getUsuariosGrupo().size());
											if(grupos.indexOf(grupo) == 9) break;
										}
										
										break;
										
									case "4":
										
										posicao = grupos.indexOf(grup);
										
										if(!grupos.get(posicao).getUsuariosGrupo().contains(usuarioAtual)) {
											grupos.get(posicao).setUsuariosGrupo(usuarioAtual);
											System.out.println("Usuário foi aceito no grupo");
										}else System.out.println("O usuário já faz parte do grupo");
											
								}
								
								if(usuarioAtual.getClass() == Professor.class) {
									switch(opcao) {
										case "5":
											
											System.out.println("Criar Grupo");
											
											System.out.println("Informe o nome do grupo: ");
											nome = leitura.nextLine();
											
											do {
												
												System.out.println("Tipo do grupo\n1. Pesquisa\n2. Trabalho");
												tipo = leitura.nextLine();
												
												switch (opcao) {
													case "1":
														tipo = "Pesquisa";
														break;
													case "2":
														tipo = "Trabalho";
														break;
													default:
														System.out.println("Opção inválida");
												}
													
											}while(!tipo.equals("1") && tipo.equals("2"));
											
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
										case "6":
											
											if(grupos.size() > 0) {
												
												if(grup.getCriador().equals(usuarioAtual)) {
													
													do {
														
														System.out.println("Você tem certeza que deseja excluir o grupo? "
																+ "Essa ação não pode ser desfeita\n1.Sim\n2.Não");
														opcao = leitura.nextLine();
														
														switch(opcao) {
														
															case "1":
																grupos.remove(grup);
																System.out.println("Grupo excluído");
																break;
															case "2":
																System.out.println("Grupo não excluído");
																break;
															default:
																System.out.println("Opção invàlida");
														}
													}while(!opcao.equals("1") && !opcao.equals("2"));
													
												} else System.out.println("Ação negada, somente o criador do grupo tem permissão para excluí-lo");

											}else System.out.println("Ação negada, não existem grupos cadastrados.");
											
											break;
									}	
								}
								
								if(usuarioAtual.getClass() == Professor.class && (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5")) && !opcao.equals("6")|| 
										usuarioAtual.getClass() == Aluno.class && (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3") && !opcao.equals("4"))) {
									switch(opcao) {
									case "V":
										voltar = false;
										break;
									default:
										System.out.println("Opção inválida");
									}
								}
								
							}while(voltar);
							
							break;
						
						case "4":
							
							do {
								
								System.out.println("Conta");
								System.out.println("1.Mudar Nome\n2.Mudar Senha\n3.Excluir Conta\nV.voltar");
								opcao = leitura.nextLine().toUpperCase();
								
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
								
								if(disciplinas.size() > 0) {
									
									do {
										
										if(disciplinaAlt.size() == 0) {
											disciplinaAlt = new ArrayList<Disciplina>(disciplinas);
											System.out.println("Disciplinas");
										}else System.out.println("Resultado da busca");
										
										for(Disciplina disciplina:disciplinaAlt) {
											System.out.println(disciplinaAlt.indexOf(disciplina) +". " + disciplina.getNome());
										}
										
										System.out.println("Informe o número da disciplina desejado: ");
										
										try {
											
											posicao = Integer.parseInt(leitura.nextLine());
											
											if(posicao >= disciplinaAlt.size()) {
												throw new OpcaoInexistenteException();
											}
											
											prosseguir = true;
											disc = disciplinaAlt.get(posicao);
											
										} catch (NumberFormatException excecao) {
											System.out.println("O valor informado não é um número inteiro");
										} catch (OpcaoInexistenteException excecao) {
											System.out.println(excecao.getMessage());
											disciplinaAlt.clear();
										}
										
									}while(!prosseguir);
									
									System.out.println("Nome: " + disciplinaAlt.get(posicao).getNome());
									
								}
								
								System.out.println("1.Pesquisar Disciplina\n2.Cadastrar Disciplina\n3.Excluir Disciplina\nV.Voltar");
								opcao = leitura.nextLine().toUpperCase();
								
								disciplinaAlt.clear();
								prosseguir = false;
								
								switch(opcao) {
								
									case "1":
										
										System.out.println("Informe o nome da disciplina: ");
										nome = leitura.nextLine();
										
										disciplinaAlt = Disciplina.pesquisarDisciplinas(disciplinas, nome);
										
										if(disciplinaAlt.size() == 0) System.out.println("Não foi encontrado nenhuma disciplina com o nome informado");
								
										break;
									case "2":
										
											System.out.println("Informe O nome da Diciplina que deseja adicionar");
											nome = leitura.nextLine();
											
											disciplinas.add(new Disciplina(nome));
											
											System.out.println("Disciplina cadastrada");
											
										break;
									case "3":
				
										if(disciplinas.size() > 0) {
											
											do {
												System.out.println("Você tem certeza que deseja excluir a disciplina? "
														+ "Essa ação não pode ser desfeita\n1.Sim\n2.Não");
												opcao = leitura.nextLine();
												
												switch(opcao) {
												
													case "1":
														disciplinas.remove(disc);
														System.out.println("Disciplina excluído");
														break;
													case "2":
														System.out.println("Disciplina não excluído");
														break;
													default:
														System.out.println("Opção invàlida");
												}
											}while(!opcao.equals("1") && !opcao.equals("2"));
												
										}else System.out.println("Ação negada, não existem disciplinas cadastrados.");
											
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
								
								if(cursos.size() > 0) {
									
									do {
										
										if(cursoAlt.size() == 0) {
											cursoAlt = new ArrayList<Curso>(cursos);
											System.out.println("Curso");
										}else System.out.println("Resultado da busca");
										
										for(Curso curso:cursoAlt) {
											System.out.println(cursoAlt.indexOf(curso) +". " + curso.getNome());
										}
										
										System.out.println("Informe o número do curso desejado: ");
										
										try {
											
											posicao = Integer.parseInt(leitura.nextLine());
											
											if(posicao >= cursoAlt.size()) {
												throw new OpcaoInexistenteException();
											}
											
											prosseguir = true;
											cur = cursoAlt.get(posicao);
											
										} catch (NumberFormatException excecao) {
											System.out.println("O valor informado não é um número inteiro");
										} catch (OpcaoInexistenteException excecao) {
											System.out.println(excecao.getMessage());
											cursoAlt.clear();
										}
										
									}while(!prosseguir);
									
									System.out.println("Nome: " + cursoAlt.get(posicao).getNome());
									System.out.println("Semestres: " + cursoAlt.get(posicao).getSemestres());
									
								}
								
								System.out.println("1.Pesquisar Curso\n2.Cadastrar Curso\n3.Excluir Curso\nV.Voltar");
								opcao = leitura.nextLine().toUpperCase();
								
								cursoAlt.clear();
								prosseguir = false;
								
								switch(opcao) {
								
									case "1":
										
										System.out.println("Informe o nome do curso: ");
										nome = leitura.nextLine();
										
										cursoAlt = Curso.pesquisaCurso(cursos, nome);
										
										if(cursoAlt.size() == 0) System.out.println("Não foi encontrado nenhum curso com o nome informado");
										break;
 									case "2":
										
										System.out.println("Cadastrar Curso");
										
										System.out.println("Informe o nome do curso: ");
										nome = leitura.next();
										
										System.out.println("Informe a quantidade de semestres do curso: ");
										semestres = Integer.parseInt(leitura.next());
										
										cur = new Curso(nome, semestres);
										
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
											
											cur.setDisciplinasPorSemestre(semestre, disciplinas.get(posicao));
											
											
											do {
												System.out.println("Deseja cadastrar outra disciplina no curso?\n1. Sim\n2. Não");
												opcao = leitura.nextLine();
												
												if(!opcao.equals("1") && !opcao.equals("2")) System.out.println("Opção inválida");
													
											}while(!opcao.equals("1") && !opcao.equals("2"));
																						
										}while(opcao.equals("1"));
										
										cursos.add(cur);
										
										System.out.println("Curso cadastrado");
										
										prosseguir = false;
				
										break;
									case "3":
										
										if(cursos.size() > 0) {
											
											do {
												
												System.out.println("Você tem certeza que deseja excluir o curso? "
														+ "Essa ação não pode ser desfeita\n1.Sim\n2.Não");
												opcao = leitura.nextLine();
												
												switch(opcao) {
												
													case "1":
														cursos.remove(cur);
														System.out.println("Curso excluído");
														break;
													case "2":
														System.out.println("Curso não excluído");
														break;
													default:
														System.out.println("Opção invàlida");
												}
											}while(!opcao.equals("1") && !opcao.equals("2"));

										}else System.out.println("Ação negada, não existem cursos cadastrados.");
										
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
					
					if(usuarioAtual.getClass() == Aluno.class && (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3") && !opcao.equals("4") && !opcao.equals("5") && !opcao.equals("6") && !opcao.equals("V")) || 
							usuarioAtual.getClass() == Professor.class && (!opcao.equals("1") && !opcao.equals("2") && !opcao.equals("3") && !opcao.equals("4")) && !opcao.equals("V")){
						switch (opcao){
						case "S":
							sair = false;
							entrou = false;
							break;
						default:
							System.out.println("Opção inválida");
						}
					}
					
				}while(sair);	
			}
		}			
	}				
}					
		