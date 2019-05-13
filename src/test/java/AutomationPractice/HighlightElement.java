package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.Utility;

public class HighlightElement {

	WebDriver driver;

	@BeforeClass
	public void setUp() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");

	}

	@Test
	public void highlightTest() {

		WebElement username = driver.findElement(By.id("email"));
		Utility.highLightElement(driver, username);
		username.sendKeys("avanali");
		
		WebElement password=driver.findElement(By.id("pass"));
		Utility.highLightElement(driver, password);
		password.sendKeys("abc1234");
		
		WebElement loginButton=driver.findElement(By.id("loginbutton"));
		Utility.highLightElement(driver, loginButton);
		Utility.captureScreenshot(driver, "highlightFacebookLogin");
		loginButton.click();
		Utility.captureScreenshot(driver, "FacebookLoginResult");
		
	}
	
//	public void highLightElement(WebDriver dr, WebElement element) {
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
//		
//		try {
//			Thread.sleep(1000);
//		}
//		catch(InterruptedException e) {
//			System.out.println(e.getMessage());
//		}
//		
//		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);		
//	}
	
	@AfterClass
	public void  close() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

}