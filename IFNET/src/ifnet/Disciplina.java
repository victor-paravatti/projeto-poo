

import java.util.ArrayList;

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

		}while( opc != 1 );
			
		return novasDisciplinas;

	}
	
	//excluir a disciplina
	public static boolean excluirDiciplina(ArrayList<Disciplina> disciplinas, Disciplina disciplina) {	
		return  disciplinas.remove(disciplina);
	}
	
	public static Disciplina exibirDisciplinas(ArrayList<Disciplina> disciplinas) {
		
		int posicao;
		Disciplina disciplinaEscolhida;
		
		System.out.println("Disciplinas");
		
		for(Disciplina disciplina:disciplinas) {
			posicao = disciplinas.indexOf(disciplina);
			System.out.println(posicao + ". " + disciplina.getNome());
		}
		
		System.out.println("Informe o n�mero da disciplina desejada: ");
		posicao = Integer.parseInt(leitura.nextLine());

	public static ArrayList<Disciplina> pesquisarDisciplinas(ArrayList<Disciplina> disciplinas, String nome) {
	
		ArrayList<Disciplina> disciplinaPesquisada = new ArrayList<Disciplina>();

		
		for(Disciplina disciplina:disciplinas) 
			if(disciplina.getNome().toLowerCase().contains(nome.toLowerCase())) 
				disciplinaPesquisada.add(disciplina);
		
		return disciplinaPesquisada;
		
	}

}
