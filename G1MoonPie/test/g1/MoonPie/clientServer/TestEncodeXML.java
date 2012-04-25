package g1.MoonPie.clientServer;

import junit.framework.TestCase;

public class TestEncodeXML extends TestCase {
	
	//This one actually completely covers and checks that the xml encoding stuff works
	public void testEncoding(){
		String testString = EncodeXML.encodeString("what's for dinner?");
		assertEquals("what&aposME;s for dinner?", testString);
		String normalString = EncodeXML.decodeString(testString);
		assertEquals("what's for dinner?", normalString);
		testString = EncodeXML.encodeString("& who's you're favorite > < ?");
		assertEquals("&ampME; who&aposME;s you&aposME;re favorite &gtME; &ltME; ?", testString);
		normalString = EncodeXML.decodeString(testString);
		assertEquals("& who's you're favorite > < ?", normalString);
		testString = EncodeXML.encodeString("there is nothing wrong");
		assertEquals("there is nothing wrong", testString);
		normalString = EncodeXML.decodeString(testString);
		assertEquals("there is nothing wrong", normalString);
	}

}
