package AutomationPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonSimple {
	WebDriver driver;
	
	@BeforeClass
	public void  setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@Test
	public void test() {
		driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Selenium cookbook");
		driver.findElement(By.xpath("//*[@id='nav-search-submit-text']/following-sibling::input[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> searchResults=driver.findElements(By.xpath("//*[@id='s-results-list-atf']//h2"));;
		for(WebElement element:searchResults) {
			if(!element.getText().contains("Selenium"))
			System.out.println("====== "+element.getText());		
		}
		for(WebElement element:searchResults) {
			if(element.getText().contains("Selenium"))
			System.out.println("++++++++ "+element.getText());		
		}
		
//		for(WebElement element:searchResults) {
//			Assert.assertTrue(element.getText().contains("Selenium"));	
//		}
	}
	
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(10);
		driver.quit();
	}

}
