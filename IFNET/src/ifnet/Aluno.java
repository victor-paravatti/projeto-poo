package ifnet;

public class Aluno extends Usuario{
	
	private String email;
	private Curso curso;
	
	public Aluno(String nome, String prontuario, String email, Curso curso) {
		super(nome, prontuario);
		this.email = email;
		this.curso = curso;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	
}
