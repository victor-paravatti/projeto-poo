package ifnet;

import java.util.ArrayList;
import java.util.LinkedList;

public class Curso {
	
	private String nome;
	private int duracao;
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public Curso(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getDuracao() {
		return duracao;
	}
	
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	public void getDisciplinas() {
		
		for(Disciplina disciplina:this.disciplinas) {
			System.out.println(disciplinas.indexOf(disciplina) + disciplina.getNome());
		}
		
	}
	
	public void setDisciplinas(Disciplina disciplina) {
		this.disciplinas.add(disciplina);
	}
	
	public static Curso cadastrarCurso() {

		return null;
	}
}
