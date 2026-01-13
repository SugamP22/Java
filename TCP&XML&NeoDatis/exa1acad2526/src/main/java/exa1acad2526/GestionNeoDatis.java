package exa1acad2526;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.neodatis.odb.ODB;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class GestionNeoDatis {

	public void crearGalaxias(Connection conn, ODB odb) throws Exception {
		String query = "Select * from galaxias";
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Galaxias galaxias = new Galaxias(rs.getString(1), rs.getObject(2, String.class),
						rs.getObject(3, Long.class));
				odb.store(galaxias);

			}
		}
	}

	public void crearEstrellas(Connection conn, ODB odb) throws Exception {

		String query = "Select *  from estrellas;";
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Galaxias galaxias = null;
				Objects<Galaxias> listaGalaxias = odb
						.getObjects(new CriteriaQuery(Galaxias.class, Where.equal("nombre", rs.getString(8))));
				galaxias = listaGalaxias.isEmpty() ? null : listaGalaxias.getFirst();

				Estrellas estrellasPrincipal = null;
				Objects<Estrellas> listaEstrellas = odb
						.getObjects(new CriteriaQuery(Estrellas.class, Where.equal("nombre", rs.getString(6))));
				estrellasPrincipal = listaEstrellas.isEmpty() ? null : listaEstrellas.getFirst();

				Estrellas estrella = new Estrellas(rs.getString(1), rs.getObject(2, Double.class),
						rs.getObject(3, Double.class), rs.getObject(4, Double.class), rs.getObject(5, Double.class),
						estrellasPrincipal, rs.getString(7), galaxias);

				odb.store(estrella);
			}
		}
	}

	public void crearPlanetas(Connection conn, ODB odb) throws Exception {
		String query = "Select * from planetas";
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Estrellas estrella = null;
				Objects<Estrellas> listaEstrellas = odb
						.getObjects(new CriteriaQuery(Estrellas.class, Where.equal("nombre", rs.getString(4))));
				estrella = listaEstrellas.isEmpty() ? null : listaEstrellas.getFirst();

				Planetas planetas = new Planetas(rs.getString(1), rs.getObject(2, Double.class),
						rs.getObject(3, Double.class), estrella);
				odb.store(planetas);
			}
		}
	}

	public void listaDePlanetas(Connection conn, ODB odb) throws Exception {
		ICriterion criterio1 = Where.lt("periodo_orbital", 10.0);
		ICriterion criterio2 = Where.equal("estrellas.tipo", "M");
		ICriterion criterio = new And().add(criterio1).add(criterio2);
		Objects<Planetas> listaPlanetas = odb.getObjects(new CriteriaQuery(Planetas.class, criterio));
		boolean encontrado = false;
		while (listaPlanetas.hasNext()) {
			encontrado = true;
			Planetas p = listaPlanetas.next();
			System.out.println("Nombre Planetas: " + p.getNombre());
			System.out.println("--------------------------------------------");
		}
		if (!encontrado) {
			throw new IllegalArgumentException(
					"No encontrado ningun planeta con un periodoOrbital menor que 10 Y tipo M");
		}

	}

}
