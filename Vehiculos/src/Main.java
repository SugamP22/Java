public class Main {
  private static final GestionarVehiculo vehiculo = new GestionarVehiculo();

  public static void main(String[] args) {
    iniciarMain();
  }

  private static void iniciarMain() {
    int opcion;
    do {
      opcion = MetododsBasicos.comprobarInt("""
            \n---- Menu Principal ----
            1. Agregar Vehiculo
            2. Eliminar Vehiculo
            3. Mostrar numeros vehiculos
            4. Mostrar info
            5. Salir
            ::::::::>
          """);
      switchMain(opcion);

    } while (opcion != 5);
  }

  private static void switchMain(int opcion) {
    switch (opcion) {
      case 1 -> agregarVehiculo();
      case 2 -> eliminarVehiculo();
      case 3 -> numerTotal();
      case 4 -> mostrarInfo();
      case 5 -> System.out.println("Saliendo de la sistema");
      default -> System.err.println("Error: Valor invalido. Debes introducir numeros entre(1-5)");
    }
  }

  private static void agregarVehiculo() {
    int opcion;
    do {
      opcion = MetododsBasicos.comprobarInt("¿Que quieres Agregar?\n1. Coche\n2. Moto\n3. Salir");
      switch (opcion) {
        case 1 -> agregarCoche();
        case 2 -> agregarMoto();
        case 3 -> System.out.println("Saliendo al menú principal!!");
        default -> System.err.println("Error: Numero introducido es incorrecto.");
      }

    } while (opcion != 3);

  }

  private static void eliminarVehiculo() {
    System.out.println("¿Que vehiculo quieres eliminar?\n1. Coche\n2. Moto");
    int opcion = MetododsBasicos.comprobarInt("¿Que vehiculo quieres eliminar?\n1. Coche\n2. Moto");
    switch (opcion) {
      case 1 -> eliminadoCoche();
      case 2 -> eliminadoMoto();
      default -> System.err.println("Error: Numero inválido!!, Saliendo al menu principal ");

    }
  }

  private static void numerTotal() {
    System.out.print("Numero total de vehiculo registrado::>");
    int num = vehiculo.mostrarNumerTotal();
    System.out.println(" " + num);
  }

  private static void mostrarInfo() {
    System.out.println("--- Vehiculos Registrado ----\n");
    vehiculo.mostrarInfo();
  }

  private static void agregarCoche() {
    String nombre = MetododsBasicos.comprobarString("Introduce un nombre del Coche: ");
    EstadoAccleracion estado = MetododsBasicos.comprobarEnum("Introduce un estado de acceleracion del Coche: ");
    int puertas = MetododsBasicos.comprobarInt("Introduce numeros puertas: ");
    if (vehiculo.addvehiculo(new Coches(nombre, estado, puertas))) {
      System.out.println("Vehiculo Añadido con exito!!");
    }

  }

  private static void agregarMoto() {
    String nombre = MetododsBasicos.comprobarString("Introduce un nombre del Moto: ");
    EstadoAccleracion estado = MetododsBasicos.comprobarEnum("Introduce un estado de acceleracion del moto: ");
    Boolean casco = MetododsBasicos.comprobarBoolean("Tiene un casco(S/N): ");
    if (vehiculo.addvehiculo(new Motos(nombre, estado, casco))) {
      System.out.println("Vehiculo Añadido con exito!!");
    }
  }

  private static void eliminadoCoche() {
    String nombre = MetododsBasicos.comprobarString("Introduce un nombre del Coche: ");
    EstadoAccleracion estado = MetododsBasicos.comprobarEnum("Introduce un estado de acceleracion del Coche: ");
    int puertas = MetododsBasicos.comprobarInt("Introduce numeros de puertas: ");
    Coches v = new Coches(nombre, estado, puertas);
    int res = vehiculo.removevehiculo(v);
    if (res == 2) {
      System.out.println("Coche Eliminado con exito!!");
    }
    if (res == 3) {
      System.out.println("No hay ningun vehiculo con este nombre!!");
    }

  }

  private static void eliminadoMoto() {
    String nombre = MetododsBasicos.comprobarString("Introduce un nombre del moto: ");
    EstadoAccleracion estado = MetododsBasicos.comprobarEnum("Introduce un estado de acceleracion del moto: ");
    boolean casco = MetododsBasicos.comprobarBoolean("Tiene un casco(S/N): ");
    Motos m = new Motos(nombre, estado, casco);
    int res = vehiculo.removevehiculo(m);
    if (res == 2) {
      System.out.println("Coche Eliminado con exito!!");
    }
    if (res == 3) {
      System.out.println("No hay ningun vehiculo con este nombre!!");
    }
  }
}
