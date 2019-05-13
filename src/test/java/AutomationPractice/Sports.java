package AutomationPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Sports {
	WebDriver driver;
	Actions action;
	Random random;
	Select select;
	
	@BeforeClass
	public void setUp() throws InterruptedException{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@Test
	public void test() throws InterruptedException {
	random=new Random();
	WebElement football=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input"));
	System.out.println(football.isSelected());
	football.isSelected();
	Thread.sleep(2000);
	List<WebElement> radios=driver.findElements(By.xpath("//*[@type='radio']"));
	List<WebElement> sports=new ArrayList<WebElement>();
	for (int i=4; i<radios.size()-1; i++) {
		sports.add(radios.get(i));
	}
	sports.get(random.nextInt(sports.size()-1)).click();
	}
	@AfterClass
	public void close() throws InterruptedException {
	Thread.sleep(5000);
	driver.quit();
	}
}
