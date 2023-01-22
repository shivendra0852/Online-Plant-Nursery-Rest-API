# Rest API for Online Plant Nursery Application - (GreenHood)
<p>
        <img
        align="center"
        src="https://github.com/shivendra0852/coherent-seed-8664/blob/main/media/GreenHoodBanner.jpg"
        alt="Coding"
        width="700"
        style="display: block"/>
    </p>
    <br>


A Spring Boot REST API web service for an online plant nursery application, developed using Core Java and the Spring Framework. The application utilizes a MySQL database for data storage and CRUD operations. The team consists of five members. The purpose of this service is to provide functionality for customers to browse and purchase plants, as well as for the management of the plant inventory and customer orders. The API includes endpoints for plant and order management, user authentication, and more. This project is open-source and hosted on GitHub.

## ER- Diagram
<p>
        <img
        align="center"
        src="https://github.com/shivendra0852/coherent-seed-8664/blob/main/media/GreenHoodERDiagram.jpeg"
        alt="Coding"
        width="700"
        style="display: block"/>
    </p>
    <br>
    
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
server.port=8808
spring.datasource.url=jdbc:mysql://localhost:3306/GreenHood
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=your_username_here
spring.datasource.password=your_password_here
```
## API Root Endpoint
```
https://localhost:8808/
```
```
https://localhost:8808/swagger-ui/index.html
```
