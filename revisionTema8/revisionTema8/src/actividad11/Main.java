package actividad11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    private static final String NOMBRE_ARCHIVO = "Persona.txt";
    private static List<String> personas = new ArrayList<>();

    public static void main(String[] args) {
        iniciarMain();
        System.out.println("Gracias por su participación!!");
    }

    private static void iniciarMain() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int opcion = 0;

            do {
                try {
                    menu();
                    opcion = Integer.parseInt(br.readLine());
                    switchMain(opcion, br);

                } catch (NumberFormatException e) {
                    System.err.println("Entrada inválida!!");
                }
            } while (opcion != 6);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void switchMain(int opcion, BufferedReader br) {
        switch (opcion) {
            case 1 -> cargarDatos(br);
            case 2 -> leerdatos();
            case 3 -> imprimirDatosmayores();
            case 4 -> contarpersonasRegistrados();
            case 5 -> modificar(br);
            case 6 -> System.out.println("Saliendo del programa...");
            default -> System.err.println("Error: Opción inválida, elige entre (1-6)");
        }
    }

    private static void cargarDatos(BufferedReader br) {
        while (true) {
            try {
                System.out.println("Introduce DNI:");
                String dni = br.readLine();
                System.out.println("Introduce Nombre:");
                String nombre = br.readLine();
                System.out.println("Introduce Apellido:");
                String apellido = br.readLine();
                System.out.println("Introduce Edad:");
                int edad = Integer.parseInt(br.readLine());

                // Prepare the data to be written
                String persona = "Dni:" + dni + "| Nombre:" + nombre + "| Apellido:" + apellido + "| Edad:" + edad;
                personas.add(persona);

                // Use 'true' to append data to the file
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
                    writer.write(persona);
                    writer.newLine();
                    System.out.println("Guardado con éxito");
                }
                return;
            } catch (NumberFormatException e) {
                System.err.println("Error: Dato inválido introducido!!, " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    private static void modificar(BufferedReader br) {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String lineas;
            personas.clear();  // Clear the list before loading from the file
            while ((lineas = reader.readLine()) != null) {
                personas.add(lineas);
            }
            System.out.println("Datos Guardados:");
            for (String p : personas) {
                System.out.println(p);
                System.out.println("------------------");
            }
            System.out.println("Introduce DNI para modificar: ");
            String dniPaModificar = br.readLine();
            if (updatingDni(dniPaModificar)) {
                System.out.println("Introduce los nuevos datos:");
                cargarDatos(br);  // Add new data after removal
                actualizarArchivo();  // Update the entire file
                leerdatos();
            } else {
                System.out.println("No coincide con ningun dato!!");
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static boolean updatingDni(String dniPaModificar) {
        boolean found = false;
        Iterator<String> it = personas.iterator();
        while (it.hasNext() && !found) {
            String info = it.next();
            String[] datos = info.trim().split("\\|");
            String[] dniSplit = datos[0].trim().split(":");
            if (dniSplit.length > 0) {
                String dni = dniSplit[1];
                if (dni.equalsIgnoreCase(dniPaModificar)) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }

    private static void actualizarArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO))) {
            for (String p : personas) {
                writer.write(p);
                writer.newLine();
            }
            System.out.println("Archivo actualizado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al actualizar el archivo: " + e.getMessage());
        }
    }

    private static void contarpersonasRegistrados() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            int contador = 0;
            String lineas;
            while ((lineas = reader.readLine()) != null) {
                contador++;
            }
            System.out.printf("Número total de personas registradas: %d\n", contador);

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void imprimirDatosmayores() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String lineas;
            while ((lineas = reader.readLine()) != null) {
                String[] datos = lineas.trim().split("\\|");
                if (datos.length == 4) {
                    String datoEdad = datos[3].trim().split(":")[1].trim();
                    try {
                        if (Integer.parseInt(datoEdad) >= 18) {
                            System.out.println("Mayor de edad: " + lineas);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Error al convertir la edad en la línea: " + lineas);
                    }
                }
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void leerdatos() {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            boolean haydatos = false;
            String leer;
            while ((leer = reader.readLine()) != null) {
                System.out.println(leer);
                haydatos = true;
            }
            if (!haydatos) {
                System.out.println("NO existe ningun dato");
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void menu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Cargar datos");
        System.out.println("2. Leer datos");
        System.out.println("3. Imprimir mayores de edad");
        System.out.println("4. Contar personas registradas");
        System.out.println("5. Modificar datos por DNI");
        System.out.println("6. Salir");
        System.out.print("============>");
    }
}
