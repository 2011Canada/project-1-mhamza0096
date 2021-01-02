package com.revature.services;

import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.FinanceManagerReimbursementDAO;

public class FinanceManagerReimbursementService {

	FinanceManagerReimbursementDAO fmdao = new FinanceManagerReimbursementDAO();
	
	public List<Reimbursement> getReimburementList(User u) {
		
		return fmdao.getReimbursementList();
	}
	
	public void updateStatus(String status, int reimb_id) {
		
		fmdao.updateStatus(status, reimb_id);
		
	}

}
