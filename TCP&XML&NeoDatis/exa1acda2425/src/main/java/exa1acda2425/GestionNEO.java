package exa1acda2425;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Not;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class GestionNEO {

	public void insertarDatosVuelos(Connection conn, ODB odb) throws SQLException {
		String query = "SELECT * FROM vuelo";

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

			while (rs.next()) {
				String id = rs.getString(1);

				Objects<Vuelos> existentes = odb.getObjects(new CriteriaQuery(Vuelos.class, Where.equal("id", id)));

				if (existentes.isEmpty()) {
					Vuelos v = new Vuelos(id, rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5));
					odb.store(v);
				}
			}
			System.out.println("Datos de vuelos insertados correctamente");
		}
	}

	public void insertarDatosPasajeros(Connection conn, ODB odb) throws SQLException {
		String query = "SELECT * FROM pasajero";

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

			while (rs.next()) {
				int cod = rs.getInt(1);

				Objects<Pasajero> existentes = odb
						.getObjects(new CriteriaQuery(Pasajero.class, Where.equal("cod", cod)));

				if (existentes.isEmpty()) {
					Pasajero p = new Pasajero(cod, rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
					odb.store(p);
				}
			}
			System.out.println("Datos de pasajeros insertados correctamente");
		}
	}

	public void insertarDatosPasaje(Connection conn, ODB odb) throws SQLException {
		String query = "SELECT * FROM pasaje";

		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {

			while (rs.next()) {

				Objects<Pasajero> listaPasajero = odb
						.getObjects(new CriteriaQuery(Pasajero.class, Where.equal("cod", rs.getInt(1))));
				if (listaPasajero.isEmpty())
					continue;
				Pasajero pasajero = listaPasajero.getFirst();

				// Buscar vuelo
				Objects<Vuelos> listaVuelos = odb
						.getObjects(new CriteriaQuery(Vuelos.class, Where.equal("id", rs.getString(2))));
				if (listaVuelos.isEmpty())
					continue;
				Vuelos vuelo = listaVuelos.getFirst();

				ICriterion criterio = new And().add(Where.equal("pasajero.cod", pasajero.getCod()))
						.add(Where.equal("vuelos.id", vuelo.getId()));

				Objects<Pasaje> existentes = odb.getObjects(new CriteriaQuery(Pasaje.class, criterio));

				if (existentes.isEmpty()) {
					Pasaje p = new Pasaje(pasajero, vuelo, rs.getInt(3), rs.getString(4), rs.getFloat(5));
					odb.store(p);
				}
			}
			System.out.println("Datos de pasajes insertados correctamente");
		}
	}

	public void buscarPasajeros(ODB odb) {

		ICriterion query = new And()
				.add(new Or().add(Where.iequal("identificador.origen", "MAD LEMD"))
						.add(Where.iequal("identificador.destino", "MAD LEMD")))
				.add(Where.iequal("clase", "turista")).add(new Not(Where.iequal("pasajero.pais", "ESPAÑA")));

		Objects<Pasaje> listaPasajes = odb.getObjects(new CriteriaQuery(Pasaje.class, query));

		if (listaPasajes.isEmpty()) {
			throw new IllegalArgumentException("No hay pasajeros que cumplan el criterio");
		}

		for (Pasaje p : listaPasajes) {
			System.out.println(p.getPasajero());
			System.out.println("-------------------------");
		}
	}
}
