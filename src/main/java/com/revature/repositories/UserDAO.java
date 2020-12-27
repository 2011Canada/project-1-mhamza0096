package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;
import com.servlets.models.Credentials;
import com.servlets.models.User;

public class UserDAO {

	ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	public User getUser(Credentials cred) {
		Connection conn = cf.getConnection();
		String sql = "select * from ers_users where ers_username = ? and ers_password = ?";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cred.getUsername());
			ps.setString(2, cred.getPassword());
			ResultSet res = ps.executeQuery();
			User u = new User();
			
			while(res.next()) {
				u.setUsername(res.getString("ers_username"));
				u.setPassword(res.getString("ers_password"));
				u.setFirstName(res.getString("user_first_name"));
				u.setLastName(res.getString("user_last_name"));
				u.setEmail(res.getString("user_email"));
				u.setRole_id(res.getInt("ers_user_role_id"));
			}
			return u;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
}
