package APIReview;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import junit.framework.Assert;
import utilities.DBUtility;

public class WP1_Map_Pojo_InsteadOfJsonPath {
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI="https://avanalitekin.dev.cc";
		RestAssured.basePath="/wp-json/wp/v2";
		
	}
//	@Test
	public void  post_User_With_Map() {
		String[] roles= {"subscriber", "contributor", "author", "editor"};
		String role=roles[new Random().nextInt(roles.length)];
		Faker fake=new Faker();
		String user=fake.name().username();
		Map<String, String> wpUser=new HashMap<String,String>();
		wpUser.put("username", user);
		wpUser.put("name", user);
		wpUser.put("first_name", user);
		wpUser.put("last_name", user);
		wpUser.put("email", user+"@"+user+".com");
		wpUser.put("roles", role);
		wpUser.put("password", user);
		RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("avanalitekin", "3mersule").contentType(ContentType.JSON).body(wpUser).post("/users").then().statusCode(201).and()
		.body("username", Matchers.is(user))
		.body("roles", Matchers.hasItem(role));
		
	}
	@Test
	public void  post_User_With_PojoClass() throws SQLException {
		String[] roles= {"subscriber", "contributor", "author", "editor"};
		String role=roles[new Random().nextInt(roles.length)];
		Faker fake=new Faker();
		String user=fake.name().username();
		String email=user+"@"+user+".com";
		WordPressUsers wpUser=new WordPressUsers(user,user,user,user,email,role,user);
		RestAssured.given().relaxedHTTPSValidation().auth().preemptive().basic("avanalitekin", "3mersule").contentType(ContentType.JSON).body(wpUser).post("/users").then().statusCode(201).and()
		.body("username", Matchers.is(user))
		.body("roles", Matchers.hasItem(role));
		
		
		DBUtility.getConnectionWP1DB();
		DBUtility.executeQuery("select display_name, user_email from wp_users where  user_email='"+email+"';");
		System.out.println(DBUtility.getDataOnAColumn("display_name").get(0));
		System.out.println(DBUtility.getDataOnAColumn("user_email").get(0));
		Assert.assertEquals(DBUtility.getDataOnAColumn("display_name").get(0), user);
		Assert.assertEquals(DBUtility.getDataOnAColumn("user_email").get(0), email);
		DBUtility.closeConnection();
		
		
	}

}
class WordPressUsers{
	String username;
	String name;
	String first_name;
	String last_name;
	String email;
	String roles;
	String password;
	public WordPressUsers() {};
	public WordPressUsers(String username, String name, String first_name, String last_name, String email, String roles, String password) {
		this.username=username;
		this.name=name;
		this.first_name=first_name;
		this.last_name=last_name;
		this.email=email;
		this.roles=roles;
		this.password=password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	};
}
