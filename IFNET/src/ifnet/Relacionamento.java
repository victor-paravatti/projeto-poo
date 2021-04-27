package ifnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Relacionamento {
	
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
		
	}
	
	//implementar
	public void definirGrauConfiabilidade() {
		
	}

	//implementar
	public Usuario consultarUsuarioMaisRelacionado() {
		return null;
	}
}
