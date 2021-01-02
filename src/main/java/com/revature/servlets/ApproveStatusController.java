package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.services.FinanceManagerReimbursementService;


public class ApproveStatusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		FinanceManagerReimbursementService fms = new FinanceManagerReimbursementService(); 
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("currUser");
		Status s = new Status();
		s = om.readValue(req.getInputStream(), Status.class);
		fms.updateStatus(s.getStatus(), s.getReimb_id(), u);
		
	}

}
