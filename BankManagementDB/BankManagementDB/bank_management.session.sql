CREATE DATABASE bank_management

CREATE TABLE account (
    account_number INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL DEFAULT 'Unknown',
    email VARCHAR(50) NOT NULL,
    cnic VARCHAR(15) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    is_active BOOLEAN NOT NULL,
    balance DECIMAL(10, 2) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    marital_status VARCHAR(20) NOT NULL,
    password VARCHAR(50) NOT NULL
);