package ifnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Curso {
	
	private String nome;
	private int semestres;
	private Map<Integer, Disciplina> disciplinasPorSemestre = new HashMap<Integer, Disciplina>();
	
	static Scanner leitura = new Scanner(System.in);
	
	public Curso(String nome, int semestres, ArrayList<Disciplina> disciplinas) {
		this.nome = nome;
		this.semestres = semestres;
		this.setDisciplinasPorSemestre(disciplinas);
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
	
	
	public static Curso cadastrarCurso() {
		return null;
	}

	public Map<Integer, Disciplina> getDisciplinasPorSemestre() {
		
		
		
		
		
		
		
		
		return disciplinasPorSemestre;
	}

	public void setDisciplinasPorSemestre(ArrayList<Disciplina> disciplinas) {
		
		int posicao, opcao, semestre;
		Disciplina disciplinaEscolhida;
		
		do {
			
			System.out.println("Disciplinas");
			
			for(Disciplina disciplina:disciplinas) {
				posicao = disciplinas.indexOf(disciplina);
				System.out.println(posicao + ": " + disciplina.getNome());
			}
			
			System.out.println("Informe o número da disciplina desejada: ");
			posicao = Integer.parseInt(leitura.nextLine());
			disciplinaEscolhida = disciplinas.get(posicao);
			
			System.out.println("Informe o semetre da disciplina");
			semestre = Integer.parseInt(leitura.nextLine());
			
			System.out.println("Deseja cadastrar outra disciplina no curso?\n1. Sim\n2. Não");
			opcao = Integer.parseInt(leitura.nextLine());
			
			this.disciplinasPorSemestre.put(semestre, disciplinaEscolhida);
			
		}while(opcao != 2);
		
	}

}
