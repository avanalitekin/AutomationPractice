package AutomationPractice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AutoITMultipleFileUpload { //This file is NOT working properly
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("file:///C:/Users/DELL/Desktop/fileupload.html");
	}
	@Test
	public void  test() throws IOException, InterruptedException {
	driver.findElement(By.xpath("//input[@id='1']")).click();
	Thread.sleep(5000);
	Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\AutoIT\\FileUploadMultiple.exe"+" "+"C:\\Users\\DELL\\Desktop\\Writing the bug report.pdf");
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@id='1']")).click();
	Runtime.getRuntime().exec("C:\\Users\\DELL\\Desktop\\AutoIT\\FileUploadMultiple.exe"+" "+"C:\\Users\\DELL\\Desktop\\HOI.pdf");
	
	}
}
