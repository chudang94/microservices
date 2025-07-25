package com.dangch.inventory;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class InventoryApplicationTests {

	static {
		MySQLContainer mysqlContainer = new MySQLContainer("mysql:8.0.32");
	}
	@LocalServerPort
	private int port;

	@BeforeEach
	void setUp() {
		RestAssured.baseURI= "http://localhost";
		RestAssured.port = port; // Assuming the application runs on port 8080
		// This method can be used to set up any preconditions or mock data before each test
	}

	@Test
	void testInventory() {

		var response = RestAssured.given()
				.queryParam("skuCode", "iphone_15")
				.queryParam("quantity", 1)
				.when()
				.get("/api/inventory")
				.then()
				.statusCode(200)
				.extract()
				.body().as(Boolean.class) ;// Asserting that the inventory check returns true

		assertTrue(response, "Inventory check failed, expected true but got false");

		var response2 = RestAssured.given()
				.queryParam("skuCode", "non_existent_item")
				.queryParam("quantity", 1)
				.when()
				.get("/api/inventory")
				.then()
				.statusCode(200)
				.extract()
				.body().as(Boolean.class) ;// Asserting that the inventory check returns false
		assertTrue(!response2, "Inventory check failed, expected false but got true");
	}

}
