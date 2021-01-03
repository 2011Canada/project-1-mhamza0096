drop table ers_user_roles 

create table ers_user_roles(
	ers_user_role_id serial primary key,
	user_role text
)



drop table ers_users

create table ers_users(
	ers_users_id serial primary key,
	ers_username text,
	ers_password text,
	user_first_name text,
	user_last_name text,
	user_email text,
	ers_user_role_id int references ers_user_roles ("ers_user_role_id")
)


create table ers_reimbursement_type(
	reimb_type_id serial primary key,
	reimb_type text
)

create table ers_reimbursement_status(
	reimb_status_id serial primary key,
	reimb_status text
)

drop table ers_reimbursement

create table ers_reimbursement(
	reimb_id serial primary key,
	reimb_amount bigint,
	reimb_submitted text,
	reimb_resolved text,
	reimb_description text,
	reimb_receipt bytea,
	reimb_author int references ers_users ("ers_users_id"),
	reimb_resolver text,
	reimb_status_id int references ers_reimbursement_status ("reimb_status_id"),
	reimb_type_id int references ers_reimbursement_type ("reimb_type_id")
)

insert into ers_reimbursement_type (reimb_type)
	values ('OFFICE_SUPPLIES')
	
insert into ers_reimbursement_status (reimb_status)
	values ('PENDING')

INSERT INTO ers_user_roles (user_role)
	VALUES ('EMPLOYEE');
	
select * from ers_reimbursement_type

select * from ers_reimbursement_status

insert into ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, ers_user_role_id)
	values ('charlie', 'password', 'Charlie', 'Horn', 'john.doe@revature.net', 2)
	
insert into ers_reimbursement (reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
	values (50, '01-05-2020', '', 'Please approve this ammount for Office supplies', null, 2, 0, 2, 1)
	
select * from ers_reimbursement natural join ers_reimbursement_status natural join ers_reimbursement_type where reimb_author = 2

select * from ers_reimbursement r natural join ers_users u natural join ers_reimbursement_type natural join ers_reimbursement_status where reimb_status = 'PENDING' and ers_user_role_id = 2 and u.ers_users_id = r.reimb_author 

select * from ers_reimbursement

update ers_reimbursement set reimb_status_id = 3, reimb_resolved = '01=25-2021', reimb_author = 1 where reimb_id = 14