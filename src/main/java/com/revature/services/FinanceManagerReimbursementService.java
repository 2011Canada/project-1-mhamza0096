package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.FinanceManagerReimbursementDAO;

public class FinanceManagerReimbursementService {

	FinanceManagerReimbursementDAO fmdao = new FinanceManagerReimbursementDAO();
	
	public List<Reimbursement> getReimburementList(String status) {
		
		return fmdao.getReimbursementList(status);
	}
	
	public void updateStatus(String status, int reimb_id, User u) {
		
		fmdao.updateStatus(status, reimb_id, u);
		
	}

}
