package peval3acda2526;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Main {
	private static final String RUTA = "D:\\pval3acda2526\\sjcucina.neo";
	private static final File ARCHIVOPADRE = new File("D:\\pval3acda2526");

	public static void main(String[] args) {
		int opcion;
		do {
			opcion = MetodosBasicos.leerInt(
					"\n====== Menú Principal ======\n1. Crear BD\n2. Ingresar Especia\n3. Modificar perfil de sabor\n4. Eliminar perfil de sabor\n5. listar especia\n6. Salir\nSelecciona una opcion: ");
			switchMain(opcion);
		} while (opcion != 6);
	}

	private static void switchMain(int opcion) {
		switch (opcion) {
		case 1:
			crearBD();
			break;
		case 2:
			ingresarEspecie();
			break;
		case 3:
			modificarPS();
			break;
		case 4:
			eliminarPS();
			break;
		case 5:
			listar();
			break;
		case 6:
			System.out.println("Saliendo de la sistema");
			break;
		default:
			System.err.println("Error: Ingresar numero entre(1-6)");
			break;
		}
	}

	private static void listar() {
		comprobarRuta();
		ODB odb = null;
		try {
			odb = ODBFactory.open(RUTA);
			String nombre = MetodosBasicos.leerString("Introduce un pais de origen: ");
			buscar(odb, nombre);

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			if (odb != null) {
				odb.close();
			}
		}

	}

	private static void buscar(ODB odb, String nombre) {
		Objects<Especia> listaEspecias = odb.getObjects(new CriteriaQuery(Especia.class));
		if (listaEspecias.isEmpty()) {
			throw new IllegalArgumentException("No hay niguno especia registrado para mostrar");
		}
		for (Especia especia : listaEspecias) {
			if (especia.getOrigenGeografico().contains(nombre)) {
				System.out.println(especia.toString());
				System.out.println("-----------------------------------------------------");
			}

		}
	}

	private static void eliminarPS() {
		comprobarRuta();
		ODB odb = null;
		try {
			odb = ODBFactory.open(RUTA);
			String tipoCocina = MetodosBasicos
					.leerString("Introduce un tipo cocina para eliminar este perfil de sabor: ");
			eliminarConBD(odb, tipoCocina);
			System.out.println("Eliminado con exitó!!");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			if (odb != null) {
				odb.close();
			}
		}

	}

	private static void eliminarConBD(ODB odb, String tipoCocina) {

		Objects<PerfilSabor> listaPS = odb
				.getObjects(new CriteriaQuery(PerfilSabor.class, Where.equal("tipoCocina", tipoCocina)));
		if (listaPS.isEmpty()) {
			throw new IllegalArgumentException("No hay ninguno perfil de sabor con este tipo de cocina!!");
		}

		PerfilSabor sabor = listaPS.getFirst();
		Objects<Especia> listaEspecias = odb.getObjects(new CriteriaQuery(Especia.class));
		for (Especia especia : listaEspecias) {
			quitar(especia.getUsos(), sabor);
			odb.store(especia);
		}
		odb.delete(sabor);
	}

	private static void quitar(ArrayList<PerfilSabor> lista, PerfilSabor sabor) {
		Iterator<PerfilSabor> it = lista.iterator();
		while (it.hasNext()) {
			PerfilSabor ps = it.next();
			if (ps == sabor) {
				it.remove();
				return;
			}
		}

	}

	private static void modificarPS() {
		comprobarRuta();
		ODB odb = null;
		try {
			odb = ODBFactory.open(RUTA);
			String nombre = MetodosBasicos.leerString("Introduce un tipo Cocina de un perfil de sabor: ");
			buscarYModificar(odb, nombre);
			System.out.println("MaridajeIdeal modificado con exito!!");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			if (odb != null) {
				odb.close();
			}
		}

	}

	private static void buscarYModificar(ODB odb, String nombre) {

		Objects<PerfilSabor> listaPerfilsabor = odb
				.getObjects(new CriteriaQuery(PerfilSabor.class, Where.equal("tipoCocina", nombre)));

		if (!listaPerfilsabor.isEmpty()) {
			PerfilSabor sabor = listaPerfilsabor.getFirst();
			System.out.println("MaridajeIdeal existente: " + sabor.getMaridajeIdeal());
			String nuevoNombre = MetodosBasicos.leerString("Introduce un nuevo maridajeIdeal: ");
			sabor.setMaridajeIdeal(nuevoNombre);
			odb.store(sabor);
		} else {
			throw new IllegalArgumentException("No encontrado perfil de sabor con este tipo Cocina");
		}

	}

	private static void ingresarEspecie() {
		comprobarRuta();
		ODB odb = null;
		try {
			odb = ODBFactory.open(RUTA);
			String nombre = MetodosBasicos.leerString("Introduce un nombre de Especia: ");
			String origrnGro = MetodosBasicos.leerString("Introduce de donde son estos Especia: ");
			double stock = MetodosBasicos.leerDouble("Cuantos gramos tienes en stock: ");
			int intensidadPicante = MetodosBasicos.leerInt("Que nivel de picante lleva: ");
			int numeroPerfildeSabor = MetodosBasicos.leerInt("Cuantos numero de perfil de sabores quieres añadir: ");
			ArrayList<PerfilSabor> lista = new ArrayList<>();
			try {
				for (int i = 0; i < numeroPerfildeSabor; i++) {
					PerfilSabor perfilSabor = buscarEspecia(odb);
					if (perfilSabor == null) {
						break;
					}
					lista.add(perfilSabor);
					System.out.println("Perfil de sabor añadido");
				}
			} catch (IllegalArgumentException e) {
				System.err.println("Error: " + e.getMessage());
			}
			Especia especia = new Especia(nombre, origrnGro, stock, intensidadPicante, lista);
			odb.store(especia);
			System.out.println("Especia registrado con exito!!");
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}

	private static PerfilSabor buscarEspecia(ODB odb) {
		try {
			Objects<PerfilSabor> listaPS = odb.getObjects(new CriteriaQuery(PerfilSabor.class));
			if (listaPS.isEmpty())
				throw new IllegalArgumentException("No hay perfiles de sabor");
			ArrayList<PerfilSabor> lista = new ArrayList<>();

			System.out.println("Perfil de sabor disponibles:");
			int num = 1;
			for (PerfilSabor perfilSabor : listaPS) {
				System.out.println(num + ". " + perfilSabor.getTipoCocina());
				lista.add(perfilSabor);
				num++;
			}
			int opcion;
			do {
				opcion = MetodosBasicos.leerInt("Selecciona una opcion: ");
			} while (opcion < 1 || opcion > listaPS.size());
			return lista.get(opcion - 1);

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return null;
	}

	private static void crearBD() {
		comprobarRuta();
		ODB odb = null;
		try {
			odb = ODBFactory.open(RUTA);
			PerfilSabor marroqui = new PerfilSabor("Marroquí", "Cítrico, floral, amaderado",
					"Cuscús, pollo, tagines de verduras", false);
			PerfilSabor india = new PerfilSabor("India", "Terroso, cálido, ligeramente picante",
					"Lentejas (dal), arroz, pollo tikka", true);
			PerfilSabor europea = new PerfilSabor("Europea", "Dulce, especiado, a nuez",
					"Tartas de manzana, galletas, café", false);
			PerfilSabor meditarrinia = new PerfilSabor("Mediterránea", "Anisado, fresco, herbal",
					"Pescados blancos, mariscos, sopas", false);
			PerfilSabor mexicana = new PerfilSabor("Mexicana", "Picante, ahumado, robusto",
					"Carnes a la parrilla, frijoles, chili ", true);
			Especia azafrán = new Especia("Azafrán", "La Mancha, España", 15.2, 0,
					new ArrayList<>(Arrays.asList(marroqui, meditarrinia, europea)));
			Especia pemiento = new Especia("Pimienta Negra", "Kerala, India", 850.5, 7,
					new ArrayList<>(Arrays.asList(mexicana, europea, india)));

			odb.store(marroqui);
			odb.store(india);
			odb.store(europea);
			odb.store(meditarrinia);
			odb.store(mexicana);
			odb.store(azafrán);
			odb.store(pemiento);
			System.out.println("Base de dato creado con exitó");

		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		} finally {
			if (odb != null) {
				odb.close();
			}
		}
	}

	private static void comprobarRuta() {
		if (!ARCHIVOPADRE.exists()) {
			ARCHIVOPADRE.mkdirs();
		}

	}
}
