package AutomationPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	
	@Test
	public void softAssertTest() {
	
	SoftAssert softAssertion=new SoftAssert();
	System.out.println("Softassert test started");
	softAssertion.assertEquals(12,13,"count does not match");
	System.out.println("Softassert test completed");
	softAssertion.assertAll();
	}
	
	@Test
	public void hardAssertTest() {
	System.out.println("Hard assert test started");
	Assert.assertEquals(12, 13);
	System.out.println("Hard assert test  completed");
	}

}
