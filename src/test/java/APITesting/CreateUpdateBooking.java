package APITesting;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateUpdateBooking {
  @Test
  public void createNewBooking() {
	  File jsonFile = new File("src\\test\\resources\\testData\\booking.json");
	  
	  RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
	  
	  Response resp = RestAssured.given()
			  .accept("application/json")
			  .contentType("application/json")
			  .body(jsonFile)
			  .post("/booking");
	  
	  Assert.assertEquals(resp.getStatusCode(), 200);
	  
//	  System.out.println(resp.getStatusLine());
	  
	  System.out.println(resp.getBody().prettyPrint());
	  
	  JsonPath jsonPathEvaluator = resp.jsonPath();
	  String fname = jsonPathEvaluator.get("booking.firstname");
	  Assert.assertEquals(fname, "Ganesh");
  }
}




