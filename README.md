🎓 SkillShare Hub

A full-stack skill-sharing platform that connects people who want to teach skills with those who want to learn them.

The platform enables users to create accounts, publish skills they can teach, discover skills offered by others, and interact through a modern web interface.
This project demonstrates the design and implementation of a scalable full-stack application using Java Spring Boot and React, with a focus on RESTful APIs, layered architecture, and database integration.

🚀 Project Overview

SkillShare Hub was built to simulate a real-world learning marketplace where individuals can exchange knowledge and develop new skills through community interaction.

The application follows a client–server architecture, where a React frontend communicates with a Spring Boot backend via REST APIs, and all application data is stored in a MySQL relational database.

The system focuses on:

clean backend architecture

modular service design

secure user authentication

scalable API development

✨ Core Features
👤 User Authentication & Profiles

Users can register, log in, and manage personal profiles within the platform. Authentication ensures that users have secure access to their accounts and personalized content.

📚 Skill Sharing System

Users can publish skills they are willing to teach, allowing others to discover and learn from them. Skills can be browsed and explored across the platform.

🔎 Skill Discovery

The platform allows learners to explore available skills and find instructors offering knowledge in different categories.

📱 Responsive User Interface

The React frontend provides a clean and responsive interface that allows users to easily navigate through the platform and interact with features.

🛠️ Tech Stack
Backend

Java

Spring Boot

Spring MVC

JPA / Hibernate

RESTful API architecture

Frontend

React

JavaScript

HTML5

CSS3

Database

MySQL

Tools & Development

Git & GitHub

Postman (API testing)

MySQL Workbench

🏗️ System Architecture

The backend is structured using a layered architecture to ensure separation of concerns and maintainable code.

Controller Layer
Handles HTTP requests and exposes REST endpoints.

Service Layer
Contains business logic and application rules.

Repository Layer
Manages database interaction using JPA repositories.

Domain Layer
Defines core entities and data models.

The React frontend communicates with the backend through REST APIs, allowing the application to remain modular and scalable.

📁 Project Structure
Backend
src/main/java/com/skillsharehub
│
├── controller
├── service
├── repository
├── domain
└── config
Frontend
src/
│
├── components
├── pages
├── services
├── hooks
└── styles
⚙️ Getting Started
Prerequisites

Make sure the following tools are installed:

Java 17+

Node.js

npm

MySQL

1️⃣ Clone the Repository
git clone https://github.com/yourusername/skillshare-hub.git
cd skillshare-hub
2️⃣ Backend Setup

Run the Spring Boot application:

cd backend
./mvnw spring-boot:run
3️⃣ Frontend Setup

Install dependencies and start the React application:

cd frontend
npm install
npm start
4️⃣ Configure Database

Update the application.properties file with your MySQL credentials.

Example:

spring.datasource.url=jdbc:mysql://localhost:3306/skillsharehub
spring.datasource.username=root
spring.datasource.password=yourpassword
🔗 Example API Endpoints
POST   /api/auth/register
POST   /api/auth/login
GET    /api/skills
POST   /api/skills
GET    /api/users/{id}

These endpoints allow the frontend to authenticate users, retrieve skill listings, and manage user profiles.

🚧 Future Improvements

Skill booking and scheduling system

Messaging between learners and instructors

Skill ratings and reviews

Notification system

Cloud deployment (AWS / Docker)
