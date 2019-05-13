package APIReview;


	import java.io.IOException;

//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;



	public class LoginDemo {
		ObjectMapper om;
		
		@Test
		public void userNamePasswordTest() throws IOException {
			 String jsonString="{ \"username\": \"user1234\", \"password\": \"Pass\" }";
			 Login login=new ObjectMapper().readValue(jsonString, Login.class);
			 String username=login.getUsername();
			 String password=login.getPassword();
			 System.out.println(username);
			 System.out.println(password);
			 password = password.replaceAll(".", "*");
			 System.out.println(password);					 
		}
	}	
	class Login{
		String username;
		String password;
		public Login() {};
		
		public Login(String username, String password) {
			this.username=username;
			this.password=password;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		
	}