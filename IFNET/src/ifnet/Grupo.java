

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grupo implements Comparable<Object>{
	
	private String nome;
	private Disciplina disciplina;
	private ArrayList<Usuario> usuariosGrupo = new ArrayList<Usuario>();
	private Usuario criador;
	private String tipo;
	
	static Scanner leitura = new Scanner(System.in);
	
	public Grupo(String nome, ArrayList<Disciplina> disciplinas, Usuario usuarioAtual, String tipo) {
		this.nome = nome;
		this.setDisciplina(disciplinas);
		this.criador = usuarioAtual;
		this.tipo = tipo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(ArrayList<Disciplina> disciplinas) {
		this.disciplina = Disciplina.exibirDisciplinas(disciplinas);
	}
	
	public ArrayList<Usuario> getUsuariosGrupo() {
		return usuariosGrupo;
	}

	public void setUsuariosGrupo(Usuario usuario) {
		this.usuariosGrupo.add(usuario);
	}
	
	public Usuario getCriador() {
		return criador;
	}
	
	public void setCriador(Professor criador) {
		this.criador = criador;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public static Grupo criarGrupo(ArrayList<Disciplina> disciplinas, Usuario usuarioAtual) {
		
		String nome, tipo;
		
		System.out.println("Criar Grupo");
		
		System.out.println("Informe o nome do grupo: ");
		nome = leitura.nextLine();
		
		System.out.println("Tipo do grupo\n1. Pesquisa\n2. Trabalho");
		tipo = leitura.nextLine();
		
		System.out.println("Grupo criado!");
		
		Grupo novoGrupo = new Grupo(nome, disciplinas, usuarioAtual, tipo);
		
		return novoGrupo;
		
	}
	
	public static void excluirGrupo(ArrayList<Grupo> grupos, Usuario usuario) {
		
		Grupo grupoExcluir;
		int opcao = 0;
		
		grupoExcluir = Grupo.exibirGrupos(grupos);
		
		do {
			
			System.out.println("Voc� tem certeza que deseja excluir o grupo? "
					+ "Essa a��o n�o pode ser desfeita\n1.Sim\n2.N�o");
			opcao = Integer.parseInt(leitura.nextLine());
			
			switch(opcao) {
			
				case 1:
					if(grupoExcluir.getCriador() == usuario) {
						grupos.remove(grupoExcluir);
						System.out.println("Grupo exclu�do");
					} else System.out.println("Voc� n�o tem permiss�o para excluir esse grupo,"
							+ "somente o criador do grupo pode exclu�-lo");
				case 2:
					System.out.println("Curso n�o exclu�do");
					break;
				default:
					System.out.println("Op��o inv�lida");
			}
		}while(opcao != 1 && opcao != 2);
	}
	
	public static void consultarGrupoMaisUsuarios(ArrayList<Grupo> grupos) {
		
		System.out.println("TOP 10 - Grupo com com mais usu�rios");
		
		Collections.sort(grupos);
		
		for(int posicao = 0; posicao < 10; posicao ++) {
			System.out.println(posicao + 1 + ". " + grupos.get(posicao).getNome());
		};
		
	}
	
	public static void consultarGpPesquisaPorDisciplina(ArrayList<Grupo> grupos, ArrayList<Disciplina> disciplinas, Usuario usuario) {
		
		int opcao, encontrado = 0;
		
		Disciplina disciplina;
		
		System.out.println("Consultar Grupo de Pesquisa por Disciplina");
		
		disciplina = Disciplina.exibirDisciplinas(disciplinas);
		
		for(Grupo grupo:grupos) {
			
			if(grupo.getDisciplina().equals(disciplina)) {
				System.out.println(grupos.indexOf(grupo) + ". " + grupo.getNome());
			};
		
		}
		
		if(encontrado == 0) System.out.println("N�o existe nenhum grupo com a disciplina escolhida");
		else {
			System.out.println("Informe o n�mero do grupo que deseja participar. Se n�o deseja participar de nenhum grupo, digite -1");
			opcao = Integer.parseInt(leitura.nextLine());
			
			if(opcao != -1) {
				
				grupos.get(opcao).setUsuariosGrupo(usuario);
				System.out.println("Voc� est� no grupo " + grupos.get(opcao).getNome());
				
			}
		}
	}
	
	public static Grupo exibirGrupos(ArrayList<Grupo> grupos) {
		
		int posicao;
		Grupo grupoEscolhido;
		
		System.out.println("Grupos");
		
		for(Grupo grupo:grupos) {
			posicao = grupos.indexOf(grupo);
			System.out.println(posicao + ": " + grupo.getNome());
		}
		
		System.out.println("Informe o n�mero da grupo desejado: ");
		posicao = Integer.parseInt(leitura.nextLine());
		
		grupoEscolhido = grupos.get(posicao);
		
		return grupoEscolhido;
		
	}

	@Override
	public int compareTo(Object arg0) {
		
		int valor = 0;
		
		if(getUsuariosGrupo().size() == ((Grupo) arg0).getUsuariosGrupo().size()) valor = 0;
		if(getUsuariosGrupo().size() < ((Grupo) arg0).getUsuariosGrupo().size()) valor = -1;
		if(getUsuariosGrupo().size() > ((Grupo) arg0).getUsuariosGrupo().size()) valor = 1;
		
		return valor;

	}

}
