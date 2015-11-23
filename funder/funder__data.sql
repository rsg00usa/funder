/* Create the tables needed to support the funder application
 * 
 * To run sql cmd from commandline:
 * %psql -c "select * from investment"
 * 
 * To run sql file from commandline:
 * %psql -f funder_data.sql
 */

DROP TABLE history;
	
CREATE TABLE history (
pkey serial PRIMARY KEY,
symbol VARCHAR(6) NOT NULL,
price MONEY NOT NULL,
shares INTEGER NOT NULL CHECK (shares > 0),
transaction VARCHAR(4) NOT NULL, 
commission MONEY,
"Transaction Date" DATE NOT NULL
);

INSERT INTO history (symbol, price, shares, transaction, commission, "Transaction Date") 
	VALUES('CRM', 77.04, 2000, 'buy', 20.00, '2012-04-14');
INSERT INTO history (symbol, price, shares, transaction, commission, "Transaction Date") 
	VALUES('GOOG', 545.86, 100, 'buy', 20.00, '2012-04-23');
INSERT INTO history (symbol, price, shares, transaction, commission, "Transaction Date") 
	VALUES('CRM', 45.86, 200, 'sell', 20.00, '2012-04-24');

DROP TABLE portfolio;

CREATE TABLE portfolio (
pkey serial PRIMARY KEY,
symbol VARCHAR(6) NOT NULL,
value NUMERIC(8,2) NOT NULL,
shares INTEGER NOT NULL CHECK (shares > 0),
"Last Updated" DATE NOT NULL
);

INSERT INTO portfolio (symbol, value, shares, "Last Updated") 
	VALUES('CRM', 7007.04, 2000, '2012-04-14');
INSERT INTO portfolio (symbol, value, shares, "Last Updated") 
	VALUES('GOOG', 5450.86, 100, '2012-04-23');
