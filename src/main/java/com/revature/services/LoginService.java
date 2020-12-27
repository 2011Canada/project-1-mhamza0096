package com.revature.services;

import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class LoginService {
	
	UserDAO udao = new UserDAO();
	
	public User getUser(Credentials cred) {
		
		User u = udao.getUser(cred);
		return u;
	}
	
}
