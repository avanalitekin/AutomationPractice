package AutomationPractice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class TestSeleniumGrid {
	
	@Test
	public void test1() throws MalformedURLException {
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setPlatform(Platform.WIN10);
//		URL url=new URL("http://192.168.1.72:4444/wd/hub");
//		URL url=new URL("http://localhost:4444/wd/hub");
//		WebDriver driver=new RemoteWebDriver(url, cap);
		ChromeOptions options=new ChromeOptions();
		options.merge(cap);
		String hubUrl="http://localhost:4444/wd/hub";
		WebDriver driver=new RemoteWebDriver(new URL(hubUrl),options);
		driver.get("http://www.google.com");
		System.out.println("Title is: "+driver.getTitle());
		driver.quit();
	}

}
