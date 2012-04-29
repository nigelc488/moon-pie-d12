package g1.MoonPie.clientServer.receiveMessages.messageController;


import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.xml.MessageXML;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;



public class CreateResponseController {

	
	public void process(MessageXML response){
		
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		String id = EncodeXML.decodeString(map.getNamedItem("id").getNodeValue());
	
		System.out.println("Created: id=" + id);
		
		//This is where you should call the createController
		//new ConnectController(id);
		
	}

}
