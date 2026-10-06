package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TestPetAPI {

    @Test
    public void GetPetDetails() {

        // Base URL
        baseURI = "https://petstore.swagger.io/v2/pet";

        // Send GET request
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(baseURI + "/findByStatus?status=sold");

        // Print response body
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is => " + responseBody);

        // Assertions
        response.then().statusCode(200);
        response.then().body("[0].status", equalTo("sold"));
    }
}