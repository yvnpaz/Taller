package repository.frameworks.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigurationDB {

	public static boolean instanciado = false;
	private static String url = "C:\\Users\\EXTypaz\\Desktop\\Taller\\myDB.db";
	static Connection connect;

	public ConfigurationDB() {}

	public static void Conex() {

		try {
			connect = DriverManager.getConnection("jdbc:sqlite:"+url);
			System.out.println("Conexion establecida.");
			instanciado = true;
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public static Connection getConex() {
		return connect;
	}

	@Override
	protected void finalize() {
		try {
			getConex().close();
			System.out.println("Conexion cerrada");
		} catch (Exception e) {
		}
	}
}
