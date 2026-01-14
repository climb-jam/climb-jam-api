# ClimbJAM API – Backend

## 📌 Project Overview

**ClimbJAM API** is the backend of the ClimbJAM application, a web and mobile platform dedicated to rock climbing practice tracking and analysis.

The API provides secure access to user data, climbing sessions, ascents, statistics, and climbing sites (crags).

---

## 🧱 Tech Stack

- **Language**: Java 21
- **Framework**: Spring Boot
- **Security**: Spring Security + JWT
- **Database**: MySQL 8
- **ORM**: Spring Data JPA (Hibernate)
- **API Documentation**: Swagger / OpenAPI
- **Build Tool**: Maven

---

## 🔑 Security

- JWT-based authentication
- Role-based authorization (USER / ADMIN)
- Secure endpoints using Spring Security
Authentication flow:
- User login
- JWT token generation
- Token sent via Authorization: Bearer <token> header

---

## 📁 Project Structure

climb-jam-api/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/gretacvld.climb_jam_api
│ │ │ ├── controllers
│ │ │ ├── dtos
│ │ │ ├── entities
│ │ │ ├── enums
│ │ │ ├── exceptions
│ │ │ ├── helpers
│ │ │ ├── mappers
│ │ │ ├── repositories
│ │ │ ├── security
│ │ │ └── services
│ │ └── resources/
│ │ ├── application.properties
│ │ └── data.sql
│ └── test/
├── .envsample
├── pom.xml
└── README.md

---

## ⚙️ Prerequisites

- Java JDK 21
- Maven 3.9+
- MySQL 8+
- (Optional) Docker & Docker Compose

---

## 🔐 Environment Variables

The backend uses `spring-dotenv` to load environment variables from a `.env` file.

### Example `.env` file

```env
jdbc:mysql://localhost:3306/climbjam
DB_USERNAME=climbjam_user
DB_PASSWORD=secret
JWT_SECRET=yourSecretJwtKey
ALLOWED_ORIGINS=http://localhost:5173
```
⚠️ Never commit the .env file to GitHub

---

## 🗄️ Database Setup (MySQL)
```sql
CREATE DATABASE climbjam CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE USER 'climbjam_user'@'%' IDENTIFIED BY 'secret';
GRANT ALL PRIVILEGES ON climbjam.* TO 'climbjam_user'@'%';
FLUSH PRIVILEGES;
```

---

## 🚀 Run the Backend Locally
Start the API
```bash
mvn clean spring-boot:run
```

API available at:
```arduino
http://localhost:8080
```

---

## 📦 Build for Production
```bash
mvn clean package
```
```bash
java -jar target/climb-jam-api-0.0.1-SNAPSHOT.jar
```
---

## 📘 API Documentation (Swagger)

Once the application is running:
```bash
http://localhost:8080/swagger-ui.html
```

---

## 🧪 Tests

```bash
mvn test
```

---

## 📄 Licence

Educational project – training purpose only.

---

## ✍️ Authors

**ClimbJAM – Backend API**
- Mariam NZEYIMANA
- Alexandre DELSOL
Projet ClimbJAM – 2025

