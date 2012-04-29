package g1.MoonPie.clientServer.receiveMessages.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


import g1.MoonPie.clientServer.xml.MessageXML;

public class TurnResponseController {
	
	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		boolean completed = Boolean.parseBoolean(map.getNamedItem("completed").getNodeValue());
		
		System.out.println("Turn completed?=" + completed);
		
		//new TurnController(event, activity, completed);
		
	}

}
