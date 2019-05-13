package APIReview;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

	public class ResponseBodyVerification {
		
		  @BeforeClass
		  public void setUp() {
			  RestAssured.baseURI="https://uinames.com/api";
		  }
		  
		  @Test
		  public void testBody() {
			  RestAssured.given()
			  .when()
			  .get()
			  .then()
//			  .assertThat()
			  .body("name", Matchers.notNullValue())
			  ;
			  
		  }
		  
		  @Test
		  public void testBody2() {
			  RestAssured.given()
			  .when()
			  .get()
			  .then()
//			  .assertThat()
			  .body("name", Matchers.notNullValue())
			  ;
			  
		  }
		  
		  @Test
		  public void testBody3() {
			  String region="Mexico";
			  RestAssured.given()
			  .queryParam("region", region)
			  .log().uri()
			  .when()
			  .get()
			  .then()
//			  .assertThat()
			  .body("region", Matchers.is(region))
			  .log().all();
			  ;
			  
		  }
		  
		  @Test
		  public void verifyNumberOfResults() {
			  RestAssured.given()
			  .queryParam("amount", 2)
			  .log().uri()
			  .when()
			  .get()
			  .then()
//			  .assertThat()
			  .body("$", Matchers.hasSize(2))
			  .log().all();
			  ;
		  }
		}
