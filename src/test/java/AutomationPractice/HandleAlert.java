package AutomationPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HandleAlert {
	WebDriver driver;
	JavascriptExecutor je;
	
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://toolsqa.com/handling-alerts-using-selenium-webdriver/");
		je = (JavascriptExecutor) driver;
	}
	@Test
	public void test() throws InterruptedException {
	driver.findElement(By.xpath("//div[@id='content']/p[4]/button")).click();
	Alert alert=driver.switchTo().alert();
	System.out.println("alert.getText(): "+alert.getText());
	System.out.println("alert.getClass()): "+alert.getClass());
//	Assert.assertTrue(alert.getText().equals("Simple Alert"));
	alert.accept();
	Thread.sleep(2000);
	

	WebElement scrollDown=driver.findElement(By.xpath("//*[text()='HTML code for such types of pop is']"));
	je.executeScript("arguments[0].scrollIntoView(true)",scrollDown);
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@id='main']/div/div/div/p[8]/button")).click();
	Alert alert2=driver.switchTo().alert();
	System.out.println("alert2.getText(): "+alert2.getText());
	System.out.println("alert2.getClass()): "+alert2.getClass());
//	Assert.assertEquals(alert2.getText(), "confirm OK decline cancel");
//	alert2.dismiss();
	alert2.accept();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//div[@id='main']/div/div/div/p[11]/button")).click();
	Alert alert3=driver.switchTo().alert();
	System.out.println("alert3.getText(): "+alert3.getText());
	System.out.println("alert3.getClass()): "+alert3.getClass());
	Assert.assertTrue(alert3.getText().equals("Do you like toolsqa?"));
	alert3.accept();
	
	}
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(10000);
		driver.quit();
	}

}
