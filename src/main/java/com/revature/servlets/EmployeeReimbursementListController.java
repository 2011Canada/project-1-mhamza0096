package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.EmployeeReimbursementService;


public class EmployeeReimbursementListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public EmployeeReimbursementListController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ObjectMapper om = new ObjectMapper();
		
		EmployeeReimbursementService ers = new EmployeeReimbursementService();
		List<Reimbursement> reimbList = ers.getReimburement();
		resp.setStatus(200);
		resp.getWriter().write(om.writeValueAsString(reimbList.get(0)));
		
	}

}
