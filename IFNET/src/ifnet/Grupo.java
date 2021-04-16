package ifnet;

import java.util.ArrayList;

public class Grupo {
	
	private String nome;
	private Disciplina disciplina;
	private ArrayList<Usuario> usuariosGrupo = new ArrayList<Usuario>();
	private Professor criador;
	private String tipo;
	
	public Grupo() {
		
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
	
	//implementar
	public void criarGrupo() {
		
	}
	
	//implementar
	public void excluirGrupo() {
		
	}
	
	//implementar
	public void consultarGrupoMaisUsuarios() {
		
	}
	
	//implementar
	public Grupo consultarGpPesquisaPorDisciplina(ArrayList<Grupo> grupos, Disciplina disciplina) {
		return null;
	}

}
