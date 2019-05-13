package utilities;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BookItAPIUtility {
	public static String getAccessToken() {
		Response response=RestAssured.given().queryParam("email", "teacherva5@gmail.com").queryParam("password", "maxpayne")
				.get("https://cybertek-reservation-api-qa.herokuapp.com/sign");
		String accessToken=response.jsonPath().get("accessToken");
		return accessToken;
	}

}
