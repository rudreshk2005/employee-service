# employee-service
Employee service for employee portal

Running Employee Portal locally

1. git clone https://github.com/rudreshk2005/employee-service.git
2. cd employee-service
3. mvn clean install
4. java -jar target/*.jar

Use postman or any rest client to access below your rest api

1. Create Employee

  Api Endpoint : http://localhost:8080/api/v1/employee
  Method Type  : POST
  Content-Type : application/json; charset=UTF-8
  
2. Get Employee list 

  Api Endpoint : http://localhost:8080/api/v1/employee
  Method Type : GET
   Content-Type : application/json; charset=UTF-8
   
   
Database Details

- Using H2 database
- Use employee_schema.sql file to create tables
- Use employee_data.sql to load employee data in table


