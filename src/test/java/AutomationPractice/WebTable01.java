package AutomationPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebTable01 {
	WebDriver driver;
	Actions action;
	Alert alert;

	@BeforeClass
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//section[@id='search']/div/div[3]/div/label")).click();
	}

	@Test
	public void getMonthYear() {
		String month = driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]"))
				.getText();
		System.out.println("Current month-year on the reservation calendar: " + month);
		System.out.println("=========== End of  getMonthYear method ===========");
	}

	@Test
	public void getARow() {
		WebElement row = driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[2]"));
		System.out.println("Days of the week on the calendar are as below:");			
		System.out.println(row.getText());
		System.out.println("=========== End of  getARow method ===========");
	}

	@Test
	public void getDaysOfWeek() {
		List<WebElement> days = driver.findElements(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[2]//th"));
		System.out.println("Days of the week on the calendar are as below:");
		for (WebElement day : days) 
		System.out.println(day.getText());
		System.out.println("=========== End of  getDaysOfWeek method ===========");
	}
	@Test
	public void dayOfMonth() {
		List<WebElement> days = driver.findElements(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody//tr//td"));
		System.out.println("Days of the week on the calendar are as below:");
		for (WebElement day : days) {
			if (day.getText().length() > 0 && Character.isDigit(day.getText().charAt(0)))
				System.out.println(day.getText());
		}
		System.out.println("=========== End of  dayOfMonth method ===========");
	}
	@Test
	public void MonthDaysOnADay() {
		String daySelected="Su";
		int index=dayIndex(daySelected);
		String xpath="//*[@id='rb-calendar_onward_cal']/table/tbody//tr//td["+index+"]";
		List<WebElement> days = driver.findElements(By.xpath(xpath));
		System.out.println("Month days on =="+daySelected+"== are below");
		for(WebElement monthDay:days) {
			if(monthDay.getText().length()>0)
		System.out.println(monthDay.getText());
		}
		System.out.println("=========== End of  MonthDaysOnADay method ===========");
	
}
	@Test
	public void selectDates() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='Onward Date']")).click();
		action=new Actions(driver);
		List<WebElement> allDatesDepature=driver.findElements(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody//tr//td"));
		for(WebElement date:allDatesDepature) {
			System.out.print(date.getText()+" ");
			if(date.getText().equalsIgnoreCase("28")) {
			action.moveToElement(date).click().build().perform();
			break;
			}
		}
	}
	public int dayIndex(String day) {
		List<WebElement> days=driver.findElements(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[2]//th"));
		for(int i=0; i<days.size(); i++) {
			if(day.equals(days.get(i).getText()))
		return i+1;
		}	
		return 0;
	}


	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(5000);
//		driver.quit();
	}

}
