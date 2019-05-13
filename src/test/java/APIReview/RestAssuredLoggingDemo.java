package APIReview;

import org.testng.annotations.Test;

import io.restassured.RestAssured;


	public class RestAssuredLoggingDemo {
		  @Test
		  public void logginTest() {
			  System.out.println("\n==============all================\n");
			  
			  RestAssured.given()
			  .log().all()
			  .when().get("https://uinames.com/api");
			  
			  System.out.println("\n=============method================\n");
			  
			  RestAssured.given()
			  .log().method()
			  .when().get("https://uinames.com/api");
			  
			  System.out.println("\n==============headers================\n"); 
			  
			  RestAssured.given()
			  .log().headers()
			  .when().get("https://uinames.com/api");
			  
			  System.out.println("\n============uri=================\n");
			  
			  RestAssured.given()
			  .log().uri()
			  .when().get("https://uinames.com/api");
			  
			  System.out.println("\n=============body================\n");
			  
			  RestAssured.given()
			  .log().body()
			  .when().get("https://uinames.com/api");
			  
			  System.out.println("\n===========parameters==================\n");
			  
			  RestAssured.given()
			  .log().parameters()
			  .when().get("https://uinames.com/api");
			  
			  System.out.println("\n==============params================\n");
			  
			  RestAssured.given()
			  .log().params()
			  .when().get("https://uinames.com/api");
			  
		  }
		}
