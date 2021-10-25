DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS employee;


CREATE TABLE IF NOT EXISTS client(
	accountNumber SERIAL PRIMARY KEY,
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	balance NUMERIC,
	approval boolean
);

CREATE TABLE IF NOT EXISTS employee(
	employe_id SERIAL PRIMARY KEY,
	balance numeric,
	clients varchar(100),
	approval boolean
);




