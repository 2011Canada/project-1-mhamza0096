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
				reimb.setReimb_amount(res.getInt("reimb_amount"));
				reimbList.add(reimb);
			}
			
		return reimbList;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
}
