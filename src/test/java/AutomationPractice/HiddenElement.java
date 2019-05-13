package AutomationPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HiddenElement {
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
	}
	
	@Test
	public void test() {

//	driver.findElement(By.id("male")).click();
//	int x=driver.findElement(By.id("male")).getLocation().getX();
//	int y=driver.findElement(By.id("male")).getLocation().getY();
//	System.out.println("x=== "+x+" and y=== "+y);
	List<WebElement> radioMale=driver.findElements(By.id("male"));
	System.out.println("total male radio buttons"+radioMale.size());
	System.out.println("total male radio buttons"+radioMale);
	for(int i=0; i<radioMale.size();i++) {
		int x=radioMale.get(i).getLocation().getX();
		if(x!=0) {
			radioMale.get(i).click();
			break;
		}
	}
		
		
	}
	
	@AfterClass
	public void close() throws InterruptedException {
	Thread.sleep(3000);
	driver.quit();
	}

}
