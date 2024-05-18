package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
//import io.restassured.http.ContentType;


//http://demo.guru99.com/V4/sinkministatement.php?CUSTOMER_ID=68195&PASSWORD=1234!&Account_No=1

public class CRUD {

	@Test
	public void getMethod() {
		
		RestAssured.baseURI="http://demo.guru99.com/";
		String response=given().log().all().queryParam("CUSTOMER_ID", "68195")
				.queryParam("PASSWORD", "1234!").queryParam("Account_No","1")
				.when().get("V4/sinkministatement.php").then().log().all().extract()
				.response().asString();
		
//		JsonPath js=new JsonPath(response);
//		String id=js.get("[\"result:\"].statements[0].TRANSACTION_ID");
//		System.out.println(id);
       
        
	System.out.println("I am From Get Method");
	}
}
