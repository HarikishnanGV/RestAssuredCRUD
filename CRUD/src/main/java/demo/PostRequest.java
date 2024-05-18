package demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PostRequest {

	@Test
	public void bookingApiPostService() {
		
		// sending payload via String
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";
		
		String bookingApiResponse=given().log().all().header("Content-Type","application/json")
				.body(Payload.createBookingPayload("Hari", "Krishnan")).when()
		.post("/booking").then().log().all().assertThat()
		.statusCode(200).extract().response().asString();
		
		JsonPath js=new JsonPath(bookingApiResponse);
		int id=js.getInt("bookingid");
		System.out.println("Id is created for the customer and value is --> "+id);
	}
	
}
