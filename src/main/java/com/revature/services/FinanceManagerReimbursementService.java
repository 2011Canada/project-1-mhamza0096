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

}
