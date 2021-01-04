# ContactDetails-Manager-CRUD
This  is a Simple Spring MVC Web Application(For learning purpose) which  allows user to Create,Read,Update and Delete Contact Details from MYSQL database.This Application Uses  Spring JdbcTemplate to handle DataBase Operations and Jsp along with BootStrap Css has been used for views.

**STEPS TO SETUP**
1. Download the Project

2. Import the project to IDE

3. create a MYSQL database named "usersdb"

4. create a table with following command:-

    CREATE TABLE `users`
    (
    
    `id` int NOT NULL AUTO_INCREMENT,
    
    `name` varchar(45) NOT NULL,
    
    `email` varchar(50) NOT NULL,
    
    `phone` varchar(15) NOT NULL,
    
     PRIMARY KEY (`id`)
     
    );
5. open "/src/main/java/database.properties" and 

   ->set "userName" as YOUR database user name
   
   ->set "password" as YOUR database password
   
6. Right Click on project-> SELECT Targete Runtimes -> SELECT Apache Tomcat

7. Run Project on Server !
