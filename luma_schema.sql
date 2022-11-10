create database loan_application;

use loan_application;

CREATE TABLE loan_card_master(
loan_id int NOT NULL AUTO_INCREMENT,
loan_type VARCHAR(15) NOT NULL,
duration_in_years INT(2) NOT NULL,
PRIMARY KEY(loan_id));

CREATE TABLE employee_master(
employee_id VARCHAR(6) NOT NULL,
employee_name VARCHAR(20) NOT NULL,
designation VARCHAR(25) NOT NULL,
department VARCHAR(25) NOT NULL,
gender CHAR(1) NOT NULL,
date_of_birth DATE,
date_of_joining DATE,
PRIMARY KEY(employee_id));


CREATE TABLE items_master (
item_id int NOT NULL AUTO_INCREMENT,
item_description VARCHAR(25) NOT NULL,
item_status CHAR(1) NOT NULL,
item_make VARCHAR(25) NOT NULL,
item_category VARCHAR(20) NOT NULL,
item_valuation INT(6) NOT NULL,
PRIMARY KEY(item_id));


CREATE TABLE employee_card_details (
employee_id VARCHAR(6) NOT NULL,
loan_id int NOT NULL,
card_issue_date DATE,
FOREIGN KEY(employee_id) REFERENCES employee_master(employee_id),
FOREIGN KEY(loan_id) REFERENCES loan_card_master(loan_id));


CREATE TABLE employee_issue_details(
issue_id int NOT NULL AUTO_INCREMENT,
employee_id VARCHAR(6) NOT NULL,
item_id int NOT NULL,
PRIMARY KEY(issue_id),
FOREIGN KEY(employee_id) REFERENCES employee_master(employee_id),
FOREIGN KEY(item_id) REFERENCES items_master(item_id));

CREATE TABLE employee_login_details(
employee_id VARCHAR(6) NOT NULL UNIQUE,
employee_password VARCHAR(8) NOT NULL,
FOREIGN KEY(employee_id) REFERENCES employee_master(employee_id));
