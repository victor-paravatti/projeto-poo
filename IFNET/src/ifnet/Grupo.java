package ifnet;

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
		
		return gruposPesquisados;
	}
	
	public static ArrayList<Grupo> pesquisarGrupos(ArrayList<Grupo> grupos, String nome) {
		
		ArrayList<Grupo> gruposPesquisados = new ArrayList<Grupo>();
		
		for(Grupo grupo:grupos) 
			if(grupo.getNome().toLowerCase().contains(nome.toLowerCase())) 
				gruposPesquisados.add(grupo);
		
		return gruposPesquisados;
		
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + 
				"\nDisciplina: " + this.disciplina.getNome() + 
				"\nQuantidade de Usu�rios: " + this.usuariosGrupo.size() + 
				"\nCriador: " + this.criador.getNome() + 
				"\nTipo: " + this.tipo;
	}
	
	

}
