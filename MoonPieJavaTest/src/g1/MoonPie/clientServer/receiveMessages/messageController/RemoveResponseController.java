package g1.MoonPie.clientServer.receiveMessages.messageController;


import g1.MoonPie.clientServer.xml.MessageXML;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;



public class RemoveResponseController {


	
	
	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		int numberAffected = Integer.parseInt(map.getNamedItem("numberAffected").getNodeValue());
		
		System.out.println("removed" + numberAffected);
		//new AdminController(event, activity, key);
		
		
	}
}
