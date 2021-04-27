package ifnet;

import java.util.ArrayList;
import java.util.Scanner;

public class Conteudo {
	
	private String tipoConteudo;
	private Usuario publicador;

	static Scanner leitura = new Scanner(System.in);
	
	public Conteudo(String tipoConteudo, Usuario publicador) {
		this.tipoConteudo = tipoConteudo;
		this.publicador = publicador;
	}	
	
	public String getTipoConteudo() {
		return tipoConteudo;
	}
	public void setTipoConteudo(String tipoConteudo) {
		this.tipoConteudo = tipoConteudo;
	}
	public Usuario getPublicador() {
		return publicador;
	}
	public void setPublicador(Usuario publicador) {
		this.publicador = publicador;
	}
	
	public static Conteudo inseriConteudo(ArrayList<Conteudo> conteudos, Usuario usuario) {
		
		Conteudo novoConteudo;
		String tipoConteudo;

		System.out.println("Informe O tipo de conteudo que deseja adicionar");
		tipoConteudo = leitura.nextLine();	

		novoConteudo = new Conteudo(tipoConteudo, usuario);
		
		return novoConteudo;
	}
	
	public static void excluirConteudo(ArrayList<Conteudo> conteudos) {
		
		Conteudo conteudoExcluir;
		int opcao;
		
		conteudoExcluir = Conteudo.exibirConteudos(conteudos);
				
		do {
			
			System.out.println("Você tem certeza que deseja excluir o conteudo? "
					+ "Essa ação não pode ser desfeita\n1.Sim\n2.Não");
			opcao = Integer.parseInt(leitura.nextLine());
			
			switch(opcao) {
			
				case 1:
					conteudos.remove(conteudoExcluir);
					System.out.println("Conteudo excluído");
				case 2:
					System.out.println("Conteudo não excluído");
					break;
				default:
					System.out.println("Opção invàlida");
			}
		}while(opcao != 1 && opcao != 2);
	}

	private static Conteudo exibirConteudos(ArrayList<Conteudo> conteudos) {
		// TODO Auto-generated method stub
		return null;
	}

}
