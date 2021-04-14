package ifnet;

import java.util.ArrayList;

public class Grupo {
	
	private String nome;
	private Disciplina disciplina;
	private int quantidadeUsuarios;
	private Professor criador;
	private String tipo;
	
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
	
	public int getQuantidadeUsuarios() {
		return quantidadeUsuarios;
	}
	
	public void setQuantidadeUsuarios(int quantidadeUsuarios) {
		this.quantidadeUsuarios = quantidadeUsuarios;
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
