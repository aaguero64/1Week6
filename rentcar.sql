CREATE database IF NOT EXISTS rentcar;

use rentcar;

DROP TABLE IF EXISTS timerent;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS rentcars;

CREATE TABLE rentcars (
id int(10) NOT NULL auto_increment,
car_make varchar(50) NOT NULL,
car_model varchar(50) NOT NULL,
car_year int(4) NOT NULL,
car_miles int(10) NOT NULL,
PRIMARY KEY (id)
);

CREATE TABLE customers(
id int(10) NOT NULL auto_increment,
rentcar_id int(10) NOT NULL,
first_name varchar (50) NOT NULL,
last_name varchar (50) NOT NULL,
address varchar (50) NOT NULL,
city varchar(20),
state varchar (2),
zip int (5),
phone_number int (12),
PRIMARY KEY (id),
FOREIGN KEY (rentcar_id) REFERENCES rentcars(id) 
);

CREATE TABLE timerent(
id int(10) NOT NULL auto_increment,
rentcar_id int(10) NOT NULL,
customer_id int (10) NOT NULL,
start_date date NOT NULL,
end_date date,
miles_qty int (10),
PRIMARY KEY (id),
FOREIGN KEY (rentcar_id) REFERENCES rentcars(id),
FOREIGN KEY (customer_id) REFERENCES customers(id)
);
