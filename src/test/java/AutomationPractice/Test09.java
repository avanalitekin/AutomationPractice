package AutomationPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test09 {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		
	}
	@Test
	public void test() throws InterruptedException {
//		driver.findElement(By.cssSelector("#user_login")).sendKeys("admin");
//		driver.findElement(By.cssSelector("input[id*='login'")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[id^='user'][name^='log']")).sendKeys("admin");
//		driver.findElement(By.cssSelector("#user_pass")).sendKeys("demo123");
//		driver.findElement(By.cssSelector("input[id*='pass']")).sendKeys("demo123");
		driver.findElement(By.cssSelector("input[id^='user'][name^='pwd']")).sendKeys("demo123");
		driver.findElement(By.cssSelector(".forgetmenot")).click();
//		driver.findElement(By.cssSelector("input[id$='submit']")).click();
		driver.findElement(By.cssSelector(".button")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#nav > a")).click();
			
	}
	@AfterMethod
	public void close() {
//		driver.quit();
	}

}
