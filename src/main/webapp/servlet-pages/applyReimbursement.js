async function applyReimbursement(e){
	e.preventDefault();
	
	let amount = document.getElementById("amount").value;
	let description = document.getElementById("description").value;
	let type = document.getElementById("type").value;
	
	alert(type)
	
	const data = {
		amount,
		description,
		type
	};
	
	let res = await fetch("http://localhost:8080/project1ERS/apply",{ 
				method: "POST",
				body: JSON.stringify(data),
				headers:{
					"Content-Type": "application/json"
				}
	});
				
	//let data = await res.json();
	//alert(data.password);
	window.location.href = "http://localhost:8080/project1ERS/servlet-pages/welcomeEmployee.html";
}





document.getElementsByTagName("form")[0].addEventListener('submit', applyReimbursement);