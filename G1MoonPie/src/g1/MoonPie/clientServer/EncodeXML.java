package g1.MoonPie.clientServer;

/**
 * This class is used to ensure that none of the strings will conflict with the XML messages.
 * Need a standard for how to encode stuff.
 * The codes for this class were taken from Microsoft at http://support.microsoft.com/kb/316063
 * @author ncochran
 *
 */
public class EncodeXML {
	
	/**
	 * This method replaces any invalid characters.
	 * @param string String the string to be checked
	 * @return String The modified string with no invalid characters
	 */
	public static String encodeString(String string){
		String xmlString = string.replace("&", "ampME");
		xmlString = xmlString.replace("<", "ltME");
		xmlString = xmlString.replace(">", "gtME");
		//xmlString = xmlString.replace(""", "&quot;");
		xmlString = xmlString.replace("'", "aposME");
		return xmlString;
	}
	
	public static String decodeString(String string){
		String normalString = string.replace("aposME", "'");
		//normalString = string.replace("&quot;", """);
		normalString = normalString.replace("gtME", ">");
		normalString = normalString.replace("ltME", "<");
		normalString = normalString.replace("ampME", "&");
		return normalString;
	}

}
