async function generateReimbursementList(){
	
/*	
	const reimbursement = {
		reimb_id,
		reimb_amount,
		reimb_submitted,
		reimb_resolved,
		reimb_description,
		reimb_receipt,
		reimb_author,
		reimb_resolver,
		reimb_status_id,
		reimb_type_id
	}
	*/
	
	let res = await fetch("http://localhost:8080/project1ERS/reimbursementList",{ 
				method: "POST",
				headers:{
					"Content-Type": "application/json"
				}
	});
	
	let data = await res.json();
	alert(data.reimb_amount)
}
