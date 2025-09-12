package hashset;

import java.util.HashSet;

public class Main {
  public static void main(String[] args) {
    HashSet<Personas> personas = new HashSet<>();
    personas.add(new Personas("sugam", 12));
    personas.add(new Personas("sugam", 12));
    personas.add(new Personas("sushil", 32));
    personas.add(new Personas("subham", 21));
    personas.add(new Personas("sughat", 11));
    personas.add(new Personas("suman", 2));
    for (Personas p : personas) {
      System.out.println(p);
      System.out.println("-------------------------------");
    }

  }

}
