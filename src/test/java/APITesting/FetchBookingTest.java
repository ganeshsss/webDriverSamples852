package APITesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class FetchBookingTest {
  @Test
  public void getAllBookings() {
	  RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
	  
	  Response response = RestAssured.get("/booking");
	  response.prettyPrint();
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode,200);
	  Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
	  ResponseBody body = response.getBody();
	  String bodyAsString = body.asString();
	  System.out.println(bodyAsString);
  }


@Test
public void getBookingsDetails() {
	  RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
	  
	  Response response = RestAssured.get("/booking/2");
	  response.prettyPrint();
	  
	  int statusCode = response.getStatusCode();
	  Assert.assertEquals(statusCode,200);
	  Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
	  
//	  System.out.println(response.getBody().asString());
	  
	  JsonPath jsonPathEvaluator = response.jsonPath();
	  String fname = jsonPathEvaluator.getString("firstname");
	  
	  Assert.assertEquals(fname, "Jim");
	  Assert.assertEquals(jsonPathEvaluator.get("additionalneeds"),"Breakfast");
	  
//	  ResponseBody body = response.getBody();
//	  String bodyAsString = body.asString();
//	  System.out.println(bodyAsString);
}
}
