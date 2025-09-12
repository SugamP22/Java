package arraylist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    ArrayList<Personas> personas = new ArrayList<>();
    personas.add(new Personas("sugam", 12));
    personas.add(new Personas("sushil", 32));
    personas.add(new Personas("subham", 21));
    personas.add(new Personas("sughat", 11));
    personas.add(new Personas("suman", 2));
    for (Personas p : personas) {
      System.out.println(p);
      System.out.println("-------------------------------");
    }
    Iterator<Personas> it = personas.iterator();
    while (it.hasNext()) {
      Personas p = it.next();
      if (p.getEdad() > 18) {
        System.out.println(p);
      }

    }
    System.out.println("Lista ordenada:  ");
    personas.sort(Comparator.comparingInt(Personas::getEdad));
    for (Personas p : personas) {
      System.out.println(p);
      System.out.println("-------------------------------");
    }
    System.out.println("Lista DISCENDING:  ");
    personas.sort(Comparator.comparingInt(Personas::getEdad).reversed());
    for (Personas p : personas) {
      System.out.println(p);
      System.out.println("-------------------------------");
    }
  }

}
