//In this activity, you will create a test class that contains three test cases:
//
//One test case for sending a POST request on https://petstore.swagger.io/v2/pet
//One test case for sending a GET request on https://petstore.swagger.io/v2/pet/{petId}
//One test case for sending a DELETE request on https://petstore.swagger.io/v2/pet/{petId}
//The test cases must execute in the order:
//POST request -> GET request -> DELETE request.

package activities;

import java.util.HashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Activity1 {
	
	int petId;
	
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	
	@BeforeClass
	public void setup() {
		requestSpec = new RequestSpecBuilder().
				setBaseUri("https://petstore.swagger.io/v2/pet").
				addHeader("Content-Type", "application/json").
				build();
		
		responseSpec = new ResponseSpecBuilder().
				expectBody("id", Matchers.equalTo(77287)).
				expectBody("name", Matchers.equalTo("Tommy")).
				expectBody("status", Matchers.equalTo("alive")).
				expectResponseTime(Matchers.lessThanOrEqualTo(3000L)).
				build();
	}
	
	@Test(priority = 1)
	public void postNewPet() {
		HashMap<String, Object> reqBody = new HashMap<String, Object>();
		reqBody.put("id", 77287);
		reqBody.put("name", "Tommy");
		reqBody.put("status", "alive");
		
		Response response = RestAssured.given().spec(requestSpec).body(reqBody).		
				when().post();
		
		petId = response.then().extract().path("id");
		
		response.then().spec(responseSpec);
	}
	
	@Test(priority = 2)
	public void getPetInfo() {
		RestAssured.given().spec(requestSpec).pathParam("petId", petId).
		when().get("/{petId}").
		then().spec(responseSpec);
	}
	
	@Test(priority = 3)
	public void deletePetInfo() {
		RestAssured.given().spec(requestSpec).pathParam("petId", petId).
		when().delete("/{petId}").
		then().statusCode(200).body("message", Matchers.equalTo(String.valueOf(petId)));
		
	}

}