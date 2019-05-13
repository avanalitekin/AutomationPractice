package AutomationPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFramesDemo {
	WebDriver driver;
	JavascriptExecutor je;
	
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.toolsqa.com/iframe-practice-page/");
	}
	@Test
	public void test() throws InterruptedException {
		int totalNumberOfFrames=driver.findElements(By.tagName("iframe")).size();
		System.out.println("total number of frames: "+totalNumberOfFrames);
		driver.switchTo().frame("IF1");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[8]/input")).sendKeys("Ali");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/div/div/div[2]/div/form/fieldset/div[11]/input")).sendKeys("Tekin");
		driver.findElement(By.id("sex-0")).click();
		driver.findElement(By.id("exp-6")).click();
		driver.findElement(By.id("datepicker")).sendKeys("01/01/2018");
		driver.findElement(By.id("profession-1")).click();
		WebElement fileUpload=driver.findElement(By.id("photo"));
		String fileLocation="C:\\Users\\DELL\\Desktop\\TestFiles\\test.txt";
		fileUpload.sendKeys(fileLocation);
		driver.findElement(By.id("tool-2")).click();
//		driver.findElement(By.xpath("//*[@id='continents']/option[text()='North America']")).click();
		driver.findElement(By.xpath("//*[@id='continents']/option[5]")).click();
//		Select select= new Select(continent);
		List<WebElement> seleniumCommands=driver.findElements(By.xpath("//select[@id='selenium_commands']//option"));
		
		for(int i=0; i<seleniumCommands.size(); i++) {
			if(seleniumCommands.get(i).getText().equals("WebElement Commands"))
				seleniumCommands.get(i).click();
		}
		driver.switchTo().defaultContent();
		driver.switchTo().frame("IF2");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='post-1']/footer/p[1]/a")).click();
		Thread.sleep(1000);
		je=(JavascriptExecutor)driver;
		WebElement scrollDown=driver.findElement(By.xpath("//*[@id='reply-title']"));
		je.executeScript("arguments[0].scrollIntoView(true)", scrollDown);
		driver.findElement(By.xpath("//input[@id='author']")).sendKeys("Ali");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc1234@ymail.com");
		driver.findElement(By.xpath("//input[@id='url']")).sendKeys("www.google.com");
		driver.findElement(By.xpath("//*[@id='comment']")).sendKeys("It is good to practice automation on this page");	
	}
	
	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
