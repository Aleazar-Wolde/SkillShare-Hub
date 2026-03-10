SkillShare Hub

SkillShare Hub is a full-stack web platform that enables users to share and learn skills through community interaction. The application allows users to create profiles, publish skills they can teach, and discover learning opportunities from others.

The goal of this project is to demonstrate the design and implementation of a modern full-stack web application using Java Spring Boot and React, including REST API development, database integration, and client-server communication.

Key Features
User Authentication and Profiles

Users can register, log in, and manage personal profiles. Authentication ensures that each user has a secure account and personalized experience within the platform.

Skill Sharing System

Users can publish skills they want to teach or share. Other users can browse available skills and connect with individuals offering learning opportunities.

Interactive User Interface

The frontend provides a responsive interface that allows users to navigate the platform, explore available skills, and manage their accounts efficiently.

Full-Stack Architecture

The platform uses a RESTful API architecture, separating the frontend and backend for scalability and maintainability.

Technology Stack
Backend

Java

Spring Boot

Spring MVC

JPA / Hibernate

REST API development

Frontend

React

JavaScript

HTML5

CSS3

Database

MySQL

Tools

Git & GitHub for version control

Postman for API testing

MySQL Workbench for database management

System Architecture

The backend follows a layered architecture to ensure clear separation of responsibilities.

Controller Layer
Handles incoming HTTP requests and exposes REST endpoints.

Service Layer
Contains the business logic responsible for processing user actions and skill management.

Repository Layer
Handles database communication using JPA repositories.

Database Layer
Stores users, skills, and related application data.

The React frontend communicates with the backend through REST APIs.

Project Structure

Backend

src/main/java/com/skillsharehub
 ├── controller
 ├── service
 ├── repository
 ├── domain
 └── config

Frontend

src/
 ├── components
 ├── pages
 ├── services
 ├── hooks
 └── styles
Getting Started
Prerequisites

Java 17+

Node.js

npm

MySQL

Installation
1. Clone the repository
git clone https://github.com/yourusername/skillshare-hub.git
2. Backend Setup

Navigate to the backend directory and run the Spring Boot application.

cd backend
./mvnw spring-boot:run
3. Frontend Setup

Navigate to the frontend directory and install dependencies.

cd frontend
npm install
npm start
4. Configure Database

Update the application.properties file with your MySQL credentials.

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/skillsharehub
spring.datasource.username=root
spring.datasource.password=yourpassword
API Overview

Example REST endpoints:

POST   /api/auth/register
POST   /api/auth/login
GET    /api/skills
POST   /api/skills
GET    /api/users/{id}

These endpoints allow the frontend to authenticate users, retrieve skill listings, and manage user profiles.

Future Improvements

Skill booking system

Messaging between learners and instructors

Ratings and reviews for skills

Notification system

Deployment using AWS
