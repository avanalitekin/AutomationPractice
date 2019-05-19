package APIReview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import ModelClasses.Person;
import ModelClasses.Person1;
import ModelClasses.drivers.DriverData;
import ModelClasses.drivers.DriverTable;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.Driver;

public class Pojo_JsonPathDemo_Drivers {
	@Test
	public void personTest() throws IOException {
		String personString="{\"name\":\"Ali\",\"age\":45}";
		Person1 person=new ObjectMapper().readValue(personString, Person1.class);
		System.out.println(person);
		System.out.println(person.getName());
		System.out.println(person.getAge());
		String backToPerson1String=new ObjectMapper().writeValueAsString(person);
		System.out.println(backToPerson1String);
	}
	
	@Test
	public void testString() {
		String js="{\r\n" + 
				"        \"xmlns\": \"http://ergast.com/mrd/1.4\",\r\n" + 
				"        \"series\": \"f1\",\r\n" + 
				"        \"url\": \"http://ergast.com/api/f1/drivers.json\",\r\n" + 
				"        \"limit\": \"30\",\r\n" + 
				"        \"offset\": \"0\",\r\n" + 
				"        \"total\": \"847\"}";
		DriverData driverData=new Gson().fromJson(js, DriverData.class);
		System.out.println(driverData.getTotal());
	}
	
	@Test
	public void driversTestWithJsonPath() throws Exception {
		 Response response=RestAssured.get("http://ergast.com/api/f1/drivers.json");
//		  response.then().log().all();
		 String total=response.jsonPath().getString("MRData.total") ;
		 System.out.println(total);
		 List<Map<Object, Object>> map=response.jsonPath().get("MRData.DriverTable.Drivers");
		 System.out.println(map.get(0).get("driverId"));
		 System.out.println(map.get(0).get("url"));
		 System.out.println(map.get(0).get("givenName"));
		 System.out.println(map.get(0).get("familyName"));
		 System.out.println(map.get(0).get("dateOfBirth"));
		 System.out.println(map.get(0).get("nationality"));
		 System.out.println();
 
	}
	
	@Test
	public void driverTestWithPojo() throws Exception {
		Response response=RestAssured.get("http://ergast.com/api/f1/drivers.json");
//		response.then().log().all();
		

//		DriverData driverData=new ObjectMapper().readValue(response.asString(), DriverData.class); //for some reason this is not working
		DriverData driverData=new Gson().fromJson(response.asString(), DriverData.class);
		System.out.println("==============================");
		System.out.println(driverData);
		System.out.println("==============================");
		System.out.println(driverData.getMRData().getTotal());
		System.out.println(driverData.getMRData().getDriverTable().getDrivers().get(0).getFamilyName());
		System.out.println(driverData.getMRData().getDriverTable().getDrivers().size());
		System.out.println("==============================");
		
	String format="%-11s%-15s%-13s%-11s%-16s%-12s%-12s%-12s%-14s%-14s%-5s%10s%n";
	for(DriverTable driver:driverData.getMRData().getDriverTable().getDrivers()) {
		System.out.printf(format,"Driver id:",driver.getDriverId(),"Driver name:",driver.getGivenName(),"Driver lastname:",driver.getFamilyName(),"Driver DOB:",driver.getDateOfBirth(),"Nationality:",driver.getNationality(),"URL:",driver.getUrl());
	}
	
	}
}


