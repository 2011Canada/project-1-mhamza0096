package com.revature.models;

public class Status{
	
	private String status;
	private int reimb_id;
	
	public int getReimb_id(){
		return this.reimb_id;
	}
	public String getStatus(){
		return this.status;
	}
	public void setReimb_id(int id) {
		this.reimb_id = id;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
