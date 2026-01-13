package exa1acda2425;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;

public class Main {
	private static GestionNEO neodatis = new GestionNEO();
	private static GestionMYSQL mysql = new GestionMYSQL();
	private static final String RUTA = "D:\\exa1acda2425\\vuelos.neo";
	private static final File PADRE = new File("D:\\exa1acda2425");
	public static final File XMLARCHIVO = new File(PADRE, " vuelos.xml");

	public static void main(String[] args) {
		int opcion;
		do {
			opcion = MetodosBasicos.leerInt(
					"\n===== Menú Principal ======\n1. Mostrar Datos Personal\n2. Obtener datos por tipo\n3. Crear XML\n4. Crear DB Neodatis\n5. Iterar Usando NeoDatis\n6.Salir\nSelecciona una opcion: ");
			switchMain(opcion);
		} while (opcion != 6);
	}

	private static void switchMain(int opcion) {
		switch (opcion) {
		case 1:
			mostrarDatosPersonal();
			break;
		case 2:
			obtenerRecaudacion();
			break;
		case 3:
			crearXML();
			break;
		case 4:
			crearNeodatis();
			break;
		case 5:
			obtenerDatosUsaNeoDB();
			break;
		case 6:
			System.out.println("Saliendo de la sistema...");
			break;
		default:
			System.err.println("Error: Ingresa un numero entre(1-6)");
			break;
		}

	}

	private static void obtenerDatosUsaNeoDB() {
		ODB odb = null;

		try {
			odb = ODBFactory.open(RUTA);
			neodatis.buscarPasajeros(odb);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			if (odb != null) {
				odb.close();
			}
		}

	}

	private static void crearNeodatis() {
		comprobarYcrearPadre();
		ODB odb = null;
		Conexion conn = new Conexion();
		try {
			conn.conectar();
			odb = ODBFactory.open(RUTA);
			if (conn.getConn() != null && odb != null) {
				neodatis.insertarDatosVuelos(conn.getConn(), odb);
				neodatis.insertarDatosPasajeros(conn.getConn(), odb);
				neodatis.insertarDatosPasaje(conn.getConn(), odb);
			} else {
				System.err.println("Error: Comprueba la conexion con los base de datos");
			}
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			conn.cerrar();
			if (odb != null) {
				odb.close();
			}
		}
	}

	private static void comprobarYcrearPadre() {
		if (!PADRE.exists()) {
			PADRE.mkdirs();
		}
	}

	private static void crearXML() {
		Conexion conn = new Conexion();
		try {
			conn.conectar();
			if (conn.getConn() != null) {
				compruebaYcrear();
				Integer mes;
				do {
					mes = MetodosBasicos.leerInt("Introduce un mes(1-12): ");
				} while (mes < 1 || mes > 12);
				mysql.crearXML(conn.getConn(), mes);
				System.out.println("DOC XML creado con exito!!");
			} else {
				System.err.println("Error: Comprueba la conexion");
			}

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			conn.cerrar();
		}

	}

	private static void compruebaYcrear() throws IOException {
		if (!PADRE.exists()) {
			PADRE.mkdirs();
		}
		if (!XMLARCHIVO.exists()) {
			XMLARCHIVO.createNewFile();
		}

	}

	private static void obtenerRecaudacion() {
		Conexion conn = new Conexion();
		try {
			conn.conectar();
			if (conn.getConn() != null) {
				String tipo;
				tipo = MetodosBasicos.leerStringOpcional("Introduce un tipo de vuelo: ");
				mysql.ObtenerPrecio(conn.getConn(), tipo);
			} else {
				System.err.println("Error: Comprueba la conexion");
			}
		} catch (SQLException | IllegalArgumentException e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			conn.cerrar();
		}

	}

	private static void mostrarDatosPersonal() {
		Conexion conn = new Conexion();
		try {
			conn.conectar();
			if (conn.getConn() != null) {
				Integer mes;
				mes = MetodosBasicos.leerInt("Introduce un mes(1-12): ");
				mysql.ObtenerDatosConMes(conn.getConn(), mes);
			} else {
				System.err.println("Error: Comprueba la conexion");
			}
		} catch (SQLException | IllegalArgumentException e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			conn.cerrar();
		}

	}

}
