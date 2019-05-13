package APIReview;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import ModelClasses.Cybertek.Students;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;

public class Pojo_Cybertek_Students {
	
	@Test
	public void oneStudentAPITest1() throws Exception {
	Response response=RestAssured.get("http://cybertekchicago.com/student/142");
	Students student=new ObjectMapper().readValue(response.asString(),Students.class);
	String format="%-15s%s%n";
	System.out.printf(format,"id:",student.getId());
	System.out.printf(format,"fist name:",student.getFirstName());
	System.out.printf(format,"last name:",student.getLastName());
	System.out.printf(format,"bach:",student.getBatch());
	System.out.printf(format,"contact id:",student.getContact().getContactId());
	System.out.printf(format, "phone:",student.getContact().getPhone());
	System.out.printf(format,"email address:",student.getContact().getEmailAddress());
	System.out.printf(format,"company id:",student.getCompany().getCompanyId());
	System.out.printf(format,"company name:",student.getCompany().getCompanyName());
	System.out.printf(format,"title:",student.getCompany().getTitle());
	System.out.printf(format,"start date:",student.getCompany().getStartDate());
	System.out.printf(format,"address id:",student.getCompany().getAddress().getAddressId());
	System.out.printf(format,"street:",student.getCompany().getAddress().getStreet());
	System.out.printf(format,"city:",student.getCompany().getAddress().getCity());
	System.out.printf(format,"state:",student.getCompany().getAddress().getState());
	System.out.printf(format,"zip code:",student.getCompany().getAddress().getZipCode());
	
	}
	
	@Test
	public void allStudentsAPITest() throws Exception {
		Response response=RestAssured.get("http://cybertekchicago.com/student/all");
		Students students=new ObjectMapper().readValue(response.asString(),Students.class);
		String format1="%-15s%s%n";
		System.out.printf(format1,"students size:",students.getStudents().size());
		for(Students student:students.getStudents()) {
			String format2="%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%s%n";
			System.out.printf(format2,"first name:",student.getFirstName(),"last name:",student.getLastName(),"phone:",student.getContact().getPhone(),"company",student.getCompany().getCompanyName(),"city",student.getCompany().getAddress().getCity());
		}
		System.out.println();
	}

}
