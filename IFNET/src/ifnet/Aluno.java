package ifnet;

import java.util.Scanner;

public class Aluno extends Usuario{
	
	private String email;
	private Curso curso;
	
	Scanner leitura = new Scanner(System.in);
	
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

	@Override
	public Usuario cadastrarUsuario() {
		
		String nome, prontuario, email, curso;
		
		System.out.println("Informe o nome: ");
		nome = leitura.nextLine();
		
		System.out.println("Informe o prontuário: ");
		prontuario = leitura.nextLine();
		
		System.out.println("Informe o e-mail: ");
		email = leitura.nextLine();
		
		System.out.println("Informe o curso: ");
		curso = leitura.nextLine();
		
		Aluno aluno = new Aluno(nome, prontuario, email, new Curso(curso)); 
		
		return aluno;
	}
	
	
}
