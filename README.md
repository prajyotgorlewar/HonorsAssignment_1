# ✈️ Flight Booking System (Microservices)

A simple flight booking system built using Java 21 and Spring Boot with a microservices architecture.

## 🧱 Microservices

| Service          | Port | Responsibilities                       |
|------------------|------|----------------------------------------|
| Flight Service   | 5000 | Manage flights                         |
| Schedule Service | 5001 | Manage flight schedules & seats        |
| Ticket Service   | 5002 | Book tickets and manage passenger info |

## 📦 Tech Stack
- Java 17
- Spring Boot 3.4.2
- Lombok
- Maven

## 🚀 How to Run

```bash
cd microservice_flights       && ./mvnw spring-boot:run
cd microservice_schedules     && ./mvnw spring-boot:run
cd microservice_tickets       && ./mvnw spring-boot:run
