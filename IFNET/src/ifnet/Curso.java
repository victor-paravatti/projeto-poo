

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Curso {
	
	private String nome;
	private int semestres;
	private Map<Integer, Disciplina> disciplinasPorSemestre = new HashMap<Integer, Disciplina>();
	
	static Scanner leitura = new Scanner(System.in);
	
	public Curso(String nome) {
		this.nome = nome;
	}
	
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

	public Map<Integer, Disciplina> getDisciplinasPorSemestre() {
		return disciplinasPorSemestre;
	}

	public void setDisciplinasPorSemestre(ArrayList<Disciplina> disciplinas) {
		
		int opcao, semestre;
		Disciplina disciplinaEscolhida;
		
		do {
			
			disciplinaEscolhida = Disciplina.exibirDisciplinas(disciplinas);
			
			System.out.println("Informe o semetre da disciplina");
			semestre = Integer.parseInt(leitura.nextLine());
			
			System.out.println("Deseja cadastrar outra disciplina no curso?\n1. Sim\n2. N�o");
			opcao = Integer.parseInt(leitura.nextLine());
			
			this.disciplinasPorSemestre.put(semestre, disciplinaEscolhida);
			
		}while(opcao != 2);
		
	}
	
	public static ArrayList<Curso> cadastrarCurso(ArrayList<Disciplina> disciplinas) {
		
		String nome;
		int semestres, opcao = 0;
		ArrayList<Curso> novosCursos = new ArrayList<Curso>();
		
		do {
			
			System.out.println("Cadastrar Curso");
			
			System.out.println("Informe o nome do curso: ");
			nome = leitura.next();
			
			System.out.println("Informe a quantidade de semestres do curso: ");
			semestres = Integer.parseInt(leitura.next());
			
			System.out.println("Deseja cadastrar outro curso?\n1.Sim\n2.N�o");
			opcao = Integer.parseInt(leitura.next());
			
			if(opcao !=1 && opcao != 2) System.out.println("Op��o inv�lida");
		
			novosCursos.add(new Curso(nome, semestres, disciplinas));
			
		}while(opcao !=1 && opcao != 2);
		
		System.out.println("Curso cadastrado!");
			
		return novosCursos;
	}
	
	public static void excluirCurso(ArrayList<Curso> cursos) {
		
		Curso cursoExcluir;
		int opcao;
		
		cursoExcluir = Curso.exibirCursos(cursos);
				
		do {
			
			System.out.println("Voc� tem certeza que deseja excluir o curso? "
					+ "Essa a��o n�o pode ser desfeita\n1.Sim\n2.N�o");
			opcao = Integer.parseInt(leitura.nextLine());
			
			switch(opcao) {
			
				case 1:
					cursos.remove(cursoExcluir);
					System.out.println("Curso exclu�do");
				case 2:
					System.out.println("Curso n�o exclu�do");
					break;
				default:
					System.out.println("Op��o inv�lida");
			}
		}while(opcao != 1 && opcao != 2);
	}
	
	public static Curso exibirCursos(ArrayList<Curso> cursos) {
		
		int posicao;
		Curso cursoEscolhido;
		
		System.out.println("Cursos");
		
		for(Curso curso:cursos) {
			posicao = cursos.indexOf(curso);
			System.out.println(posicao + ": " + curso.getNome());
		}
		
		System.out.println("Informe o n�mero da grupo desejado: ");
		posicao = Integer.parseInt(leitura.nextLine());
		
		cursoEscolhido = cursos.get(posicao);
		
		return cursoEscolhido;
		
	}
	
}