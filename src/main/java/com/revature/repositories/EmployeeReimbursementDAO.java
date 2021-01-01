package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class EmployeeReimbursementDAO {
	
	ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	public List<Reimbursement> getReimbursement(User u) {
		
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		
		Connection conn = cf.getConnection();
		String sql = "select * from ers_reimbursement natural join ers_reimbursement_status natural join ers_reimbursement_type where reimb_author = ? order by reimb_status asc";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, u.getUser_id());
			System.out.println(u.getUser_id());
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
				reimb.setReimb_status_description(res.getString("reimb_status"));
				reimb.setReimb_type_description(res.getString("reimb_type"));
				reimbList.add(reimb);
			}
			
		return reimbList;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}

	public void applyReimbursement(Reimbursement r) {
		Connection conn = cf.getConnection();
		String sql = "insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)"
				+ "	values ( ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, r.getReimb_amount());
			ps.setString(2, r.getReimb_submitted());
			ps.setString(3, "");
			ps.setString(4, r.getReimb_description());
			ps.setInt(5, r.getReimb_author());
			ps.setInt(6, 0);
			ps.setInt(7, 3);
			ps.setInt(8, r.getReimb_type_id());
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
