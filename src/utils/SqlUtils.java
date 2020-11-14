package utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public final class SqlUtils {
	private SqlUtils() {
	}

	public static void runGetSqlQuery(String sql, GetSqlQueryInterface getSqlQueryInterface) {
		// JDBC driver name and database URL
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		// String DB_URL = "jdbc:mysql://52.26.86.130:3306/student";
		String DB_URL = "jdbc:mysql://localhost:3306/orgchat";

		// Database credentials
		String USER = "root";
		String PASS = "";

		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = (Statement) conn.createStatement();
			System.out.println(sql);
			// STEP 5: Extract data from result set
			ResultSet rs = (ResultSet) stmt.executeQuery(sql);
			while (rs.next()) {
				getSqlQueryInterface.onGetResultSet(rs);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			StringWriter writer = new StringWriter();
			e.printStackTrace(new PrintWriter(writer));
		}
	}
}
