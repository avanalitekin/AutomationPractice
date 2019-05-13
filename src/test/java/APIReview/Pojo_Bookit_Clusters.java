package APIReview;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import ModelClasses.Bookit.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.BookItAPIUtility;

public class Pojo_Bookit_Clusters {
	String token;
	String teamName;
	String batch="8";
	
	@BeforeClass
	public void setUp() {
		token=BookItAPIUtility.getAccessToken();
		RestAssured.baseURI="https://cybertek-reservation-api-qa.herokuapp.com";
	}
	@Test 
	public void clusterAPITest() throws Exception {
		
		System.out.println(token);
		
		Response response=RestAssured.given()
				  .header("Authorization",token)
				  .get("/api/clusters");
		response.then().log().all();
		
		
		Clusters clusters=new ObjectMapper().readValue(response.asString(), Clusters.class);
		System.out.println(clusters.getClusters());
	}		 
}