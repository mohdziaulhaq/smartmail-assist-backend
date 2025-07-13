# SMARTMAIL‑ASSIST BACKEND

*AI‑Powered Email Reply Assistant*

![GitHub last commit](https://img.shields.io/badge/last%20commit-today-blue)
![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/Spring--Boot-3.4-green)
![Spring AI](https://img.shields.io/badge/Spring%20AI-Gemini-green)
![Docker](https://img.shields.io/badge/Containerized-Yes-blue)
![Gemini API](https://img.shields.io/badge/Google%20Gemini-API-orange)

---

## 📝 Overview

SmartMail‑Assist is a **Spring Boot REST API** that generates context‑aware, professional email replies using **Google Gemini** via **Spring AI**. It is designed to plug into any email client or front‑end (e.g., the associated React app) to boost productivity and streamline communication.

---

## 🚀 Key Features

| Feature                            | Description                                                            |
| ---------------------------------- | ---------------------------------------------------------------------- |
| ✨ **AI‑Generated Replies**         | Parses the original message & prompt → returns a polished reply.       |
| 🔒 **Stateless REST API**          | Single endpoint `POST /api/email/generate` for integration simplicity. |
| 🧠 **Google Gemini via Spring AI** | Leverages Gemini models for coherent, professional tone.               |
| ⚙️ **Configurable Prompting**      | System & user prompts kept in external config for quick tuning.        |
| 🐳 **Dockerized**                  | Two‑stage Dockerfile for repeatable builds & cloud deployment.         |
| 📄 **OpenAPI (Swagger)**           | Auto‑generated docs using Springdoc.                                   |

---

## 🛠 Tech Stack

* **Java 17**
* **Spring Boot 3** (Web, Validation)
* **Spring AI** (Gemini Client)
* **OpenAPI/Swagger** (`springdoc-openapi-starter`)
* **Lombok**
* **Docker / Docker Compose**

---

## 📚 Table of Contents

* [Overview](#-overview)
* [Getting Started](#getting-started)

    * [Prerequisites](#prerequisites)
    * [Installation](#installation)
    * [Running the App](#running-the-app)
    * [Docker Deployment](#docker-deployment)
* [API Reference](#api-reference)
* [Configuration](#configuration)
* [Learnings](#learnings)
* [Author](#author)
* [License](#license)

---

## Getting Started

### Prerequisites

* **Java 17**
* **Maven 3.9+**
* A **Google Gemini API key** (set as env var `GEMINI_API_KEY`)

### Installation

```bash
# Clone the repo
git clone https://github.com/mohdziaulhaq/smartmail-assist-backend.git
cd smartmail-assist-backend

# Install dependencies & build
mvn clean package -DskipTests
```

### Running the App

```bash
export GEMINI_API_KEY=your_key_here
java -jar target/smartmail-assist-0.0.1-SNAPSHOT.jar
```

The API will start on **`http://localhost:8080`**. Visit `/swagger-ui.html` for interactive docs.

### Docker Deployment

```dockerfile
# Build stage
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q dependency:go-offline
COPY src ./src
RUN mvn -q clean package -DskipTests

# Runtime stage
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/smartmail-assist-0.0.1-SNAPSHOT.jar app.jar
ENV GEMINI_API_KEY=""
EXPOSE 8080
ENTRYPOINT ["sh","-c","java -jar app.jar --server.port=${PORT:-8080}"]
```

Build & run:

```bash
docker build -t smartmail-assist .
# remember to pass GEMINI_API_KEY
docker run -e GEMINI_API_KEY=your_key -p 8080:8080 smartmail-assist
```

---

## API Reference

| Method | Endpoint              | Description                                                                                                                                                                   |
| ------ | --------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `POST` | `/api/email/generate` | Generate a professional reply. **Body**: `{ "from": "alice@example.com", "to": "bob@example.com", "subject": "", "body": "<original email>" }` **Returns**: plain‑text reply. |

Full schema available in Swagger.

---

## Configuration

`application.properties` snippet:

```properties
spring.ai.gemini.api-key=${GEMINI_API_KEY}
spring.ai.gemini.model=text-bison-001
smartmail.prompt.system=You are an efficient email assistant...
smartmail.prompt.user=Draft a concise, polite reply...
```

Adjust model, temperature, or prompts as needed.

---

## Live Demo

| Environment       | URL                                                                            |
| ----------------- | ------------------------------------------------------------------------------ |
| **Frontend**      | [https://smartmail.netlify.app/](https://smartmail.netlify.app/)               |
| **Backend / API** | [https://smartmail-assist.onrender.com](https://smartmail-assist.onrender.com) |

Use the above links to test the React UI or call the `/api/email/generate` endpoint with Postman/curl.

---

## Learnings

Building SmartMail‑Assist taught me to:

* Integrate **Spring AI** with the new **Gemini** models.
* Design clean prompting strategies for high‑quality email replies.
* Expose AI services as REST micro‑APIs with proper validation.
* Containerize Spring Boot apps for repeatable deployments.
* Document APIs using **OpenAPI** & Swagger UI.

---

## Author

**Zia Ul Haq Mohammed**
[Portfolio](https://mohdziaulhaq.netlify.app) | [LinkedIn](https://www.linkedin.com/in/mohdziaulhaq/) | [GitHub](https://github.com/mohdziaulhaq)

---

## License

This project is licensed under the **MIT License**.

---

*Built with ❤️ using Spring Boot, Spring AI, and Google Gemini*
