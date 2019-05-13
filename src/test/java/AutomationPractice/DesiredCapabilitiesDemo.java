package AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

//https://peter.sh/experiments/chromium-command-line-switches   (check this webside for chrome browser commands)

public class DesiredCapabilitiesDemo {
	@Test
	public void desiredCapabilitiesTest() {
		
		DesiredCapabilities dcap=new DesiredCapabilities();
		dcap.setAcceptInsecureCerts(true);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-infobars");/*this will remove the info bar. You will not see "Chrome is being controlled by automated test software." message */
//		options.setHeadless(true);
		options.addArguments("--headless");
		options.setAcceptInsecureCerts(true);
		options.merge(dcap);
		WebDriver driver=new ChromeDriver(options);
		
		driver.get("http://www.google.com");
		
		System.out.println(driver.getCurrentUrl());
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/?gws_rd=ssl", "Actual title is: "+driver.getCurrentUrl());
		
		driver.close();
		
	}

}
