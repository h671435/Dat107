package no.hvl.dat107.solution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main2_UsingPersonObjects {

	static final String JDBC_DRIVER = "org.postgresql.Driver";
	
//	static final String DB_URL = "jdbc:postgresql://localhost:5432/dat107v22";
//	static final String USER = "postgres";
//	static final String PASS = Passwords.LOCALHOST_PASSWORD;
	
	static final String DB_URL = "jdbc:postgresql://ider-database.westeurope.cloudapp.azure.com:5432/h671435";
	static final String USER = "h671435";
	static final String PASS = "pass";

	public static void main(String[] args) throws ClassNotFoundException {
		
		List<Person> personer = new ArrayList<>();
		
		String sql = "SELECT id, navn FROM forelesning1.person";

		Class.forName(JDBC_DRIVER);
		
		System.out.println("Kobler til database...");
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			while (rs.next()) {
				Person p = new Person();
				p.setId(rs.getInt("id"));
				p.setNavn(rs.getString("navn"));
				personer.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("Resultat:");
		for (Person p : personer) {
			System.out.println(p);
		}
		
		System.out.println("Ferdig!");
	}

}
