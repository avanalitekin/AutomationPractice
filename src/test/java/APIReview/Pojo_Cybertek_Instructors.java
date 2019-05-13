package APIReview;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import ModelClasses.Cybertek.Instructors;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Pojo_Cybertek_Instructors {
	@Test
	public void oneInstructorTest() throws Exception {
	Response response=RestAssured.get("http://cybertekchicago.com/instructor/129");
	Instructors instructor=new ObjectMapper().readValue(response.asString(), Instructors.class);
	
		String format="%-15s%s%n";
	System.out.printf(format,"id:",instructor.getId());
	System.out.printf(format,"first name:",instructor.getFirstName());
	System.out.printf(format,"last name:",instructor.getLastName());
	System.out.printf(format,"batch:",instructor.getBatch());
	System.out.printf(format,"subject:",instructor.getSubject());
	
	}
	
	@Test
	public void allInstructorTest() throws Exception {
	Response response=RestAssured.get("http://cybertekchicago.com/instructor/all");
	Instructors instructors=new ObjectMapper().readValue(response.asString(), Instructors.class);
	System.out.println(instructors.getInstructors().size());
	for(Instructors instructor:instructors.getInstructors()) {
		String format="%-5s%-5s%-12s%-15s%-12s%-15s%-8s%-5s%-12s%s%n";
		System.out.printf(format, "id:",instructor.getId(),"first name:",instructor.getFirstName(),"last name:",instructor.getLastName(),"batch",instructor.getBatch(),"subject:",instructor.getSubject());
	}
	System.out.println();
	
	}

}
