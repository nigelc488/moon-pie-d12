package g1.MoonPie.clientServer.receiveMessages.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.xml.MessageXML;

public class AddChoiceResponseController {
	int line;
	String choice;
	
	public void process(MessageXML response){
		System.out.println("response: " + response );
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		line = Integer.parseInt(map.getNamedItem("number").getNodeValue());
		choice = EncodeXML.decodeString(map.getNamedItem("choice").getNodeValue());
		System.out.println("Add Choice: Line: " + line + " choice: " + choice);
		
	}

	public int getLine() {
		return line;
	}

	public String getChoice() {
		return choice;
	}
	
	
}
