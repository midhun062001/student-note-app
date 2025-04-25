# 📝 Student Notes App

An intuitive note-taking web application built for students. Easily create, edit, and manage notes with a clean interface. Built with React and Spring Boot in a microservices architecture.

---

## 🚀 Features

- 📚 Create, edit, and delete notes
- 🔒 User authentication with JWT
- 🎨 Clean and responsive UI
- 🌐 RESTful API communication
- 🧾 Tag, filter, and organize notes

---

## 🔧 Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/midhun062001/student-notes-app.git
cd student-notes-app
```

## 2. Start Backend (Spring Boot)

```bash
cd backend
./mvnw spring-boot:run
```

**Make sure PostgreSQL is running and configured in application.properties.**

## 3. Start Frontend (React + Vite)

```bash
cd frontend
npm install
npm run dev
```

- Frontend runs on http://localhost:3000
- Backend runs on http://localhost:8080

## 🧰 Tech Stack

## 🧰 Tech Stack

| Layer               | Technology                   |
| ------------------- | ---------------------------- |
| **Frontend**        | React, Vite, Axios           |
| **Backend**         | Spring Boot, Spring Security |
| **Database**        | PostgreSQL                   |
| **Authentication**  | JWT                          |
| **Deployment**      | Docker, Docker Compose       |
| **Version Control** | Git, GitHub                  |

## 📁 Folder Structure (Initial Phase)

```bash
student-notes-app/
│
├── backend/ # Spring Boot application
│ ├── controller/
│ ├── service/
│ ├── repository/
│ ├── model/
│ └── NotesAppApplication.java
│
├── frontend/ # React + Vite app
│ ├── components/
│ ├── pages/
│ ├── services/
│ ├── App.jsx
│ └── main.jsx
│
├── docs/ # Documentation files
├── docker-compose.yml
├── README.md
└── .gitignore
🖼 Screenshots
```

**Screenshots will be added as the project progresses.**
