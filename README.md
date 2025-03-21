# ✈️ Flight Booking System (Microservices)

A simple flight booking system built using Java 21 and Spring Boot with a microservices architecture.

## 🧱 Microservices

| Service          | Port | Responsibilities                       |
|------------------|------|----------------------------------------|
| Flight Service   | 5000 | Manage flights                         |
| Schedule Service | 5001 | Manage flight schedules & seats        |
| Ticket Service   | 5002 | Book tickets and manage passenger info |

## 📦 Tech Stack
- Java 21
- Spring Boot 3.4.2
- Lombok
- Maven

## 🚀 How to Run

```bash
cd flights       && ./mvnw spring-boot:run
cd schedules     && ./mvnw spring-boot:run
cd tickets       && ./mvnw spring-boot:run
