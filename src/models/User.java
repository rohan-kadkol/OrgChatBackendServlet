package models;

import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public class User {
	String id;
	String name;
	String phoneNumber;
	String email;
	
	public User(String id, String name, String phoneNumber, String email) {
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public static User fromResultSet(ResultSet rs) {
		try {
			String id = rs.getString("ID");
			String name = rs.getString("name");
			String phoneNumber = rs.getString("phone_number");
			String email = rs.getString("email");
			
			return new User(id, name, phoneNumber, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
