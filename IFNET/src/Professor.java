package ifnet;

import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends Usuario{
	
	private Area area;
	private Disciplina disciplMinistrada;
	
	Scanner leitura = new Scanner(System.in);
	
	public Professor(String nome, String prontuario, String senha, Area area, Disciplina disciplMinistrada) {
		super(nome, prontuario, senha);
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
	
	public void setDiciplMinistrada(ArrayList<Disciplina> disciplinas) {
		this.disciplMinistrada = Disciplina.exibirDisciplinas(disciplinas);
	}

}
