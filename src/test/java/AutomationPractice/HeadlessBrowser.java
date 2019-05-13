package AutomationPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class HeadlessBrowser {
	WebDriver driver;
	
	@Test
	public void verifyTitle() throws InterruptedException {
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless");
		
		driver =new ChromeDriver(options);
		
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Automation");
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).click();
		
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
	

}
