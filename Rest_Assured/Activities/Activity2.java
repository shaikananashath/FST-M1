//In this activity, you will create a test class that contains three test cases:
//One test case for sending a POST request on https://petstore.swagger.io/v2/user
//One test case for sending a GET request on https://petstore.swagger.io/v2/user/{username}
//One test case for sending a DELETE request on https://petstore.swagger.io/v2/user/{username}
//The test cases must execute in the order:
//POST request -> GET request -> DELETE request.
//For the POST request, the request body should come from an external JSON file.
//For the GET request, use a path parameter to set the username and get the details of the user created in the POST request test case.
//Add assertions to ensure that ALL the details being returned in the body of the response match the expected values.
//Also write the response of the GET request to an external JSON file.
//For the DELETE request, use a path parameter to set the username.
//Add assertions to ensure that the response body contains code as 200 and message as the username of the user.

package activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity2 {
	
	String userId;
	
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setup() {
		requestSpec = new RequestSpecBuilder().
				setBaseUri("https://petstore.swagger.io/v2").
				addHeader("Content-Type", "application/json").
				build();
		
		responseSpec = new ResponseSpecBuilder().
				expectBody("username", Matchers.equalTo("TestUserName")).
				expectBody("firstName", Matchers.equalTo("Steven")).
				expectBody("lastName", Matchers.equalTo("Parkinson")).
				expectBody("email", Matchers.equalTo("Steven.Parkinson@gmail.com")).
				expectBody("password", Matchers.equalTo("StePark")).
				expectBody("phone", Matchers.equalTo("9123456789")).
				expectResponseTime(Matchers.lessThanOrEqualTo(3000L)).
				build();
	}
	
	@Test(priority = 1)
	public void postNewUserFromJSONFile() throws IOException {
		FileInputStream inputJSON = new FileInputStream("C:/Users/SwarnavMondal/eclipse-workspace/FST_RESTAssured/src/test/java/activities/TestJSON.json");
		
		Response response = RestAssured.given().spec(requestSpec).body(inputJSON).		
				when().post("/user");
		inputJSON.close();
		
		userId = response.then().extract().path("message");
				
		response.then().statusCode(200).body("message", Matchers.equalTo(userId));
	}
	
	@Test(priority = 2)
	public void getUserInfo() throws IOException {
		
		File outputJSON = new File("src/test/java/activities/userGETResponse.json");
		
		Response response = RestAssured.given().spec(requestSpec).pathParam("username", "TestUserName").
		when().get("/user/{username}");
		
		response.then().spec(responseSpec).log().all();
		
		String respBody = response.getBody().asPrettyString();
		
		outputJSON.createNewFile();
		FileWriter writer = new FileWriter(outputJSON.getPath());
		writer.write(respBody);
		writer.close();
		
	}
	
	@Test(priority = 3)
	public void deleteUserInfo() {
		RestAssured.given().spec(requestSpec).pathParam("username", "TestUserName").
		when().delete("/user/{username}").
		then().statusCode(200).body("message", Matchers.equalTo("TestUserName"));
		
	}

}