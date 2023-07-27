# Food delivery Application
### Requirements
  * IntelliJIDEA
  * ServerPort: 8080 (use: 16.171.208.1:8080)
  * Java version: 17
  * Everything is present in the pom.xml (no need to download any  library)
  * AWS(EC2)
### Steps to run the Project
* Download the source code and import in intellijIDEA.
*  Go to 16.171.208:8080/
* Put specific end_points besides the port accordingly to run the project to access and modify the data or *Click on the link which is integrated with swagger and use it 
http://3.109.21.88:8080/swagger-ui/index.html#/

## Dependencies
 ### Validation
   * Bean Validation with Hibernate validator.
 ### Spring Web
  * Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
 ### Spring Boot DevTools
   * Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
### Spring Data JPA
  * Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
### Lombok
  * Java annotation library which helps to reduce boilerplate code.
### JSON
  * JSON is a lightweight, language-independent, data interchange format. See http://www.JSON.org/ The files in this package implement JSON encoders/decoders in Java. It also includes the capability to convert between JSON and XML, HTTP headers, Cookies, and CDL. This is a reference implementation.
### MySQL
  * MySQL JDBC driver.
### Swagger
  * It provide the UserInterface for all our API's.
## Project Structure(MVC Structure)
### Model
* #### User Model
* #### Order Model
* #### Food Model
* #### Admin Model
### Controller
* #### UserController
* #### OrderController
* #### FoodItemController
* #### AdminController
### Repository
* #### IUserRepo
* #### IOrderRepo
* #### IFoodRepo
* #### IAdminRepo
### Service
* #### UserService
* #### OrderService
* #### FoodService 
* #### AdminService
## EndPoints
* ### Admin
  * creat-admin
  * getadmin
  * create-food-item
  * getallfood
  * deletefoodbyid
  * update-food-details
  * getOrderbyorderid
* ### Food
  * create-food_item
  * getAllfoodItems
  * getfoodbyId
  * delete-food-by-id
  * update-food-item/{foodid}
* ### Order
  * create-order
  * get-order-by-orderid
* ### User
  * create-user
  * getallUsers
  * login
## Working
Project mainly focuses on Users, Orders and foodItems.
Crud operations on User like add user,fetch user,login user.
Crud operation on Orders like add order and fetch order.
Crud operation on Admin like add admin, fetch admin , CRUD operation on food items by using Admin.
We have provide the validations on every entry data from the end user.
All the can be seen in the mySql workbench
we have deployed our project by using Static Url of the AWS Server which helps in running the project in background.

## Authors

- [@Rudra Pratap Singh](https://github.com/rudrapratapsingh2000)

