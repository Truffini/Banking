DROP TABLE IF EXISTS client Cascade;
DROP TABLE IF EXISTS employee cascade;
drop table if exists accounts cascade;
drop table if exists client_employee cascade;
drop table if exists balance cascade;
drop table if exists transactions cascade;

CREATE TABLE IF NOT EXISTS client(
	accountnumber SERIAL PRIMARY key,
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	approval boolean
);

CREATE TABLE IF NOT EXISTS accounts(
	id serial primary key,                                                                                                                                                      
	checkingAccount varchar(100),
	savingAccount varchar(100),
	client_id integer,
	checking_balance_id integer,
	saving_balance_id integer
);

alter table accounts 
add constraint accounts_client_fkey
foreign key  (client_id)
references client(accountnumber);


create table if not exists balance(
	id serial primary key,
	balance money,
	account_id integer --references accounts(id)
);


alter table accounts
add constraint checking_balance_accounts_fkey
foreign key (checking_balance_id)
references balance(id);

alter table accounts
add constraint saving_balance_accounts_fkey
foreign key (saving_balance_id)
references balance(id);

CREATE TABLE IF NOT exists employee(
	id SERIAL PRIMARY key,
	client integer,
	approval boolean
);


create table if not exists client_employee(
	client_id integer references client(accountNumber),
	employee_id integer references employee(id),
	primary key (client_id, employee_id)
);

create table if not exists transactions(
	id serial primary key,
	deposit money,
	withdraw money,
	approval boolean,
	client_id integer
);

alter table transactions 
add constraint client_transaction_fkey
foreign key (client_id)
references client(accountnumber);


select * from client;
select * from employee;
select * from accounts;
select * from client_employee;
select * from balance;
select * from transactions;

truncate client,employee,accounts,client_employee cascade;
