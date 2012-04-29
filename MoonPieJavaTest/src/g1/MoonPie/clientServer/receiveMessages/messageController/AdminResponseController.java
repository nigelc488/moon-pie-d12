package g1.MoonPie.clientServer.receiveMessages.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.xml.MessageXML;

public class AdminResponseController {
	String key;
	
	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		key = EncodeXML.decodeString(map.getNamedItem("key").getNodeValue());
		
		System.out.println("Admin with key=" + key);
		//new AdminController(event, activity, key);
	}

	public String getKey() {
		return key;
	}

}
