//- Crea la clase Producto (Serializable) con código, nombre, stock, precio y proveedor.
//- El programa debe ofrecer un menú con las opciones:
//    - Añadir producto
//    - Listar productos
//    - Buscar producto por código
//    - Actualizar stock
//    - Eliminar producto
//    - Guardar y Salir
//    
//    > El proveedor no se guarda en el archivo
//    >
package actividad14;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Main {
	private static final String NOMBRE_ARCHIVO = "Producto.obj";
	private static List<Producto> producto;

	public static void main(String[] args) {
		iniciarMain();
		System.out.println("\033[34mGracias por su participación!!\033[0m");
	}

	private static void iniciarMain() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			cargarDatos();
			int opcion = 0;
			do {
				menu();
				try {
					opcion = Integer.parseInt(br.readLine());
					switchMain(opcion, br);
				} catch (NumberFormatException e) {
					System.err.println("Error: " + e.getMessage());
				}
			} while (opcion != 6);
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked") // deciendo al compilador que ignorar las lineas en amarillo para que no
									// confunde y piensa es un error!!
	private static void cargarDatos() {
		try (FileInputStream fis = new FileInputStream(NOMBRE_ARCHIVO)) {
			ObjectInputStream ois = new ObjectInputStream(fis);
			producto = (ArrayList<Producto>) ois.readObject();
			int contador = 0;
			for (Producto p : producto) {
				if (p.getCodigo() > contador) {
					contador++;
				}
			}
			Producto.setContador(contador + 1);

			System.err.println("Deserializado con exito!!");

		} catch (FileNotFoundException e) {
			System.err.println("Error: " + e.getMessage());
			producto = new ArrayList<Producto>();
			System.out.println("Lista producto initializado sin producto!!");
		} catch (IOException | ClassNotFoundException e) {
			System.err.println("Error: " + e.getMessage());
			producto = new ArrayList<Producto>();// si no existe el clase initializamos una lista vacia!!
			System.out.println("Lista producto initializado sin producto!!");
		}
	}

	private static void switchMain(int opcion, BufferedReader br) {
		switch (opcion) {
		case 1 -> aniadirProducto(br);
		case 2 -> listarProductos();
		case 3 -> buscarProducto(br);
		case 4 -> actualizarProducto(br);
		case 5 -> eliminarProducto(br);
		case 6 -> guardarProductos();
		default -> System.err.println("Error: Entrada invalido ingresa numero entre 1 y 6");

		}

	}

	private static void guardarProductos() {
		try (FileOutputStream fos = new FileOutputStream(NOMBRE_ARCHIVO)) {
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(producto);
			System.out.println("Datos guardado con exito!!");

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	private static void eliminarProducto(BufferedReader br) {
		if (producto.isEmpty()) {
			System.out.println("NO hay ningun peoducto registrado para eliminar!!");
			return;
		}
		try {
			do {
				System.out.println("Codigo para eliminar: ");
				try {
					int codigo = Integer.parseInt(br.readLine());

					Iterator<Producto> it = producto.iterator();
					while (it.hasNext()) {
						Producto producto = it.next();
						if (producto.getCodigo() == codigo) {

							it.remove();
							System.out.println("✔ Producto con código " + codigo + " eliminado con éxito.");
							return;
						}

					}

					System.err.println("No existe ningun producto con ese codigo para eliminar");

				} catch (NumberFormatException e) {
					System.err.println("Error: " + e.getMessage());
				}
			} while (true);

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static void actualizarProducto(BufferedReader br) {

		if (producto.isEmpty()) {
			System.out.println("NO hay ningun peoducto registrado para eliminar!!");
			return;
		}
		try {
			do {
				System.out.println("Codigo para actualizar el stock: ");
				try {
					int codigo = Integer.parseInt(br.readLine());
					System.out.println("Estado de stock(s/n)");
					boolean stock = br.readLine().equalsIgnoreCase("s");

					Iterator<Producto> it = producto.iterator();
					while (it.hasNext()) {
						Producto producto = it.next();
						if (producto.getCodigo() == codigo) {
							producto.setStock(stock);
							System.out.println("✔ Stock de producto con codigo" + codigo + " Actualizado a " + stock);
							return;
						}

					}

					System.err.println("No existe ningun producto con ese codigo para actualizar su stock");

				} catch (NumberFormatException e) {
					System.err.println("Error: " + e.getMessage());
				}
			} while (true);

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	private static void buscarProducto(BufferedReader br) {
		try {
			if (producto.isEmpty()) {
				System.out.println("NO hay ningun producto registrado para buscar!!");
				return;
			}

			try {
				System.out.print("Codigo parabuscar: ");
				int codigo = Integer.parseInt(br.readLine());
				for (Producto p : producto) {
					if (p.getCodigo() == codigo) {

						System.out.println(p);
						return;
					}
				}

				System.err.println("Error: no encontrado ningun libro con ese numero de codigo!!");

			} catch (NumberFormatException e) {
				System.err.println("Error: " + e.getMessage());
			}

		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

	private static void listarProductos() {
		if (producto.isEmpty()) {
			System.out.println("No hay ningun producto registrado!!");
			return;
		}
		System.out.println("Productos registrados :");
		System.out.println("-----------------------------------------------");
		for (Producto p : producto) {
			System.out.println(p);
		}
	}

	private static void aniadirProducto(BufferedReader br) {
		try {
			while (true) {
				try {
					System.out.print("Nombre:");
					String nombre = br.readLine();
					System.out.print("Stock(s/n):");
					boolean stock = br.readLine().trim().equalsIgnoreCase("s");
					System.out.print("Precio: ");
					double precio = Double.parseDouble(br.readLine());
					System.out.print("Provedor: ");
					String provedor = br.readLine();
					producto.add(new Producto(nombre, stock, precio, provedor));
					System.out.print("Producto añadido con exito!!");
					return;
				} catch (NumberFormatException e) {
					System.err.println("Error: invalido dato");
				}

			}
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

	private static void menu() {
		System.out.println("\n---- Menú Principal ----");
		System.out.println("1. Añadir producto");
		System.out.println("2. Listar Productos");
		System.out.println("3. Buscar producto por código");
		System.out.println("4. Actualizar stock");
		System.out.println("5. Eliminar producto");
		System.out.println("6. Guardar y Salir");
		System.out.print("=========>");

	}

}
