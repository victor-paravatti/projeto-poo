package ifnet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Relacionamento {
	
	private Usuario usuario;
	private String grauRelacionamento;
	private Usuario usuarioRelacionado;

	static Scanner leitura = new Scanner(System.in);
	


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
	
	public String getGrauRelacionamento() {
		return grauRelacionamento;
	}
	
	public void setGrauRelacionamento(String grauRelacionamento) {
		this.grauRelacionamento = grauRelacionamento;
	}
	
	public Usuario getUsuarioRelacionado() {
		return usuarioRelacionado;
	}
	
	public void setUsuarioRelacionado(Usuario usuarioRelacionado) {
		this.usuarioRelacionado = usuarioRelacionado;
	}
	
	// * Implemanentação para criar uma relação com outro usuario e atribuir as mesmas de forma predefinida
	public static Relacionamento criarRelacionamento() {

		
	}
	
	//Ja defini o grau de comfiadilidade e atribui aou usuario desejado
	public void alterarGrauConfiabilidade() {
		
	}

	//implementar
	public Object consultarUsuarioMaisRelacionado(ArrayList<Relacionamento> relacionamentos) {
		
		return null;
	}
}
