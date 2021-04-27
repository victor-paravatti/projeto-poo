package ifnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	public void relacionarUsuario() {
		int opc = 0;

		// Implementação da Criação do grau de amizade do usuario
		do {

			System.out.println("Para Criar um vinculo de Conhecido digite {1}\n" + 
							   	"Para Criar um vinculo de Amigo digite {2}\n" + 
								"Para Criar um vinculo de Melhor Amigo digite {3}");

		 	grau = Integer.parseInt(leitura.nextLine());
			System.out.println(" Informe o Nome da Pesosa no qual deseja criar vinculo");
			nome = Integer.parseString(leitura.nextLine());
			map.get(grau).add(nome);
			System.out.println(" Se desejar sair Aperte {1}");
			opc = Integer.parseInt(leitura.nextLine());

		}while(opc != 0);
		
	}
	
	//implementar
	public void definirGrauConfiabilidade() {

		do {
			for(Map.Entry<Usuarios, List<Usuario>> entry : map.entrySet()){    

				System.out.println(entry.getKey() + "" + entry.getValue());
				
				
			}

		}while(opc != 0);

		
	}

	//implementar
	public Usuario consultarUsuarioMaisRelacionado() {
		return null;
	}
}
