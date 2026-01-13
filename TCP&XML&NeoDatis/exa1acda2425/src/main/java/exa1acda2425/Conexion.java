package exa1acda2425;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private Connection conn = null;

	public Connection getConn() {
		return conn;
	}

	public void cerrar() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void conectar() throws SQLException {
		if (conn == null) {
			String url = "jdbc:mysql://localhost:3306/vuelos";
			String usuario = "root";
			String pas = "";
			conn = DriverManager.getConnection(url, usuario, pas);
			System.out.println("Conexion con base de dato establecido");
		}

	}
}
