# **SkillShare Hub**

![License](https://img.shields.io/badge/License-MIT-blue.svg)
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-Backend-brightgreen)
![React](https://img.shields.io/badge/React-Frontend-blue)
![MySQL](https://img.shields.io/badge/MySQL-Database-lightgrey)

SkillShare Hub is a **full-stack skill-sharing platform** that connects learners and teachers in one place.  
It allows users to create accounts, build profiles, share skills they can teach, and explore skills offered by others through a modern web application built with **Spring Boot**, **React**, and **MySQL**.

---

## **Table of Contents**
- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Back End Setup](#back-end-setup)
  - [Front End Setup](#front-end-setup)
  - [Database Setup](#database-setup)
- [API Documentation](#api-documentation)
- [Future Improvements](#future-improvements)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

---

## **Overview**

SkillShare Hub was built to simulate a real-world platform where users can both **teach** and **learn** skills.  
The application demonstrates full-stack development principles such as **REST API design**, **layered backend architecture**, **frontend-backend integration**, and **relational database management**.

This project highlights practical experience in:
- building a Spring Boot REST API
- creating a responsive React frontend
- integrating MySQL for persistent data storage
- organizing backend logic using controller, service, repository, and domain layers

---

## **Features**

- **User Authentication**: Register and log in to access the platform securely.
- **User Profiles**: Create and manage personal user profiles.
- **Skill Sharing System**: Users can post and share skills they want to teach.
- **Skill Discovery**: Browse and explore skills shared by other users.
- **Responsive UI**: Frontend designed to work across different screen sizes.
- **Full-Stack Integration**: React frontend communicates with Spring Boot REST APIs.
- **Database Persistence**: User and skill data stored in MySQL.

---

## **Technologies Used**

### **Back End**
- **Java**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Hibernate**

### **Front End**
- **React**
- **JavaScript**
- **HTML5**
- **CSS3**

### **Database**
- **MySQL**

### **Tools**
- **Git & GitHub**
- **Postman**
- **MySQL Workbench**
- **Maven**

---

## **Architecture**

SkillShare Hub follows a **layered architecture** to keep the application modular and maintainable.

- **Controller Layer**: Handles HTTP requests and exposes REST endpoints.
- **Service Layer**: Contains the business logic of the application.
- **Repository Layer**: Manages database operations using JPA repositories.
- **Domain Layer**: Defines entities and core data models.
- **Frontend Layer**: React-based client that consumes backend APIs.

This separation of concerns makes the project easier to test, scale, and maintain.

---

## **Project Structure**

### **Back End**
```bash
src/main/java/com/skillsharehub
├── controller
├── service
├── repository
├── domain
└── config
Front End
src/
├── components
├── pages
├── services
├── hooks
└── styles
Getting Started

Follow these steps to run SkillShare Hub on your local machine.

Prerequisites

Make sure you have the following installed:

Java 17+

Node.js

npm

MySQL

Maven

Back End Setup

Clone the repository:

git clone https://github.com/your-username/skillshare-hub.git
cd skillshare-hub/backend

Configure your database connection in application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/skillsharehub
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

Run the Spring Boot application:

./mvnw spring-boot:run

The backend will start on:

http://localhost:8080
Front End Setup

Navigate to the frontend directory:

cd ../frontend

Install dependencies:

npm install

Start the React development server:

npm start

The frontend will start on:

http://localhost:3000
Database Setup

Open MySQL Workbench or your MySQL client.

Create a database named:

CREATE DATABASE skillsharehub;

Make sure your backend application.properties file matches your local MySQL credentials.

API Documentation

The backend exposes RESTful APIs for authentication, profile management, and skill-sharing functionality.

Authentication API

POST /api/auth/register → Register a new user

POST /api/auth/login → Authenticate a user

User API

GET /api/users/{id} → Get a user profile

PUT /api/users/{id} → Update a user profile

Skill API

GET /api/skills → Retrieve all skills

POST /api/skills → Create a new skill listing

PUT /api/skills/{id} → Update a skill listing

DELETE /api/skills/{id} → Delete a skill listing

Future Improvements

Add messaging between learners and teachers

Add skill categories and filtering

Add ratings and reviews

Add scheduling or booking functionality

Improve authentication with JWT and role-based access control

Deploy the platform using Docker and AWS

Contributing

Contributions are welcome. To contribute:

Fork the repository

Create a feature branch:

git checkout -b feature/your-feature-name

Commit your changes:

git commit -m "Add your feature"

Push to your branch:

git push origin feature/your-feature-name

Open a pull request

License

This project is licensed under the MIT License.

Contact

For questions or collaboration, feel free to reach out:

Email: walazer2112@gmail.com

GitHub: Aleazar-Wolde

LinkedIn: Aleazar Wolde
