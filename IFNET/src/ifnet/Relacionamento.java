package ifnet;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.util.HashMap;
import java.util.Map;
public class Relacionamento {
	
	private Usuario usuario;

	private String grauRelacionamento;
	private Usuario usuarioRelacionado;

	static Scanner leitura = new Scanner(System.in);

	Map<Integer,ArrayList<Usuario>> map = new HashMap<Integer,ArrayList<Usuario>>();
	
	public Relacionamento(Usuario usuario) {
		this.usuario = usuario;
		this.criarMapa();
	}

	


	//iqual e hashCode para o atributo  grauRelacionamento
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof Relacionamento)) {
			return false;
		}
		Relacionamento relacionamento = (Relacionamento) o;
		return Objects.equals(usuario, relacionamento.usuario) && Objects.equals(grauRelacionamento, relacionamento.grauRelacionamento) && Objects.equals(usuarioRelacionado, relacionamento.usuarioRelacionado);
	}
	//hashCode para a implementação do map
	@Override
	public int hashCode() {
		return Objects.hash(usuario, grauRelacionamento, usuarioRelacionado);
	}	

	
	
	public Relacionamento(String grauRelacionamento, Usuario usuario, Usuario usuarioRelacionado) {
		this.usuario = usuario;
		this.grauRelacionamento = grauRelacionamento;
		this.usuarioRelacionado = usuarioRelacionado;
	}

	public  Usuario getUsuario() {
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
	
	// * Implemanentação para criar uma relação com outro usuario e atribuir as mesmas de forma predefinida
	public static Relacionamento criarRelacionamento() {

		
	}
	
	
	public void alterarGrauConfiabilidade() {
		
	}

	//implementar
	public Object consultarUsuarioMaisRelacionado(ArrayList<Relacionamento> relacionamentos) {
		
		return null;
	}
}
