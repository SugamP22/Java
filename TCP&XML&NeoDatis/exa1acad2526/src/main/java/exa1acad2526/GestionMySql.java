package exa1acad2526;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GestionMySql {
	public void crearDocXML2(String nombreGalaxia, Connection connection) throws Exception {
		String query = "SELECT estrellas.*,galaxias.tipo,galaxias.numero_estrellas FROM estrellas INNER JOIN galaxias ON galaxias.nombre=estrellas.nombre_galaxia WHERE estrellas.nombre_galaxia=?;";
		try (PreparedStatement psmt = connection.prepareStatement(query);) {

		}
	}

	public void crearDocXML(String nombreGalaxia, Connection connection) throws Exception {
		String query = "SELECT estrellas.*,galaxias.tipo,galaxias.numero_estrellas FROM estrellas INNER JOIN galaxias ON galaxias.nombre=estrellas.nombre_galaxia WHERE estrellas.nombre_galaxia=?;";
		try (PreparedStatement psmt = connection.prepareStatement(query);) {
			psmt.setString(1, nombreGalaxia);
			ResultSet rs = psmt.executeQuery();
			boolean galaxiaEscribido = false;
			Document doc = null;
			Element estrellas = null;

			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();
			while (rs.next()) {
				if (!galaxiaEscribido) {
					galaxiaEscribido = true;
					Element root = doc.createElement("Galaxia");
					doc.appendChild(root);
					Element nombre = doc.createElement("Nombre");
					Element tipo = doc.createElement("Tipo");
					Element numeroEstrellas = doc.createElement("numeroEstrellas");
					estrellas = doc.createElement("Estrellas");

					nombre.setTextContent(rs.getString(8));
					tipo.setTextContent(rs.getString(11));
					numeroEstrellas.setTextContent(rs.getString(12));
					root.appendChild(nombre);
					root.appendChild(tipo);
					root.appendChild(numeroEstrellas);
					root.appendChild(estrellas);
				}

				Element estrella = doc.createElement("Estrella");
				Element coordinada = doc.createElement("Coordinadas");
				ingresarHijosCoordinadas("X", doc, coordinada, rs.getString(2));
				ingresarHijosCoordinadas("Y", doc, coordinada, rs.getString(3));
				ingresarHijosCoordinadas("Z", doc, coordinada, rs.getString(4));
				Element distancia = doc.createElement("Distancia");
				Element tipo = doc.createElement("Tipo");
				Element fechaDiscubrimiento = doc.createElement("FechaDescubrimiento");
				Element descubridor = doc.createElement("Descubridor");

				estrella.setAttribute("nombre", rs.getString(1));
				distancia.setTextContent(rs.getString(5));
				tipo.setTextContent(rs.getString(7));
				fechaDiscubrimiento.setTextContent(rs.getString(9));
				descubridor.setTextContent(rs.getString(8));

				estrellas.appendChild(estrella);
				estrella.appendChild(coordinada);
				estrella.appendChild(distancia);
				estrella.appendChild(tipo);
				estrella.appendChild(fechaDiscubrimiento);
				estrella.appendChild(descubridor);

			}
			TransformerFactory transformerFac = TransformerFactory.newInstance();
			Transformer transformer = transformerFac.newTransformer();
			transformer.transform(new DOMSource(doc), new StreamResult(Main.archivoXML));
			if (!galaxiaEscribido) {
				throw new IllegalArgumentException("No existe ninguno estrllas con este nombre de galaxia");
			}
		}
	}

	private void ingresarHijosCoordinadas(String string, Document doc, Element coordinada, String string2) {
		Element element = doc.createElement(string);
		element.setTextContent(string2);
		coordinada.appendChild(element);

	}

	public void buscarEstrellas(String tipo_Estrellas, Connection conn) throws Exception {

		String query = "SELECT estrellas.nombre_galaxia,estrellas.tipo,COUNT(estrellas.nombre) as numeroTotal FROM estrellas WHERE estrellas.tipo=? GROUP BY estrellas.nombre_galaxia,estrellas.tipo HAVING COUNT(estrellas.nombre)>1;";
		try (PreparedStatement psmt = conn.prepareStatement(query)) {
			psmt.setString(1, tipo_Estrellas);
			ResultSet rs = psmt.executeQuery();
			boolean encontrado = false;
			while (rs.next()) {
				encontrado = true;
				System.out.printf("Nombre Galaxia: %-35s  || Tipo: %-5s  || Numero Estrellas: %s%n", rs.getString(1),
						rs.getString(2), rs.getString(3));
				System.out.println("==========================================================================");
			}
			if (!encontrado) {
				throw new IllegalArgumentException("No hay estrella con este tipo en niguno galaxia!!");
			}
		}

	}

}
