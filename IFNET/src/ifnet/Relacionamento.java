package ifnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Relacionamento {
	
	private Map<Integer, ArrayList<Usuario>> grauUsuario = new HashMap<Integer, ArrayList<Usuario>>();
	
	public Relacionamento() {
		this.criarMapa();
	}
	
	public Map<Integer, ArrayList<Usuario>> getGrauUsuario() {
		return grauUsuario;
	}

	public void setGrauUsuario(Map<Integer, ArrayList<Usuario>> grauUsuario) {
		this.grauUsuario = grauUsuario;
	}
	
	public void criarMapa() {
		this.grauUsuario.put(0, new ArrayList<Usuario>());
		this.grauUsuario.put(1, new ArrayList<Usuario>());
		this.grauUsuario.put(2, new ArrayList<Usuario>());
	}
	
	public static boolean relacionarUsuario(Usuario usuarioAtual, Usuario usuarioRelacionar) {
		
		Relacionamento relacionar = null;
		ArrayList<Usuario> usuarios;
		
		relacionar = usuarioAtual.getRelacionamento();
		
		for (Map.Entry<Integer , ArrayList<Usuario>> mapa : relacionar.grauUsuario.entrySet()) { 
			
			usuarios = mapa.getValue();
			
			for(Usuario usuario:usuarios) {
				if(usuario.getProntuario().equals(usuarioRelacionar.getProntuario())) return false;
			}
		}
		
		usuarioRelacionar.getRelacionamento().getGrauUsuario().get(1).add(usuarioAtual);
		relacionar.grauUsuario.get(1).add(usuarioRelacionar);
		return true;
		
	}
	
	public static void alterarGrauConfiabilidade(Usuario usuarioAtual, int grauAtual, int novoGrau, int posicaoRelacao) {
		
		Usuario usuario;
		
		usuario = usuarioAtual.getRelacionamento().grauUsuario.get(grauAtual).get(posicaoRelacao);
		
		usuarioAtual.getRelacionamento().grauUsuario.get(grauAtual).remove(posicaoRelacao);
		
		usuarioAtual.getRelacionamento().grauUsuario.get(novoGrau).add(usuario);
		
	}

	public static Map<Integer, Integer> consultarUsuariosMaisRelacionado(ArrayList<Usuario> usuarios) {
		
		Map<Integer,Integer> maisRelacionados = new HashMap<Integer, Integer>();
		
		Relacionamento relacionamento = null;
		
		int tamanho = 0;
		
		for(Usuario usuario:usuarios) {
			
			relacionamento = usuario.getRelacionamento();
			
			for (Map.Entry<Integer , ArrayList<Usuario>> mapa : relacionamento.grauUsuario.entrySet()) { 
				tamanho += mapa.getValue().size();
			}
			
			maisRelacionados.put(usuarios.indexOf(usuario), tamanho);

			tamanho = 0;
		}
		
		maisRelacionados.values();
		
		return maisRelacionados;
	}
	
}
