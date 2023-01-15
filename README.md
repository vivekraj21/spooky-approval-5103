![Logo](https://i.ibb.co/c1qYrZy/Garden-greens-1.png)
# Garden Greens

An Online Nursery Plant Management System where customers can buy 
plants and planters.

There are 2 kinds of users : 

- Admin
- Customers 

Admin can manage all the things, whereas customers can only manage themselves and
their orders.
## Features

- Admin can register and login/logout 
- Admin can look into any modules i.e. plants, planters, customers etc. and manage them as well.
- Admin can perform CRUD operations on plants, planters and also delete customer details.
- Customers can register and login/logout.
- Customers can look at all the plants and planters present.
- Customers can place order of plants and planters.
- Customers can also perform CRUD operations on themselves.



## Tech Stack

- Core Java
- Spring Boot
- Hibernate
- MySQL (RDBMS)
- Maven
- Swagger UI
- Spring Tool Suite (Eclipse)


## Deployment

To deploy this project on localhost paste this below code in application.properties file in the 
resources and update according to your database name, username and password of your MySQL database.

```properties
 #changing the server port
server.port=8888

#db specific properties
spring.datasource.url=jdbc:mysql://localhost:3306/database
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.username=username
spring.datasource.password=password



#ORM s/w specific properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.mvc.throw-exception-if-no-handler-found=true
spring.web.resources.add-mappings=false

spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER

```

### Swagger UI - Link

Use this link after deploying the application on your localhost.
```swagger
http://localhost:8888/swagger-ui/index.html

```
## ER Diagram

![ER Diagram](https://i.ibb.co/2PfBRwr/ERDIA.png)
## Modules

![alt text](https://i.ibb.co/jgDvHfk/hello-Module1.png)
![alt text](https://i.ibb.co/dgB0QjT/modul2.png)


## Explanation Video

- [Click Here]( https://drive.google.com/file/d/1FmdL1pRTIosr67cbZPksqyzeNpUuhH57/view)
## Authors

- [Vivek Raj (@vivekraj21) ](https://github.com/vivekraj21)
- [Pradeep Singroul (@pradeepsingroul) ](https://github.com/pradeepsingroul)
- [Jyoti Pardhi (@JyotiP123) ](https://github.com/JyotiP123)
- [Mrityunjay Sarkar (@MrityuNJ45)](https://github.com/MrityuNJ45)

