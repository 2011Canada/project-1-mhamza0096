package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class FinanceManagerReimbursementDAO {

	ConnectionFactory cf = ConnectionFactory.getConnectionFactory();
	
	public List<Reimbursement> getReimbursementList(String status) {
		
		List<Reimbursement> reimbList = new ArrayList<Reimbursement>();
		
		Connection conn = cf.getConnection();
		String sql = "select * from ers_reimbursement r natural join ers_users u natural join ers_reimbursement_type natural join ers_reimbursement_status where reimb_status = ? and ers_user_role_id = 2 and u.ers_users_id = r.reimb_author";
		
		try {
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, status);
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
				reimb.setReimb_resolver(res.getString("reimb_resolver"));
				reimb.setReimb_status_id(res.getInt("reimb_status_id"));
				reimb.setReimb_type_id(res.getInt("reimb_type_id"));
				reimb.setReimb_status_description(res.getString("reimb_status"));
				reimb.setReimb_type_description(res.getString("reimb_type"));
				reimb.setReimb_author_name(res.getString("user_first_name") + " " + res.getString("user_last_name"));
				reimbList.add(reimb);
			}
			
		return reimbList;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

	public void updateStatus(String status, int reimb_id, User u) {
		
		Connection conn = cf.getConnection();
		LocalDate lc = LocalDate.now();
		
		String sql = "update ers_reimbursement set reimb_status_id = ?, reimb_resolved = ?, reimb_resolver = ? where reimb_id = ?";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			if(status.equals("APPROVED")) {
				ps.setInt(1, 1);
			}
			else {
				ps.setInt(1, 2);
			}
			ps.setString(2, lc.toString());
			ps.setString(3, u.getFirstName() + " " + u.getLastName());
			ps.setInt(4, reimb_id);
			
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
