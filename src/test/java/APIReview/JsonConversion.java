package APIReview;


import org.testng.annotations.Test;

import utilities.APIUtility;

	public class JsonConversion {

		@Test
		public void convertXMLToJson() {
		String xmlString =
	        "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";
		String jsonString=APIUtility.convertXMLToJson(xmlString);
	    	System.out.println(jsonString);
	    }
	   
	}