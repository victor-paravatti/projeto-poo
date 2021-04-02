package ifnet;

public class Grupo {
	
	private String nome;
	private Disciplina disciplina;
	private int quantidadeUsuarios;
	private Professor criador;
	private Curso curso;
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
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	//implementar
	public void consultarGrupoMaisUsuarios() {
		
	}

}
