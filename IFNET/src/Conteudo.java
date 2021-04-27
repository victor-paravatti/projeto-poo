package ifnet;

import java.util.ArrayList;
import java.util.Scanner;

public class Conteudo {
	
	private String tipoConteudo;
	private Usuario publicador;

	static Scanner leitura = new Scanner(System.in);
	
	public Conteudo(String nome, String publicador2) {
		Conteudo conteudo = this;
		conteudo.tipoConteudo = tipoConteudo;
		conteudo.publicador = publicador;
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
	
	public void inseriConteudo(Conteudo novoConteudo) {
		
		String tipoConteudo, publicador;
		int opc = 0;

		do {

			System.out.println("Informe O tipo de conteudo que deseja adicionar");
			tipoConteudo = leitura.nextLine();
			System.out.println("Informe O publicadorn oqual conteudo pertence");
			publicador = leitura.nextLine();			
			opc = Integer.parseInt(leitura.nextLine());

			novoConteudo = new Conteudo(tipoConteudo, publicador);

		}while( opc !=0 );
		
	}
	
	public static boolean excluirDiciplina(ArrayList<Conteudo> tipoConteudos, Conteudo tipoConteudo) {	
		return  tipoConteudos.remove(tipoConteudo);
	}

}
