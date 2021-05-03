

import java.util.ArrayList;

public class Grupo {
	
	private String nome;
	private Disciplina disciplina;
	private ArrayList<Usuario> usuariosGrupo = new ArrayList<Usuario>();
	private Usuario criador;
	private String tipo;
		
	public Grupo(String nome, Disciplina disciplina, Usuario usuarioAtual, String tipo) {
		this.nome = nome;
		this.disciplina = disciplina;
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
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
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
			
			System.out.println("Vocï¿½ tem certeza que deseja excluir o grupo? "
					+ "Essa aï¿½ï¿½o nï¿½o pode ser desfeita\n1.Sim\n2.Nï¿½o");
			opcao = Integer.parseInt(leitura.nextLine());
			
			switch(opcao) {
			
				case 1:
					if(grupoExcluir.getCriador() == usuario) {
						grupos.remove(grupoExcluir);
						System.out.println("Grupo excluï¿½do");
					} else System.out.println("Vocï¿½ nï¿½o tem permissï¿½o para excluir esse grupo,"
							+ "somente o criador do grupo pode excluï¿½-lo");
				case 2:
					System.out.println("Curso nï¿½o excluï¿½do");
					break;
				default:
					System.out.println("Opï¿½ï¿½o invï¿½lida");
			}
		}while(opcao != 1 && opcao != 2);
	}
	
	public static void consultarGrupoMaisUsuarios(ArrayList<Grupo> grupos) {
		
		System.out.println("TOP 10 - Grupo com com mais usuï¿½rios");
		
		Collections.sort(grupos);

	public static void consultarGrupoMaisUsuarios(ArrayList<Grupo> grupos) {
		
		Grupo grupoAlt ;

		
		int priPo, segPo;
		
		for(priPo = 0; priPo < grupos.size(); priPo++ ) {
			for(segPo = 0; segPo < grupos.size(); segPo++) {
				if(grupos.get(priPo).getUsuariosGrupo().size() < grupos.get(segPo).getUsuariosGrupo().size()) {
					grupoAlt = grupos.get(priPo);
					grupos.add(priPo, grupos.get(segPo));
					grupos.add(segPo, grupoAlt);
				};
			}
		}
	}
	
	public static ArrayList<Grupo> consultarGpPesquisaPorDisciplina(ArrayList<Grupo> grupos, Disciplina disciplina) {
		
		ArrayList<Grupo> gruposPesquisados = new ArrayList<Grupo>();
		
		for(Grupo grupo:grupos) {
			if(grupo.getDisciplina().getNome().contains(disciplina.getNome()) && grupo.getTipo().equals("Pesquisa")) 
				gruposPesquisados.add(grupo);
		}
		

		if(encontrado == 0) System.out.println("Nï¿½o existe nenhum grupo com a disciplina escolhida");
		else {
			System.out.println("Informe o nï¿½mero do grupo que deseja participar. Se nï¿½o deseja participar de nenhum grupo, digite -1");
			opcao = Integer.parseInt(leitura.nextLine());
			
			if(opcao != -1) {
				
				grupos.get(opcao).setUsuariosGrupo(usuario);
				System.out.println("Vocï¿½ estï¿½ no grupo " + grupos.get(opcao).getNome());
				
			}
		}

		return gruposPesquisados;

	}
	
	public static ArrayList<Grupo> pesquisarGrupos(ArrayList<Grupo> grupos, String nome) {
		
		ArrayList<Grupo> gruposPesquisados = new ArrayList<Grupo>();
		
		for(Grupo grupo:grupos) 
			if(grupo.getNome().toLowerCase().contains(nome.toLowerCase())) 
				gruposPesquisados.add(grupo);
		

		for(Grupo grupo:grupos) {
			posicao = grupos.indexOf(grupo);
			System.out.println(posicao + ": " + grupo.getNome());
		}
		
		System.out.println("Informe o nï¿½mero da grupo desejado: ");
		posicao = Integer.parseInt(leitura.nextLine());
		
		grupoEscolhido = grupos.get(posicao);
		
		return grupoEscolhido;

		return gruposPesquisados;

		
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + 
				"\nDisciplina: " + this.disciplina.getNome() + 
				"\nQuantidade de Usuários: " + this.usuariosGrupo.size() + 
				"\nCriador: " + this.criador.getNome() + 
				"\nTipo: " + this.tipo;
	}
	
	

}
