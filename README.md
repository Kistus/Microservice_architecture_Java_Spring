<h1 align="center">
  <br>
  <br>
  Microservice Architecture - Java Spring
  <br>
</h1>

<h4 align="center">A microservice architecture app using Java Spring for backend and Angular for frontend, with Docker for containerization</h4>

<p align="center">
  <a href="#key-features">Key Features</a> 
  <a href="#how-to-use">How To Use</a> 
</p>

## Key Features

* **Microservice Architecture**
  - Application follows a microservices pattern, breaking down business functionalities into independent services.
* **Java Spring Boot Backend**
  - Built with Java Spring Boot, offering RESTful API services for each microservice.
* **Angular Frontend**
  - Angular is used to create a dynamic, responsive frontend.
* **Docker Support**
  - Docker is used to containerize both frontend and backend services, ensuring portability and easier deployment.
* **CRUD Operations**
  - Full Create, Read, Update, Delete operations on entities with simple REST APIs.
* **Service Communication**
  - Microservices communicate with each other using HTTP/REST or messaging (e.g., RabbitMQ, Kafka).
* **API Gateway**
  - A gateway service to manage routing between frontend and backend microservices.
* **Centralized Configuration**
  - Spring Cloud Config for managing external configuration of microservices.
* **Load Balancing**
  - Uses Ribbon for client-side load balancing between microservices.
* **Service Discovery**
  - Eureka for service registration and discovery.
* **Monitoring**
  - Integration with tools like Spring Boot Actuator, Prometheus, and Grafana for monitoring services.
* **Security**
  - JWT (JSON Web Token) authentication for securing APIs.
* **Scalability**
  - Each microservice can be scaled independently.

## How To Use

To clone and run this application, you'll need [Git](https://git-scm.com), [Java 17+](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html), [Maven](https://maven.apache.org/), [Node.js](https://nodejs.org/), and [Docker](https://www.docker.com/) installed on your system. From your command line:

### Backend (Java Spring Boot)
```bash
# Clone the backend repository
$ git clone https://github.com/your-username/microservice-java-spring

# Navigate into the backend directory
$ cd microservice-java-spring
```
### Front (Angular)
```bash
# Clone the frontend repository
$ git clone https://github.com/your-username/microservice-angular-frontend

# Navigate into the frontend directory
$ cd microservice-angular-frontend

# Install dependencies
$ npm install

# Run the frontend app
$ ng serve
```
### Docker (Compose)
```bash
# Build Docker images for all services
$ docker-compose build

# Start all services
$ docker-compose up
```

# Build the project using Maven
$ mvn clean install

# Run the backend services
$ mvn spring-boot:run
