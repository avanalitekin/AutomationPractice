package AutomationPractice;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//https://commons.apache.org/proper/commons-email/userguide.html
public class SendEmail {
	
	
	@Test
	public void setUp() throws EmailException {
		System.out.println("==========TEST STARTED===========");
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("avanali@gmail.com", "abc1235"));
		email.setSSLOnConnect(true);
		email.setFrom("avanalitekin@gmail.com");
		email.setSubject("Selenimum Test Report");
		email.setMsg("This is a test email from Selenium");
		email.addTo("avanalitekin@yahoo.com");
		email.send();
		System.out.println("==========TEST STARTED===========");
		System.out.println("==========TEST COMPLETED===========");
	}

}
