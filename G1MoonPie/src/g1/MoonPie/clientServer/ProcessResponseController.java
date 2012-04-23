package g1.MoonPie.clientServer;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import g1.MoonPie.clientServer.xml.MessageXML;

public class ProcessResponseController {

	public void processAddChoiceResponse(MessageXML response){
		
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		String id = map.getNamedItem("id").getNodeValue();
		int line = Integer.getInteger(map.getNamedItem("number").getNodeValue());
		String choice = map.getNamedItem("choice").getNodeValue();
		
		System.out.println("Line: " + line + " choice: " + choice);
	}
}
