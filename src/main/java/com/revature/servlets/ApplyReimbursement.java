package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Credentials;
import com.revature.models.ReimbursementData;
import com.revature.models.User;
import com.revature.services.EmployeeReimbursementService;


public class ApplyReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper om = new ObjectMapper();
			ReimbursementData rd = new ReimbursementData();
			EmployeeReimbursementService ers = new EmployeeReimbursementService();
			HttpSession session = req.getSession();
			User u = (User) session.getAttribute("currUser");
			
			rd = om.readValue(req.getInputStream(), ReimbursementData.class);
			ers.applyReimbursement(rd, u);
			
	}

}
