package com.dangch.orderservice;

import com.dangch.orderservice.stubs.InventoryClientStub;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class OrderServiceApplicationTests {
    @ServiceConnection
    static MySQLContainer mysqlContainer = new MySQLContainer("mysql:8.0.32");

    static {
        mysqlContainer.start();
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
    void shouldPlaceOrder() {
        String orderRequestJson = """
                {
                     "skuCode":"iphone_15",
                     "price":"1000",
                     "quantity":"1"
                 }
                """;
        InventoryClientStub.stubInventoryClient("iphone_15", 1); // Stubbing the InventoryClient to return true for the given SKU code and quantity

        var response = RestAssured.given()
                .contentType("application/json")
                .body(orderRequestJson)
                .when()
                .post("/api/orders")
                .then()
                .statusCode(201)
                .extract()
                .body().asString();// Asserting that the order was placed successfully with a 201 Created status

        // You can add further assertions here to verify the response or the state of the system
        assertThat(response, Matchers.is("Order placed successfully"));
            }
    }
