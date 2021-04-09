package ifnet;

import java.util.ArrayList;
import java.util.LinkedList;

public class Curso {
	
	private String nome;
	private int duracao;
	private ArrayList<LinkedList<Disciplina>> disciplinas = new ArrayList<LinkedList<Disciplina>>();
	
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
	
	public ArrayList<LinkedList<Disciplina>> getDisciplinas() {
		return disciplinas;
	}
	
	public void setDisciplinas(ArrayList<LinkedList<Disciplina>> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	
}
