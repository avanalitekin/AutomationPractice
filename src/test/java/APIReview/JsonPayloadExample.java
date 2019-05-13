package APIReview;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.Random;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import ModelClasses.Instructor;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonPayloadExample {
	@BeforeClass
	public void setUp() {
	RestAssured.baseURI="http://cybertekchicago.com";
	}
	@Test
	public void jsonPayLoadTest() throws JsonParseException, JsonMappingException, IOException {
	String firstName=new Faker().name().firstName();
	String lastName=new Faker().name().lastName();
	String subject=new Faker().educator().course();
	int batch=new Random().nextInt(20)+1;
	Instructor instructor=new Instructor();
	instructor.setFirstName(firstName);
	instructor.setLastName(lastName);
	instructor.setBatch(batch);
	instructor.setSubject(subject);
	Response postResponse=RestAssured.given().contentType(ContentType.JSON).body(instructor).and().post("/instructor/create");
	postResponse.then().statusCode(200);
	int instructorId=postResponse.jsonPath().get("id");
	
	Response getResponse=RestAssured.given().pathParam("id", instructorId).get("/instructor/{id}");
	getResponse.then().log().all().statusCode(200);
	
	String responseFirstName=getResponse.jsonPath().get("firstName");
	String responseLastName=getResponse.jsonPath().get("lastName");
	int responseBatch=getResponse.jsonPath().get("batch");
	String responseSubject=getResponse.jsonPath().get("subject");
	
	MatcherAssert.assertThat(instructor.getFirstName(),Matchers.is(responseFirstName));
	MatcherAssert.assertThat(instructor.getLastName(),Matchers.is(responseLastName));
	MatcherAssert.assertThat(instructor.getBatch(),Matchers.equalTo(responseBatch));
	MatcherAssert.assertThat(instructor.getSubject(),Matchers.is(responseSubject));
	
	Instructor instructor2=new ObjectMapper().readValue(getResponse.asString(), Instructor.class);
	
	MatcherAssert.assertThat(instructor.getFirstName(),Matchers.is(instructor2.getFirstName()));
	MatcherAssert.assertThat(instructor.getLastName(),Matchers.is(instructor2.getLastName()));
	MatcherAssert.assertThat(instructor.getBatch(),Matchers.equalTo(instructor2.getBatch()));
	MatcherAssert.assertThat(instructor.getSubject(),Matchers.is(instructor2.getSubject()));
	}

}
