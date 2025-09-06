package actividadEvaluableTema06;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Clase principal que gestiona el menú de opciones para añadir, eliminar personas,
 * asignaturas, y mostrar información.
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Scanner sl = new Scanner(System.in);
    private static ArrayList<Personal> personal = new ArrayList<>();

    /**
     * Método principal que inicia la aplicación y muestra un mensaje de despedida al finalizar.
     * @param args Argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        IniciarMain();
        System.out.println("\033[37mGracias por su participacion!!\033[0m ");
    }

    /**
     * Método que inicia el menú principal y maneja las excepciones de entrada de usuario.
     */
    private static void IniciarMain() {
        int opcion = 0;
        do {
            menu();
            try {
                opcion = sc.nextInt();
                switchMain(opcion);
            } catch (InputMismatchException e) {
                System.err.println("Error: Entrada invalida");
                sc.next();
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } while (opcion != 6);
    }

    /**
     * Método que ejecuta las diferentes opciones según la opción seleccionada en el menú.
     * @param opcion Opción seleccionada por el usuario.
     */
    private static void switchMain(int opcion) {
        switch (opcion) {
            case 1:
                System.out.println("[ Añadir Personas:::::> ");
                anadirPersonas();
                break;
            case 2:
                System.out.println("[ Eliminar Personas:::::>");
                eliminarPersonas();
                break;
            case 3:
                System.out.println("[ Añadir asignaturas:::::>");
                anadirAsignaturas();
                break;
            case 4:
                System.out.println("[ Eliminar asignatura::::>");
                eliminarAsignaturas();
                break;
            case 5:
                System.out.println("[ Mostrar Informacion::::>");
                mostrarInformacion();
                break;
            case 6:
                System.out.println("\033[45mSaliendo...\033[0m");
                break;
            default:
                System.err.println("|| Error: Ingresa un numero entre 1-5 ||");
                break;
        }
    }

    /**
     * Método que muestra la información de todas las personas registradas, incluyendo
     * los estudiantes y sus asignaturas.
     */
    private static void mostrarInformacion() {
        if (personal.isEmpty()) {
            System.err.println("Error: No hay personas registradas");
        }
        for (Personal persona : personal) {
            if (persona instanceof Estudiante) {
                Estudiante estudiante = (Estudiante) persona;
                System.out.printf("Nombre Estudiante:%-15s\n", estudiante.getNombre());
                estudiante.mostrarAsignaturas();
            } else {
                System.out.println(persona);
            }
        }
    }

    /**
     * Método que elimina a una persona (Estudiante o Personal) de la lista de personas.
     * El nombre de la persona a eliminar se introduce por consola.
     */
    private static void eliminarPersonas() {
        boolean flag = false; // Al principio no hemos encontrado nada
        if (personal.isEmpty()) {
            System.err.println("|| No hay ninguna persona registrada ||");
            return;
        } else {
            System.out.println("Introduce el nombre de la persona que desea eliminar: ");
            String personaEliminar = sl.nextLine().toUpperCase();
            Iterator<Personal> it = personal.iterator();
            while (it.hasNext() && (!flag)) {
                Personal p = it.next();
                if (p instanceof Estudiante) {
                    Estudiante estudiante = (Estudiante) p;
                    if (estudiante.getNombre().equalsIgnoreCase(personaEliminar)) {
                        it.remove();
                        System.out.println("El estudiante ha sido eliminado con éxito.");
                        flag = true; // hemos encontrado
                    }
                } else {
                    if (p.getNombre().equalsIgnoreCase(personaEliminar)) {
                        it.remove();
                        System.out.println("El personal ha sido eliminado con éxito.");
                        flag = true; // hemos encontrado
                    }
                }
            }
        }
        if (!flag) {
            System.err.println("Error: Este nombre no coincide con ningún personal ni estudiante.");
        }
    }

    /**
     * Método que elimina una asignatura de un estudiante. El nombre del estudiante,
     * el nombre de la asignatura, el nombre del profesor y los créditos de la asignatura
     * se introducen por consola.
     */
    private static void eliminarAsignaturas() {
        if (personal.isEmpty()) {
            System.err.println(" | Error: no hay ningun estudiante registrado !!|");
        } else {
            System.out.println("De que estudiante desea eliminar la asignatura?");
            String nombreEstudiante = sl.nextLine();
            for (Personal p : personal) {
                if (p instanceof Estudiante) {
                    Estudiante estudiante = (Estudiante) p;
                    if (estudiante.getNombre().equalsIgnoreCase(nombreEstudiante)) {
                        System.out.print("Introduce el nombre de la asignatura a eliminar: ");
                        String nombreAsignatura = sl.nextLine().toUpperCase();
                        System.out.print("Introduce el nombre del profesor de la asignatura a eliminar: ");
                        String nombreProfesor = sl.nextLine().toUpperCase();
                        System.out.print("Introduce el nombre del credito a eliminar: ");
                        int credito = sl.nextInt();
                        Asignatura asignatura = new Asignatura(nombreAsignatura, nombreProfesor, credito);
                        int resultado = estudiante.borrarAsignatura(asignatura);
                        if (resultado == 1) {
                            System.err.println("|| No hay ningun asignatura registrada || ");
                        } else if (resultado == 2) {
                            System.out.println("|| Asignatura Eliminada con exito!!  ||");
                        } else {
                            System.err.println("|| Error: No se ha podido encontrar la asignatura!! ||");
                        }
                    }
                }
            }
        }
    }

    /**
     * Método que añade una asignatura a un estudiante. Se solicita el nombre del estudiante,
     * el nombre de la asignatura, el nombre del profesor y los créditos de la asignatura.
     */
    private static void anadirAsignaturas() {
        boolean flag = false;
        if (personal.isEmpty()) {
            System.err.println("No hay ningun perosnal registrado!! ");
        } else {
            System.out.println("Introduce un nombre de estudiante: ");
            String nombre = sl.nextLine();
            for (Personal p : personal) {
                if (p instanceof Estudiante) {
                    Estudiante estudiante = (Estudiante) p;
                    if (estudiante.getNombre().equalsIgnoreCase(nombre)) {
                        System.out.print("Introduzca la nombre de asignatura que desea añadir :");
                        String nombreAsignatura = sl.nextLine().toUpperCase();
                        System.out.print("Introduzca un profesor de esta asignatura:");
                        String profesor = sl.nextLine().toUpperCase();
                        System.out.print("Que creditos desea añadir?:");
                        int credito = sc.nextInt();
                        while (!flag) {
                            System.out.println("Estado Asignatura: | SUPERADO |. CURSADO | ABANDONADO |");
                            String estado = sl.nextLine().toUpperCase();

                            try {
                                EstadoAsignatura estadoParaAniadir = EstadoAsignatura.valueOf(estado);
                                Asignatura asignatura = new Asignatura(nombreAsignatura, profesor, credito);
                                if (!estudiante.anadirAsignaturas(asignatura, estadoParaAniadir)) {
                                    System.out.println("Asignatura añadido con exito");
                                    flag = true;
                                } else {
                                    System.err.println(" !! Error: La asignatura ya está registrada. !!");
                                    flag = true;
                                }
                            } catch (IllegalArgumentException e) {
                                System.err.println("Error: Valores válidos (SUPERADO, CURSADO, ABANDONADO)");
                            }
                        }
                    }
                }
            }
        }
        if (!flag) {
            System.out.println("No hay ningun estudiante con este nombre !! ");
        }
    }

    /**
     * Método que añade una nueva persona (Estudiante o Personal) a la lista de personas.
     */
    private static void anadirPersonas() {
        System.out.println("¿Quieres añadir un Estudiante(sí/no)?");
        boolean opcion = sc.next().trim().equalsIgnoreCase("sí");
        if (opcion) {
            System.out.println("Introduce el nombre del Estudiante: ");
            String nombreEstudiante = sl.nextLine().toUpperCase();
            Personal estudianteNew = new Estudiante(nombreEstudiante);
            personal.add(estudianteNew);
            System.out.println("Estudiante añadido correctamente");
        } else {
            System.out.println("Introduce el nombre del Personal: ");
            String nombrePersonal = sl.nextLine().toUpperCase();
            Personal personalNew = new Personal(nombrePersonal);
            personal.add(personalNew);
            System.out.println("Personal añadido correctamente");
        }
    }

    /**
     * Muestra el menú principal con las opciones disponibles.
     */
    private static void menu() {
        System.out.println("::::::: Menu Principal :::::");
        System.out.println("1. Añadir Personas");
        System.out.println("2. Eliminar Personas");
        System.out.println("3. Añadir asignaturas");
        System.out.println("4. Eliminar asignaturas");
        System.out.println("5. Mostrar informacion");
        System.out.println("6. Salir");
        System.out.print(">>>>>>>>>>>>");
    }
}
