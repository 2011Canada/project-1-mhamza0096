package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.EmployeeReimbursementDAO;

public class EmployeeReimbursementService {

	
	public List<Reimbursement> getReimburement() {
		
		EmployeeReimbursementDAO erdao = new EmployeeReimbursementDAO();
		return erdao.getReimbursement();
	}
	
}
