

insert into client (accountnumber, first_name, last_name,client_username,client_password, approval)
values (1, 'bob', 'smith', 'bobuser', 'password',True),
			(12, 'parry', 'plat', 'platy11', 'ball', False),
			(123, 'will', 'smith', 'will22', 'bat', true),
			(1234, 'greg', 'mando', 'greg33', 'base', true),
			(12345, 'sally', 'baker', 'sally44', 'dilly', true);
		
		
insert into accounts (id,checkingaccount, savingaccount,client_id,checking_balance, saving_balance)
values(1,'checking account', 'savings account',1,30,15),
		(2,'checking account', 'savings account',12,10,300 ),
		(3,'checking account', 'saving account', 123,1,100),
		(4,'checking account', 'savings account', 1234,40,400),
		(5,'checking account', 'savings account', 12345, 500, 1000);
	
	
insert into employee(id, first_name,last_name,employee_username, employee_password)
values (1,'stan', 'sullivan', 'stansull','wolf'),
		(2,'fred', 'mercer', 'fred4','lion'),
		(3,'mary', 'rennie', 'mary2','bear'),
		(4,'bill', 'dillon', 'billed','pass');
	

select * from client;
select * from employee;
select * from accounts;
select * from transactions;
