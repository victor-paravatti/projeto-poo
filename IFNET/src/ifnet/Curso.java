package ifnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Curso {
	
	private String nome;
	private int semestres;
	private Map<Integer, Disciplina> disciplinasPorSemestre = new HashMap<Integer, Disciplina>();

	public Curso(String nome) {
		this.nome = nome;
	}
	
	public Curso(String nome, int semestres, int semestre, Disciplina disciplina) {
		this.nome = nome;
		this.semestres = semestres;
		this.disciplinasPorSemestre.put(semestre, disciplina);
	} 
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getSemestres() {
		return semestres;
	}

	public void setSemestres(int semestres) {
		this.semestres = semestres;
	}

	public Map<Integer, Disciplina> getDisciplinasPorSemestre() {
		return disciplinasPorSemestre;
	}
	
	public void setDisciplinasPorSemestre(Map<Integer, Disciplina> disciplinasPorSemestre) {
		this.disciplinasPorSemestre = disciplinasPorSemestre;
	}

	public static ArrayList<Curso> pesquisaCurso(ArrayList<Curso> cursos, String nome) {
		
		ArrayList<Curso> cursosPesquisados = new ArrayList<Curso>();
		
		for(Curso curso:cursos) {
			if(curso.getNome().toLowerCase().contains(nome.toLowerCase())) 
				cursosPesquisados.add(curso);
		}
		
		return cursosPesquisados;
	}
	
}