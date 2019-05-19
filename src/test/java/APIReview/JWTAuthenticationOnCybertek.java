package APIReview;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JWTAuthenticationOnCybertek {
	String token = "10960~iuItVvzg7agKelW9ELrURU8dstPy32PSGBqjQMLEHi2HsW9lcF8yGtfwPwLV5wLd";

	@BeforeClass
	public void setUp() {

		RestAssured.baseURI = "https://learn.cybertekschool.com";
		RestAssured.basePath = "/api/v1";
	}

	@Test
	public void coursesModulesTest() {
		Response response = RestAssured
				.given().relaxedHTTPSValidation()
				.auth().oauth2(token)
				.get("/courses/129/modules");
		
		response.then().statusCode(200);
//		response.then().log().all();
		List<Integer> idsList=response.jsonPath().get("id");
		int id=response.jsonPath().get("id[0]");
		System.out.println(idsList);
		System.out.println(id);

		List<String> modulesList = response.jsonPath().get();
		for (int i = 0; i < modulesList.size(); i++) {
			String format = "%-20s%s%n";
			System.out.printf(format, "id for module " + (i + 1) + ": ", response.jsonPath().get("id[" + i + "]"));
			System.out.printf(format, "name for module " + (i + 1) + ": ", response.jsonPath().get("id[" + i + "]"));
		}

	}

}
