# Rest API for Online Plant Nursery Application - (GreenHood)



This project is developed by a team of 5 members with the help of the Spring-Boot framework. The main objective of this Web services application is to cater needs of front-end developers to call different types of API as per the requirement.


## Tech Stack and Tools
- Core Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- Spring Validation
- Hibernate
- MySQL
- Lombok
- Swagger-UI

## Modules
- Login & Logout Module
- Admin Module
- Customer Module
- Planter Module
- Plant Module
- Seed Module
- Cart Module
- Order Module

## Features:
### Admin Features
 - Admin can do all the operations like:
 - Add plant/seed/planter
 - Delete plant/seed/planter
 - View all plants/seeds/plantes
 
### Customer Features
 - Customer can do all the operations like:
 - Register himself
 - Login himself
 - Delete himself
 - Add plant/seed/planter to the cart
 - Remove plant/seed/planter from the cart
 - View all plants/seeds/plantes of the cart
 - Can place the order
  
## Installation & Run
- To run this API server, you should update the database configuration inside the application.properties file which is present in the src/main/resources folder.
- Update the port number, username and password as per your local database configuration.
server.port=8008
spring.datasource.url=jdbc:mysql://localhost:3306/FoodExpress;
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=your_username_here
spring.datasource.password=your_password_here
```
## API Root Endpoint
```
https://localhost:8888/
```
```
https://localhost:8888/swagger-ui.html
```
