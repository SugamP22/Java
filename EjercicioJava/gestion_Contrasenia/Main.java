package gestion_Contrasenia;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Scanner sl = new Scanner(System.in);
    private static ArrayList<Usuario> users = new ArrayList<Usuario>();
    private static Administrador admin = new Administrador("Sugam", "Gune112232");

    public static void main(String[] args) {
        precargarDatos();  // Preload sample data
        iniciarMenu();
        System.out.println("!! Gracias Por su Participacion !!");
    }

    private static void iniciarMenu() {
        int opcion = 0;
        do {
            menu();
            try {
                opcion = sc.nextInt();
                sc.nextLine();  // This line clears the buffer (consume the newline character)
                switch (opcion) {
                    case 1:
                        System.out.println("|| Registrar Usuarios ||");
                        registrarUsuarios();
                        break;
                    case 2:
                        System.out.println("|| Iniciar Sesión ||");
                        iniciarSesion();
                        break;
                    case 3:
                        System.out.println("|| Cambiar Contraseña ||");
                        cambiarContrasenia();
                        break;
                    case 4:
                        System.out.println("Saliendo..");
                        break;
                    default:
                        System.out.println("Introduce un número entre 1 y 4");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println(" || Entrada Inválida ||");
                sc.next();  // To consume the invalid input
            }

        } while (opcion != 4);
    }


    private static void registrarUsuarios() {
        boolean flag = false;
        while (!flag) {
            try {
                System.out.print("Introduce un nombre de Usuario: ");
                String nombre = sl.nextLine().toUpperCase();
                System.out.print("Introduce una Contraseña: ");
                String contrasenia = sc.nextLine();
                users.add(new Usuario(nombre, contrasenia));
                System.out.println("El Usuario añadido con éxito!!");
                flag = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void iniciarSesion() {
        System.out.print("Introduce tu nombre de usuario: ");
        String nombreUsuario = sl.nextLine();
        System.out.print("Introduce tu contraseña: ");
        String contrasenia = sc.nextLine();

        for (Usuario u : users) {
            if (u.getUsuarioNombre().equalsIgnoreCase(nombreUsuario)) {
                if (u.getContrasenia().equals(contrasenia)) {
                    System.out.println("Inicio de sesión exitoso.");
                    return; // Exit the method when login is successful
                } else {
                    System.out.println("Contraseña incorrecta.");
                    return;
                }
            }
        }
        System.out.println("El usuario no existe.");
    }

    private static void cambiarContrasenia() {
        System.out.print("Introduce tu nombre de usuario: ");
        String nombreUsuario = sl.nextLine();
        System.out.print("Introduce tu contraseña actual: ");
        String contraseniaActual = sc.nextLine();
        System.out.print("Introduce tu nueva contraseña: ");
        String nuevaContrasenia = sc.nextLine();

        for (Usuario u : users) {
            if (u.getUsuarioNombre().equalsIgnoreCase(nombreUsuario)) {
                if (u.getContrasenia().equals(contraseniaActual)) {
                    try {
                        u.setContrasenia(nuevaContrasenia);
                        System.out.println("Contraseña cambiada con éxito.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    return;
                } else {
                    System.out.println("La contraseña actual no es correcta.");
                    return;
                }
            }
        }
        System.out.println("El usuario no existe.");
    }

    private static void precargarDatos() {
        // Preload some sample users
        users.add(new Usuario("JUAN", "Contraseña123$$"));
        users.add(new Usuario("MARIA", "Pass1234$$"));
        users.add(new Usuario("PEDRO", "MiContraseña$123"));
    }

    private static void menu() {
        System.out.println("::::: Menú Principal :::::");
        System.out.println("1. Registrar Nuevos Usuarios");
        System.out.println("2. Iniciar Sesión (Validando Contraseña)");
        System.out.println("3. Cambiar Contraseña");
        System.out.println("4. Salir");
        System.out.print(">>>>>>>>>>>");
    }
}
