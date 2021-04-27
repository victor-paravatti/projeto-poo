package ifnet;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		//cria os ArrayList onde as classes ficaram salvas
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
		ArrayList<Conteudo> conteudos = new ArrayList<Conteudo>();
		ArrayList<Grupo> grupos = new ArrayList<Grupo>();
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		Map<String,String> map =new HashMap<String,String>();		
		Scanner leitura = new Scanner(System.in);
		
		Usuario usuarioAtual = null;
		boolean comecar = true, sair = true, voltar = true, entrou = false;
		String opcao = "";		
	
		while(comecar) {
			
			do {
				//p�gina principal do sistema
				System.out.println("Bem vindo ao IFNET");
				System.out.println("1.Entrar\n2.Criar nova conta\nS.Sair");
				opcao = leitura.nextLine();
			
				switch(opcao) {
				
					case "1":
						
						do {
							usuarioAtual = Usuario.loginUsuario(usuarios);
							if(usuarioAtual  != null) {
								entrou = true;
								sair = false;
							} else {
								System.out.println("O e-mail e a senha fornecidos n�o correspondem �s "
										+ "informa��es em nossos registros. Verifique-as e tente novamente.");
							}
						}while(usuarioAtual == null);
						
						break;
					case "2":
						usuarios.add(Usuario.cadastrarUsuario());
						break;
					case "S":
						comecar = sair = false;
						break;
					default:
						System.out.println("Op��o Inv�lida");
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
										System.out.println("Conte�do publicado");
										break;
									case "2":
									System.out.println("Conte�do excluido");
										break;
									case "V":
										voltar = false;
									default:
										System.out.println("Op��o inv�lida");
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
										System.out.println("Op��o inv�lida");
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
										Grupo.consultarGpPesquisaPorDisciplina(grupos, disciplinas, usuarioAtual);;
										break;
									case "2":
										Grupo.consultarGrupoMaisUsuarios(grupos);
										break;
								}
								
								if(usuarioAtual.getClass() == Professor.class) {
									switch(opcao) {
										case "3":
											grupos.add(Grupo.criarGrupo(disciplinas, usuarioAtual));
											break;
										case "4":
											Grupo.excluirGrupo(grupos, usuarioAtual);
											break;
									}	
								}
								
								switch(opcao) {
									case "V":
										voltar = false;
										break;
									default:
										System.out.println("Op��o inv�lida");
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
										usuarioAtual.setNome();
										break;
									case "2":
										usuarioAtual.setSenha();
										break;
									case "3":
										if(Usuario.excluirUsuario(usuarios, usuarioAtual)) {
											sair = false;
											entrou = false;
										}
										break;
									case "V":
										voltar = false;
										break;
									default:
										System.out.println("Op��o inv�lida");
										
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
										disciplinas.addAll(Disciplina.cadastrarDisciplina(disciplinas));
										break;
									case "2":
										System.out.println("Disciplina excluida");
										break;
									case "V":
										voltar = false;
										break;
									default:
										System.out.println("Opção invalida");
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
										cursos.addAll(Curso.cadastrarCurso(disciplinas));
										break;
									case "2":
										Curso.excluirCurso(cursos);
										break;
									case "V":
										voltar = false;
										break;
									default:
										System.out.println("Op��o inv�lida");
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
							System.out.println("Op��o inv�lida");
					}
				}while(sair);	
			}
		}			
	}				
}					
		