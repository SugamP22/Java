package exa1acad2526;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private Connection conn = null;

	public Connection getConn() {
		return conn;
	}

	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println("Error: " + e.getMessage());
			}
		}

	}

	public Conexion() {
		conectar();
	}

	private void conectar() {
		if (conn == null) {
			String url = "jdbc:mysql://localhost:3306/astronomia";
			String usuario = "root";
			String contrasenia = "";
			try {
				conn = DriverManager.getConnection(url, usuario, contrasenia);
				System.out.println("Conexion establecido con base de dato...");
			} catch (SQLException e) {
				System.err.println("Error: " + e.getMessage());
			}

		}

	}

}
