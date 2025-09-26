import java.util.ArrayList;

public class Main {

  private static final ConectorDB db = new ConectorDB();
  private static ArrayList<String> especialidades;
  private static ArrayList<Sospechoso> sospechosos;
  private static ArrayList<Casos> casos;

  public static void main(String[] args) {
    if (db.getConn() != null) {
      iniciarMain();
    } else {
      System.err.println("Error conexión!! , Porfavor revisar la conexión con base de datos!!");
    }
  }

  private static void iniciarMain() {
    int opcion;
    do {
      opcion = MetodosBasicos.comprobarint("""
          ----- Menú Principal ----\n
          1. Listar Especialidad
          2. Añadir detectives
          3. Listar Sospechosos
          4. Listar Casos Resueltas
          5. Listar Casos Pendientes
          6. Resolver Casos Pendientes
          7. Salir
          Selecciona una opción : """);
      switchMain(opcion);
    } while (opcion != 7);
  }

  private static void switchMain(int opcion) {
    switch (opcion) {
      case 1 -> listarEspecialidad();
      case 2 -> aniadirDetectives();
      case 3 -> listarSospechosos();
      case 4 -> listarCasosResueltas();
      case 5 -> listarCasosPendientes();
      case 6 -> resolverCasosPendientes();
      case 7 -> {
        System.out.println("Saliendo de la sistema!!");
        db.disconnenctar();
      }
      default -> System.err.println("Error: Numero incorrecto Ingresa entre (1-7)");
    }
  }

  private static void listarEspecialidad() {
    especialidades = db.listarDetectives();
    if (especialidades != null) {
      if (especialidades.isEmpty()) {
        System.out.println("no hay ninguno especialidades registrado!!");
        return;
      }
      System.out.println("\n:::::::: Lista de Especialidades :::::::::::\n");
      for (String es : especialidades) {
        System.out.println("- " + es);
      }
      System.out.println();
      return;
    }

    System.out.println("No pudo recuperar datos!!");

  }

  private static void aniadirDetectives() {
    System.out.println("\n::::::::::: Añadir Detective :::::::::::\n");
    String nombre = MetodosBasicos.comprobarString("Ingresa nombre del detective: ");
    String especialidad = MetodosBasicos.comprobarString("Ingresa especialidad del detective: ");
    Detective detective = new Detective(especialidad, nombre);
    if (db.insertarDetective(detective)) {
      System.out.println("Detctive insertado con exitó!!");
      return;
    }
    System.out.println("No pudo insertar detective!!");

  }

  private static void listarSospechosos() {
    sospechosos = db.listarSospechosos();
    if (sospechosos != null) {
      if (sospechosos.isEmpty()) {
        System.out.println("no hay ninguno sospechosos registrado!!");
        return;
      }
      System.out.println("\n:::::::: Lista de Sospechosos :::::::::::\n");
      for (Sospechoso s : sospechosos) {
        System.out.println(s.toString());
        System.out.println("-----------------");

      }
      System.out.println();
      return;
    }
    System.out.println("No pudo mostrar los sospechosos revisa la conexión!!");

  }

  private static void listarCasosResueltas() {
    casos = db.listarCasosDB();
    if (casos != null) {
      if (casos.isEmpty()) {
        System.out.println("no hay ninguno caso registrado!!");
        return;
      }
      System.out.println("\n:::::::: Lista de Casos Resueltos :::::::::::\n");
      for (Casos caso : casos) {
        if (caso.isResuelto()) {
          System.out.printf("""
                ID: %d
                Titulo: %s
                Discripcion: %s
                Fecha De Apertura: %s
                Resuelto:%s
                Detective: %s
                Sospechosos: %s
              """, caso.getId(), caso.getTitulo(), caso.getDiscrpcion(), caso.getFecha(), caso.isResuelto(),
              caso.getDetective().getNombre(), caso.getSospechoso().getNombre());
          System.out.println("-----------------");
        }
      }
      System.out.println();
      return;
    }
    System.out.println("No pudo mostrar los Casos revisa la conexión!!");

  }

  private static void listarCasosPendientes() {
    casos = db.listarCasosDB();
    if (casos != null) {
      if (casos.isEmpty()) {
        System.out.println("no hay ninguno caso registrado!!");
        return;
      }
      System.out.println("\n:::::::: Lista de Casos Pendientes :::::::::::\n");
      for (Casos caso : casos) {
        if (!caso.isResuelto()) {
          System.out.printf("""
                ID: %d
                Titulo: %s
                Discripcion: %s
                Fecha De Apertura: %s
                Resuelto:%s
                Detective: %s
                Sospechosos: %s
              """, caso.getId(), caso.getTitulo(), caso.getDiscrpcion(), caso.getFecha(), caso.isResuelto(),
              caso.getDetective().getNombre(), "N/A");
          System.out.println("-----------------");
        }
      }
      System.out.println();
      return;
    }
    System.out.println("No pudo mostrar los Casos revisa la conexión!!");
  }

  private static void resolverCasosPendientes() {
    listarCasosPendientes();
    int id = MetodosBasicos.comprobarint("\n Inique el id  del caso que quiere resolver: ");
    if (casos.isEmpty()) {
      System.out.println("No hay ningun caso para interpretar!!");
      return;
    }
    for (Casos c : casos) {
      if (c.getId() == id) {
        System.out.printf("En este caso el sospechoso tiene un nivel de criminalidad: %d y utilizó el arma: %s ",
            c.getSospechoso().getNivelDePeligro(), c.getSospechoso().getArma());
        System.out.println("De los siguente  sospechosos cual crees que ha sido. (Indique su id): ");
        listarSospechosos();
        int quien = MetodosBasicos.comprobarint(":::::> ");
        if (quien == c.getSospechoso().getId()) {
          System.out.println("Enhorabuena has resuelto el caso. Eres un digno sucesor de Sherlocl");
          boolean hecho = db.modificarCaso(id);
          if (hecho) {
            System.out.println("Actualizado con exito!!. Se quedan menos casos!!");
            return;
          }
          System.out.println("No pudo actualizar los casos!!");

        } else {
          System.out.println("No has podido ser un sucesor de Sherlock pero buen intento!!");
        }
      }
    }
    System.out.println("No hay ningun caso con esa id!!");
  }
}
