package AutomationPractice;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class WebOrder01 extends TestBase{
	
	String username="Tester";
	String password="test";
	String blankUsername="";
	String blankPassword="";
	String wrongUsername="Test";
	String titleExpectedBeforeLogin="Web Orders VerifyLogin";
	String titleExpectedAfterLogin="Web Orders";
	String uRLBeforeLogin;
	
	public void login(String userName, String password) {
	//4. Enter username “Tester”
	driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(userName);
	//5. Enter password “test”
	driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(password);
	//6. Click on VerifyLogin button
	driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	}
	
	@Test (priority=1)//WO-1: Positive VerifyLogin Test
	public void loginPosiveTesting() {
	//2. Go to website
	driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
	//3. Verify title equals “Web Orders VerifyLogin”
	Assert.assertEquals(titleExpectedBeforeLogin,driver.getTitle());
	login(username, password);
	//7. Verify title equals “Web Orders”
	Assert.assertEquals(titleExpectedAfterLogin,driver.getTitle());
	//8. Verify url equals 
	String expectedURL="http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/";//different than asked in the homework
//	System.out.println(expectedURL);
//	System.out.println(driver.getCurrentUrl());
	Assert.assertTrue(expectedURL.equalsIgnoreCase(driver.getCurrentUrl()));
	}
	
	
	@Test (priority=2)//WO-2: Negative VerifyLogin Test Wrong Username
	public void logingWrongUN() {
	//2. Go to website
	driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
	//3. Verify title equals “Web Orders VerifyLogin”
	Assert.assertEquals(titleExpectedBeforeLogin,driver.getTitle());
	uRLBeforeLogin=driver.getCurrentUrl();
	login(wrongUsername,password);
	Assert.assertEquals(titleExpectedBeforeLogin,driver.getTitle());
	Assert.assertEquals(uRLBeforeLogin,driver.getCurrentUrl());
	}
	
	@Test (priority=3)//WO-3: Negative VerifyLogin Test Wrong Password
	public void logingWrongPW() {
	//2. Go to website
	driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
	//3. Verify title equals “Web Orders VerifyLogin”
	Assert.assertEquals(titleExpectedBeforeLogin,driver.getTitle());
	uRLBeforeLogin=driver.getCurrentUrl();
	login(wrongUsername,wrongUsername);
	Assert.assertEquals(titleExpectedBeforeLogin,driver.getTitle());
	Assert.assertEquals(uRLBeforeLogin,driver.getCurrentUrl());
	}
	
	@Test (priority=4)//WO-4: Negative VerifyLogin Test Blank Username
	public void loginBlankUN() {
	//2. Go to website
	driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
	//3. Verify title equals “Web Orders VerifyLogin”
	Assert.assertEquals(titleExpectedBeforeLogin,driver.getTitle());
	uRLBeforeLogin=driver.getCurrentUrl();
	login(blankUsername, password);
	Assert.assertEquals(titleExpectedBeforeLogin,driver.getTitle());
	Assert.assertEquals(uRLBeforeLogin,driver.getCurrentUrl());
	}
	
	@Test (priority=5)//WO-5: Negative VerifyLogin Test Blank Password
	public void loginBlankPW() {
	//2. Go to website
	driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
	//3. Verify title equals “Web Orders VerifyLogin”
	Assert.assertEquals(titleExpectedBeforeLogin,driver.getTitle());
	uRLBeforeLogin=driver.getCurrentUrl();
	login(username, blankPassword);
	Assert.assertEquals(titleExpectedBeforeLogin,driver.getTitle());
	Assert.assertEquals(uRLBeforeLogin,driver.getCurrentUrl());
	}
	
}
