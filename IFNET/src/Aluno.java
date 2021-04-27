package ifnet;

import java.util.Scanner;

public class Aluno extends Usuario{
	
	private String email;
	private Curso curso;
	
	Scanner leitura = new Scanner(System.in);
	
	public Aluno(String nome, String prontuario, String senha, String email, Curso curso) {
		super(nome, prontuario, senha);
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
