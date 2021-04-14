package ifnet;

import java.util.ArrayList;
import java.util.Scanner;

public class Disciplina {
	
	private static String nome;
	private String semestre;
	private String curso;
	
	static Scanner leitura = new Scanner(System.in);

	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public Disciplina(String nome) {
		Disciplina disciplina = this;
		Disciplina.nome = nome;
		disciplina.semestre = semestre;
		disciplina.curso = curso;

	}
	
	// Contutor para acessar as variaveis locais
	public Disciplina(String nome2, String curso2, String semestre2) {
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		Disciplina.nome = nome;
	}
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public static ArrayList<Disciplina> cadastrarDisciplina() {
		
		ArrayList<Disciplina> novasDisciplinas = new ArrayList<Disciplina>();
		String semestre, curso;
		int opc = 0;
		
		//Looop para cadastrar mais de uma Diciplina		
		do {

			System.out.println("Informe O nome da Diciplina que deseja adicionar");
			nome = leitura.nextLine();
			System.out.println("Informe O semestre no qual a Diciplina pertence");
			semestre = leitura.nextLine();
			System.out.println("Informe O curso no qual a Diciplina pertence");
			curso = leitura.nextLine();
			System.out.println("Se desejar sair do cadastro de Diciplina aperte {1}");
			opc = Integer.parseInt(leitura.nextLine());
			
			novasDisciplinas.add(new Disciplina(nome, curso, semestre));

		}while( opc !=0 );
			
		return novasDisciplinas;

	}
	
	//excluir a disciplina
	public static boolean excluirDiciplina(ArrayList<Disciplina> disciplinas, Disciplina disciplina) {	
		return  disciplinas.remove(disciplina);
	}

}
