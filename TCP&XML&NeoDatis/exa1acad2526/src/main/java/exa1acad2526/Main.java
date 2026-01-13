package exa1acad2526;

import java.io.File;
import java.io.IOException;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class Main {
	private static final String ruta = "D:\\exa1acda2526\\astronomia.neo";
	private static final File ARCHIVOPADRE = new File("D:\\exa1acda2526");
	public static final File archivoXML = new File(ARCHIVOPADRE, "estrellas.xml");
	private static GestionMySql gestionMySql = new GestionMySql();
	private static GestionNeoDatis gestionNeoDatis = new GestionNeoDatis();

	public static void main(String[] args) {
		int opcion;
		do {
			String info = "\n==== Menú Principal =====\n1. Crear Xml"
					+ "\n2. Leer dato de BD\n3. Crear Tabla de Neodatis\n4. Buscar en Neodatis\n5. Salir\n Selecciona una opcion: ";
			opcion = MetodosBasicos.leerInt(info);
			switchMain(opcion);
		} while (opcion != 5);

	}

	private static void switchMain(int opcion) {
		switch (opcion) {
		case 1:
			crearXML();
			break;
		case 2:
			numeroEstrellas();
			break;
		case 3:
			crearTablaNeoDatis();
			break;
		case 4:
			listaDePlanetas();
			break;
		case 5:
			System.out.println("Saliendo de la sistema...");
			break;
		default:
			System.err.println("Error: Ingresa numero entre (1-5)");
			break;
		}

	}

	private static void listaDePlanetas() {
		comprobarRutaPadre();
		Conexion conn = null;
		ODB odb = null;
		try {
			conn = new Conexion();
			odb = ODBFactory.open(ruta);
			if (conn.getConn() != null) {
				System.out.println("estoy dentro..");
				gestionNeoDatis.listaDePlanetas(conn.getConn(), odb);
			} else {
				System.err.println("Error: Comprobar la conexion de base de datos");
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
			// TODO: handle exception
		} finally {
			conn.close();
			odb.close();
		}

	}

	private static void crearTablaNeoDatis() {
		comprobarRutaPadre();
		Conexion conn = null;
		ODB odb = null;
		try {
			conn = new Conexion();
			odb = ODBFactory.open(ruta);
			if (conn.getConn() != null) {
				gestionNeoDatis.crearGalaxias(conn.getConn(), odb);
				gestionNeoDatis.crearEstrellas(conn.getConn(), odb);
				gestionNeoDatis.crearPlanetas(conn.getConn(), odb);
			} else {
				System.err.println("Error: Comprueba la conexion con Base de dato!!");
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());

		} finally {
			odb.close();
			conn.close();
		}
	}

	private static void comprobarRutaPadre() {
		if (!ARCHIVOPADRE.exists()) {
			ARCHIVOPADRE.mkdirs();
		}
	}

	private static void numeroEstrellas() {
		Conexion conn = null;
		try {
			conn = new Conexion();
			if (conn.getConn() != null) {
				String tipo_Estrellas = MetodosBasicos.leerString("Introduce un tipo de estrella: ");
				gestionMySql.buscarEstrellas(tipo_Estrellas, conn.getConn());
			} else {
				System.err.println("Error: Comprueba la conexion!!");
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			conn.close();
		}

	}

	private static void crearXML() {
		comprobarYCrear();
		Conexion conn = null;
		try {
			conn = new Conexion();
			if (conn.getConn() != null) {
				String nombreGalaxia = MetodosBasicos.leerString("Introduce un nombre de galaxia: ");
				gestionMySql.crearDocXML(nombreGalaxia, conn.getConn());
				System.out.println("XMl creado con exito!!");
			} else {
				System.err.println("Error: Comprueba la conexion!!");
			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			conn.close();
		}
	}

	private static void comprobarYCrear() {
		if (!ARCHIVOPADRE.exists())
			ARCHIVOPADRE.mkdirs();
		if (!archivoXML.exists()) {
			try {
				archivoXML.createNewFile();
			} catch (IOException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}

	}
}
