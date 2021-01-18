# Employee Reimbursement System 

### Project Description
- The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

### Technologies used
- Java
- JavaScript
- CSS / Bootstrap
- HTML
- Postgres with JDBC

### Features
- Employess and Finance managers can login to their pages
- Employees can submit a reimbursement request with a given amount, type of reimbursement and a short description
- Employees can view their past requests 
- Finance managers can view pending/approved/denied requests 
- Finance managers can accept or deny a reimburesement request 
#### To-do list
- Add additional styling to make the webpage responsive 
- Add a feature on employees where they can filter their requests 

### Getting Started
- ##### Windows/Mac git clone command:
`git clone 2011Canada/project-1-mhamza0096.git`
- ##### Java version 8:
https://www.oracle.com/ca-en/java/technologies/javase-downloads.html 
- ##### DBeaver for DDL
https://dbeaver.io/download/
- ##### RDS setup on AWS
https://aws.amazon.com/

#### Steps
- Open Dbeaver and connect to the RDS created on AWS
- Run the database script to create the database and tables
- Start the application on tomcat server
- Navigate to http://localhost:8080/project1ers/login.html
- login as an employee or a finance manager
### Usage
- Employee can login
- Employee can view pending all requests 
- Employee can create a new request with a given amount, type of reimbursement and a short description
- Employee can logout
- Finance manager can login
- Finance manager can view all pending/approved/denied requests 
- Finance manager can approve or deny a reimbursement request
- Finance manager can logout
