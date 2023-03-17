package no.hvl.dat107.solution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main3_FindPersonById {

	static final String JDBC_DRIVER = "org.postgresql.Driver";

//	static final String DB_URL = "jdbc:postgresql://localhost:5432/dat107v22";
//	static final String USER = "postgres";
//	static final String PASS = Passwords.LOCALHOST_PASSWORD;

	static final String DB_URL = "jdbc:postgresql://ider-database.westeurope.cloudapp.azure.com:5432/h671435";
	static final String USER = "h671435";
	static final String PASS = "pass";

	public static void main(String[] args) throws ClassNotFoundException {

		Class.forName(JDBC_DRIVER);

		Person p = finnPersonMedId(1001);

		System.out.println(p);

	}

	public static Person finnPersonMedId(int id) {

		String sql = "SELECT id, navn FROM forelesning1.person WHERE id=" + id;

		Person p = null;

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			if (rs.next()) {
				p = new Person();
				p.setId(rs.getInt("id"));
				p.setNavn(rs.getString("navn"));
			}

			return p;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
