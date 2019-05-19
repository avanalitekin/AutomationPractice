package APIReview;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ModelClasses.Person;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PojoDemo_Person {
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI="https://uinames.com/api";
	}
	@Test
	public void GAndOMTest1() throws Exception {
		Person person=new Person();
		person.setName("Ali");
		person.setSurname("Tekin");
		person.setGender("Male");
		person.setRegion("America");
		
		String jsonStringFromOM=new ObjectMapper().writeValueAsString(person);
		System.out.println(jsonStringFromOM);
		String jsonStringFromG=new Gson().toJson(person);
		System.out.println(jsonStringFromG);
		
		Person backToPersonOM=new ObjectMapper().readValue(jsonStringFromG, Person.class);
		Person backToPersonG=new Gson().fromJson(jsonStringFromOM, Person.class);
		System.out.println(backToPersonOM.getName());
		System.out.println(backToPersonOM.getSurname());
		System.out.println(backToPersonOM.getGender());
		System.out.println(backToPersonOM.getRegion());
		
		System.out.println(backToPersonG.getName());
		System.out.println(backToPersonG.getSurname());
		System.out.println(backToPersonG.getGender());
		System.out.println(backToPersonG.getRegion());
	}
	@Test
	public void GAndOMTest2() throws IOException {
	Person person =new Person();
	person.setName("Ali");
	person.setSurname("Tekin");
	String jsonStringWithG=new Gson().toJson(person);
	System.out.println(jsonStringWithG);
	String jsonSTringWithOM=new ObjectMapper().writeValueAsString(person);
	System.out.println(jsonSTringWithOM);
	
	Person backToPersonOM=new ObjectMapper().readValue(jsonStringWithG, Person.class);
	System.out.println(backToPersonOM.getName());
	System.out.println(backToPersonOM.getSurname());
	System.out.println(backToPersonOM.getGender());
	System.out.println(backToPersonOM.getRegion());
	
	Person backToPersonG=new Gson().fromJson(jsonStringWithG, Person.class);
	System.out.println(backToPersonG.getName());
	System.out.println(backToPersonG.getSurname());
	System.out.println(backToPersonG.getGender());
	System.out.println(backToPersonG.getRegion());
	}
	
	@Test
	public void testWithAPI() throws IOException {
	Response response=RestAssured.get("");
	response.then().log().all();
	String jsonString=response.asString();
	System.out.println("jsonString "+jsonString);
	Person person=new Gson().fromJson(jsonString, Person.class);
	Person person2=new ObjectMapper().readValue(jsonString, Person.class);
	System.out.println(person.getName());
	System.out.println(person.getSurname());
	System.out.println(person.getGender());
	System.out.println(person.getRegion());
	
	System.out.println(person2.getName());
	System.out.println(person2.getSurname());
	System.out.println(person2.getGender());
	System.out.println(person2.getRegion());
	
	Person person3=new Gson().fromJson(response.asString(), Person.class);
	Person person4=new ObjectMapper().readValue(response.asString(), Person.class);
	
	System.out.println(person3.getName());
	System.out.println(person3.getSurname());
	System.out.println(person3.getGender());
	System.out.println(person3.getRegion());
	
	System.out.println(person4.getName());
	System.out.println(person4.getSurname());
	System.out.println(person4.getGender());
	System.out.println(person4.getRegion());
	}
	@Test
	public void testWithQueryParam() {
	Response response=RestAssured.given().queryParam("amount", 9).when().get();
	response.then().statusCode(200);
	response.then().log().all();
	List<Person> persons=response.jsonPath().getList("",Person.class);
	for(Person person:persons) {
		String format="%-10s%-10s%-10s%-10s%-10s%-10s%-10s%10s%n";
		System.out.printf(format, "name:",person.getName(),"last name:",person.getSurname(),"gender:",person.getGender(),"region",person.getRegion());
	}
		System.out.println(persons.get(8).getSurname());
	}

}
