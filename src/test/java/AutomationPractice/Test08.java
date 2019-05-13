package AutomationPractice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Test08 {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new  ChromeDriver();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.manage().window().maximize();
		
	}

	@Test
	public void test1() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("demo123");
		driver.findElement(By.xpath("//input[@name='rememberme']")).click();
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		Thread.sleep(5000);
		
		WebElement moveToPosts=driver.findElement(By.xpath("//*[@id='menu-posts']/a/div[3]"));
		Actions action=new Actions(driver);
		action.moveToElement(moveToPosts).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Tags')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='menu-posts']/ul/li[4]/a")).click();
		WebElement moveToAdmin=driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a/span"));
		action.moveToElement(moveToAdmin).build().perform();
//		WebElement moveToLogout=driver.findElement(By.xpath("//*[@id='wp-admin-bar-logout']/a"));
//		action.moveToElement(moveToLogout).build().perform();
//		moveToLogout.click();
//		WebElement moveDashboard=driver.findElement(By.xpath("//*[contains(text(),'Dashboard')]"));
//		action.moveToElement(moveDashboard).build().perform();
//		driver.findElement(By.xpath("//*[contains(text(),'Home')]")).click();
//		driver.findElement(By.xpath("//*[@id='content-prompt-text']")).sendKeys("this is what I have in mind");
		
	}
	
	@AfterMethod
	public void test() {
		driver.quit();
	}
}
