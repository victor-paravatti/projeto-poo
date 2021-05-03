package ifnet;

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
	
	// *Implementação para criar uma relação com outro usuario e atribuir as mesmas de forma predefinida
	public static Relacionamento criarRelacionamento() {
		return null;
	}
	
	public static void alterarGrauConfiabilidade() {
		
	}

	//implementar
	public static ArrayList<Usuario> consultarUsuariosMaisRelacionado(ArrayList<Relacionamento> relacionamentos) {
		return null;
	}
}
