package ifnet;

import java.util.Scanner;

public class Professor extends Usuario{
	
	private Area area;
	private Disciplina disciplMinistrada;
	
	Scanner leitura = new Scanner(System.in);
	
	public Professor(String nome, String prontuario, Area area, Disciplina disciplMinistrada) {
		super(nome, prontuario);
		this.area = area;
		this.disciplMinistrada = disciplMinistrada;
	}
	
	public Area getArea() {
		return area;
	}
	
	public void setArea(Area area) {
		this.area = area;
	}
	
	public Disciplina getDiciplMinistrada() {
		return disciplMinistrada;
	}
	
	public void setDiciplMinistrada(Disciplina disciplMinistrada) {
		this.disciplMinistrada = disciplMinistrada;
	}

	@Override
	public Usuario cadastrarUsuario() {
		
		String nome, prontuario, area, disciplina;
		
		System.out.println("Informe o nome: ");
		nome = leitura.nextLine();
		
		System.out.println("Informe o prontuário: ");
		prontuario = leitura.nextLine();
		
		System.out.println("Informe o e-mail: ");
		area = leitura.nextLine();
		
		System.out.println("Informe o curso: ");
		disciplina = leitura.nextLine();
		
		Professor professor = new Professor(nome, prontuario, new Area(area), new Disciplina(disciplina)); 
		
		return professor;
	}

}
