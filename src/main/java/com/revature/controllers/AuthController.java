package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.services.LoginService;
import com.servlets.models.Credentials;
import com.servlets.models.User;

public class AuthController {
	
	ObjectMapper om = new ObjectMapper();
	LoginService ls = new LoginService();
	
	public void userLogin(HttpServletRequest req, HttpServletResponse resp) {
		Credentials cred;
		try {
			
			cred = om.readValue(req.getInputStream(), Credentials.class);
			User u = ls.getUser(cred);
			
			resp.setStatus(200);
			resp.getWriter().write(om.writeValueAsString(u));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
