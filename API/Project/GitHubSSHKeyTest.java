package githubtests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class GitHubSSHKeyTest {

    private RequestSpecification requestSpec;

    // Public SSH key generated specifically for this activity
    private final String sshKey =
            "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIKewPbdala44sWiG8u7HtYsRNGihTsXzZlVG0Cr2PYXK restassured-test";

    // GitHub-generated ID of the SSH key
    private long keyId;


    // =========================================================
    // SETUP
    // =========================================================

    @BeforeClass
    public void setup() {

        String githubToken = System.getenv("GITHUB_TOKEN");

        assertNotNull(
                githubToken,
                "GITHUB_TOKEN environment variable is not configured"
        );

        assertTrue(
                !githubToken.isBlank(),
                "GITHUB_TOKEN environment variable is empty"
        );

        requestSpec = new RequestSpecBuilder()
                .setBaseUri("https://api.github.com")
                .setContentType(ContentType.JSON)
                .addHeader(
                        "Accept",
                        "application/vnd.github+json"
                )
                .addHeader(
                        "Authorization",
                        "Bearer " + githubToken
                )
                .build();
    }


    // =========================================================
    // 1. POST - CREATE SSH KEY
    // =========================================================

    @Test(priority = 1)
    public void addSSHKey() {

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put(
                "title",
                "RESTAssured-Test-Key"
        );

        requestBody.put(
                "key",
                sshKey
        );

        Response response =
                given()
                        .spec(requestSpec)
                        .body(requestBody)
                        .when()
                        .post("/user/keys");

        Reporter.log(
                "POST Response: "
                        + response.asPrettyString(),
                true
        );

        response.then()
                .statusCode(201)
                .body(
                        "title",
                        equalTo("RESTAssured-Test-Key")
                );

        keyId = response
                .jsonPath()
                .getLong("id");

        assertTrue(
                keyId > 0,
                "SSH key ID was not returned by GitHub"
        );

        Reporter.log(
                "Created SSH key ID = " + keyId,
                true
        );
    }


    // =========================================================
    // 2. GET - GET THE CREATED SSH KEY
    // =========================================================

    @Test(priority = 2, dependsOnMethods = "addSSHKey")
    public void getSSHKey() {

        Response response =
                given()
                        .spec(requestSpec)
                        .pathParam("keyId", keyId)
                        .when()
                        .get("/user/keys/{keyId}");

        Reporter.log(
                "GET Response: "
                        + response.asPrettyString(),
                true
        );

        response.then()
                .statusCode(200)
                .body(
                        "title",
                        equalTo("RESTAssured-Test-Key")
                );
    }


    // =========================================================
    // 3. DELETE - DELETE THE CREATED SSH KEY
    // =========================================================

    @Test(priority = 3, dependsOnMethods = "getSSHKey")
    public void deleteSSHKey() {

        Response response =
                given()
                        .spec(requestSpec)
                        .pathParam("keyId", keyId)
                        .when()
                        .delete("/user/keys/{keyId}");

        Reporter.log(
                "DELETE Response Status = "
                        + response.statusCode(),
                true
        );

        response.then()
                .statusCode(204);
    }
}