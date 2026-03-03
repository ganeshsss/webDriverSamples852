package APITesting;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


@Test

public class tagapi {

	 public void TagApi() {

		  
		  RestAssured.baseURI = "https://conduit-realworld-example-app.fly.dev";
		  
		  Response resp = RestAssured.get("/api/tags");
		  int statuscode = resp.getStatusCode();
		  Assert.assertEquals(statuscode, 200);
		  Assert.assertEquals(resp.getContentType(), "application/json; charset=utf-8");
		  ResponseBody body =resp.getBody();
		  String bodyasstring = body.asString();
		  System.out.println(bodyasstring);

	  }
	}


