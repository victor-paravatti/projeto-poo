package ifnet;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Teste {

  public static void main(String[] args) {

    Map<Integer, String> mapaNomes = new HashMap<Integer, String>();
    mapaNomes.put(10, "João Delfino");
    mapaNomes.put(5, "Maria do Carmo");
    mapaNomes.put(-1, "Claudinei Silva");

System.out.println(mapaNomes);

    //resgatando o nome da posição 2
    System.out.println(mapaNomes.get(-1).compareTo(mapaNomes.get(5)));
    
    
    

  }
}