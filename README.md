# 📝 Student Notes Microservices App

A modern note-taking web application built with a microservices architecture. Designed for students to organize notes, media, and mind maps efficiently. Backend developed using **Spring Boot**, secured with **JWT**, and powered by **PostgreSQL**.

---

## 🧰 Tech Stack

| Layer           | Technology           |
| --------------- | -------------------- |
| Backend         | Java, Spring Boot    |
| Microservices   | Spring Cloud Gateway |
| Database        | PostgreSQL           |
| Authentication  | JWT, Spring Security |
| Version Control | Git, GitHub          |
| Build Tool      | Maven                |

---

## 📂 Project Structure

```
student-notes-backend/
├── user-service/              # Handles user registration, login, and profile
│   ├── controller/
│   ├── model/
│   ├── repository/
│   ├── service/
│   └── UserServiceApplication.java
│
├── note-service/              # Manages notes CRUD
│
```

---

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- PostgreSQL
- Git

### 🛠 Setup Instructions

1.  **Clone the repo**

    ```
    git clone https://github.com/your-username/student-note-backend.git
    cd student-notes-backend
    ```

2.  **Create Databases**

    - Create PostgreSQL databases for each service (e.g., user_db, note_db, etc.)

3.  **Update application.yml files**

    - Configure database URLs and credentials for each service

4.  **Build & Run Services**

    ```
    cd user-service
    mvn spring-boot:run
    ```

    Repeat for other services: `note-service`,`media-service`, etc.

5.  **Run Gateway**

    ```bash
    cd gateway-service
    mvn spring-boot:run
    ```

---

# 🔐 Authentication

- Spring Security is used to secure endpoints

- JWT token is required for accessing protected routes

- You can add authentication at a later stage and update your gateway route filters
