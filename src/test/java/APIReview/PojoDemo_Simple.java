package APIReview;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ModelClasses.Person1;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PojoDemo_Simple {
	@Test
	public void personTest() throws IOException {
		String personString="{\"name\":\"Ali\",\"age\":45}";
		Person1 person=new ObjectMapper().readValue(personString, Person1.class);
		System.out.println(person);
		String backToPerson1String=new ObjectMapper().writeValueAsString(person);
		System.out.println(backToPerson1String);
	}
	
	@Test
	public void driversTest() {
		 Response response=RestAssured.get("http://ergast.com/api/f1/drivers.json");
//		  response.then().log().all();
		  JsonPath jp=response.jsonPath().get("MRData.DriverTable.Drivers");
		  System.out.println(jp.toString());
////		  List<Map<Drivers,Drivers>> driversInfo=new ObjectMapper().readValue(jp.get("MRData.DriverTable.Drivers"), ArrayList<Map<Drivers,Drivers>>.class);
//		  String[] driversInfoArr=jp.get("MRData.DriverTable.Drivers");
//		  System.out.println(driversInfo);
//		  System.out.println(Arrays.toString(driversInfoArr));
		  
	}

}


