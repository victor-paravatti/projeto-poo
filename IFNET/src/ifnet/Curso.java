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
	
	public Curso(String nome, int semestres) {
		this.nome = nome;
		this.semestres = semestres;
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
	
	public static ArrayList<Curso> cadastrarCurso() {
		
		String nome;
		int semestres, opcao;
		ArrayList<Curso> novosCursos = new ArrayList<Curso>();
		
		do {
			
			System.out.println("Cadastrar Curso");
			
			System.out.println("Informe o nome do curso: ");
			nome = leitura.next();
			
			System.out.println("Informe a quantidade de semestres do curso: ");
			semestres = Integer.parseInt(leitura.next());
			
			System.out.println("Deseja cadastrar outra disciplina no curso?\n1. Sim\n2. Não");
			opcao = Integer.parseInt(leitura.nextLine());
			
			novosCursos.add(new Curso(nome, semestres));
			
		}while(opcao != 2);
		
		return novosCursos;
	}
	
	public static Boolean excluirCurso(ArrayList<Curso> cursos, Curso curso) {
		return cursos.remove(curso);
	}

}
