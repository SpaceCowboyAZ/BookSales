create database if not exists book_central;

use book_central;

drop table if exists review;
drop table if exists create_order;
drop table if exists order_details;
drop table if exists books;
drop table if exists author;
drop table if exists customer;

CREATE TABLE author(
author_id INT NOT NULL AUTO_INCREMENT,
first_name_id VARCHAR(50)  NOT NULL,
last_name_id VARCHAR(50),
PRIMARY KEY (author_id)

);
CREATE TABLE customer (
	customer_id INT NOT NULL AUTO_INCREMENT,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    address varchar(100) NOT NULL,
    phone_number int NOT NULL,
    PRIMARY KEY(customer_id)
);
CREATE TABLE books(
books_id INT NOT NULL AUTO_INCREMENT,
author_id INT NOT NULL,
title_id VARCHAR(50) NOT NULL,
isbn_id INT(50) NOT NULL,
PRIMARY KEY(books_id),
FOREIGN KEY (author_id) REFERENCES author(author_id)
);

CREATE TABLE order_details(
order_id INT NOT NULL AUTO_INCREMENT,
customer_id INT NOT NULL,
order_date INT NOT NULL,
ship_date INT NOT NULL,
PRIMARY KEY(order_id),
FOREIGN KEY (customer_id) REFERENCES customer(customer_id)

);
CREATE TABLE create_order(
create_order_id INT NOT NULL AUTO_INCREMENT,
order_id INT NOT NULL,
books_id INT  NOT NULL,
PRIMARY KEY(create_order_id,order_id,books_id),
FOREIGN KEY (order_id) REFERENCES order_details(order_id),
FOREIGN KEY (books_id) REFERENCES books(books_id)

);
CREATE TABLE review(
review_id INT NOT NULL AUTO_INCREMENT,
customer_id int NOT NULL,
order_book_id INT NOT NULL,
books_id INT NOT NULL,
PRIMARY KEY (review_id),
FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
FOREIGN KEY (books_id) REFERENCES books(books_id)
);