package hashMap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GestionBiblioteca {

    private static HashMap<Libro, Integer> biblioteca = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    // Punto de entrada
    public static void main(String[] args) {
        ejecutarMenu();
    }

    private static void ejecutarMenu() {
        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1: // Añadir un libro
                    añadirLibro();
                    break;
                case 2: // Actualizar cantidad de copias
                    actualizarCantidad();
                    break;
                case 3: // Eliminar un libro
                    eliminarLibro();
                    break;
                case 4: // Mostrar todos los libros
                    mostrarLibros();
                    break;
                case 5: // Salir
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 5);
    }

    // Mostrar el menú
    private static void mostrarMenu() {
        System.out.println("\n----- Menú de Gestión de Biblioteca -----");
        System.out.println("1. Añadir un nuevo libro");
        System.out.println("2. Actualizar cantidad de copias de un libro");
        System.out.println("3. Eliminar un libro");
        System.out.println("4. Mostrar todos los libros");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");
    }

    // Añadir un libro
    private static void añadirLibro() {
        System.out.print("Introduce el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Introduce la cantidad de copias: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Libro nuevoLibro = new Libro(titulo, autor);
        if (biblioteca.containsKey(nuevoLibro)) {
            System.out.println("El libro ya existe. Actualizando la cantidad de copias.");
            actualizarCantidad(nuevoLibro, cantidad);
        } else {
            biblioteca.put(nuevoLibro, cantidad);
            System.out.println("Libro añadido correctamente.");
        }
    }

    // Actualizar la cantidad de copias
    private static void actualizarCantidad() {
        System.out.print("Introduce el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Introduce la nueva cantidad de copias: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Libro libroAActualizar = new Libro(titulo, autor);
        actualizarCantidad(libroAActualizar, cantidad);
    }

    // Método de actualización de cantidad
    private static void actualizarCantidad(Libro libro, int cantidad) {
        if (biblioteca.containsKey(libro)) {
            biblioteca.put(libro, cantidad);
            System.out.println("Cantidad actualizada correctamente.");
        } else {
            System.out.println("El libro no se encuentra en la biblioteca.");
        }
    }

    // Eliminar un libro
    private static void eliminarLibro() {
    	if(biblioteca.isEmpty()) {
    		System.out.println("No tiene ningun Libro registrado para Eliminar!!");
    	}else {
    		
			System.out.print("Introduce el título del libro: ");
			String titulo = scanner.nextLine();
			System.out.print("Introduce el autor del libro: ");
			String autor = scanner.nextLine();

			Libro libroAEliminar = new Libro(titulo, autor);
			if (biblioteca.containsKey(libroAEliminar)) {
				biblioteca.remove(libroAEliminar);
				System.out.println("Libro eliminado correctamente.");
			} else {
				System.out.println("El libro no se encuentra en la biblioteca.");
			}
    	}
    }

    // Mostrar todos los libros
    private static void mostrarLibros() {
        if (biblioteca.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            System.out.println("Libros en la biblioteca:");
            for (Map.Entry<Libro, Integer> entry : biblioteca.entrySet()) {
                System.out.println(entry.getKey() + ", Cantidad de copias: " + entry.getValue());
            }
        }
    }
}