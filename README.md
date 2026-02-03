# 🛒 Spring Boot REST API Project

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![JPA](https://img.shields.io/badge/JPA-Hibernate-blue)
![H2](https://img.shields.io/badge/Database-H2-lightgrey)
![Maven](https://img.shields.io/badge/Maven-Build-red)

## 📖 About

This project is a **RESTful API** developed with **Spring Boot**, designed to manage a basic sales system with entities such as **User, Product, Category, Order, Order Item, and Payment**.

The goal of this project is to practice REST APIs, entity relationships, exception handling, and clean project structure.

## 🚀 Main Features

- Full CRUD operations for **Users** and **Products**
- Many-to-many relationship between **Products** and **Categories**
- Association between **Orders** and **Order Items**, including total price calculation
- **Payment** associated with orders
- Custom exception handling (`ResourceNotFoundException` and `DatabaseException`)
- Test environment database seeding

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA (Hibernate)
- H2 Database (or other configured database)
- Jackson for JSON serialization
- Maven for dependency management

## 🧩 Main Entities

- **User**: Represents system users.
- **Product**: Represents products, related to categories and order items.
- **Category**: Product categories.
- **Order**: Orders placed by users.
- **OrderItem**: Order item linking orders and products with quantity and price.
- **Payment**: Payment associated with an order.

## 📂 Project Structure

```
src/main/java/com/witalo/course/
├── config              # Application configuration and test data
├── entities            # Entity classes (User, Product, Order, etc.)
├── entities/pk         # Composite primary key classes (e.g., OrderItemPK)
├── repositories        # JpaRepository interfaces
├── resources           # REST controllers (API endpoints)
├── services            # Business logic and entity handling
└── services/exceptions # Custom exceptions and handlers
```

## 🔗 Main Endpoints

| Method | Endpoint        | Description               |
|-------|-----------------|---------------------------|
| GET   | /users          | List all users            |
| GET   | /users/{id}     | Find user by ID           |
| POST  | /users          | Create a new user         |
| PUT   | /users/{id}     | Update an existing user   |
| DELETE| /users/{id}     | Delete a user             |
| GET   | /products       | List all products         |
| GET   | /products/{id}  | Find product by ID        |

*Additional endpoints can be implemented following the same structure.*

## ⚠️ Handled Exceptions

- `ResourceNotFoundException`: Thrown when a resource is not found (e.g., invalid ID)
- `DatabaseException`: Database integrity errors (e.g., delete violating foreign key constraints)

## ▶️ How to Run the Project

1. Clone the repository:
   ```bash
   git clone <REPOSITORY_URL>
   cd course
   ```

2. Configure the database in `application.properties`  
   (By default, the project uses an in-memory H2 database)

3. Run the application with Maven:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Access the API:
   ```
   http://localhost:8080/users
   http://localhost:8080/products
   ```

## 🧪 Test Data Seeding

When using the `test` profile (`application-test.properties`), the database is automatically populated via the `TestConfig` class with sample users, products, categories, and orders.

## 📫 Contact

Developed by **Witalo Dias**  
📧 [Email](mailto:witalodias1@gmail.com)  
💼 [LinkedIn](https://www.linkedin.com/in/witalo-dias-775a59289/)
