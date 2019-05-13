package AutomationPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utilities.Utility;

public class FacebookScreenshot {

	@Test
	public void captureScreenshot() throws IOException {
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://wwww.facebook.com");
		Utility.captureScreenshot(driver, "BrowserStarted1");
		driver.findElement(By.cssSelector("input[id='email']")).sendKeys("avanali@ymail.com");
		Utility.captureScreenshot(driver, "TypeUName2");
		driver.quit();
	}

}
