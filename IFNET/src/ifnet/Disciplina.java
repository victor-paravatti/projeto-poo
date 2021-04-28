package ifnet;

import java.util.ArrayList;

public class Disciplina {
	
	private String nome;
	
	public Disciplina(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public static ArrayList<Disciplina> pesquisarDisciplinas(ArrayList<Disciplina> disciplinas, String nome) {
	
		ArrayList<Disciplina> disciplinaPesquisada = new ArrayList<Disciplina>();
		
		for(Disciplina disciplina:disciplinas) 
			if(disciplina.getNome().toLowerCase().contains(nome.toLowerCase())) 
				disciplinaPesquisada.add(disciplina);
		
		return disciplinaPesquisada;
		
	}

}
