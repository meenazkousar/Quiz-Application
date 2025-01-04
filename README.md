# User Management Service

## Overview

The **User Management Service** is a Spring Boot-based application designed to manage user data and authentication. It leverages various utilities, security configurations, and REST APIs for seamless user management. This service is modular, making it easy to extend and integrate into larger applications.

## Project Structure

```plaintext
src/main/java
├── com.quizapp.user_management_service
│   ├── config
│   │   ├── SecurityConfig.java
│   │   ├── ModelMapperConfig.java
│   │   └── OAuth2Config.java
│   ├── controller
│   │   └── UserController.java
│   ├── dao
│   │   └── UserDao.java
│   ├── dto
│   │   ├── request
│   │   │   └── UserRequestDto.java
│   │   ├── response
│   │   │   └── UserResponseDto.java
│   ├── entity
│   │   └── UserEntity.java
│   ├── exceptions
│   │   └── CustomException.java
│   ├── repository
│   │   └── UserRepository.java
│   ├── service
│   │   ├── UserService.java
│   │   └── impl
│   │       └── UserServiceImpl.java
│   ├── util
│   │   ├── PasswordUtil.java
│   │   ├── JWTUtil.java
│   │   └── MapperUtil.java
```

## Key Features

- **User Authentication and Authorization** using OAuth2 and JWT.
- **Password Encryption** with BCrypt.
- **DTO Mapping** using ModelMapper.
- **Custom Exception Handling**.
- Modular and scalable architecture.

## Prerequisites

Before running the application, ensure you have the following:

- Java 17 or higher
- Maven 3.6+
- PostgreSQL or any preferred database

## Configuration

### Application Properties

Configure the `application.properties` file for database connectivity and other environment-specific settings.

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/user_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
jwt.secret=your_secret_key
jwt.expiration=3600000
```

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/your-repo/user-management-service.git
   ```

2. Navigate to the project directory:

   ```bash
   cd user-management-service
   ```

3. Build the project:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

The application will start at `http://localhost:8080`.

## API Endpoints

### Public Endpoints

- `POST /api/public/register` - Register a new user
- `POST /api/public/login` - Authenticate a user

### Secured Endpoints

- `GET /api/users/{id}` - Get user details by ID
- `PUT /api/users/{id}` - Update user details
- `DELETE /api/users/{id}` - Delete a user

## Utilities

### PasswordUtil

Handles password encryption and matching using BCrypt.

### JWTUtil

Manages JWT token generation, validation, and extraction.

### MapperUtil

Provides reusable methods for DTO to Entity mapping and vice versa.

## Security Configuration

The application uses:

- **OAuth2** for resource server configuration.
- **JWT** for stateless authentication.
- **BCrypt** for secure password storage.

## Contributing

Contributions are welcome! Please follow the standard GitHub flow:

1. Fork the repository.
2. Create a feature branch.
3. Commit your changes.
4. Push the branch and open a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

---

**Author:** Meenaz
