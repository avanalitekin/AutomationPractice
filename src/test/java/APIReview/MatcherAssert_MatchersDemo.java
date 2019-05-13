package APIReview;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class MatcherAssert_MatchersDemo {
	@Test
	public void  matcherAssert_Matchers_Test() {
	String str1="programmer";
	String str2="programmer";
	String str3="programmer3";
	String str4="ProgrammER";
	String str5=" programmer ";
	MatcherAssert.assertThat(str1, Matchers.is(str2));
	MatcherAssert.assertThat(str1, Matchers.not(str3));
	MatcherAssert.assertThat(str1, Matchers.equalToIgnoringCase(str4));
	MatcherAssert.assertThat(str1, Matchers.equalToIgnoringWhiteSpace(str5));
	MatcherAssert.assertThat(str1, Matchers.notNullValue());
	int a=5;
	int b=6;
	int c=5;
	MatcherAssert.assertThat(a,Matchers.equalTo(c));
	MatcherAssert.assertThat(b,Matchers.greaterThan(a));
	MatcherAssert.assertThat(c, Matchers.lessThan(b));
	List<String> names=Arrays.asList("Mark","Tom","Chris");
	List<String> nickNames=Arrays.asList("Tom");
	MatcherAssert.assertThat(names, Matchers.containsInAnyOrder("Tom","Mark","Chris"));
//	MatcherAssert.assertThat(names, Matchers.contains(nickNames));
//	MatcherAssert.assertThat(names, Matchers.contains("Tom"));
	MatcherAssert.assertThat(names, Matchers.hasItem("Tom"));
	List<Integer> numbers=Arrays.asList(4,5,6);
	MatcherAssert.assertThat(numbers, Matchers.everyItem(Matchers.greaterThan(3)));
	MatcherAssert.assertThat(numbers, Matchers.everyItem(Matchers.lessThan(10)));
	
	
	
		
	}

}
