

async function financeManager(){
	
	
	let res = await fetch("http://localhost:8080/project1ERS/financeManager",{ 
				method: "POST",
				headers:{
					"Content-Type": "application/json"
				}
	});
	
	let data = await res.json()
	
	
	
}



document.onload = financeManager()