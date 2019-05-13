package AutomationPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertions {

	@Test
	public void test1() {
		Assert.assertEquals(12, 13);
	}

	@Test
	public void test2() {
		Assert.assertEquals(12, 13, "Dropdown count does not match, please check with the developer");
	}

	@Test
	public void test3() {
		System.out.println("Test case started");
		Assert.assertEquals("Hello", "Hello", "Words do not match please raise a bug");
		System.out.println("Test case 3 completed");
	}
	@Test
	public void test4() {
		String str="Ali Tekin";
		Assert.assertTrue(str.contains("Ali"));
	}
	@Test
	public void test5() {
		Assert.assertTrue(false);
	}


}
