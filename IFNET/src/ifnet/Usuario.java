package ifnet;

public abstract class Usuario {
	
	private String nome;
	private String prontuario;
	
	public Usuario(String nome, String prontuario) {
		this.nome = nome;
		this.prontuario = prontuario;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getProntuario() {
		return prontuario;
	}
	
	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}
	
	public abstract Usuario cadastrarUsuario();
	
	//implementar
	public void excluirUsuario() {
		
	}
	
}
