package APIReview;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class StatusCodeValidation {

	@BeforeClass
	public void setUp() {
		RestAssured.baseURI = "https://uinames.com/api";
	}

	@Test
	public void testOK() {
		RestAssured.given()
		.log().all()
		.when()
		.get()
		.then()
		.log().all()
		.statusCode(200);
	}
	
//	@Test
	public void notFoundTest() {
		RestAssured.given()
		.log().all()
		.when()
		.get("/aflafa;lf")
		.then()
		.log().all()
		.statusCode(404);
	}
}
