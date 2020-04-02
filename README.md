<h2> Customer Rewards Service </h2>
This service is implemented to calculate the reward points based on the product purchases by the customer.
The data is stored as a in-memory hash map for this implementation. For the real world use case, you can use any persistent database.

<h3> Compile and run the application</h3>

```
mvn clean package
```

Run all JUnits Tests
```
mvn clean test
```

Run the application using below command or Run the main app class RewardCalculatorApplication from any Java based IDE.
```
./mvnw spring-boot:run
```

<h3>Product's Rewards APIs</h3>
There are 3 rest endpoints created for this service:

API 1 : This API is used to purchase the product by given customer and calculates the rewards points internally.
- URL : http://localhost:8080/purchase
- URI Path : /purchase 
- HTTP Method: POST
- JSON Payload
```
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
```

API 2: This API is used to search the reward points based on customer name. This API can also give you an ability to search rewards based on number of days provided.
- URL: http://localhost:8080/rewards/search
- URI Path: /rewards/search
- Http Method: GET
- Query Parameters: 
    - firstName
    - lastName
    - filterDays 


API 3: This API is used to give all the transactions made by customers.
- URL: http://localhost:8080/rewards/transaction
- URI Path: /rewards/transaction
- Http Method: GET


<h3>Swagger UI</h3>
This services are also exposed via Swagger UI. Navigate below swagger UI for more details:
- http://localhost:8080/swagger-ui.html
- http://localhost:8080/v2/
