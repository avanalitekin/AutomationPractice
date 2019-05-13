package utilities;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

public class APIUtility {
	public static String convertXMLToJson(String xmlString) {
		String jsonString="";

        try {
            JSONObject xmlJSONObj = XML.toJSONObject(xmlString);
            jsonString = xmlJSONObj.toString();
        } catch (JSONException je) {
            System.out.println(je.toString());
        }
    return jsonString;
	}

}
