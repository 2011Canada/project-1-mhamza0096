async function loginSubmit(e){
	e.preventDefault();
	
	let username = document.getElementById("user_login").value;
	let password = document.getElementById("user_password").value;
	
	const credentials = {
		username,
		password
	};
	
	let res = await fetch("http://localhost:8080/project1ERS/login",{ 
				method: "POST",
				body: JSON.stringify(credentials),
				headers:{
					"Content-Type": "application/json"
				}
	});
				
	let data = await res.json();
	//alert(data.password);
	if(data.role_id === 1){
		window.location.href = "http://localhost:8080/project1ERS/servlet-pages/welcomeFinanceManager.html";
	} else{
		window.location.href = "http://localhost:8080/project1ERS/servlet-pages/welcomeEmployee.html";
	}
	
	
}





document.getElementsByTagName("form")[0].addEventListener('submit', loginSubmit);