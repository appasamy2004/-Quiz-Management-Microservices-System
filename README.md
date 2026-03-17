Quiz Management Microservices System
📌 Project Overview
The Quiz Management Microservices System is a backend application built using Java Spring Boot and Microservices Architecture.
This system allows users to manage quiz questions and generate quizzes using separate microservices.
The project demonstrates how a large application can be split into independent services that communicate through REST APIs, improving scalability and maintainability.

🚀 Features
Add new quiz questions
Retrieve questions by category
Create quizzes from question bank
Fetch quiz questions
Microservices communication using REST APIs
Service discovery using Eureka Server
Centralized routing using API Gateway
Scalable and modular architecture

🏗️ Microservices Architecture
This project consists of multiple microservices:
1️⃣ Question Service
Responsible for managing quiz questions.
Functions:
Add questions
Get all questions
Filter questions by category
Provide questions for quiz generation
2️⃣ Quiz Service
Responsible for creating and managing quizzes.
Functions:
Generate quiz from questions
Retrieve quiz questions
Calculate quiz results
3️⃣ Service Registry (Eureka Server)
Registers all microservices and allows them to discover each other dynamically.
4️⃣ API Gateway
Acts as the single entry point for all client requests and routes them to appropriate microservices.
🛠️ Technologies Used
Backend
Java
Spring Boot
Spring Web
Spring Data JPA
Microservices
Spring Cloud
Eureka Server
OpenFeign Client
API Gateway
Database
MySQL
Build Tool
Maven
Tools
IntelliJ IDEA
Postman
Git
GitHub


📂 Project Structure

Quiz-Management-Microservices-System
│
├── question-service
│
├── quiz-service
│
├── service-registry
│
├── api-gateway
│
└── README.md

⚙️ Setup Instructions
1️⃣ Clone the Repository
Copy code
Bash
git clone https://github.com/appasamy2004/-Quiz-Management-Microservices-System.git

2️⃣ Open Project in IDE
Open the project using:
IntelliJ IDEA
Eclipse
VS Code
11
3️⃣ Configure Database
Create a MySQL database:
Copy code

quiz_db
Update database configuration in application.properties:
Copy code

spring.datasource.url=jdbc:mysql://localhost:3306/quiz_db
spring.datasource.username=root
spring.datasource.password=yourpassword

4️⃣ Run Microservices
Start the services in the following order:
Service Registry (Eureka Server)
Question Service
Quiz Service
API Gateway

5️⃣ Access APIs
Example endpoints:
Copy code

GET /question/allQuestions
POST /question/add
GET /quiz/get/{id}
You can test the APIs using Postman.
