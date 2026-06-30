CREATE DATABASE IF NOT EXISTS gestion_utilisateurs;
USE gestion_utilisateurs;

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL,
  password VARCHAR(150) NOT NULL
);
