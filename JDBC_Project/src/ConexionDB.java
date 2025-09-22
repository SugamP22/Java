
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConexionDB {
  private Connection conn = null;

  public ConexionDB() {
    connectar();
  }

  private void connectar() {
    String url = "jdbc:mysql://localhost:3306/marvel";
    String usuario = "root";
    String contra = "";
    try {
      conn = DriverManager.getConnection(url, usuario, contra);
      if (conn != null) {
        System.err.println("Connection establecido con exito!!");
      }
    } catch (SQLException e) {
      System.err.println("Error:" + e.getMessage());
    }
  }

  public void disconnectar() {
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        System.err.println("Error:" + e.getMessage());
      }
    }
  }

  public Connection getConn() {
    return conn;
  }

  public boolean insertarPersonaje(Personaje p) {
    if (conn != null) {
      String query = """
          Insert into personaje(nombre,mascara,capa,tipo) Values(?,?,?,?)
          """;
      String query1 = """
          Insert into poderes(nombre,id_personaje) Values(?,?)
          """;
      try (PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {
        pstmt.setString(1, p.getNombre());
        pstmt.setBoolean(2, p.isMascara());
        pstmt.setBoolean(3, p.isCapa());
        pstmt.setString(4, p.getTipo().name());

        int res = pstmt.executeUpdate();
        if (res == 0)
          return false;
        ResultSet rs = pstmt.getGeneratedKeys();
        rs.next();
        int id = rs.getInt(1);
        try (PreparedStatement psmt1 = conn.prepareStatement(query1)) {
          for (Poderes poder : p.getPoderes()) {
            psmt1.setString(1, poder.getNombre());
            psmt1.setInt(2, id);
            psmt1.executeUpdate();
          }
          return true;
        }

      } catch (SQLException e) {
        System.err.println("Error:" + e.getMessage());
      }
    }
    return false;
  }

  public boolean eliminarPersonaje(int id) {
    if (conn != null) {
      String query = """
          Delete from personaje
          where id=?
          """;
      try (PreparedStatement psmt = conn.prepareStatement(query);) {
        psmt.setInt(1, id);
        int res = psmt.executeUpdate();
        return res > 0;
      } catch (SQLException e) {
        System.err.println("Error:" + e.getMessage());
      }

    }
    return false;
  }

  public boolean modificarPersonje(int idPersonaje, String nombre, boolean mascara, boolean capa) {
    if (conn != null) {
      String query = """
          UPDATE personaje SET nombre=?, mascara=?, capa=? WHERE id=?
          """;
      try (PreparedStatement psmt = conn.prepareStatement(query)) {
        psmt.setString(1, nombre);
        psmt.setBoolean(2, mascara);
        psmt.setBoolean(3, capa);
        psmt.setInt(4, idPersonaje);
        int rs = psmt.executeUpdate();
        return rs > 0;
      } catch (SQLException e) {
        System.err.println("Error:" + e.getMessage());
      }
    }
    return false;
  }

  public ArrayList<Personaje> listarPersonaje() {
    if (conn != null) {
      ArrayList<Personaje> personaje = new ArrayList<>();
      String query = "Select personaje.id,personaje.nombre,personaje.mascara,personaje.capa,personaje.tipo from personaje";
      String query1 = "Select poderes.id,poderes.nombre,poderes.id_personaje from poderes";
      try (Statement smt = conn.createStatement()) {
        ResultSet rs = smt.executeQuery(query);
        while (rs.next()) {
          int id = rs.getInt(1);
          String nombre = rs.getString(2);
          boolean mascara = rs.getBoolean(3);
          boolean capa = rs.getBoolean(4);
          Tipo tipo = (Tipo.valueOf(rs.getString(5)));
          Personaje p = new Personaje(capa, id, mascara, nombre, tipo);
          personaje.add(p);
        }
        try (Statement stmt1 = conn.createStatement()) {
          ResultSet rs1 = stmt1.executeQuery(query1);
          while (rs1.next()) {
            int idPoder = rs1.getInt(1);
            String nombrePoder = rs1.getString(2);
            int idPersonaje = rs1.getInt(3);
            Poderes poder = new Poderes(idPoder, nombrePoder);
            for (Personaje p : personaje) {
              if (p.getId() == idPersonaje) {
                p.addpoder(poder);
              }
            }
          }

        }

        return personaje;
      } catch (SQLException e) {
        System.err.println("Error: " + e.getMessage());
      }
    }
    return null;
  }

  public boolean insertarBatalla(Batalla batalla) {
    if (conn != null) {

    }
    return false;
  }

  public ArrayList<Batalla> listarBatallas() {
    if (conn != null) {
      ArrayList<Batalla> listabatalla = new ArrayList<>();
      String query = "Select batalla.id,batalla.lugar,batalla.fecha,batalla.id_ganador,batlla.id_perdedor from batalla";

      return listabatalla;
    }
    return null;
  }

}