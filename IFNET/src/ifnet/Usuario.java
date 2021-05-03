

import java.util.ArrayList;

public abstract class Usuario {
	
	private String nome;


	private String prontuario;
	private String senha;



	public Usuario cont;	
	static Scanner leitura = new Scanner(System.in);


		@Override
	public String toString() {
		return "{" +
			" nome='" + getNome() + "'" +
			"}";
	}

	

	public Usuario(String nome, String prontuario, String senha) {
		this.nome = nome;
		this.prontuario = prontuario;
		this.senha = senha;
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
	
	public String getSenha() {
		return senha;	
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	

	/*
	realiza o cadastro do usuï¿½rio, a partir do inserï¿½ï¿½o das 
	informaï¿½ï¿½es do usuï¿½rio, dependendo do tipo do usuï¿½rio
	*/
	public static Usuario cadastrarUsuario() {
		
		Usuario novoUsuario;
		String nome, prontuario, senha, area, disciplina, email, curso;
		int tipo = 0;
		
		do {
			System.out.println("Vocï¿½ ï¿½ Aluno ou Professor?\n1 - Aluno\n2 - Professor");
			tipo = Integer.parseInt(leitura.nextLine());
		} while(tipo != 1 && tipo != 2);
		
		System.out.print("Informe o nome: ");
		nome = leitura.nextLine();
		
		System.out.print("Informe o prontuï¿½rio: ");
		prontuario = leitura.nextLine();
		
		System.out.print("Informe a senha: ");
		senha = leitura.nextLine();
		
		if(tipo == 2) {
			
			System.out.print("Informe a ï¿½rea: ");
			area = leitura.nextLine();
			
			System.out.print("Informe a disciplina: ");
			disciplina = leitura.nextLine();
			
			novoUsuario = new Professor(nome, prontuario, senha,
					new Area(area), new Disciplina(disciplina));
		} else {
			
			System.out.print("Informe o e-mail: ");
			email = leitura.nextLine();
			
			System.out.print("Informe o curso: ");
			curso = leitura.nextLine();
			
			novoUsuario = new Aluno(nome, prontuario, senha, email, new Curso(curso));

	//faz o login do usuário, recebendo o array de usuários
	public static Usuario loginUsuario(ArrayList<Usuario> usuarios, String prontuario, String senha) {
		
		//verifica se o prontuario e a senha constam no cadastro de algum usuário
		for(Usuario usuario: usuarios) {
			if(usuario.getProntuario().equals(prontuario)) {
				if(usuario.getSenha().equals(senha)) {
					return usuario;
				}
			}		

		}
		return null;
	}
	
	public static ArrayList<Usuario> pesquisaUsuario(ArrayList<Usuario> usuarios, String nome) {
	
		ArrayList<Usuario> usuariosPesquisados = new ArrayList<Usuario>();
		
		for(Usuario usuario:usuarios) 
			if(usuario.getNome().toLowerCase().contains(nome.toLowerCase())) 
				usuariosPesquisados.add(usuario);
		
		return usuariosPesquisados;
	}
	

	//excluir o usuï¿½rio a partir do recebimento do array de usuï¿½rios e o usuï¿½rio a ser excluido
	public static boolean excluirUsuario(ArrayList<Usuario> usuarios, Usuario usuario) {
		
		boolean excluido = false;
		int opcao;
		
		do {
			
			System.out.println("Vocï¿½ tem certeza que deseja excluir a sua conta? "
					+ "Essa aï¿½ï¿½o nï¿½o pode ser desfeita\n1.Sim\n2.Nï¿½o");
			opcao = Integer.parseInt(leitura.nextLine());
			
			switch(opcao) {
			
				case 1:
					usuarios.remove(usuario);
					excluido = true;
					System.out.println("Conta excluï¿½da");
				case 2:
					excluido = false;
					System.out.println("Conta nï¿½o excluï¿½da");
					break;
				default:
					System.out.println("Opï¿½ï¿½o invï¿½lida");
			}
			
		}while(opcao != 1 && opcao != 2);

	public static boolean usuarioExistente(ArrayList<Usuario> usuarios, String prontuario) {
		
		for(Usuario usuario:usuarios) {
			if(usuario.getProntuario().equals(prontuario)) return true;
		}

		
		return false;
		
	}
	

	//faz o login do usuï¿½rio, recebendo o array de usuï¿½rios
	public static Usuario loginUsuario(ArrayList<Usuario> usuarios) {
		
		String prontuario, senha;
		
		//recebe o prontuï¿½rio
		System.out.print("Informe o prontuario: ");
		prontuario = leitura.nextLine();

	@Override public boolean equals(Object usuario) {
		
		if(this.nome == ((Usuario) usuario).getNome())
			if(this.prontuario == ((Usuario) usuario).getProntuario())
				return true;
		return false;
		
		//verifica se o prontuario e a senha constam no cadastro de algum usuï¿½rio
		for(Usuario usuario: usuarios) {
			if(usuario.getProntuario().equals(prontuario)) {
				if(usuario.getSenha().equals(senha)) {
					return usuario;
				}
			}		
		}
		return null;
	}
	public static ArrayList<Usuario> pesquisaUsuario(ArrayList<Usuario> usuarios, String nome) {

		ArrayList<Usuario> usuariosPesquisados = new ArrayList<Usuario>();
	
		for(Usuario usuario:usuarios) 
			if(usuario.getNome().toLowerCase().contains(nome.toLowerCase())) 
				usuariosPesquisados.add(usuario);
	
		return usuariosPesquisados;
	}

	}

	@Override
	public abstract String toString();

	
}
