CREATE TABLE USERS(user_name varchar(20) primary key, first_name varchar(50), last_name varchar(50), description varchar(255), created_at timestamp default now(), updated_at timestamp default now());
INSERT INTO USERS(user_name, first_name, last_name, description) VALUES('foo', 'foo first', 'foo second', 'foo description');
INSERT INTO USERS(user_name, first_name, last_name, description) VALUES('bar', 'bar first',  'bar second', 'bar desc');
INSERT INTO USERS(user_name, first_name, last_name, description) VALUES('joe', 'joe first','joe second','joe desc');
INSERT INTO USERS(user_name, first_name, last_name, description) VALUES('mike', 'mike first', 'mike second', 'mike desc');
INSERT INTO USERS(user_name, first_name, last_name, description) VALUES('tom', 'tom first','tom second', 'tom desc' );
