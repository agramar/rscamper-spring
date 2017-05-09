package kr.co.rscamper;

import java.sql.DriverManager;
import org.junit.Test;
import java.sql.Connection;

public class MySQLConnectionTest {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://127.0.0.1:3306/rscamper";
	private static final String USER = "rscamper";
	private static final String PW = "rscamper";
	
	@Test
	public void testConnection() throws Exception {
		Class.forName(DRIVER);
		
		try (Connection con = DriverManager.getConnection(URL, USER, PW)) {
			System.out.println(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
