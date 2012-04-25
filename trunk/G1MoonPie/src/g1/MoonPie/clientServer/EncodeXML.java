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
		String xmlString = string.replace("&", "~ampWPI:");
		xmlString = xmlString.replace("<", "~ltWPI:");
		xmlString = xmlString.replace(">", "~gtWPI:");
		//xmlString = xmlString.replace(""", "&quot;");
		xmlString = xmlString.replace("'", "~aposWPI:");
		return xmlString;
	}
	
	/**
	 * This method converts the encoded message back to standard text.
	 * @param string String containing encoded characters
	 * @return String The string as was originally entered
	 */
	public static String decodeString(String string){
		String normalString = string.replace("~aposWPI:", "'");
		//normalString = string.replace("&quot;", """);
		normalString = normalString.replace("~gtWPI:", ">");
		normalString = normalString.replace("~ltWPI:", "<");
		normalString = normalString.replace("~ampWPI:", "&");
		return normalString;
	}

}
