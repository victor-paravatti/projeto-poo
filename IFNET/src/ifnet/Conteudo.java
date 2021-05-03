

import java.util.ArrayList;
import java.util.Scanner;

public class Conteudo {
	
	private String titulo;
	private String tipo;
	private Usuario publicador;

	static Scanner leitura = new Scanner(System.in);
	

	public Conteudo(String nome, String publicador2) {
		Conteudo conteudo = this;
		conteudo.tipoConteudo = tipoConteudo;
		conteudo.publicador = publicador;
	}

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
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	public static Conteudo inseriConteudo(ArrayList<Conteudo> conteudos, Usuario usuario) {
		
		Conteudo novoConteudo;
		String tipoConteudo, titulo;
		
		System.out.println("Informe o titulo do contéudo");
		titulo = leitura.nextLine();

		System.out.println("Informe O tipo de conteudo que deseja adicionar");
		tipoConteudo = leitura.nextLine();	
	
		novoConteudo = new Conteudo(titulo, tipoConteudo, usuario);
		return novoConteudo;
		
	}
	

	public static boolean excluirDiciplina(ArrayList<Conteudo> tipoConteudos, Conteudo tipoConteudo) {	
		return  tipoConteudos.remove(tipoConteudo);
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


	public static ArrayList<Conteudo> pesquisarConteudos(ArrayList<Conteudo> conteudos, String titulo) {
		

		System.out.println("Conteúdos");

		ArrayList<Conteudo> conteudosPesquisados = new ArrayList<Conteudo>();

		
		for(Conteudo conteudo:conteudos) {
			if(conteudo.getTitulo().toLowerCase().contains(titulo.toLowerCase())) 
				conteudosPesquisados.add(conteudo);
		}
		

		System.out.println("Informe o número do conteudo desejado: ");
		posicao = Integer.parseInt(leitura.nextLine());
		
		conteudoEscolhido = conteudos.get(posicao);
		
		return conteudoEscolhido;

		return conteudosPesquisados;

		

	}

	@Override
	public String toString() {
		return "Titulo: " + titulo + 
				"\nTipo: " + tipo + 
				"\nPublicador: " + publicador.getNome();
	}
	
	

}
