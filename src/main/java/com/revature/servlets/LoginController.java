package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.services.LoginService;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ObjectMapper om = new ObjectMapper();

	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Credentials cred;
		try {
			LoginService ls = new LoginService();
			cred = om.readValue(req.getInputStream(), Credentials.class);
			User u = ls.getUser(cred);
			
			req.getRequestDispatcher("servlet-pages/welcomeEmployee.html").forward(req, resp);
			
			//resp.setStatus(200);
			//resp.getWriter().write(om.writeValueAsString(u));
			//resp.sendRedirect("servlet-pages/welcomeEmployee.html");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
