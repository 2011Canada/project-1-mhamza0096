package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class EmployeeReimbursementDAO {
	
	ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	public List<Reimbursement> getReimbursement() {
		
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		
		Connection conn = cf.getConnection();
		String sql = "select * from ers_reimbursement";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet res = ps.executeQuery();
			
			while(res.next()) {
				Reimbursement reimb = new Reimbursement();
				reimb.setReimb_id(res.getInt("reimb_id"));
				reimb.setReimb_amount(res.getInt("reimb_amount"));
				reimb.setReimb_submitted(res.getString("reimb_submitted"));
				reimb.setReimb_resolved(res.getString("reimb_resolved"));
				reimb.setReimb_description(res.getString("reimb_description"));
				//reimb receipt
				reimb.setReimb_author(res.getInt("reimb_author"));
				reimb.setReimb_resolver(res.getInt("reimb_resolver"));
				reimb.setReimb_status_id(res.getInt("reimb_status_id"));
				reimb.setReimb_type_id(res.getInt("reimb_type_id"));
				reimbList.add(reimb);
			}
			
		return reimbList;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
}
