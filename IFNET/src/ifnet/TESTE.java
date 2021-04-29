package ifnet;

import java.util.Scanner;

import excecoes.OpcaoInexistenteException;

public class TESTE {
	
	public static void main(String[] args) {
		
		Scanner leitura = new Scanner(System.in);
		
		Object numero = 0;
		String str = "Sample String";
		
		System.out.println("Informe um número");
		
		try {
			numero = Integer.parseInt(leitura.nextLine());
			
			System.out.println(numero.getClass().getSimpleName());
			
			if((numero.getClass().getSimpleName() != int.class.getClass().getSimpleName())) {
				throw new OpcaoInexistenteException();
			}
		} catch(OpcaoInexistenteException erro) {
			System.out.println(erro.getMessage());
		}
		
		
		
	
				
					
			
			
		
		
		
		
		
		
		
	}

}
