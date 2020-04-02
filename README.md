# rewards-service
This service is implemented to calculate the reward points based on the product purchase by the customer
The data is store as a in-memory hash map for this implementation. For real world use, you can use any persistent database

Compile and run the application
mvn clean package

Run all JUNits test
mvn clean test

Run the application using below command or Run the main app class RewardCalculatorApplication from IDE
./mvnw spring-boot:run


There are 3 rest endpoints created for this service:

API 1 : This API is used to purchase the product by given customer and calculates the rewards points internally
URL : http://localhost:8080/purchase
URI Path : /purchase 
HTTP Method: POST
JSON Payload
{
	"customer" : {
		"firstName" : "Kapil",
		"lastName" : "Nimje",
		"phoneNumber": "505-567-3867"
	},
	"product" : {
		"name" : "Apple iPhone 10",
		"type" : "Electronics",
		"price" : "120"
	}
}

API 2: This API is used to search the reward points based on customer name. This API can also giv you ability to search based on filter days
URL: http://localhost:8080/rewards/search
URI Path: /rewards/search
Http Method: GET
Query Parameters: 
 - firstName
 - lastName
 - filterDays 


API 3: This API is used to give all the transactions made by customers
URL: http://localhost:8080/rewards/transaction
URI Path: /rewards/transaction
Http Method: GET


This services are also exposed via Swagger UI. Navigate below swagger UI for more details:
http://localhost:8080/swagger-ui.html
http://localhost:8080/v2/
