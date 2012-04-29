package g1.MoonPie.clientServer.receiveMessages.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import g1.MoonPie.clientServer.xml.MessageXML;

public class ForceResponseController {

	
	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		int numberAffected = Integer.parseInt(map.getNamedItem("numberAffected").getNodeValue());
		
		System.out.println("forced" + numberAffected);
		//new AdminController(event, activity, key);
		
		
	}

}
