package AutomationPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Expedia_Practice {
	WebDriver driver;
	@Test
	public void expedia_Test() {
	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.get("https://www.expedia.com");
	driver.findElement(By.id("tab-flight-tab-hp")).click();
	WebElement from_city=driver.findElement(By.xpath("//input[@id='flight-origin-hp-flight']"));
	WebElement to_city=driver.findElement(By.xpath("//input[@id='flight-destination-hp-flight']"));
	from_city.sendKeys("MCI");
	to_city.sendKeys("AUS");
	driver.findElement(By.id("flight-departing-hp-flight")).click();
	driver.findElement(By.xpath("//*[@data-day='25']")).click();
	driver.findElement(By.id("flight-returning-hp-flight")).click();
	driver.findElement(By.xpath("//*[@data-day='30']")).click();
	driver.findElement(By.xpath("(//*[text()='Search']/parent::*[@type='submit'])[1]")).click();
	driver.findElement(By.xpath("//*[@data-test-id='1 Stop']")).click();
	List<WebElement> flight_list=driver.findElements(By.xpath("//span[contains(text(),'1 stop')]"));
	WebElement flight_count=driver.findElement(By.xpath("//*[contains(text(),'1 Stop ')]/child::*"));
	System.out.println(flight_list.size());
	System.out.println(flight_count.getText());
	Assert.assertEquals(flight_list.size(), Integer.parseInt(flight_count.getText()));
	driver.quit();	
	}
}
