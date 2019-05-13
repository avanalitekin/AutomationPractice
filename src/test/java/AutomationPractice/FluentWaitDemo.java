package AutomationPractice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.google.common.base.Function;
import java.time.Duration; 

public class FluentWaitDemo {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
	}
	@Test
	public void test() {
	driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
	
	FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver);
	wait.pollingEvery(Duration.ofMillis(100));
	wait.withTimeout(Duration.ofSeconds(10));

	WebElement element=wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) {
		WebElement ele=driver.findElement(By.xpath("//p[@id='demo']"));
		String value=ele.getAttribute("innerHTML");
		if(value.equalsIgnoreCase("WebDriver"))
		{
			System.out.println("Displaying element is ======="+value);
			return ele;
		}else {
			System.out.println("Displaying element while not webdiver is ====="+value);
			return null;
		}
	}
});
	System.out.println("Final visible status is >>>>> " + element.isDisplayed());
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
}
