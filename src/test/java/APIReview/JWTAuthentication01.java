package APIReview;

import utilities.DBUtility;
import utilities.APIUtility;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class JWTAuthentication01 {
	String token;
	
	@Test (priority=0)
	public void getToken() {
	RestAssured.baseURI="https://www.avanalitekin-api-testing.dev.cc";
	RestAssured.basePath="/wp-json/jwt-auth/v1";
	
	Response response=RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.URLENC)
			.formParam("username", "avanalitekin").formParam("password", "3mersule").post("/token");
	response.then().log().all();
	token="Bearer "+response.jsonPath().get("token");
	System.out.println(token);
	}
	
//	@Test (priority=1)
	public void postPostsWithToken() {
		RestAssured.baseURI="https://www.avanalitekin-api-testing.dev.cc";
		RestAssured.basePath="/wp-json/wp/v2";
		String title=new Faker().gameOfThrones().quote();
		String content=new Faker().shakespeare().asYouLikeItQuote();
		String postString="{\r\n" + 
				"	\"title\":"+"\""+title+"\""+",\r\n" + 
				"	\"content\":"+"\""+content+"\""+",\r\n" + 
				"	\"categories\" : [1],\r\n" + 
				"	\"tags\" : [2,4],\r\n" + 
				"	\"status\": \"publish\"\r\n" + 
				"}";
		RestAssured.given().relaxedHTTPSValidation()
		.header("Authorization",token)
		.header("Content-Type","application/json")
		.body(postString)
		.log().all()
		.post("/posts").then().statusCode(201).body("status", Matchers.is("publish"));
		
	}
	
//	@Test (priority=2)
	public void postUserWithJWT() {
		RestAssured.baseURI="https://www.avanalitekin-api-testing.dev.cc";
		RestAssured.basePath="/wp-json/wp/v2";
		String[] roles= {"subscriber", "contributor", "author", "editor" };
		String role=roles[new Random().nextInt(roles.length)];
		String user=new Faker().name().username();
		String email=user+"@"+user+".com";
		Map<String,String> wp2User=new HashMap<>();
		wp2User.put("username", user);
		wp2User.put("name", user);
		wp2User.put("first_name", user);
		wp2User.put("last_name", user);
		wp2User.put("email", email);
		wp2User.put("roles", role);
		wp2User.put("password", user);
		
		RestAssured.given().relaxedHTTPSValidation()
		.header("Authorization", token).header("Content-Type", "application/json")
		.body(wp2User).post("/users").then().statusCode(201);
		
		DBUtility.getConnectionWP2DB();
		DBUtility.executeQuery("select display_name, user_email from wp_users where user_email='"+email+"';");
		Assert.assertEquals(DBUtility.getDataOnAColumn("display_name").get(0), user);
		Assert.assertEquals(DBUtility.getDataOnAColumn("user_email").get(0), email);
		DBUtility.closeConnection();
	}

}
