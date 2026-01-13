package exa1acda2425;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GestionMYSQL {

	public void ObtenerDatosConMes(Connection conn, Integer mes) throws SQLException {
		String query = "SELECT DISTINCT vuelo.*,personal.*,tripulacion.PUESTO,pasajero.NOMBRE,pasaje.NUMASIENTO,pasaje.CLASE FROM personal \r\n"
				+ "INNER JOIN tripulacion ON tripulacion.PERSONAL_CODIGO=personal.CODIGO\r\n"
				+ "INNER JOIN vuelo ON vuelo.IDENTIFICADOR=tripulacion.VUELO_IDENTIFICADOR\r\n"
				+ "INNER JOIN pasaje ON pasaje.IDENTIFICADOR=vuelo.IDENTIFICADOR\r\n"
				+ "INNER JOIN pasajero ON pasajero.COD=pasaje.PASAJERO_COD\r\n" + "WHERE Month(vuelo.FECHA_VUELO)=?;";
		try (PreparedStatement psmt = conn.prepareStatement(query);) {
			psmt.setObject(1, mes, Types.INTEGER);
			ResultSet rs = psmt.executeQuery();
			boolean encontrado = false;
			while (rs.next()) {
				encontrado = true;
				System.out.printf(
						"IDENTIFICADOR: %s%nAEROPUERTO_ORIGEN: %s%nAEROPUERTO_DESTINO: %s%nFECHA_VUELO: %s%nNOMBRE_PERSONAL: %s%nCATEGORÍA_PERSONA: %s%nPuesto: %s%nNombre_Pasajero: %s%nNum Asiento: %s%nClase: %s%n",
						rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
				System.out.println("--------------------------------");
			}
			if (!encontrado) {
				throw new IllegalArgumentException("No encontrado ningunp dato de personal!!");
			}
		}

	}

	public void ObtenerPrecio(Connection conn, String tipo) throws SQLException {
		String query = "SELECT vuelo.TIPO_VUELO,pasaje.CLASE,SUM(pasaje.PVP) as Total FROM pasaje INNER JOIN vuelo ON vuelo.IDENTIFICADOR=pasaje.IDENTIFICADOR WHERE vuelo.TIPO_VUELO=? GROUP BY vuelo.TIPO_VUELO,pasaje.CLASE ORDER BY SUM(pasaje.PVP) DESC;";
		try (PreparedStatement psmt = conn.prepareStatement(query);) {
			psmt.setObject(1, tipo, Types.VARCHAR);
			ResultSet rs = psmt.executeQuery();
			boolean encontrado = false;
			while (rs.next()) {
				encontrado = true;
				System.out.printf("Tipo: %s%nClase: %s%nRecaudacion: %s%n", rs.getString(1), rs.getString(2),
						rs.getString(3));
				System.out.println("--------------------------------");
			}
			if (!encontrado) {
				throw new IllegalArgumentException("No encontrado ninguno vuelo para mostrar!!");
			}
		}
	}

	public void crearXML(Connection conn, int mes)
			throws SQLException, ParserConfigurationException, TransformerException {
		String query = "SELECT DISTINCT vuelo.*,personal.*,tripulacion.PUESTO,pasajero.NOMBRE,pasaje.NUMASIENTO,pasaje.CLASE FROM personal \r\n"
				+ "INNER JOIN tripulacion ON tripulacion.PERSONAL_CODIGO=personal.CODIGO\r\n"
				+ "INNER JOIN vuelo ON vuelo.IDENTIFICADOR=tripulacion.VUELO_IDENTIFICADOR\r\n"
				+ "INNER JOIN pasaje ON pasaje.IDENTIFICADOR=vuelo.IDENTIFICADOR\r\n"
				+ "INNER JOIN pasajero ON pasajero.COD=pasaje.PASAJERO_COD\r\n" + "WHERE Month(vuelo.FECHA_VUELO)=? "
				+ "ORDER BY vuelo.IDENTIFICADOR;";

		try (PreparedStatement psmt = conn.prepareStatement(query);) {
			psmt.setInt(1, mes);
			ResultSet rs = psmt.executeQuery();

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			Element root = doc.createElement("vuelos");
			doc.appendChild(root);

			String previous = "";
			boolean encontrado = false;

			Element vuelo = null;
			Element tripulacionContainer = null;
			Element pasajerosContainer = null;

			Set<String> tripulantesVuelo = new HashSet<>();
			Set<String> pasajerosVuelo = new HashSet<>();

			while (rs.next()) {
				encontrado = true;
				String currentId = rs.getString(1);

				if (!previous.equals(currentId)) {
					vuelo = doc.createElement("vuelo");
					vuelo.setAttribute("identificador", currentId);

					Element origen = doc.createElement("origen");
					origen.setTextContent(rs.getString(2));
					vuelo.appendChild(origen);

					Element destino = doc.createElement("destino");
					destino.setTextContent(rs.getString(3));
					vuelo.appendChild(destino);

					Element fecha = doc.createElement("fecha");
					fecha.setTextContent(rs.getString(5));
					vuelo.appendChild(fecha);

					tripulacionContainer = doc.createElement("tripulacion");
					vuelo.appendChild(tripulacionContainer);

					pasajerosContainer = doc.createElement("pasajeros");
					vuelo.appendChild(pasajerosContainer);

					root.appendChild(vuelo);

					previous = currentId;
					tripulantesVuelo.clear();
					pasajerosVuelo.clear();
				}

				String nombreTripu = rs.getString(7);
				if (!tripulantesVuelo.contains(nombreTripu)) {
					insertarDatos(doc, tripulacionContainer, nombreTripu, rs.getString(8), rs.getString(9));
					tripulantesVuelo.add(nombreTripu);
				}

				String nombrePas = rs.getString(10);
				String asiento = rs.getString(11);
				String keyPasajero = nombrePas + "-" + asiento;
				if (!pasajerosVuelo.contains(keyPasajero)) {
					insertarDatosPasejeros(doc, pasajerosContainer, nombrePas, asiento, rs.getString(12));
					pasajerosVuelo.add(keyPasajero);
				}
			}

			if (!encontrado) {
				throw new IllegalArgumentException("No encontrado ninguno dato para el mes indicado!!");
			}

			TransformerFactory Tf = TransformerFactory.newInstance();
			Transformer t = Tf.newTransformer();
			t.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
			t.transform(new DOMSource(doc), new StreamResult(Main.XMLARCHIVO));
		}
	}

	private void insertarDatosPasejeros(Document doc, Element pasajeros, String string, String string2,
			String string3) {
		Element e = doc.createElement("pasajero");
		e.setAttribute("nombre", string);
		pasajeros.appendChild(e);
		Element e1 = doc.createElement("asiento");
		e1.setTextContent(string2);
		Element e2 = doc.createElement("clase");
		e2.setTextContent(string3);
		e.appendChild(e1);
		e.appendChild(e2);

	}

	private void insertarDatos(Document doc, Element tripulacion, String string, String string2, String string3) {
		Element e = doc.createElement("tripulante");
		e.setAttribute("nombre", string);
		tripulacion.appendChild(e);
		Element e1 = doc.createElement("categoria");
		e1.setTextContent(string2);
		Element e2 = doc.createElement("puesto");
		e2.setTextContent(string3);
		e.appendChild(e1);
		e.appendChild(e2);

	}

}