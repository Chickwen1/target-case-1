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

###### __Technology Stack:__
<ul>
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
</ul>
###### __Setup instructions:__

