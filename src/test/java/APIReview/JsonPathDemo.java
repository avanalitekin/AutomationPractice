package APIReview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPathDemo {
  @Test
  public void instructorAll(){
      Response response = RestAssured.get("http://cybertekchicago.com/instructor/all");
      response.then().log().body();
//    System.out.println(response.asString());
    JsonPath jp = response.jsonPath();
    List<String> instructorIds=jp.get("instructors.id");
    System.out.println(instructorIds);
    ArrayList<Integer> batchList=jp.get("instructors.batch");
//    Collections.sort(batchList);
    System.out.println(batchList);
    Set<Integer> batchSet=new TreeSet<Integer>(batchList);
    System.out.println(batchSet);
    ArrayList<String> subjectsList = jp.get("instructors.subject");
    System.out.println(subjectsList.size());
    List<Map<String,String>> instructors = jp.get("instructors");
//    System.out.println(instructors.size());
//    List<String> subjects=new ArrayList<String>();
//    for (Map<String,String> element:instructors) {
//  	  subjects.add(element.get("subject"));
//    }
//    System.out.println(subjects.size());
//    System.out.println(subjects);
    System.out.println("instructors: "+instructors);
 } 
  
  @Test
  public void instructorOne(){
      Response response = RestAssured.get("http://cybertekchicago.com/instructor/61");
      response.then().log().body();
//      System.out.println(response.asString());
      JsonPath jp = response.jsonPath();
      System.out.println("id: "+jp.get("id"));
      System.out.println("first name: "+jp.get("firstName"));
      System.out.println("last name: "+jp.get("lastName"));
      System.out.println("batch number: "+jp.get("batch"));
      System.out.println("subject: "+jp.get("subject"));
   }   
  @Test
  public void driverInfo() {
	  Response response=RestAssured.get("http://ergast.com/api/f1/drivers.json");
//	  response.then().log().all();
	  JsonPath jp=response.jsonPath();
	  List<Map<String,String>> driversMapList=jp.get("MRData.DriverTable.Drivers");
	  System.out.println(driversMapList.size());
	  Map<String, String> driverInfo=jp.get("MRData.DriverTable.Drivers[0]");
	  System.out.println(" Map<String, String> driverInfo=jp.get(\"MRData.DriverTable.Drivers[0]\");\n"+driverInfo);
	  String driverId=jp.get("MRData.DriverTable.Drivers[0].driverId");
	  String url=jp.get("MRData.DriverTable.Drivers[0].url");
	  String givenName=jp.get("MRData.DriverTable.Drivers[0].givenName");
	  String familyName=jp.get("MRData.DriverTable.Drivers[0].familyName");
	  String dateOfBirth=jp.get("MRData.DriverTable.Drivers[0].dateOfBirth");
	  String nationality=jp.get("MRData.DriverTable.Drivers[0].nationality");
	  System.out.println("driverId: "+driverId);
	  System.out.println("url: "+url);
	  System.out.println("givenName: "+givenName);
	  System.out.println("familyName: "+familyName);
	  System.out.println("dateOfBirth: "+dateOfBirth);
	  System.out.println("nationality: "+nationality);
  }
  @Test
  public void driverInfo2() {
	  Response response=RestAssured.get("http://ergast.com/api/f1/drivers.json");
//	  response.then().log().all();
	  JsonPath jp=response.jsonPath();
	  List<Map<String,String>> driversMapList=jp.get("MRData.DriverTable.Drivers");
	  System.out.println(driversMapList.size());
	  for(int i=0; i<driversMapList.size();i++) {
	  Map<String, String> driverInfo=jp.get("MRData.DriverTable.Drivers["+i+"]");
	  System.out.println("Map<String, String> driverInfo=jp.get(\"MRData.DriverTable.Drivers[\"+i+\"]\"); \n"+driverInfo);
	  System.out.println("Driver "+i+" info: ");
	  String driverId=jp.get("MRData.DriverTable.Drivers["+i+"].driverId");
	  String url=jp.get("MRData.DriverTable.Drivers["+i+"].url");
	  String givenName=jp.get("MRData.DriverTable.Drivers["+i+"].givenName");
	  String familyName=jp.get("MRData.DriverTable.Drivers["+i+"].familyName");
	  String dateOfBirth=jp.get("MRData.DriverTable.Drivers["+i+"].dateOfBirth");
	  String nationality=jp.get("MRData.DriverTable.Drivers["+i+"].nationality");
	  System.out.println("driverId: "+driverId);
	  System.out.println("url: "+url);
	  System.out.println("givenName: "+givenName);
	  System.out.println("familyName: "+familyName);
	  System.out.println("dateOfBirth: "+dateOfBirth);
	  System.out.println("nationality: "+nationality);
	  System.out.println("======================================");
	  } 

  }
  @Test
  public void driverInfo3() {
	  Response response=RestAssured.get("http://ergast.com/api/f1/drivers.json");
//	  response.then().log().all();
	  List<Map<String,String>> driversMapList=response.jsonPath().getList("MRData.DriverTable.Drivers");
	  System.out.println(driversMapList.get(0));
	  
	  Map<String,String> driversMap=response.jsonPath().getMap("MRData.DriverTable.Drivers[0]");
	  System.out.println(driversMap);
	  String drivername=response.jsonPath().getString("MRData.DriverTable.Drivers[0].givenName");
	  System.out.println(drivername);
	  } 

  
}
