package APIReview;

import java.io.IOException;
import java.util.Arrays;
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
import com.google.gson.Gson;

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
//		response.then().log().all();
				
		Clusters[] clusters=new ObjectMapper().readValue(response.asString(), Clusters[].class);
		System.out.println(clusters.length);
		System.out.println(clusters[0].getId());
		System.out.println(clusters[0].getName());
		System.out.println(clusters[0].getRooms().get(0).getId());
		System.out.println(clusters[0].getRooms().get(0).getName());
		System.out.println(clusters[0].getRooms().get(0).getDescription());
		System.out.println(clusters[0].getRooms().get(0).getCapacity());
		System.out.println(clusters[0].getRooms().get(0).isWithTV());
		System.out.println(clusters[0].getRooms().get(0).isWithWhiteBoard());
		String format="%-12s%-3s%-14s%-12s%-10s%-5s%-11s%-12s%-18s%-40s%-15s%-3s%-8s%-6s%-16s%s%n";
		for(Clusters cluster:clusters) {
			for(Rooms room:cluster.getRooms()) {
			System.out.printf(format,"cluster id:",cluster.getId(),"cluster name:",cluster.getName(),"room id:",room.getId(),"room name:",room.getName(),"room description:",room.getDescription(),"room capacity:",room.getCapacity(),"withTV:",room.isWithTV(),"withWhiteBoard:",room.isWithWhiteBoard());
		}
		}
		
	}		 
}