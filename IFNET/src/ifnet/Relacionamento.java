package ifnet;

import java.util.ArrayList;
import java.util.LinkedList;

public class Relacionamento {
	
	private Usuario usuario;
	private String grauRelacionamento;
	private ArrayList<LinkedList<Usuario>> usuarios = new ArrayList<LinkedList<Usuario>>();
	public Usuario getUsuario() {
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
	public ArrayList<LinkedList<Usuario>> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(ArrayList<LinkedList<Usuario>> usuarios) {
		this.usuarios = usuarios;
	}
	
	//implementar
	public void relacionarUsuario() {
		
	}
	
	//implementar
	public void definirGrauConfiabilidade() {
		
	}

	//implementar
	public Usuario consultarUsuarioMaisRelacionado() {
		Usuario usuario = new Usuario();
		return usuario;
	}
}
