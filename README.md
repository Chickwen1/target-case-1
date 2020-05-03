                                               # Target Interview - USA

## __Case Study:  myRetail RESTful service__

myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps. 

The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API, which will aggregate product data from multiple sources and return it as JSON to the caller. 
Your goal is to create a RESTful service that can retrieve product and price details by ID. The URL structure is up to you to define, but try to follow some sort of logical convention.
Build an application that performs the following actions: 
Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number. 

<ul>
	<li>Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793) 
	<li>Example response: {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}</li>
	<li>Performs an HTTP GET to retrieve the product name from an external API. (For this exercise the data will come from redsky.target.com, but let’s just pretend this is an internal resource hosted by myRetail)</li>
	<li>Example: http://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics</li>
	<li>Reads pricing information from a NoSQL data store and combines it with the product id and name from the HTTP request into a single response.</li>
	<li>BONUS: Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store.</li>
</ul>

*********************************************************************************************************************************

# __My Solution:__

<ol>
	<li>Use command Line runner for initial set up of database item on loading of application.</li>
	<li>Layered approach to keep MVC, Services, and Repository separate.</li>
  	<li>Retrieve product and price information by Product Id from database.</li>
  	<li>Update only the price information in the database (title retrieved from 3rd party site and ID provided by user).</li>
  	<li>Implement Swagger2 for API documentation.</li>
	<li>Implement Log4j to keep track of issues.</li>
	<li>Unit tests for testing program.</li>
</ol>

### __Technology Stack:__

<ul>
	<li>Java 1.8</li>
	<ul>
		<li>This is a widely used version of Java that works in many environments. Also, I am a full stack java developer so I wanted to use Java.</li>
	</ul>
	<li>Spring Boot</li>
	<ul>
		<li>Spring boot has a built in server (Tomcat) and helps reduce boiler code increasing development time through various things like IoC.</li>
	</ul>
	<li>MongoDB 4.2.6</li>
	<ul>
		<li>Mongo is a NoSQL database (requirement) and has query language that is strong like SQL. While their were no complex joins, Mongo does well in this scenario. While I have not used Mongo in development, it works great in spring boot.</li>
	</ul>
	<li>Maven 3.6.3</li>
	<ul>
		<li>Maven is a great management tool for helping with build automation. It also comes with a POM (Project Object Model) making it easier to add dependencies in Java.</li>
	</ul>
	<li>Mockito/Junit4</li>
	<ul>
		<li>Testing of single units is a necessity in development to find bugs, determine quality of code, etc. Mockito was used so layers were separated in testing and we did not want to diectly interact with the database itself for testing.</li>
	</ul>
	<li>Swagger 2.0</li>
	<ul>
		<li>Swagger is a great tool I love to use for testing REST APIs as to Postman. It makes calls like GET, POST, PUT, etc very easy to visualize and test JSON objects with results displayed as well.</li>
	</ul>
	<li>Git 2.26.2</li>
	<ul>
		<li>Git is a familiar tool I know to manage versions during development.</li>
	</ul>
</ul>

### __Setup instructions:__
<ol type="1">
<li>Java 1.8</li>
	Verify version using 
```
java -version
```
If the version is not 1.8 or higher, please update your current version at https://java.com/en/download/</li>
<li>Spring Tool Suite (you may use another IDE): https://spring.io/tools
<li>Install Mongo DB: https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/</li>

Once installed, start the application by following the path
```
C:\Program Files\MongoDB\Server\4.2\bin\mongo.exe (default path)
```
You may use the MongoDB Compass Community app if your more comfortable with that

Create a new database once loaded named Products the command is below
```
use Products
```
<li>Install Maven: https://www.mkyong.com/maven/how-to-install-maven-in-windows/</li> 
<li>Github:</li>

Download project from the following git repository
https://github.com/Chickwen1/target-case-1 or use Git Bash (in desired location) and enter
```
git clone https://github.com/Chickwen1/target-case-1.git
```
</ol>

Then you can start the application as a spring boot application. Once the server has started up, you may go to the fllowing URL to use swagger to test
```
http://localhost:8080/swagger-ui.html
```

### __Swagger Results:__

The initial screen looks like this:
![image](https://raw.githubusercontent.com/Chickwen1/target-case-1/master/images/swagger1.PNG)

The first one we will look at is the GET
```
![image](https://raw.githubusercontent.com/Chickwen1/target-case-1/master/images/swagger2.PNG)
```
when we use the id "13860428" and click execute, this will be the resulting JSON object. If another id is used, a message will be shown stating the product id does not exist.
```
![image](https://raw.githubusercontent.com/Chickwen1/target-case-1/master/images/swagger5.PNG)
```
The second option is PUT
```
![image](https://raw.githubusercontent.com/Chickwen1/target-case-1/master/images/swagger3.PNG)
```
It is similar to the GET in which the id will be entered and within the JSON, we can change the price.
``` 
Note: updating any other of the JSON values like title and id will not effect the actual output
```

The resulting option will have a result of the following
```
![image](https://raw.githubusercontent.com/Chickwen1/target-case-1/master/images/swagger4.PNG)
```
```
Note: Similar to GET, if an ID is entered that does not exist, it will display a message saying Product ID does not exist
```