package demo;

public class Payload {

	
	public static String createBookingPayload(String firstName,String lastName) {
		
		String payload="{\r\n"
				+ "    \"firstname\" : \""+firstName+"\",\r\n"
				+ "    \"lastname\" : \""+lastName+"\",\r\n"
				+ "    \"totalprice\" : 150,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}";
		
		return payload;
		
	}
}
