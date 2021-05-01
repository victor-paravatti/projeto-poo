package excecoes;

public class UsuarioCadastradoException extends Exception{
	
	public UsuarioCadastradoException() {
		super("Esse usuário já está cadastrado no sistema");
	}
	
	public UsuarioCadastradoException(String menssagem) {
		super(menssagem);
	}

}
