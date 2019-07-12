package AutomationPractice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ScreenShot {
	@Test
	public void screenshot() {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.get("https://www.amazon.com");
	String screenshot_time=new SimpleDateFormat("YYYY_MM_dd_hh_mm_ss").format(new Date());
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String targetPath="./Screenshots/test_screenshot_"+screenshot_time+".png";
	File destination=new File(targetPath);
	try {
		FileUtils.copyFile(source,destination);
	}catch(IOException e) {
		e.printStackTrace();
	}
	driver.quit();
	}
}
	