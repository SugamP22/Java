
import java.util.ArrayList;

public class Main {
  private static final ConexionDB db = new ConexionDB();
  private static ArrayList<Personaje> listPersonajes;

  public static void main(String[] args) {
    if (db.getConn() != null) {
      iniciarMain();
      return;
    }
    System.err.println("Error: NO encontrado conexion propio para iniciar sistema!!");
  }

  public static void iniciarMain() {
    System.out.println("Iniciando la sistema....\n");
    int opcion;
    do {
      opcion = MetodosBasicos.comprobarInt("""
            --- Menu Principal ---\n
            1. Insertar Personaje
            2. Eliminar personaje
            3. listar Personaje
            4. Modificar personaje
            5. Agregar Batalla
            6. Listar Todas Batallas
            7. mostrar batallas ganado por personaje
            8. mostrar batallas perdido por personaje
            9. Salir
            :::::::::>
          """);
      switchMain(opcion);

    } while (opcion != 9);
  }

  private static void switchMain(int opcion) {
    switch (opcion) {
      case 1 -> insertarPersonaje();
      case 2 -> eliminarPersonaje();
      case 3 -> listarPersonaje();
      case 4 -> modificarPersonaje();
      case 5 -> agregarBatalla();
      case 9 -> {
        System.out.println("Saliendo de la sistema!!");
        db.disconnectar();
      }
      default -> System.err.println("Error: Valoe introducido incorrecto ingresa entre(1-5)");
    }
  }

  private static void insertarPersonaje() {
    System.out.println("::::::::: INFO PERSONAJE :::::::::::\n");
    String nombre = MetodosBasicos.comnproString("Introduce un nombre de personaje: ");
    boolean mascara = MetodosBasicos.comprobarBoolean("Tu personaje tiene mascara (S/N:)");
    boolean capa = MetodosBasicos.comprobarBoolean("Tu personaje tiene capa (S/N:)");
    Tipo tipo = MetodosBasicos.comprobarTipo("Introduce el tipo del Personaje(HEROE O VILLANO)");
    Personaje personaje = new Personaje(capa, mascara, nombre, tipo);
    int numeroPoder = MetodosBasicos
        .comprobarInt("Introducir numero de poderes que  quieres añadir(1 es obligatorio!!):");
    if (numeroPoder < 1 || numeroPoder > 3) {// giving a default value if its less then 1 and more then 3
      numeroPoder = 1;
    }
    for (int i = 0; i < numeroPoder; i++) {
      String nombrePoder = MetodosBasicos.comnproString("Introduce la nombre del poder:");
      Poderes poder = new Poderes(nombrePoder);
      personaje.addpoder(poder);
    }
    boolean res = db.insertarPersonaje(personaje);
    if (res) {
      System.out.println("Personaje insertado con exito");

    } else {
      System.out.println("Tuvo problema al insertar Personaje");
    }

  }

  private static void eliminarPersonaje() {
    System.out.println("::::::::: Info Personaje ::::::::::");
    int id = MetodosBasicos.comprobarInt("Ingresa una id de personaje para eliminar:");
    System.out.println(db.eliminarPersonaje(id) ? "Elimainado con exito" : "No podido eliminar!!");
  }

  private static void listarPersonaje() {
    System.out.println(":::::: Info Personajes Registrados :::::::\n");
    listPersonajes = db.listarPersonaje();
    if (listPersonajes != null) {
      if (listPersonajes.isEmpty()) {
        System.out.println("No hay ninguno personaje registrado!!");
        return;
      }
      for (Personaje p : listPersonajes) {
        System.out.println(p.toString());
        System.out.println("----------------------------------------");
      }
      return;
    }
    System.out.println("No podido mostrar las personajes!!");
  }

  private static void modificarPersonaje() {
    System.out.println(":::::::::: Modificando Personaje :::::::::::::\n");

    int id = MetodosBasicos.comprobarInt("Introducir id de la personaje que quiere cambiar:");
    String nombre = MetodosBasicos.comnproString("Introducir el nuevo nombre:");
    boolean mascara = MetodosBasicos.comprobarBoolean("Tiene mascara puesto(s/n)");
    boolean capa = MetodosBasicos.comprobarBoolean("Tiene capa puesto(s/n)");
    boolean res = db.modificarPersonje(id, nombre, mascara, capa);
    System.out.println(res ? "Modificado con exito" : "No podido modificar !!");

  }

  private static void agregarBatalla() {
    System.out.println("::::::::: Insertar batalla ::::::::::\n");
    listarPersonaje();
    System.out.println(":::::::::::::::::::::::::::::::\n");
    Personaje ganador = null;
    Personaje perdedor = null;
    int idGanador = MetodosBasicos.comprobarInt("Introducir el id del ganador de esa batalla:");
    int idPerdedor = MetodosBasicos.comprobarInt("Introducir el id del perdedor de esa batalla:");
    for (Personaje p : listPersonajes) {
      if (p.getId() == idGanador) {
        ganador = p;
      }
      if (p.getId() == idPerdedor) {
        perdedor = p;
      }

    }
    if (ganador == null || perdedor == null) {
      System.err.println("Error: Datos introducido invalido");
      return;
    }
    if (ganador.getTipo() == perdedor.getTipo()) {
      System.err.println("Error: Los dos jugadores no pueden ser del mismo tipo!!");
      return;
    }

    while (true) {
      String lugar = MetodosBasicos.comnproString("Introduce la lugar en donde estuvo la batalla: ");
      try {
        String date = MetodosBasicos.comnproString("Ingresa la fecha cuando fue la lucha(yyyy-MM-dd): ");
        Batalla batalla = new Batalla(date, ganador, lugar, perdedor);
        System.out.println(
            db.insertarBatalla(batalla) ? "Batalla insertado con exito!!" : "No podido indertar la batalla");
        return;
      } catch (IllegalArgumentException e) {
        System.err.println("Error: " + e.getMessage());
        System.out.println("Introduce de nuevo....\n");
      }
    }
  }

}
