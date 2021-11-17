DROP TABLE IF EXISTS client Cascade;
DROP TABLE IF EXISTS employee cascade;
drop table if exists accounts cascade;
drop table if exists client_employee cascade;
drop table if exists balance cascade;
drop table if exists transactions cascade;
drop table if exists client_id cascade;

CREATE TABLE IF NOT EXISTS client(
	accountnumber SERIAL primary key,
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	client_username VARCHAR(100),
	client_password VARCHAR(100),
	approval boolean	
);

CREATE TABLE IF NOT EXISTS accounts(
	id serial primary key,                                                                                                                                                      
	checkingAccount varchar(100),
	savingAccount varchar(100),
	client_id integer,
	checking_balance integer,
	saving_balance integer
);

alter table accounts 
add constraint accounts_client_fkey
foreign key  (client_id)
references client(accountNumber)
on delete CASCADE;

CREATE TABLE IF NOT exists employee(
	id SERIAL PRIMARY key,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	employee_username VARCHAR(100),
	employee_password VARCHAR(100)
);

create table if not exists transactions(
	id serial primary key,
	client_id integer,
	deposit integer,
	withdraw integer
);

alter table transactions 
add constraint client_transaction_fkey
foreign key (client_id)
references client(accountnumber)
on delete cascade;
;
select * from client;
select * from employee;
select * from accounts;
select * from transactions;

truncate client,employee,accounts cascade;