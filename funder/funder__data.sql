DROP TABLE investment;

CREATE TABLE investment (
investment_pkey serial PRIMARY KEY,
symbol VARCHAR(6),
price MONEY NOT NULL,
number_of_shares INTEGER NOT NULL CHECK (number_of_shares > 0),
buy BOOLEAN NOT NULL, 
commission MONEY,
transaction_date DATE NOT NULL
);

INSERT INTO investment (symbol, price, number_of_shares, buy, commission, transaction_date) 
	VALUES('CRM', 77.04, 2000, true, 20.00, '2012-04-14');
INSERT INTO investment (symbol, price, number_of_shares, buy, commission, transaction_date) 
	VALUES('GOOG', 545.86, 100, true, 20.00, '2012-04-23');
INSERT INTO investment (symbol, price, number_of_shares, buy, commission, transaction_date) 
	VALUES('CRM', 79.23, 1000, false, 10.00, '2012-06-02');	
	
-- psql -c "select * from investment"