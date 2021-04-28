

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;




public class Relacionamento {

	static Scanner leitura = new Scanner(System.in);
	
	private Usuario usuario;
	Map<Integer,ArrayList<Usuario>> map = new HashMap<Integer,ArrayList<Usuario>>();
	
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

		// Implementação da Criação do grau de amizade do usuario
		do {

			System.out.println("Para Criar um vinculo de Conhecido digite {1}\n" + 
							   	"Para Criar um vinculo de Amigo digite {2}\n" + 
								"Para Criar um vinculo de Melhor Amigo digite {3}");

		 	grau = Integer.parseInt(leitura.nextLine());
			System.out.println(" Informe o Nome da Pesosa no qual deseja criar vinculo");
			nome = leitura.nextLine();
			/*usuario = getUsuario(nome);*/			
			/*map.get(grau).add(usuario);*/
			System.out.println(" Se desejar sair Aperte {1}");
			opc = Integer.parseInt(leitura.nextLine());

		}while(opc != 0);
		
	}
	
	//implementar
	public void definirGrauConfiabilidade(Map<Integer,ArrayList<Usuario>> map) {
		Usuario usuario;
		String nome;
		int opc = 0, grau;
		
		
		do {
			//iteração para mostrar o conteudo do mapa 
			for(Map.Entry<Integer, ArrayList<Usuario>> entry : map.entrySet()){  
				
				// Print para mopstrar a chave e o valor relacionado a chave 
				System.out.println(entry.getKey() + "" + entry.getValue());	
				System.out.println("Digite o Grau de relacionamento no qual  a pessoa que deseja trocar está");
				grau = Integer.parseInt(leitura.nextLine());
				if(map.containsKey(grau)){
					System.out.println("Digite o nome da pesoa no qual deseja trocar de Grau de relacionamento");
					nome = leitura.nextLine();
					/*if(map.containsValue(nome)){

					}*/
										

				}


				
				
			}

		}while(opc != 0);

		
	}

	//implementar
	public Usuario consultarUsuarioMaisRelacionado() {
		return null;
	}
}
