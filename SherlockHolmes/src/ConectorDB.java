import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

public final class ConectorDB {
  private Connection conn = null;

  public ConectorDB() {
    connectar();
  }

  public Connection getConn() {
    return conn;
  }

  public void disconnenctar() {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
  }

  public void connectar() {
    if (conn == null) {
      String usuario = "root";
      String url = "jdbc:mysql://localhost:3306/sherlock";
      String contrasenia = "";
      try {
        conn = DriverManager.getConnection(url, usuario, contrasenia);
        if (conn == null) {
          System.out.println("Conexión a base de datos de Sherlock lista!!");
        }
      } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }

  }

  public ArrayList<String> listarDetectives() {
    if (conn != null) {
      ArrayList<String> especialidad = new ArrayList<>();
      String query = "SELECT detective.especialidad from detective";
      try (PreparedStatement psmt = conn.prepareStatement(query)) {
        ResultSet rs = psmt.executeQuery();
        while (rs.next()) {
          String habilidad = rs.getString("especialidad");
          especialidad.add(habilidad);
        }
        return especialidad;
      } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());

      }

    }
    return null;
  }

  public boolean insertarDetective(Detective detective) {
    if (conn != null) {
      String query = "Insert into detective(nombre,especialidad) Values(?,?)";
      try (PreparedStatement psmt = conn.prepareStatement(query)) {
        psmt.setString(1, detective.getNombre());
        psmt.setString(2, detective.getEspecialidad());
        int rs = psmt.executeUpdate();
        return rs > 0;
      } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());

      }
    }
    return false;
  }

  public ArrayList<Sospechoso> listarSospechosos() {
    if (conn != null) {
      ArrayList<Sospechoso> sospechosos = new ArrayList<>();
      String query = "SELECT sospechoso.id,sospechoso.nombre,sospechoso.nivel_peligrosidad,sospechoso.arma FROM sospechoso;";
      try (PreparedStatement psmt = conn.prepareStatement(query)) {
        ResultSet rs = psmt.executeQuery();
        while (rs.next()) {
          int id = rs.getInt("id");
          String nombre = rs.getString("nombre");
          int nivel_peligrosidad = rs.getInt("nivel_peligrosidad");
          String arma = rs.getString("arma");
          Sospechoso s = new Sospechoso(id, nombre, nivel_peligrosidad, arma);
          sospechosos.add(s);
        }
        return sospechosos;
      } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());

      }

    }
    return null;
  }

  public ArrayList<Casos> listarCasosDB() {
    if (conn != null) {
      ArrayList<Casos> casos = new ArrayList<>();
      String query = """
          SELECT caso.id,caso.titulo,caso.descripcion,caso.fecha_apertura,caso.resuelto,detective.nombre as detective_nombre,sospechoso.nombre as sospechoso_nombre,sospechoso.id as id_sospechoso,sospechoso.arma,sospechoso.nivel_peligrosidad
          FROM caso
          INNER JOIN detective ON caso.detective_id=detective.id
          INNER JOIN sospechoso on caso.sospechoso_id=sospechoso.id
                """;
      try (Statement stmt = conn.createStatement()) {
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
          int id = rs.getInt("id");
          String titulo = rs.getString("titulo");
          String discripcion = rs.getString("descripcion");
          boolean resuelto = rs.getBoolean("resuelto");
          LocalDate fecha = rs.getDate("fecha_apertura").toLocalDate();
          Sospechoso s = new Sospechoso();
          s.setNombre(rs.getString("sospechoso_nombre"));
          s.setId(rs.getInt("id_sospechoso"));
          s.setArma(rs.getString("arma"));
          s.setNivelDePeligro(rs.getInt("nivel_peligrosidad"));
          Detective d = new Detective();
          d.setNombre(rs.getString("detective_nombre"));
          casos.add(new Casos(id, titulo, discripcion, fecha, s, d, resuelto));

        }
        return casos;

      } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
    return null;
  }

  public boolean modificarCaso(int id) {
    if (conn != null) {
      String query = "Update caso set resuelto = TRUE where id =?";
      try (PreparedStatement psmt = conn.prepareStatement(query)) {
        psmt.setInt(1, id);
        int rs = psmt.executeUpdate();
        return rs > 0;
      } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
    return false;
  }

}
