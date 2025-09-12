package hasmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
  private static Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Map<Integer, Personas> mapa = new HashMap<>();
    mapa.put(1, new Personas("sushil", 21));
    mapa.put(2, new Personas("subham", 21));
    mapa.put(3, new Personas("sugam", 21));
    mapa.put(3, new Personas("suman", 21));
    mapa.put(4, new Personas("saugat", 21));
    System.out.print("Introduce un id para saber su valor:::>");
    int id = sc.nextInt();
    if (mapa.containsKey(id)) {
      System.out.println("Id  encontrado!!");
      System.out.printf("ID: %d -> %s\n", id, mapa.get(id));
    } else {
      System.out.println("No podido encontrar la id!!");
    }
    System.out.println(":::::::::::::::::::::::::::::::");
    for (Map.Entry<Integer, Personas> entry : mapa.entrySet()) {
      System.out.printf("ID: %d -> %s\n", entry.getKey(), entry.getValue());
      System.out.println("------------------------------------");
    }

  }

}
