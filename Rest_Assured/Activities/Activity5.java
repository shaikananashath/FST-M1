package activities;

import au.com.dius.pact.consumer.MockServer;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.V4Pact;
import au.com.dius.pact.core.model.annotations.Pact;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class Activity5 {

    private Map<String, String> jsonHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }

    // =========================================================
    // POST PACT
    // =========================================================

    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public V4Pact createPostFragment(PactDslWithProvider builder) {

        String body =
                "{\"id\":123," +
                        "\"firstName\":\"Saahil\"," +
                        "\"lastName\":\"Sharma\"," +
                        "\"email\":\"saahil@example.com\"}";

        return builder
                .given("POST Request")
                .uponReceiving("A request to create a user")
                .path("/api/users")
                .method("POST")
                .headers(jsonHeaders())
                .body(body)
                .willRespondWith()
                .status(201)
                .headers(jsonHeaders())
                .body(body)
                .toPact(V4Pact.class);
    }

    // =========================================================
    // GET ONE USER PACT
    // =========================================================

    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public V4Pact createGetFragment(PactDslWithProvider builder) {

        String body =
                "{\"id\":1," +
                        "\"firstName\":\"Saahil\"," +
                        "\"lastName\":\"Sharma\"," +
                        "\"email\":\"saahil@example.com\"}";

        return builder
                .given("GET Request")
                .uponReceiving("A request to get a user")
                .path("/api/users/1")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(jsonHeaders())
                .body(body)
                .toPact(V4Pact.class);
    }

    // =========================================================
    // GET ALL USERS PACT
    // =========================================================

    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public V4Pact createGetAllFragment(PactDslWithProvider builder) {

        String body =
                "[" +
                        "{" +
                        "\"id\":1," +
                        "\"firstName\":\"Gretel\"," +
                        "\"lastName\":\"\"," +
                        "\"email\":\"gretel@example.com\"" +
                        "}," +
                        "{" +
                        "\"id\":2," +
                        "\"firstName\":\"Hansel\"," +
                        "\"lastName\":\"\"," +
                        "\"email\":\"hansel@example.com\"" +
                        "}" +
                        "]";

        return builder
                .given("GET ALL Request")
                .uponReceiving("A request to get all users")
                .path("/api/users")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(jsonHeaders())
                .body(body)
                .toPact(V4Pact.class);
    }

    // =========================================================
    // DELETE USER PACT
    // =========================================================

    @Pact(consumer = "UserConsumer", provider = "UserProvider")
    public V4Pact createDeleteFragment(PactDslWithProvider builder) {

        return builder
                .given("DELETE Request")
                .uponReceiving("A request to delete a user")
                .path("/api/users/1")
                .method("DELETE")
                .willRespondWith()
                .status(204)
                .toPact(V4Pact.class);
    }

    // =========================================================
    // POST TEST
    // =========================================================

    @Test
    @PactTestFor(
            providerName = "UserProvider",
            pactMethod = "createPostFragment"
    )
    public void postRequestTest(MockServer mockServer) {

        String body =
                "{\"id\":123," +
                        "\"firstName\":\"Saahil\"," +
                        "\"lastName\":\"Sharma\"," +
                        "\"email\":\"saahil@example.com\"}";

        given()
                .baseUri(mockServer.getUrl())
                .headers(jsonHeaders())
                .body(body)
                .log().all()
                .when()
                .post("/api/users")
                .then()
                .statusCode(201)
                .body("id", equalTo(123))
                .body("firstName", equalTo("Saahil"))
                .body("lastName", equalTo("Sharma"))
                .body("email", equalTo("saahil@example.com"))
                .log().all();
    }

    // =========================================================
    // GET ONE USER TEST
    // =========================================================

    @Test
    @PactTestFor(
            providerName = "UserProvider",
            pactMethod = "createGetFragment"
    )
    public void getRequestTest(MockServer mockServer) {

        given()
                .baseUri(mockServer.getUrl())
                .log().all()
                .when()
                .get("/api/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("firstName", equalTo("Saahil"))
                .body("lastName", equalTo("Sharma"))
                .body("email", equalTo("saahil@example.com"))
                .log().all();
    }

    // =========================================================
    // GET ALL USERS TEST
    // =========================================================

    @Test
    @PactTestFor(
            providerName = "UserProvider",
            pactMethod = "createGetAllFragment"
    )
    public void getAllRequestTest(MockServer mockServer) {

        given()
                .baseUri(mockServer.getUrl())
                .log().all()
                .when()
                .get("/api/users")
                .then()
                .statusCode(200)
                .body("[0].id", equalTo(1))
                .body("[0].firstName", equalTo("Gretel"))
                .body("[1].id", equalTo(2))
                .body("[1].firstName", equalTo("Hansel"))
                .log().all();
    }

    // =========================================================
    // DELETE USER TEST
    // =========================================================

    @Test
    @PactTestFor(
            providerName = "UserProvider",
            pactMethod = "createDeleteFragment"
    )
    public void deleteRequestTest(MockServer mockServer) {

        given()
                .baseUri(mockServer.getUrl())
                .log().all()
                .when()
                .delete("/api/users/1")
                .then()
                .statusCode(204)
                .log().all();
    }
}