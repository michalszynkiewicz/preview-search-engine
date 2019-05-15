package com.example.search.engine;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class SearchEndpointTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/search?query=awesome")
          .then()
             .statusCode(200);
    }

}