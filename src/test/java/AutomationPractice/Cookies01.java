package AutomationPractice;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utilities.Driver;

public class Cookies01 {
	WebDriver driver;

	@Test
	public void cookiesTest01() {
		driver = Driver.getDriver();
		driver.get("https://www.amazon.com/");

		Set<Cookie> cookies = driver.manage().getCookies();

		System.out.println("cookies size: " + cookies.size());

		for (Cookie cookie : cookies) {
			System.out.println("cookie name and value: " + cookie.getName() + " : " + cookie.getValue());
		}

		System.out.println("session-id-time cookie: " + driver.manage().getCookieNamed("session-id-time"));

		System.out.println("====================== ADD COOKIE =======================================");
		Cookie cookieToBeAdded = new Cookie("Ali's cookie", "cookieAli");
		driver.manage().addCookie(cookieToBeAdded);

		Set<Cookie> cookiesWithMyCookyAdded = driver.manage().getCookies();

		System.out.println("Cookies size after my cookie added: " + cookiesWithMyCookyAdded.size());

		for (Cookie cookie : cookiesWithMyCookyAdded) {
			System.out
					.println("cookiesWithMyCookyAdded name and value: " + cookie.getName() + " : " + cookie.getValue());
		}
		System.out.println("====================== DELETE A COOKIE =======================================");

		driver.manage().deleteCookieNamed("i18n-prefs");

		Set<Cookie> cookiesAfterDeletingOne = driver.manage().getCookies();
		System.out.println("cookiesAfterDeletingOne: " + cookiesAfterDeletingOne.size());

		for (Cookie cookie : cookiesAfterDeletingOne) {

			System.out
					.println("cookiesAfterDeletingOne name and value: " + cookie.getName() + " : " + cookie.getValue());

		}

		System.out.println("====================== DELETE ALL COOKIES =======================================");

		driver.manage().deleteAllCookies();

		Set<Cookie> cookiesAfterAllDeleted = driver.manage().getCookies();
		System.out.println("cookiesAfterAllDeleted size: " + cookiesAfterAllDeleted.size());
		driver.close();

	}
}
