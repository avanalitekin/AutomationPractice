package AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Navigate_Back_Forward {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void navigate() throws InterruptedException {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.get("https://www.amazon.com");
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		driver.get("https://www.kcfse.org");
		System.out.println(driver.getTitle());
		String kcfse_window_handle=driver.getWindowHandle();
		driver.findElement(By.xpath("//a[contains(text(),'ACT')]")).click();
		for(String window_handle:driver.getWindowHandles()) {
			if(!window_handle.equals(kcfse_window_handle)) {
				driver.switchTo().window(window_handle);
			}
		}	
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[contains(text(),'Sign In')]")).click();
		Thread.sleep(3);
		System.out.println(driver.getTitle());
		driver.quit();
		
		
		
	}

}
