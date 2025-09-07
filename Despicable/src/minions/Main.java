package minions;

public class Main {
  private static final Mision[] mision = new Mision[10];
  private static Villano villano = null;

  public static void main(String[] args) {
    iniciarMain();
  }

  private static void iniciarMain() {
    villano = new Villano("Sushil", 7);
    int opcion;
    do {
      opcion = MetodosBasicos.comprobarInt("""
            \n ---- Menú Principal ----
            1. Crear Misiones
            2. Listar Misiones
            3. Listar Estadisticas
            4. Conseguir Victorias
            5. Salir
            ::::::::>
          """);
      mainSwitch(opcion);
    } while (opcion != 5);

  }

  private static void mainSwitch(int opcion) {
    switch (opcion) {
      case 1 -> crearMision();
      case 2 -> ListarMisiones();
      case 3 -> listarEstadisticas();
      case 4 -> conseguirVictorias();
      case 5 -> System.out.println("Saliendo de la sistema!!");
      default -> System.err.println("Error: Numero inválido!!, Ingresa numero entre(1-5)");
    }
  }

  private static void crearMision() {
    String nombre = MetodosBasicos.comprobarString("Introduce nombre de la mision: ");
    String descripcion = MetodosBasicos.comprobarString("Introduce un descripción sobre la misino: ");
    int puntuacionNecesario = MetodosBasicos.comprobarInt("Ingresa un puntuacion necesario para hacer este misión: ");
    for (int i = 0; i < mision.length; i++) {
      if (mision[i] == null) {
        mision[i] = new Mision(nombre, descripcion, puntuacionNecesario);
        System.out.println("Mision añadido con exitó!!");
        return;
      }
    }
    System.err.println("Error: No hay espacio para añadir mas mision!!");
  }

  private static void ListarMisiones() {
    if (mision != null) {
      for (Mision m : mision) {
        System.out.println(":::::::: Misiones Registrado ::::::::");
        System.out.println(m);
        System.out.println("----------------------");
      }
      System.err.println("Error: no hay ninguno mision listado!! ");

    }

  }

  private static void listarEstadisticas() {
    System.out.println("::::: El villano registrado :::::");
    System.out.println(villano);
  }

  private static void conseguirVictorias() {
    if (mision == null) {
      System.err.println("No hay ningun misoin registrado para conseguir victorias!!");
      return;
    }
    int numTotalFuerza = 0;
    int numTotalorpeza = 0;
    for (Minions minion : villano.getMinions()) {
      numTotalFuerza = minion.getFuerza();
      numTotalorpeza = minion.getTorpeza();
    }
    int numParaConseguirVictoria = numTotalFuerza - numTotalorpeza;

    String res = elegirMision(numParaConseguirVictoria);
    System.out.println(res);
  }

  private static String elegirMision(int numParaConseguirVictoria) {
    String nombre = MetodosBasicos.comprobarString("Introducir nombre de la mision para luchar: ");
    for (Mision m : mision) {
      if (m.getNombreMision().equalsIgnoreCase(nombre)) {
        if (m.getPuntuacionNecesario() > numParaConseguirVictoria) {
          return "Has perdido la lucha teniendo en total" + numParaConseguirVictoria
              + " Donde la la puntuacion necesasario fue " + m.getPuntuacionNecesario();
        }
        return "Has ganado la lucha teniendo en total" + numParaConseguirVictoria
            + " Donde la la puntuacion necesasario fue " + m.getPuntuacionNecesario();
      }
    }
    return "No hay ningun mision con esa nombre";
  }

}
