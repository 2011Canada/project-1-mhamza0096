package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controllers.AuthController;


public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ObjectMapper om = new ObjectMapper();

	private void directControllerRouter(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		AuthController ac = new AuthController();
		
		String URI = req.getRequestURI().substring(req.getContextPath().length(), req.getRequestURI().length());
		System.out.println(URI);
		
		
		switch(URI) {
		
		case "/login":
			switch(req.getMethod()) {
				case "GET":
					System.out.println("this is get");
					 req.getRequestDispatcher("servlet-pages/index.html").forward(req, resp);;
					break;
				case "POST":
					System.out.println("this is post");
					ac.userLogin(req, resp);
					break;
			}
			break;
		}
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		directControllerRouter(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		directControllerRouter(req, resp);
		
	}

}
