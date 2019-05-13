package APIReview;

	import org.json.JSONException;
	import org.json.JSONObject;
	import org.json.XML;

import utilities.APIUtility;

	public class JsonConversion {

	    public static String xmlString =
	        "<?xml version=\"1.0\" ?><test attrib=\"moretest\">Turn this to JSON</test>";

	    public static void main(String[] args) {
	    	System.out.println(APIUtility.convertXMLToJson(xmlString));
	    }
	   
	}