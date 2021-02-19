package ma.youcode.ConnectionDB;

import java.sql.Connection;

import java.sql.DriverManager;

public class SingletonConnection {
	//singleton pour creer la connection un seul fois

	private static Connection connection;
	//le premier bloc a execute c'est bloc static

	static {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/WebAppPharmacy", "postgres", "123456789");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
