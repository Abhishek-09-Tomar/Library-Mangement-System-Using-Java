-- Create database
CREATE DATABASE IF NOT EXISTS librarymanagement;
select *from librarymanagement;
USE librarymanagement;

-- Books table
CREATE TABLE IF NOT EXISTS books(
    book_id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255),
    genre VARCHAR(100),
    publication_year YEAR,
    isbn VARCHAR(20) UNIQUE
);

-- Fines table
CREATE TABLE IF NOT EXISTS fines(
    fine_id INT PRIMARY KEY AUTO_INCREMENT,
    member_id INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    issued_date DATE NOT NULL,
    FOREIGN KEY (member_id) REFERENCES members(member_id)
);

-- Members table
CREATE TABLE IF NOT EXISTS members (
    member_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100),
    email VARCHAR(255) UNIQUE,
    join_date DATE NOT NULL
);

-- Reservations table
CREATE TABLE IF NOT EXISTS reservations (
    reservation_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT NOT NULL,
    member_id INT NOT NULL,
    reservation_date DATE NOT NULL,
    FOREIGN KEY (book_id) REFERENCES books(book_id),
    FOREIGN KEY (member_id) REFERENCES members(member_id)
);

-- Transition table
CREATE TABLE IF NOT EXISTS transition (
    transition_id INT PRIMARY KEY AUTO_INCREMENT,
    book_id INT NOT NULL,
    member_id INT NOT NULL,
    issue_date DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (book_id) REFERENCES books(book_id),
    FOREIGN KEY (member_id) REFERENCES members(member_id)
);


