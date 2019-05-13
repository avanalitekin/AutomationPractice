package APIReview;

import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
//http://jsonpathfinder.com/
public class ResponseManipulation {
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI="https://avanalitekin.dev.cc/";
		RestAssured.basePath="wp-json/wp/v2/";
	}
//	@Test
	public void getWP1UsersTest() {
		Response response=RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("avanalitekin", "3mersule")
		.get("users");
//		response.then().log().all();
		String username1=response.jsonPath().getString("name[0]");
//		System.out.println(username1);
		String username2=response.jsonPath().getString("name[1]");
		System.out.println();
//		System.out.println(username2);
		List<Map<String,String>> usersMapList=response.jsonPath().get();
		for(int i=0; i<usersMapList.size();i++) {
			String format="%-15s%s%n";
			System.out.printf(format,"user "+(i+1)+" name:",response.jsonPath().getString("name["+i+"]"));
			System.out.printf(format,"user "+(i+1)+" id:",response.jsonPath().getString("id["+i+"]"));
			System.out.printf(format,"user "+(i+1)+" link:",response.jsonPath().getString("link["+i+"]"));
		}
	}
	
	@Test
	public void getWP1PostsTests() {
		Response response=RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("avanalitekin", "3mersule").get("posts");
		JsonPath jp=response.jsonPath();
		System.out.println("jp.get(\"id\"): "+jp.get("id"));
		System.out.println("jp.gejp.get(\"id[o]\"): "+jp.get("id[0]"));
		System.out.println("jp.get(\"_links.self.href\") "+jp.get("_links.self.href"));
		System.out.println("jp.get(\"_links.self.href[0]\") "+jp.get("_links.self.href[0]"));
		System.out.println("jp.get(\"_links.self.href[0][0]\") "+jp.get("_links.self.href[0][0]"));
		System.out.println("jp.get(\"_links.self.href[0][0]\") "+jp.get("_links.self.href[1][0]"));
		List<String> postList=jp.get();
		for(int i=0; i<postList.size(); i++) {
			String format="%-18s%s%n";
			System.out.printf(format,"href for post "+(i+1), jp.get("_links.self.href["+i+"][0]"));
		}
	}
	
//	@Test
	public void getDriversTest() {
		Response response=RestAssured.given().get("http://ergast.com/api/f1/drivers.json");
		response.then().log().all();
		List<Map<String,String>> driversMapList=response.jsonPath().get("MRData.DriverTable.Drivers");
		List<String> driversList=response.jsonPath().get("MRData.DriverTable.Drivers");
		System.out.println(driversMapList.size());
		System.out.println(driversList.size());
		for(int i=0; i<driversMapList.size();i++) {
			String format="%-22s%s%n";
			System.out.printf(format, "Driver "+(i+1)+" name:",response.jsonPath().get("MRData.DriverTable.Drivers["+i+"].givenName"));
			System.out.printf(format,"Driver "+(i+1)+" lastname:",response.jsonPath().get("MRData.DriverTable.Drivers["+i+"].familyName"));
			System.out.printf(format,"Driver "+(i+1)+" id:",response.jsonPath().get("MRData.DriverTable.Drivers["+i+"].driverId"));
			System.out.printf(format, "Driver "+(i+1)+" DOB:",response.jsonPath().get("MRData.DriverTable.Drivers["+i+"].dateOfBirth"));
			System.out.printf(format, "Driver "+(i+1)+" nationality:",response.jsonPath().get("MRData.DriverTable.Drivers["+i+"].nationality"));
			System.out.println();
		}	
	}

}
