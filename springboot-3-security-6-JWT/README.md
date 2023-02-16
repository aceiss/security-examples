# Spring Boot 3.0 Security with JWT Implementation
This project demonstrates the implementation of security using Spring Boot 3.0 and JSON Web Tokens (JWT). It includes the following features:

## Features
* User registration and login with JWT authentication
* Password encryption using BCrypt
* Role-based authorization with Spring Security
* Customized access denied handling

## Technologies
* Spring Boot 3.0
* Spring Security
* JSON Web Tokens (JWT)
* BCrypt
* Maven
 
## Getting Started
To get started with this project, you will need to have the following installed on your local machine:

* JDK 17+
* Maven 3+


To build and run the project, follow these steps:

* Clone the repository: `git clone https://github.com/ali-bouali/spring-boot-3-jwt-security.git`
* Navigate to the project directory: cd spring-boot-security-jwt
* Build the project: mvn clean install
* Run the project: mvn spring-boot:run 

-> The application will be available at http://localhost:8080.

## Authentication and Request Sending
To authenticate the JWT and send requests, use a tool like Postman to send the requests:
Authentication
POST: http://localhost:8080/api/v1/auth/authenticate
    JSON Body:
{
"email":"catmgr@mail.com",
"password":"password"
}
You can use admin@mail.com or user@mail.com
The following will be returned in the response body:
"token": "eyJhbGciOiJIUzI1NiJ9.eyJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9DQVRBTE9HX01HUiJ9LHsiYXV0aG9yaXR5IjoiUk9MRV9VU0VSIn1dLCJzdWIiOiJjYXRtZ3JAbWFpbC5jb20iLCJpYXQiOjE2NzY1NjMwOTgsImV4cCI6MTY3NjU2NDUzOH0.fwUiGn1vf-43NL9r-wn9s8uqn5eHPzKcQR0h4OyzKyQ"

Send page request
GET: http://localhost:8080/api/v1/demo-controller
Add to Header: Key: Authorization  Value: Bearer <token from above with quotes removed>
    Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9DQVRBTE9HX01HUiJ9LHsiYXV0aG9yaXR5IjoiUk9MRV9VU0VSIn1dLCJzdWIiOiJjYXRtZ3JAbWFpbC5jb20iLCJpYXQiOjE2NzY1NjMwOTgsImV4cCI6MTY3NjU2NDUzOH0.fwUiGn1vf-43NL9r-wn9s8uqn5eHPzKcQR0h4OyzKyQ
This request will trigger an entitlement used in the Aceiss App.

## Code Snippet from Agent
For this implementation, the master list does not work. The Advice get's triggered, but the job fails because it can't find the repository to retrieve all of the users. Here is the code that was being used to investigate:

            if (Arrays.stream(userDetailsService.getClass().getDeclaredFields()).count() == 1){
                try {
                    System.out.println("Made it Here!!" + userDetailsService.getClass().getName());
                    for (Field field : userDetailsService.getClass().getDeclaredFields()){
                        System.out.println("Made it Here 2 " + field.getName());
                        field.setAccessible(true);
                        repository = field.get(userDetailsService);
                        System.out.println("Repository : " + repository.getClass().getName());
                        for (Method md : repository.getClass().getDeclaredMethods()){
                            System.out.println("Repository Method : " + md.getName());
                        }
                        for (Field md : repository.getClass().getDeclaredFields()){
                            System.out.println("Repository Field : " + md.getName());
                        }
 
                    }
                    for (Method md : userDetailsService.getClass().getDeclaredMethods()){
                        System.out.println("Method : " + md.getName());
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }

            }





