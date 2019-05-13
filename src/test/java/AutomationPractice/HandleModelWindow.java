package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleModelWindow {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.get("https://www.goibibo.com");
//		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
	}
	@Test
	public void test() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='get_sign_in']")).click();
		driver.switchTo().frame("authiframe");
		driver.findElement(By.xpath("//input[@id='authMobile']")).sendKeys("1234567890");
		driver.findElement(By.xpath("//button[@id='mobileSubmitBtn']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='authCredentialPassword']")).sendKeys("ali12345");
		driver.findElement(By.xpath("//i[@id='passwordEyeMobilePassword']")).click();
	}

}
