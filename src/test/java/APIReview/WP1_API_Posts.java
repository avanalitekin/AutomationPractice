package APIReview;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.hamcrest.MatcherAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
// https://developer.wordpress.org/rest-api/reference/posts
public class WP1_API_Posts {
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI="https://avanalitekin.dev.cc/wp-json";
		RestAssured.basePath="/wp/v2";
	}
	
	@Test
	public void getPostSatusTest() {
		RestAssured.given().relaxedHTTPSValidation().get("/posts/17").then()
//		.log()
//		.all()
		.statusCode(200);
	}
	
	@Test
	public void verifyBodyTest() {
		RestAssured.given().relaxedHTTPSValidation()
//		.log().all()
		.get("/posts/{id}",9).then().statusCode(200).and()
//		.body("id",Matchers.equalTo(9))
		.body("id",equalTo(9))
		.body("title.rendered",equalTo("THIS TITLE UPDATED ON POSTMAN"))
		.body("content.protected",equalTo(false))
		.body("author",equalTo(1))
		.body("status",equalTo("publish"));
	}
	@Test
	public void testWithHamcrest() {
		int a=5;
		int b=6;
		int c=5;
		MatcherAssert.assertThat(a, Matchers.equalTo(c));
		MatcherAssert.assertThat(b,Matchers.greaterThan(a));
		assertThat(a,equalTo(c));
		assertThat(b,greaterThan(a));
		assertThat(c,Matchers.lessThan(b));
	}
	@Test
	public void ifValidationFailsTest() {
		RestAssured.given().relaxedHTTPSValidation().queryParam("per_page", 1).get("/posts").then().log().ifValidationFails().statusCode(200)
		.and().body("id", hasItem(39))
		.body("title.rendered", hasItem("THIS POST COMES AFTER POST 27"));
	}
	
	@Test
	public void prettyPrintBody() {
		RestAssured.given().relaxedHTTPSValidation().get("/posts").prettyPrint();
	}
	
	@Test
	public void postTest() {
		RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("avanalitekin", "3mersule")
		.contentType(ContentType.JSON).when().body("{\r\n" + 
				"	\"title\":\"Automation post\",\r\n" + 
				"	\"content\":\"this post is sent from automation framework\",\r\n" + 
				"	\"tags\" : [1],\r\n" + 
				"	\"status\":\"publish\"\r\n" + 
				"}").post("/posts").then().statusCode(201);
	}
	@Test
	public void putTest() {
		RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("avanalitekin", "3mersule").contentType(ContentType.JSON).body("{\r\n" + 
				"	\"title\":\"Automation post updated\",\r\n" + 
				"	\"content\":\"THIS POST WAS SENT FROM AUTOMATION FRAMEWORK AS AN UPDATE TO AN EXISTING POST\",\r\n" + 
				"	\"tags\" : [1],\r\n" + 
				"	\"status\":\"publish\"\r\n" + 
				"}").put("/posts/34").then().statusCode(200);
	}
	
	@Test
	public void trashPost() {
		RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("avanalitekin","3mersule").delete("/posts/34")
		.then().log().all().statusCode(200).and().body("delete", is("true"));
	}
	
	@Test
	public void deletePost() {
		RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("avanalitekin","3mersule").queryParam("force", true).delete("/posts/40")
		.then().log().all().statusCode(200).and().body("deleted", is(true));
	}

}
