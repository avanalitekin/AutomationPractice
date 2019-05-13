package APIReview;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class WP1_API_Users {
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI="https://avanalitekin.dev.cc/wp-json";
		RestAssured.basePath="/wp/v2";
	}
//	@Test
	public void getUsersNoAuthTest() {
		RestAssured.given().relaxedHTTPSValidation()
		.get("/users")
		.then()
		.log()
		.ifValidationFails()
		.statusCode(200)
		.body("id",Matchers.hasSize(1))
		.body("name",Matchers.hasItem("avanalitekin"))
		.header("Content-Type", "application/json; charset=UTF-8");
	}
//	@Test
	public void getUsersWithAuthTest() {
		RestAssured.given().relaxedHTTPSValidation()
		.auth()
		.preemptive() //this makes it to get all users, without this only one user will be visible
		.basic("avanalitekin", "3mersule")  
		.get("/users")
		.then()
		.log()
		.ifValidationFails()
		.statusCode(200)
		.body("id",Matchers.hasSize(10))
		.body("name",Matchers.hasItem("avanalitekin"))
		.header("Content-Type", "application/json; charset=UTF-8");
	}
	
//	@Test
	public void postUserTest() {
		RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("avanalitekin", "3mersule").contentType(ContentType.JSON).body("{"+
				"\"username\" : \"user77\",\n" + 
				"\"name\" : \"user77\",\n" + 
				"\"first_name\" : \"firstname77\",\n" + 
				"\"last_name\" : \"lastname77\",\n" + 
				"\"email\" : \"user77@gmail.com\",\n" + 
				"\"url\" : \"http://www.user77.com\",\n" + 
				"\"description\" : \"This is  user 77\",\n" + 
				"\"locale\" : \"en_US\",\n" + 
				"\"nickname\" : \"user77\",\n" + 
				"\"slug\" : \"user77onWP1\",\n" + 
				"\"roles\" : \"author\",\n" + 
				"\"password\" : \"user77\"\n" + 
				"}").post("/users").then().log().all().statusCode(201).body("capabilities.author", Matchers.is(true));
	}
	
//	@Test
	public void updateUserTest() {
		RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("avanalitekin", "3mersule").contentType(ContentType.JSON).body("{"+
				"\"username\" : \"user77\",\n" + 
				"\"name\" : \"user77\",\n" + 
				"\"first_name\" : \"firstname77\",\n" + 
				"\"last_name\" : \"lastname77\",\n" + 
				"\"email\" : \"user77@gmail.com\",\n" + 
				"\"url\" : \"http://www.user77.com\",\n" + 
				"\"description\" : \"This is  user 77\",\n" + 
				"\"locale\" : \"en_US\",\n" + 
				"\"nickname\" : \"user77\",\n" + 
				"\"slug\" : \"user77onWP1\",\n" + 
				"\"roles\" : \"subscriber\",\n" + 
				"\"password\" : \"user77\"\n" + 
				"}").put("/users/50").then().log().all().statusCode(200).body("capabilities.subscriber", Matchers.is(true));
	}
//	@Test
	public void deleteUserTest() {
		RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("avanalitekin", "3mersule").queryParam("force", true).queryParam("reassign", 1).delete("/users/52").then().log().all().statusCode(200).body("deleted", Matchers.is(true));
	}
	
//	@Test
	public void user_can_see_self_info() {
		RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("user1", "user1").get("/users/3").then().log().all().statusCode(200).body("id", Matchers.is(3));
	}
//	@Test
	public void user_can_see_admin_info() {
		RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("user1", "user1").get("/users/1").then().log().all().statusCode(200).body("id", Matchers.is(1));
	}
	
//	@Test
	public void everyone_can_see_admin_info() {
		RestAssured.given().relaxedHTTPSValidation().get("/users/1").then().log().all().statusCode(200).body("id", Matchers.is(1));
	}
	@Test
	public void user_cannot_see_other_user_info() {
		RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("user1", "user1").get("/users/5").then().log().all().statusCode(HttpStatus.SC_FORBIDDEN).body("message", Matchers.is("Sorry, you are not allowed to list users."));
	}

}
