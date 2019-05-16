package APIReview;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;


public class GetAPIData {
	@Test
	public void testAPIData1() {
	Response response=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	String responseString=response.asString();
	System.out.println(responseString);
	int responseCode=response.statusCode();
	Assert.assertEquals(responseCode, 200);
	String format="%-25s%s%n";
	System.out.printf(format,"response.contentType()",response.contentType());
	System.out.printf(format,"response.getTime())",response.getTime());
	System.out.printf(format,"response.getTime())",response.time());
//	System.out.printf(format,"response.headers()\n",response.headers());
	
	}
	
	@Test
	public void testAPIData2() {
	Response response=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
	String format="%-45s%s%n";
	System.out.printf(format,"response.jsonPath().get(\"name\"):",response.jsonPath().get("name"));
	System.out.printf(format,"response.jsonPath().get(\"coord.lon\"):",response.jsonPath().get("coord.lon"));
	System.out.printf(format,"response.jsonPath().get(\"coord.lat\"):",response.jsonPath().get("coord.lat"));
	System.out.printf(format,"response.jsonPath().get(\"weather.id\"):",response.jsonPath().get("weather.id"));
	System.out.printf(format,"response.jsonPath().get(\"weather.main\"):",response.jsonPath().get("weather.main"));
	System.out.printf(format,"response.jsonPath().get(\"coord.description\"):",response.jsonPath().get("weather.description"));
	System.out.printf(format,"response.jsonPath().get(\"coord.lat\"):",response.jsonPath().get("weather.icon"));
	System.out.printf(format,"response.jsonPath().get(\"weather.id\"):",response.jsonPath().get("weather.id"));
	System.out.printf(format,"response.jsonPath().get(\"weather.main\"):",response.jsonPath().get("weather.main"));
	System.out.printf(format,"response.jsonPath().get(\"wind.speed\"):",response.jsonPath().get("wind.speed"));
	}
}
