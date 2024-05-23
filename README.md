# vcriate-internet-services
# Restaurant Management System

This project is a Restaurant Management System built using Spring Boot. It provides features for managing users, menu items, orders, and reservations. It also supports JWT and OAuth2 authentication with role-based access control.

## Features

- User Management: Register, login, and manage users with different roles (Admin, Customer, Staff).
- Menu Management: CRUD operations on menu items.
- Order Management: Create and manage orders.
- Reservation Management: Create and manage reservations.
- JWT Authentication: Secure endpoints using JWT tokens.
- OAuth2 Authentication: Login using OAuth2 providers.
- Role-Based Access Control: Restrict access to endpoints based on user roles.
- API Documentation: Integrated Swagger UI for API documentation.

## Technologies Used

- Spring Boot
- Spring Security
- JWT (JSON Web Tokens)
- OAuth2
- JPA/Hibernate
- MySQL
- Lombok
- Swagger UI

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven
- MySQL

### Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/yourusername/restaurant-management-system.git
   cd restaurant-management-system

2. **Configure MySQL database:**

   Update application.properties with your MySQL database configuration.
   spring.datasource.url=jdbc:mysql://localhost:3306/restaurant_db
   spring.datasource.username=root
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update

   app.jwtSecret=yourSecretKey
   app.jwtExpirationMs=86400000
   
3. **Build and run the application:**

   mvn clean install
   mvn spring-boot:run

4. **Access the application:**

   The application will be running at http://localhost:8087

5. **Swagger UI:**

   Access the API documentation at http://localhost:8087/swagger-ui/index.html


## Project Structure

- Model Layer: Defines the entities.
- Repository Layer: Provides CRUD operations for the entities.
- Service Layer: Contains the business logic.
- Controller Layer: Handles HTTP requests and responses.
- Security Layer: Manages authentication and authorization.



   


