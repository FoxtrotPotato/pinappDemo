CREATE SCHEMA IF NOT EXISTS pinappdemo;
USE pinappdemo;

DROP TABLE clients;

CREATE TABLE clients (
    client_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    birthday DATE
);

INSERT INTO clients (first_name, last_name, age, birthday) VALUES
('Lucas', 'Martinez', 34, '1990-05-12'),
('Sofia', 'Gomez', 27, '1996-02-21'),
('Mateo', 'Perez', 45, '1979-11-03'),
('Valentina', 'Rodriguez', 22, '2002-08-14'),
('Joaquin', 'Fernandez', 31, '1992-07-25');

commit;