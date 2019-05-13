package APIReview;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import ModelClasses.ClusterRooms;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utilities.BookItAPIUtility;
public class JsonPathDemoBookIt {
	String token;
	String teamName;
	String batch="8";
	
	@BeforeClass
	public void setUp() {
		token=BookItAPIUtility.getAccessToken();
		RestAssured.baseURI="https://cybertek-reservation-api-qa.herokuapp.com";
	}
	@Test 
	public void clusterAPITest() {
		
		System.out.println(token);
		
		Response response=RestAssured.given()
				  .header("Authorization",token)
				  .get("/api/clusters");
		
		 JsonPath jp=response.jsonPath();
//		 List<Object> clusters=jp.get();
//		 System.out.println("clusters.size(): "+clusters.size());
//		 String id=jp.getString("id");
//		 System.out.println(id);
//		 System.out.println(id.charAt(1));
//		 List<String> idNumbersArrList=jp.get("id");
//		 System.out.println(idNumbersArrList); //even though this works, the one below does not work
//		 System.out.println(idNumbersArrList.get(0));
//		 List<Integer> idnumbers=jp.get("id");
//		 System.out.println(idnumbers);
//		 System.out.println(idnumbers.get(0));
//		 Integer id0=jp.getInt("id[0]");
//		 System.out.println(id0);
//		 String idZero=jp.getString("id[0]");
//		 System.out.println(idZero);
//		 List<Integer> roomNumbers=jp.get("rooms[0].id");
//		 System.out.println(roomNumbers);
//		 Integer roomNumber=jp.getInt("rooms[0].id[0]");
//		 System.out.println(roomNumber);
		 
//		 Map<String,String> cluster1String=jp.getMap("rooms[0][0]",String.class,String.class);
		 Map<String,String> cluster1room1=jp.getMap("rooms[0][0]",String.class,String.class);
		 System.out.println(cluster1room1);
		 for(String str:cluster1room1.values()) {
			 System.out.println(str);
		 }
		 
//	 List<Map<String,Object>> cluster1roomsAll=jp.getList("rooms[0]");
//		 System.out.println(cluster1roomsAll);
//		 for(int i=0; i<cluster1roomsAll.size();i++) {
//			 System.out.println("=================== ROOM "+(i+1)+" INFORMATION =================== ");
//			 for(Entry<String, Object> entry:cluster1roomsAll.get(i).entrySet()) {
//				 String format="%-20s%-20s%-20s%s%n";
//				 System.out.printf(format,"entry.getKey():",entry.getKey(),"  Entry.getValue(): ",entry.getValue());
//			 }
//		}
		 List<ClusterRooms> rooms=jp.getList("rooms[0]",ClusterRooms.class);
		 for(int i=0; i<rooms.size(); i++) {
			 String format="%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%s%n";
			 System.out.println("======== ROOM"+(i+1)+" INFORMATION ========");
			 System.out.printf(format,"id:",rooms.get(i).getId(),"name",rooms.get(i).getName(),"capacity:",rooms.get(i).getCapacity(),"isWithTV:",rooms.get(i).isWithTV(),"isWithWhiteBoard:",rooms.get(i).isWithWhiteBoard(),"description:",rooms.get(i).getDescription());
		 }
		 
		 
//		 Map<String,String> cluster1String=jp.getMap("rooms[0][0]",String.class,String.class);
//		 System.out.println(cluster1String);
//		 for(String str:cluster1String.values()) {
//			 System.out.println(str);
//		 }
		 
		 List<List<Map<String,Object>>> roomsInfo=jp.get("rooms");
		 System.out.println(roomsInfo);
		 for(int i=0; i<roomsInfo.size();i++) {
			 for(int j=0; j<roomsInfo.get(i).size(); j++) {
				 String format2="%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%-12s%s%n";
				 System.out.printf(format2,"room id:",roomsInfo.get(i).get(j).get("id"),"room name:",roomsInfo.get(i).get(j).get("name"),"room capacity:",roomsInfo.get(i).get(j).get("capacity")
						 ,"withTV:",roomsInfo.get(i).get(j).get("withTV"),"withWhiteBoard:",roomsInfo.get(i).get(j).get("withWhiteBoard"),"description:",roomsInfo.get(i).get(j).get("description"));
			 }
		 }
		 
		 
//		 for(Entry<String, String> entry:roomsInfo.get(i).entrySet()) {
//			 System.out.println("entry.getKey(): "+entry.getKey()+"  Entry.getValue(): "+entry.getValue());
//		 }
//	}
}
	@Test
	public void postTeam() {
		teamName=new Faker().team().name();
		String  teamNumber=batch;
		
		Response response=RestAssured.given()
		.log().all()
		.header("Authorization",token)
		.queryParam("campus-location", "VA")
		.queryParam("batch-number", teamNumber)
		.queryParam("team-name", teamName)
		.when()
		.post("/api/teams/team");
		
		response.then().statusCode(201);
		System.out.println(response.asString());
		String expectedString="team "+teamName+" has been added to the batch "+8+".";
		MatcherAssert.assertThat(response.asString(), Matchers.is(expectedString));
		
	}
	
	@Test (dependsOnMethods= {"postTeam"} )
	public void postStudent() {
		String firstName=new Faker().name().firstName();
		String lastName=new Faker().name().lastName();
		String email=new Faker().internet().emailAddress();
		String password=new Faker().internet().password();
		String role="student-team-member";
		String campus="VA";
		String batchNumber=batch;
		String teamN=teamName;
		
		Response response=RestAssured.given()
				.header("Authorization", token)
				.queryParam("first-name", firstName)
				.queryParam("last-name", lastName)
				.queryParam("email", email)
				.queryParam("password", password)
				.queryParam("role", role)
				.queryParam("campus-location", campus)
				.queryParam("batch-number", batchNumber)
				.queryParam("team-name", teamN)
				.when()
				.post("/api/students/student");
		
		response.then().statusCode(201);
		System.out.println(response.asString());
		MatcherAssert.assertThat(response.asString(),Matchers.is("user "+firstName+" "+lastName+" has been added to database."));
	}
}