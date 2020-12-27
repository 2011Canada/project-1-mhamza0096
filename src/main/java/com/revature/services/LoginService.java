package com.revature.services;

import com.revature.repositories.UserDAO;
import com.servlets.models.Credentials;
import com.servlets.models.User;

public class LoginService {
	
	UserDAO udao = new UserDAO();
	
	public User getUser(Credentials cred) {
		
		User u = udao.getUser(cred);
		return u;
	}
	
}
