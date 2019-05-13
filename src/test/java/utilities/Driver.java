package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	private static WebDriver driver;

	private Driver() {
	}

	public static void setDriver() {
		String browser = ConfigurationReader.getProperty("browser");
		switch (browser) {
		case "chrome":
//		WebDriverManager.chromedriver().setup(); //if chromedriver path is added in the computer environment path, no need to use it here
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			break;
		}
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			String browser = ConfigurationReader.getProperty("browser");
			switch (browser) {
			case "chrome":

				driver = new ChromeDriver();
				break;
			case "firefox":

				driver = new FirefoxDriver();
				break;
			case "ie":

				driver = new InternetExplorerDriver();
				break;
			}
			driver.manage().window().maximize();
		}
		
		return driver;
	}

	public static WebDriver getDriver(String url) {
		if (driver == null) {
			String browser = ConfigurationReader.getProperty("browser");
			switch (browser) {
			case "chrome":

				driver = new ChromeDriver();
				break;
			case "firefox":

				driver = new FirefoxDriver();
				break;
			case "ie":

				driver = new InternetExplorerDriver();
				break;
			}
			driver.manage().window().maximize();
			driver.get(url);
		}
		return driver;
	}
	public static void closeDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}

	}

}
