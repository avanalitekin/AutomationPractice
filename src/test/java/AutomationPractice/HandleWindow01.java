package AutomationPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandleWindow01 {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.naukri.com/");
	}
	@Test
	public void test() {
	String parentWindow=driver.getWindowHandle();
	System.out.println(parentWindow);
	Set<String> allWindows=driver.getWindowHandles();
	Iterator<String> iterator=allWindows.iterator();
	while(iterator.hasNext())
	{
		String childWindow=iterator.next();
		if(!parentWindow.equals(childWindow))
		{
			driver.switchTo().window(childWindow);
			System.out.println(driver.switchTo().window(childWindow).getTitle());
			driver.close();
		}
	}
		driver.switchTo().window(parentWindow);
	}
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
