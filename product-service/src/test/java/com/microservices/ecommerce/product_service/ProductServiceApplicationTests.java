package com.microservices.ecommerce.product_service;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MongoDBContainer;

@Import(TestcontainersConfiguration.class)
/**
 * Use random port to avoid conflict using webEnvironment
 * otherwise integration test will also use the port 8080
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {

	/**
	 * @ServiceConnection will automatically inject the relevant URI details for our application properties for
	 * mongodb like
	 * spring.data.mongodb.uri=mongodb://root:root@localhost:27017/product-service?authSource=admin
	 * dynamically assign the mongodb host and port while running
	 */
	@ServiceConnection
	static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");

	/**
	 * @LocalServerPort whenever the application is running
	 * it will inject the port on which the application is running
	 */
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup(){
		RestAssured.baseURI="http://localhost";
		RestAssured.port = port;
	}

	/**
	 * start the mongodb test container before running the test so for that
	 * static block is used to start mongodb container
	 */
	static {
		mongoDBContainer.start();
	}
	@Test
	void shouldCreateProduct() {
		String requestBody = """
				
				{
				    "name": "iPhone_15_pro",
				    "description": "iPhone 15 pro is a smart phone form Apple",
				    "price": 999
				}
				""";
		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
				.when()
				.post("/api/product")
				.then()
				.statusCode(201)
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("iPhone_15_pro"))
				.body("description", Matchers.equalTo("iPhone 15 pro is a smart phone form Apple"))
				.body("price", Matchers.equalTo(999));
	}

}
