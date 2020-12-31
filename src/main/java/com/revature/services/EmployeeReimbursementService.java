package com.revature.services;

import java.util.Date;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.ReimbursementData;
import com.revature.models.User;
import com.revature.repositories.EmployeeReimbursementDAO;

public class EmployeeReimbursementService {

	EmployeeReimbursementDAO erdao = new EmployeeReimbursementDAO();
	
	public List<Reimbursement> getReimburement(User u) {
		
		return erdao.getReimbursement(u);
	}

	public void applyReimbursement(ReimbursementData rd, User u) {
		
		Reimbursement r = new Reimbursement();
		
		
		
		r.setReimb_amount(rd.getAmount());
		r.setReimb_description(rd.getDescription());
		
		if(rd.getType().toUpperCase().equals("TRAVEL")) {
			r.setReimb_type_id(1);
			
		} else if(rd.getType().toUpperCase().equals("DENTAL")) {
			r.setReimb_type_id(2);
			
		} else if(rd.getType().toUpperCase().equals("MEDICAL")) {
			r.setReimb_type_id(3);
			
		} else if(rd.getType().toUpperCase().equals("OFFICE SUPPLIES")) {
			r.setReimb_type_id(4);
			
		}
		r.setReimb_author(u.getUser_id());
		r.setReimb_type_id(3);
		System.out.println(r.getReimb_type_id());
		Date date = new Date();
		String date_submitted = date.getDate() + "-" + date.getMonth() + "-" + date.getYear();
		r.setReimb_submitted(date_submitted);
		erdao.applyReimbursement(r);
		
		
	}
	
}
