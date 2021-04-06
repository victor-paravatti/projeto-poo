package ifnet;

public class Relacionamento {
	
	private Usuario usuario;
	private String grauRelacionamento;
	private Usuario usuarioRelacionado;
	
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
	
	public Usuario getUsuarioRelacionado() {
		return usuarioRelacionado;
	}
	public void setUsuarioRelacionado(Usuario usuarioRelacionado) {
		this.usuarioRelacionado = usuarioRelacionado;
	}
	
	//implementar
	public void relacionarUsuario() {
		
	}
	
	//implementar
	public void definirGrauConfiabilidade() {
		
	}

	//implementar
	public Usuario consultarUsuarioMaisRelacionado() {
		Usuario usuario = new Usuario("Gilberto", "BP3007685");
		return usuario;
	}
}
