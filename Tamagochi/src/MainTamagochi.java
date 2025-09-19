public class MainTamagochi {

  private static final Tamagochi[] tamagochi = new Tamagochi[6];

  public static void main(String[] args) {
    rellenarTamagochi();
    iniciarMain();
    System.out.println("Gracias para usar nuestro sistema!!");
  }

  private static void rellenarTamagochi() {
    tamagochi[0] = new Tamagochi("sugam", 20, 25, 33, 100);
    tamagochi[1] = new Tamagochi("suman", 20, 20, 33, 100);
    tamagochi[2] = new Tamagochi("sushil", 100, 2, 33, 100);
    tamagochi[3] = new Tamagochi("sostik", 0, 20, 33, 100);
    tamagochi[4] = new Tamagochi("shubham", 0, 20, 33, 100);
    System.out.println("Los primeros posiciÓn rellanado con exitó!!");
  }

  private static void iniciarMain() {
    int opcion;

    do {

      opcion = MetodoBasicos.comprobarInt("""
          ---- Menu Principal ----
          1. Añadir Tamagochi
          2. Listar Tmagochi
          3. Interactuar Con Tamagochi
          4. Revision Urgentes
          5. Salir
          ::::::>
                    """);
      switchMain(opcion);

    } while (opcion != 5);
  }

  private static void switchMain(int opcion) {
    switch (opcion) {
      case 1 -> aniadirTamgochi();
      case 2 -> listarTamagochi();
      case 3 -> interactuar();
      case 4 -> revisionUrgentes();
      case 5 -> {
        System.out.println("Saliendo del sistema!!");
        System.out.println("-----------------------------");
      }
      default -> System.err.println("Error: valor introducido es incorrecto ingresar entre(1-5)");
    }
  }

  private static void revisionUrgentes() {
    boolean existe = false;
    int id = MetodoBasicos.comprobarInt("Ingresa un id para encontrar tamagochi:");
    for (Tamagochi tamagochi1 : tamagochi) {
      if (tamagochi1 != null && (tamagochi1.getDiversion() < 20 || tamagochi1.getHambre() < 20
          || tamagochi1.getHigiene() < 20 || tamagochi1.getSuenyo() < 20) && tamagochi1.getId() == id) {
        System.out.println("Tamagochi encontrado en necesitad de ayuda urgente");
        existe = true;
        System.out.println("----- Estado Actual ------");
        System.out.println(tamagochi1.toString() + "\n");
        if (tamagochi1.getHigiene() < 20) {
          tamagochi1.duchar();
        } else if (tamagochi1.getDiversion() < 20) {
          tamagochi1.jugar();
        } else if (tamagochi1.getHambre() < 20) {
          tamagochi1.comer();
        } else {
          tamagochi1.dormir();
        }
        System.out.println("-------Estado Actualizado-------");
        System.out.println(tamagochi1.toString() + "\n");

      }

    }
    if (!existe) {
      System.err.println("No hay ninguno tamagochi con esa id que tenga habilidad menor que 20!!");
      return;
    }

  }

  private static void interactuar() {
    int elegirTamagochi = MetodoBasicos.comprobarInt("Introducir el id del tamagochi:");

    for (Tamagochi tamagochi1 : tamagochi) {
      if ((tamagochi1 != null) && (tamagochi1.getId() == elegirTamagochi)) {

        System.out.println("Tamagochi encontrado con esa id!!\n");
        int opcion = MetodoBasicos.comprobarInt("""
              ---- Elige una Opcion -----
              1. Duchar
              2. Jugar
              3.Comer
              4.Dormir
            """);
        switchOpcion(opcion, tamagochi1);
        System.out.println("Tamagochis atualizado con exito!!");
        listarTamagochi();
        return;
      }
    }

    System.err.println("Error: No hay ninguno tamagochi con esa id!!");

  }

  private static void listarTamagochi() {
    boolean existe = false;
    System.out.println("::::: Lista de Tamagochi registrado!! ::::::");
    System.out.println();
    for (Tamagochi tamagochi1 : tamagochi) {
      if (tamagochi1 != null) {
        System.out.println(tamagochi1.toString());
        System.out.println("--------------------------------");

        existe = true;
      }
    }
    if (!existe) {
      System.out.println("No hay ninguno tamagochi registrado!!");
    }
  }

  private static void aniadirTamgochi() {

    for (int i = 0; i < tamagochi.length; i++) {
      if (tamagochi[i] == null) {
        System.out.println(":::::: Añadiendo Tamagochi ::::::");
        String nombre = MetodoBasicos.comprobarString("Introduce un nombre para tamagochi:");
        int hambre = MetodoBasicos.comprobarInt("Ingresa un cantidad para nivel de hambre:");
        int suenio = MetodoBasicos.comprobarInt("Ingresa un cantidad para nivel de sueño: ");
        int higiene = MetodoBasicos.comprobarInt("Ingresa un cantidad para nivel de higiene: ");
        int diversion = MetodoBasicos.comprobarInt("Ingresa un cantidad para nivel de diversion: ");
        tamagochi[i] = new Tamagochi(nombre, hambre, suenio, higiene, diversion);
        System.out.println("Tamagochi añadido con exito!!");
        return;
      }
    }
    System.out.println("No hay espacio para añadir mas tamagochi!!");
  }

  private static void switchOpcion(int opcion, Tamagochi tamagochi1) {
    switch (opcion) {

      case 1 -> tamagochi1.duchar();
      case 2 -> tamagochi1.jugar();
      case 3 -> tamagochi1.comer();
      case 4 -> tamagochi1.dormir();
      default -> System.out.println("Error: Valor incorrecto!!, Ingresa entre (1-5)");
    }
  }
}
