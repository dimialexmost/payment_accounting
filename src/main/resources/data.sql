DROP TABLE IF EXISTS users;

CREATE TABLE users (
                       id int AUTO_INCREMENT primary key,
                       username varchar(255),
                       password varchar(11),
                       created_at date,
                       created_by varchar(32)
);


INSERT INTO users (username, created_at, created_by, password) VALUES ("Niklas", now(), "CONSOLE", "column");
INSERT INTO users (username, created_at, created_by, password) VALUES ("David", now(), "CONSOLE", "column2");
INSERT INTO users (username, created_at, created_by, password) VALUES ("Fredrik", now(), "CONSOLE", "column3");
INSERT INTO users (username, created_at, created_by, password) VALUES ("Agnetta", now(), "CONSOLE", "column4");