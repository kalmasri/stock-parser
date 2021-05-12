######## Stocks Query and Upload ########

Please run the Spring Boot application locally, once the application is running please open this link in your browser


http://localhost:8080/swagger-ui.html#/stock-controller


##########################################

I am using Swagger to show the end points and allow front end visualization of the API. I have decided for Swagger rather than PostMan

I have Created 4 APIs
- upload a bulk data set
- query for data by stock ticker 
- query for data by stock ticker and quarter
- add a new record

I am using an H2 database for an in-memory database instead of Postgre
I have chosen JPA with Hibernate to create the column and tables needed for my database also to dynamically query stocks


