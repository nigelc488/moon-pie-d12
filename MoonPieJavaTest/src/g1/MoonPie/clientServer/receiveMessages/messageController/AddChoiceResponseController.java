package g1.MoonPie.clientServer.receiveMessages.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.xml.MessageXML;

public class AddChoiceResponseController {

	public void process(MessageXML response){
		System.out.println("response: " + response );
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		int line = Integer.parseInt(map.getNamedItem("number").getNodeValue());
		String choice = EncodeXML.decodeString(map.getNamedItem("choice").getNodeValue());
		System.out.println("Add Choice: Line: " + line + " choice: " + choice);
		
	}
}
