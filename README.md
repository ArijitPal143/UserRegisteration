User Registration and Login System:

This project implements a basic user registration and login system with Spring Boot, Thymeleaf, Hibernate, and Oracle Database. Users can register with their details, login securely, view their profile information, and logout.



Features:

•	User registration with mandatory fields: username, password, first name, last name, gender, phone numbers, address, and email.
•	Mandatory field validation during registration.
•	Login functionality with mandatory username and password fields.
•	Secure password storage using hashing.
•	User profile display after successful login, showing first name, last name, gender, phone numbers, address, and email.
•	Logout option provided for user session management.



Technologies Used:

•	Java
•	Spring Boot
•	Spring Data JPA
•	Thymeleaf
•	Bootstrap
•	Oracle Database



Setup:

1.	Set up your Oracle database and configure the database connection properties in src/main/resources/application.properties.

spring.datasource.driver-classname=oracle.jdbc.driver.OracleDriver

spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xstore

spring.datasource.username=System

spring.datasource.password=Oracle_1

spring.jpa.hibernate.ddl-auto=update

logging.level.org.hibernate.SQL=DEBUG


2.	Create the necessary tables in your Oracle database using scripts or JPA entities. Ensure proper normalization for data integrity.



Build the project:

•	Access the application in your web browser at http://localhost:8080.
•	Register as a new user by filling out the required fields. If there are any errors during registration, a generic error message will be displayed.
•	Login with your registered username and password. If there are any errors during login, a generic error message will be displayed.
•	After successful login, you'll be redirected to your user profile page, where you can view your details. You can also logout from the system.
