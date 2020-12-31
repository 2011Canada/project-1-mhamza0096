package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

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
				u.setUser_id(res.getInt("ers_users_id"));
				u.setUsername(res.getString("ers_username"));
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
