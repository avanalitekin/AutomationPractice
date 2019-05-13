package APIReview;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class QueryParameterDemo {
	  @BeforeClass
	  public void setUp() {
		  RestAssured.baseURI="https://uinames.com/api";  
	  }
	  
	  @Test
	  public void agetCityNameTest() {
		  given()
		  .queryParam("amount", "2")
		  .when()
		  .get("")
		  .prettyPrint();
		  
		  System.out.println(" ======== QUERY IN THE QUERY PARAM ABOVE AND QUERY IN THE URI BELOW ======== ");
		  
		  given()
		  .when()
		  .get("/?amount=2")
		  .prettyPrint();	  
		  
		  System.out.println(" ===============================================================");
		  System.out.println(" ===============================================================");
	  }
	  
	  @Test
	  public void bgetRegionNameTest() {
		 
		  
		  given()
		  .queryParam("region", "Colombia")
		  .when()
		  .get("")
		  .prettyPrint();
		  
		  System.out.println(" ======== QUERY IN THE QUERY PARAM ABOVE AND QUERY IN THE URI BELOW ======== ");
		  
		  given()
		  .get("/?region=Colombia")
		  .prettyPrint();
		  
		  System.out.println(" ===============================================================");
		  System.out.println(" ===============================================================");
		  
	  }
	  
	  @Test
	  public void cgetAmountAndRegionTest() {
		 
		  
		  given()
		  .queryParam("amount", "2")
		  .queryParam("region", "Colombia")
		  .when()
		  .get("")
		  .prettyPrint();
		  
		  System.out.println(" ======== QUERY IN THE QUERY PARAM ABOVE AND QUERY IN THE URI BELOW ======== ");
		  
		  given()
		  .get("/?amount=2&region=Colombia")
		  .prettyPrint();
		  
		  System.out.println(" ===============================================================");
		  System.out.println(" ===============================================================");
		  
	  }
	  
	  @Test
	  public void dgetAmountAndRegionGenderTest() {
		 
		  
		  given()
		  .queryParam("amount", "2")
		  .queryParam("region", "Colombia")
		  .queryParam("gender", "male")
		  .when()
		  .get("")
		  .prettyPrint();
		  
		  System.out.println(" ======== QUERY IN THE QUERY PARAM ABOVE AND QUERY IN THE URI BELOW ======== ");
		  
		  given()
		  .get("/?amount=2&region=Colombia&gender=male")
		  .prettyPrint();
		  
		  System.out.println(" ===============================================================");
		  System.out.println(" ===============================================================");
		  
	  }
	  
	  @Test
	  public void amountAndRegionTest(){
	      given().queryParam("amount", "2").
	              queryParam("region", "United States").
	              when().get().
	              prettyPrint();
	  }
	}