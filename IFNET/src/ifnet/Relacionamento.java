



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;






public class Relacionamento {

	static Scanner leitura = new Scanner(System.in);
	
	private Usuario usuario;

	Map<Integer,ArrayList<Usuario>> map = new HashMap<Integer,ArrayList<Usuario>>();
	
	public Relacionamento(Usuario usuario) {
		this.usuario = usuario;
		this.criarMapa();
	}
	
	public Usuario getUsuario(String nome) {

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;

public class Relacionamento {
	
	private Usuario usuario;
	Map<Integer,ArrayList<Usuario>> map = new HashMap<Integer,ArrayList<Usuario>>();
	
	static Scanner leitura = new Scanner(System.in);
	
	public Relacionamento(Usuario usuario) {
		this.usuario = usuario;
		this.criarMapa();
	}

	public Usuario getUsuario() {

		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void criarMapa() {
		this.map.put(1, new ArrayList<Usuario>());
		this.map.put(2, new ArrayList<Usuario>());
		this.map.put(3, new ArrayList<Usuario>());
	}

	//implementar
	public void relacionarUsuario(ArrayList<Usuario> usuarios) {
		int opc = 0 , grau;
		String nome;
		Usuario usuario;

		// ImplementaÃ§Ã£o da CriaÃ§Ã£o do grau de amizade do usuario
		do {

			System.out.println("Para Criar um vinculo de Conhecido digite {1}\n" + 
							   	"Para Criar um vinculo de Amigo digite {2}\n" + 
								"Para Criar um vinculo de Melhor Amigo digite {3}");

		 	grau = Integer.parseInt(leitura.nextLine());
			System.out.println(" Informe o Nome da Pesosa no qual deseja criar vinculo");
			nome = leitura.nextLine();
			usuario = getUsuario(nome);		
			map.get(grau).add(usuario);
			System.out.println(" Se desejar sair Aperte {1}");
			opc = Integer.parseInt(leitura.nextLine());

		}while(opc != 0);
		
	}
	
	//implementar
	public void definirGrauConfiabilidade(Map<Integer,ArrayList<Usuario>> map) {
		Usuario usuario = null;
		String nome;

	// *Implementação para criar uma relação com outro usuario e atribuir as mesmas de forma predefinida
	public static Relacionamento criarRelacionamento() {
		return null;
	}
	
	public static void alterarGrauConfiabilidade() {

		
		int opc = 0, grau;
		
		
		do {
			//iteraÃ§Ã£o para mostrar o conteudo do mapa 
			for(Map.Entry<Integer, ArrayList<Usuario>> entry : map.entrySet()){ 
				
				// Print para mostrar a chave e o valor relacionado a chave 
				System.out.println(entry.getKey() + "" + entry.getValue());	
				System.out.println("Digite o Grau de relacionamento no qual  a pessoa que deseja trocar estÃ¡");
				grau = Integer.parseInt(leitura.nextLine());

				// ImplementaÃ§Ã£o daleitura e subistuiÃ§Ã£o fo grau de relacionamento do usuario
				if(map.containsKey(grau)){
					System.out.println("Digite o nome da pesoa no qual deseja trocar de Grau de relacionamento");
					nome = leitura.nextLine();

					ArrayList<Usuario> usuarios = entry.getValue();
					Usuario.pesquisaUsuario(usuarios, nome);
					for(Usuario usuariosGrupo : usuarios){
						if(usuariosGrupo.getNome().equals(nome)){
							if(map.containsValue(usuariosGrupo)){
								usuario = usuariosGrupo;
								map.get(grau).remove(usuariosGrupo);
								break;
							}								
						}
					}										
				}
				System.out.println("Digite o Grau de relacionamento no qual  a pessoa que deseja trocar irÃ¡ ficar");
				grau = Integer.parseInt(leitura.nextLine());
				if(map.containsKey(grau)){
					map.get(grau).add(usuario);
				}						
			}
		}while(opc != 0);	
	}

	//implementar

	public Usuario consultarUsuarioMaisRelacionado() {

		int cont = 0;

		for(Map.Entry<Integer, ArrayList<Usuario>> entry : map.entrySet()){
			if(map.containsKey(1)){
				ArrayList<Usuario> usuarios = entry.getValue();
					for(Usuario usuariosGrupo : usuarios){
						if(usuariosGrupo.getNome().equals(usuarios)){
							usuario= usuariosGrupo;
							cont++;
						}
					}	
			}
			if(map.containsKey(2)){
				ArrayList<Usuario> usuarios = entry.getValue();
					for(Usuario usuariosGrupo : usuarios){
						if(usuariosGrupo.getNome().equals(usuarios)){
							usuario= usuariosGrupo;
							cont++;
						}
					}	
			}
			if(map.containsKey(3)){
				ArrayList<Usuario> usuarios = entry.getValue();
					for(Usuario usuariosGrupo : usuarios){
						if(usuariosGrupo.getNome().equals(usuarios)){
							usuario= usuariosGrupo;
							cont++;
						}
					}	
			}
		}
		return usuario.cont;

	public static ArrayList<Usuario> consultarUsuariosMaisRelacionado(ArrayList<Relacionamento> relacionamentos) {
		return null;

	}
}


