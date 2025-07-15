# Educational-Management-System.
A Java + MySQL project to manage students and courses.
# 🎓 Educational Management System

A Java + MySQL based console app to manage Students and Courses.

## 📂 Features
- Add & View Students
- Add & View Courses

## 🛠️ Tech Stack
- Java
- MySQL
- JDBC

## 🗃️ MySQL Setup
```sql


CREATE DATABASE edudb;
USE edudb;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE courses (
    id INT PRIMARY KEY,
    title VARCHAR(100)
);
