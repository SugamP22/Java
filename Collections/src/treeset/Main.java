package treeset;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
  public static void main(String[] args) {
    TreeSet<Personas> personas = new TreeSet<>(
        Comparator.comparingInt(Personas::getEdad).thenComparing(Personas::getNombre));
    personas.add(new Personas("sugam", 12));
    personas.add(new Personas("sugam", 12));
    personas.add(new Personas("sushil", 32));
    personas.add(new Personas("sushil", 34));
    personas.add(new Personas("sushil", 32));
    personas.add(new Personas("subham", 21));
    personas.add(new Personas("subham", 21));
    personas.add(new Personas("subham", 21));
    personas.add(new Personas("sughat", 11));
    personas.add(new Personas("suman", 2));
    for (Personas p : personas) {
      System.out.println(p);
      System.out.println("-------------------------------");
    }
    System.out.println("Descending::::>");
    for (Personas p : personas.descendingSet()) {
      System.out.println(p);
      System.out.println("-------------------------------");
    }

  }

}
