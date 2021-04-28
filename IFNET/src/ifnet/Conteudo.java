package ifnet;

import java.util.ArrayList;
import java.util.Scanner;

public class Conteudo {
	
	private String titulo;
	private String tipo;
	private Usuario publicador;

	static Scanner leitura = new Scanner(System.in);
	
	public Conteudo(String titulo, String tipoConteudo, Usuario publicador) {
		this.titulo = titulo;
		this.tipo = tipoConteudo;
		this.publicador = publicador;
	}	
	
	public String getTipoConteudo() {
		return tipo;
	}
	public void setTipoConteudo(String tipoConteudo) {
		this.tipo = tipoConteudo;
	}
	public Usuario getPublicador() {
		return publicador;
	}
	public void setPublicador(Usuario publicador) {
		this.publicador = publicador;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public static ArrayList<Conteudo> pesquisarConteudos(ArrayList<Conteudo> conteudos, String titulo) {
		
		ArrayList<Conteudo> conteudosPesquisados = new ArrayList<Conteudo>();
		
		for(Conteudo conteudo:conteudos) {
			if(conteudo.getTitulo().toLowerCase().contains(titulo.toLowerCase())) 
				conteudosPesquisados.add(conteudo);
		}
		
		return conteudosPesquisados;
		
	}

}
