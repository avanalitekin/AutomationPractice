package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestTest {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercuryreservation.php?osCsid=079b94fc69871a6d1977bee85b89a8b5");
		Thread.sleep(3000);
	}
	
	@Test
	public void testRoundTripChecked() throws InterruptedException {
	
	driver.findElement(By.xpath("//input[@name='tripType'][@value='oneway']")).click();
	Thread.sleep(3000);
	WebElement roundTrip=driver.findElement(By.xpath("//input[@name='tripType'][@value='roundtrip']"));
	roundTrip.click();
	System.out.println(roundTrip.isSelected());
	Assert.assertTrue(!roundTrip.isSelected());
//	Assert.assertFalse(roundTrip.isSelected());

	}
	@AfterClass
	public void close() throws InterruptedException {
	Thread.sleep(5000);
	driver.quit();
	}

}
