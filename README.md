# 💇 Salon Booking System (Spring Boot)

A full-featured backend API for managing a salon business. Built with Spring Boot, secured with JWT authentication, and deployed using Docker.

---

## 🚀 Features

- 🔐 User Authentication (JWT + Role-based)
  - Roles: ADMIN, STAFF, CLIENT
- 💇 Service Management
- 📅 Appointment Booking & Cancellation
- 📆 Staff Availability Scheduling
- ⭐ Client Ratings & Reviews
- 💰 Payment Tracking
- 🐳 Dockerized for deployment
- 📡 REST API with clean architecture

---

## 🛠 Tech Stack

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA (Hibernate)
- MySQL
- Lombok
- JWT (jjwt)
- Docker

---

## 🧠 Roles

| Role   | Access                                 |
|--------|----------------------------------------|
| ADMIN  | Full access (all features)             |
| STAFF  | Manage availability, view bookings     |
| CLIENT | Book appointments, leave reviews       |

---

## 📦 Run the App Locally

### 🔧 Requirements:
- Java 17
- MySQL
- Maven or `mvnw` wrapper

### ⚙️ Setup

1. Update `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/salon_db
spring.datasource.username=your_mysql_user
spring.datasource.password=your_mysql_password
Create database in MySQL:

sql
Copy code
CREATE DATABASE salon_db;
Build and run:

bash
Copy code
# In root folder
./mvnw clean install
./mvnw spring-boot:run
App runs on:
📍 http://localhost:8080

🐳 Run with Docker
Package the app:

bash
Copy code
./mvnw clean install
Build Docker image:

bash
Copy code
docker build -t salon-app .
Run the container:

bash
Copy code
docker run -p 8080:8080 salon-app
🔐 API Authentication
Use /api/auth/register and /api/auth/login to create/get JWT tokens.

🧪 Example Login Response:
json
Copy code
{
  "token": "eyJhbGciOiJIUzI1NiIsInR...",
  "role": "CLIENT"
}
Then pass the token in headers:

makefile
Copy code
Authorization: Bearer YOUR_TOKEN
📡 Main API Endpoints
🧾 Auth
POST /api/auth/register

POST /api/auth/login

💇 Services
GET /api/services

POST /api/services

📅 Appointments
GET /api/appointments/me

POST /api/appointments

DELETE /api/appointments/{id}

📆 Availability
GET /api/staff/availability/me

POST /api/staff/availability

⭐ Ratings
POST /api/ratings

GET /api/ratings/staff/{staffId}

💰 Payments
POST /api/payments

🙋 Contact
Built with ❤️ by Mulanga Lukhwareni


📄 License
This project is for educational and portfolio use only. Commercial use requires permission.

---

