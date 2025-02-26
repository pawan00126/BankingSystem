Banking System (Console-Based + MySQL with JDBC)

Overview

The Banking System is a console-based Java application that allows users to perform basic banking operations such as creating an account, depositing and withdrawing money, checking balances, and deleting accounts. The project utilizes MySQL and JDBC to store account details securely.

Features

Create a new bank account

Deposit money into an account

Withdraw money from an account (with validation to prevent overdrafts)

Check account balance

Delete an account

Loops until a valid input is entered instead of exiting on errors

Technologies Used

Java (JDK 21)

MySQL (Database for account storage)

JDBC (Java Database Connectivity for database operations)

Console-Based UI

Database Schema

The system uses a single table accounts in MySQL:

CREATE TABLE accounts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    balance DOUBLE NOT NULL
);

Setup and Installation

Prerequisites

Install Java JDK 21

Install MySQL Server and create a database (e.g., BankDB)

Configure JDBC Driver in your project

Steps

Clone this repository:

git clone https://github.com/pawan00126/BankingSystem

Import the project into your preferred Java IDE (IntelliJ IDEA, Eclipse, etc.)

Update DatabaseConnection.java with your MySQL credentials:

String url = "jdbc:mysql://localhost:3306/BankDB";
String user = "root";
String password = "your_password";



How to Use

Run the application

Choose an option from the menu (Create Account, Deposit, Withdraw, Check Balance, Delete Account)

Follow the instructions to perform banking operations

Future Enhancements

Implement transaction history tracking

Add user authentication for security


Author

Pawan Bhati

