package utilities;

import org.hamcrest.Matchers;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class WPUtility {
	private static Faker faker;
	
	public static int create_User(String role) {
			faker=new Faker();
			String user=faker.name().username();
//			String capabilities="capabilities.get("+role+")";//capabilities.subscriber or capabilities.author, etc.
			  Response response = (Response) RestAssured.given()
			  .relaxedHTTPSValidation()
			  .auth().preemptive().basic("avanalitekin", "3mersule")
			  .when()
			  .log().all()
			  .body("{"+
					  "\"username\":\""+user+ "\",\n"+
					  "\"name\":\""+user+"\",\n"+
					  "\"first_name\":\""+user+"\",\n"+
					  "\"last_name\":\""+user+"\",\n"+
					  "\"email\":\""+user+"@"+user+".com"+"\",\n"+
					  "\"roles\":\""+role+"\",\n"+
					  "\"password\":\""+user+"\"\n"+
					  "}")
			  .contentType(ContentType.JSON)
			  .post("users");
			  response.then().statusCode(201);
			  		
			  int new_UserID= response.jsonPath().getInt("id");
			  System.out.println("New User ID is "+new_UserID);
			  
			  return new_UserID;
		  }
	public static void update_User(String role, int id) {
		faker=new Faker();
		String user=faker.name().username();
		String capabilities="capabilities."+role;  
		  RestAssured.given()
		  .relaxedHTTPSValidation()
		  .auth().preemptive().basic("avanalitekin", "3mersule")
		  .when()
		  .log().all()
		  .body("{"+
				  "\"name\":\""+user+"\",\n"+
				  "\"first_name\":\""+user+"\",\n"+
				  "\"last_name\":\""+user+"\",\n"+
				  "\"email\":\""+user+"@"+user+".com"+"\",\n"+
				  "\"roles\":\""+role+"\",\n"+
				  "\"password\":\""+user+"\"\n"+
				  "}")
		  .contentType(ContentType.JSON)
		  .pathParam("id", id)
		  .put("users/{id}")
		  .then()
		  .log().all()
		  .contentType(ContentType.JSON)
		  .statusCode(200)
		  .body(capabilities, Matchers.is(true));
	  }
	
	public static void delete_User(int id) {
		  RestAssured.given()
		  .relaxedHTTPSValidation()
		  .auth().preemptive().basic("avanalitekin", "3mersule")
		  .queryParam("force", true)
		  .param("reassign", 1)
		  .when()
		  .log().all()
		  .pathParam("id", id)
		  .delete("users/{id}")
		  .then()
		  .log().all()
		  .contentType(ContentType.JSON)
		  .statusCode(200)
		  .body("deleted",Matchers.is(true))
		  ;
	  }
	
	
	}


