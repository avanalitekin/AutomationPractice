package APIReview;

import java.util.Random;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class WPUtilityDemo {
	String[] roles= {"subscriber", "contributor", "author", "editor"};
	String roleCreate;
	String roleUpdate;
	int newUserId;
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI="https://avanalitekin.dev.cc/wp-json";
		RestAssured.basePath="/wp/v2";
		roleCreate=roles[new Random().nextInt(roles.length)];
		while(roleUpdate==null || roleUpdate==roleCreate) {
			roleUpdate=roles[new Random().nextInt(roles.length)];
		}
	}
	@Test (priority=0)
	public void create_user_with_role() {
//		System.out.println("roleCreate: "+roleCreate);
//		System.out.println("roleUpdate: "+roleUpdate);
		newUserId=utilities.WPUtility.create_User(roleCreate);
	}
	
	@Test (priority=1)
	public void update_user() {
		utilities.WPUtility.update_User(roleUpdate, newUserId);
	}
	
	@Test (priority=2)
	public void delete_user() {
		utilities.WPUtility.delete_User(newUserId);
	}

}
