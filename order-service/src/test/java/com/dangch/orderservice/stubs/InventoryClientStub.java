package com.dangch.orderservice.stubs;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class InventoryClientStub {

    public static void stubInventoryClient(String skuCode, Integer quantity) {
        // This method is a placeholder for stubbing the InventoryClient
        // In a real test, you would use a mocking framework like Mockito to create a stub
        // For example:
        // when(inventoryClient.isInStock(anyString(), anyInt())).thenReturn(true);
        stubFor(get(urlEqualTo("/api/inventory?skuCode=" + skuCode + "&quantity=" + quantity))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("true"))); // Simulating a successful response indicating the product is in stock
    }
}
