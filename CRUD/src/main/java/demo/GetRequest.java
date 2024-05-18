package demo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class GetRequest {

	@Test
	public void bookingApi() {
		
		RestAssured.baseURI="https://restful-booker.herokuapp.com";

	//Step 1 : Get Booking ID
		
	String response=given().when().get("/booking")
				.then().log().all().assertThat().statusCode(200)
				.extract().response().asString();
		
		JsonPath js=new JsonPath(response);
	
	int numberOfId=	js.getList("bookingid").size();
	System.out.println("Total number of Id --> "+numberOfId);
	int selectRandomIndex=BasePage.getRandomNumber(numberOfId);
	String selectedIdValue=js.getString("["+selectRandomIndex+"].bookingid");
	System.out.println("Selected BookingId is--> "+selectedIdValue);
	
	// Step 2: Get Booking Details for the selected ID
	
	String bookingDetailsResponse=given().log().all().pathParam("key", selectedIdValue).when()
			.get("/booking/{key}")
			.then().log().all().assertThat().statusCode(200)
			.extract().response().asString();
	
	JsonPath js1=new JsonPath(bookingDetailsResponse);
	String firstName=js1.get("firstname").toString();
	String lastName=js1.get("lastname").toString();
	
	System.out.println("Customer full name is --> "+firstName.concat(lastName));
		
	}
}
