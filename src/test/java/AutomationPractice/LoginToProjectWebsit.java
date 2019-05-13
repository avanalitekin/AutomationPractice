package AutomationPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginToProjectWebsit {
Actions action;
WebDriver driver;
String[] usernames= {"EventsCRM_Manager@info.com","EventsCRM_Manager2@info.com","EventsCRM_Manager3@info.com", "EventsCRM_Manager4@info.com", "EventsCRM_Manager5@info.com",
		"EventsCRM_Manager6@info.com", "EventsCRM_Manager7@info.com", "EventsCRM_Manager8@info.com", "EventsCRM_Manager9@info.com", "eventsCRM_User@info.com", "EventsCRM_User2@info.com", "EventsCRM_User3@info.com", 
		"EventsCRM_User4@info.com", "EventsCRM_User5@info.com", "EventsCRM_User6@info.com", "EventsCRM_User7@info.com", "EventsCRM_User8@info.com", "EventsCRM_User9@info.com"};

String[] passwords= {"Ugh45wQ12", "Ugh45wQ13", "Ugh45wQ14", "Ugh45wQ15", "Ugh45wQ16", "Ugh45wQ17", "Ugh45wQ18",  "Ugh45wQ19", "Ugh45wQ20", "opJu56KKL39", "opJu56KKL40", "opJu56KKL41",
		"opJu56KKL42", "opJu56KKL43", "opJu56KKL44", "opJu56KKL45", "opJu56KKL46", "opJu56KKL47"};
int arrayIndex;


@BeforeClass
public void  open() throws InterruptedException {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://54.148.96.210/web/login");
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//	driver.findElement(By.xpath("(//*[@class='list-group-item'])[2]")).click();
//	Thread.sleep(3000);
}
@Test
public void login() throws InterruptedException {
	for(int i=0; i<usernames.length; i++) {
	Thread.sleep(1000);
	driver.findElement(By.id("login")).sendKeys(usernames[this.arrayIndex]);
	driver.findElement(By.id("password")).sendKeys(passwords[this.arrayIndex]);
	driver.findElement(By.xpath("//*[@type='submit']")).click();
	Thread.sleep(1000);
	
	try {
		driver.findElement(By.xpath("//*[@class='oe_topbar_name']")).click();
		driver.findElement(By.xpath("//*[@class='dropdown-menu']/li[6]/a")).click();
		System.out.println("LOGIN IN IS SUCCESSFULL");
		System.out.println("Username: "+usernames[this.arrayIndex]+"\nPassWord: "+passwords[this.arrayIndex]);
		System.out.println("===========================================================");
		Thread.sleep(1000);
	}catch (NoSuchElementException e) {
		String errorMessage=driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText();
		System.out.println("LOGIN IN IS NOT SUCCESSFULL");
		System.out.println("Username: "+usernames[this.arrayIndex]+"\nPassWord: "+passwords[this.arrayIndex]+"\nError Message: "+errorMessage);
		System.out.println("===========================================================");
		Thread.sleep(1000);
		driver.findElement(By.id("login")).clear();
		continue;
//		action=new Actions(driver);
//		action.sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.DELETE).build().perform();
		
	}
	this.arrayIndex++;
	}
}

@AfterClass
public void close() throws InterruptedException {
	Thread.sleep(2000);
	driver.quit();
}
}
