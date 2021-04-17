package ifnet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Grupo {
	
	private String nome;
	private Disciplina disciplina;
	private ArrayList<Usuario> usuariosGrupo = new ArrayList<Usuario>();
	private Professor criador;
	private String tipo;
	
	static Scanner leitura = new Scanner(System.in);
	
	public Grupo(String nome, ArrayList<Disciplina> disciplinas, Professor criador, String tipo) {
		this.nome = nome;
		this.setDisciplina(disciplinas);
		this.criador = criador;
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
	
	public Professor getCriador() {
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
	
	
	public static Grupo criarGrupo(ArrayList<Disciplina> disciplinas, Professor criador) {
		
		String nome, tipo;
		
		System.out.println("Criar Grupo");
		
		System.out.println("Informe o nome do grupo: ");
		nome = leitura.nextLine();
		
		System.out.println("Tipo do grupo\n1. Pesquisa\n2. Trabalho");
		tipo = leitura.nextLine();
		
		Grupo novoGrupo = new Grupo(nome, disciplinas, criador, tipo);
		
		return novoGrupo;
		
	}
	
	
	public static Boolean excluirGrupo(ArrayList<Grupo> grupos) {
		
		Grupo grupoExcluir;
		
		grupoExcluir = Grupo.exibirGrupos(grupos);
		
		return grupos.remove(grupoExcluir);
	}
	
	
	public void consultarGrupoMaisUsuarios(ArrayList<Grupo> grupos) {
		
		System.out.println("TOP 10 - Grupo com com mais usuários");
		
		Arrays.sort(grupos);
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
		
		if(encontrado == 0) System.out.println("Não existe nenhum grupo com a disciplina escolhida");
		else {
			System.out.println("Informe o número do grupo que deseja participar. Se não deseja participar de nenhum grupo, digite -1");
			opcao = Integer.parseInt(leitura.nextLine());
			
			if(opcao != -1) {
				
				grupos.get(opcao).setUsuariosGrupo(usuario);
				System.out.println("Você está no grupo " + grupos.get(opcao).getNome());
				
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
		
		System.out.println("Informe o número da grupo desejado: ");
		posicao = Integer.parseInt(leitura.nextLine());
		
		grupoEscolhido = grupos.get(posicao);
		
		return grupoEscolhido;
		
	}

}
