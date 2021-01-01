async function generateReimbursementList(){

	
	let res = await fetch("http://localhost:8080/project1ERS/reimbursementList",{ 
				method: "POST",
				headers:{
					"Content-Type": "application/json"
				}
	});
	
	const data = await res.json();
	const currentDiv = document.getElementById("accordion");
	
	
	
	for(key in data){
		
		let card = document.createElement("div")
		let card_class = document.createAttribute("class")
		card_class.value = "card"
		card.setAttributeNode(card_class);
		
		
		//Card header
		let card_header = document.createElement("div")
		
		let card_header_attr_1 = document.createAttribute("class")
		card_header_attr_1.value = "card-header"
		
		
		card_header.setAttributeNode(card_header_attr_1)
		
		card.appendChild(card_header)
		
		//heading
		let heading = document.createElement("h5")
		let heading_attr = document.createAttribute("class")
		heading_attr.value = "mb-0"
		heading.setAttributeNode(heading_attr)
		
		//append heading to card header
		card_header.appendChild(heading)
		
		let button = document.createElement("button")
		let button_attr_1 = document.createAttribute("class")
		button_attr_1.value = "btn btn-link"
		let button_attr_3 = document.createAttribute("data-toggle")
		button_attr_3.value = "collapse" 
		let button_attr_4 = document.createAttribute("data-target")
		button_attr_4.value = "#target-" + data[key].reimb_id
		let button_attr_5 = document.createAttribute("aria-expanded")
		button_attr_5.value = "false"
		
		button.setAttributeNode(button_attr_1)
		button.setAttributeNode(button_attr_3)
		button.setAttributeNode(button_attr_4)
		button.setAttributeNode(button_attr_5)
		button.innerHTML = "Reimbursement reference number " + data[key].reimb_id
		heading.appendChild(button)
		
		/////////data/////////
		let data_div = document.createElement("div")
		let data_attr_1 = document.createAttribute("id")
		data_attr_1.value = "target-" + data[key].reimb_id
		
		let data_attr_2 = document.createAttribute("class")
		data_attr_2.value = "collapse"
		
		let data_attr_3 = document.createAttribute("data-parent")
		data_attr_3.value = "#accordion"
		
		data_div.setAttributeNode(data_attr_1)
		data_div.setAttributeNode(data_attr_2)
		data_div.setAttributeNode(data_attr_3)
		
		let data_body = document.createElement("div")
		let data_body_attr = document.createAttribute("class")
		data_body_attr.value = "card-body"
		
		data_body.setAttributeNode(data_body_attr)
		data_body.innerHTML = "Reimbursement amount: " + data[key].reimb_amount + 
							  "<br/>Reimbursement type: " + data[key].reimb_type_description;
		if(data[key].reimb_status_description === 'PENDING'){
			data_body.innerHTML +="<br/>Application status: <span style=\"color: orange;\">" + data[key].reimb_status_description + "</span>"
							 
		}else if(data[key].reimb_status_description === 'APPROVED')
			data_body.innerHTML +="<br/>Application status: <span style=\"color: green;\">" + data[key].reimb_status_description + "</span>"
		else{
			data_body.innerHTML +="<br/>Application status: <span style=\"color: red;\">" + data[key].reimb_status_description + "</span>"
		}
		
		data_body.innerHTML += "<br/>Date submitted: " + data[key].reimb_submitted + 
							  "<br/>Description: " + data[key].reimb_description;
		
		data_div.appendChild(data_body)
		card.appendChild(data_div)				
		
		//append the card to the main div
		currentDiv.appendChild(card)
		
		
	}
	
}

document.onload = generateReimbursementList()
