package utilities;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

public class TestBase {
	protected WebDriver driver;
	protected Actions action;
	protected SoftAssert softAssert;
	protected JavascriptExecutor je;
	protected Select select;
	protected Faker faker=new Faker();;
	protected Random random;

	@BeforeClass
	public void setUpClass() {
//	WebDriverManager.chromedriver().setup(); //if  chromedriver path is added in the computer environment path, no need to use it here
	Driver.setDriver();	
	}
	
	@BeforeMethod
	public void setUpMethod() {
		driver=Driver.getDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		action=new Actions(driver);
		softAssert=new SoftAssert();
		je = (JavascriptExecutor) driver;
		random=new Random();
		
		
	}
	
//	@AfterMethod
	public void closeMethod() throws InterruptedException {
	Thread.sleep(5000);
//	DriverPrestaShop.closeDriver();
	softAssert.assertAll();
	
	}
	@AfterClass
	public void closeClass() throws InterruptedException {
		Thread.sleep(5000);
		Driver.closeDriver();
	}
}

