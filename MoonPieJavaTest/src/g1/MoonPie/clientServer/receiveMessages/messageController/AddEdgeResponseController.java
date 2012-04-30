package g1.MoonPie.clientServer.receiveMessages.messageController;


import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.xml.MessageXML;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


public class AddEdgeResponseController {
	int left;
	int right;
	int height;


	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		String id = EncodeXML.decodeString(map.getNamedItem("id").getNodeValue());
		left = Integer.parseInt(map.getNamedItem("left").getNodeValue());
	    right = Integer.parseInt(map.getNamedItem("right").getNodeValue());
		height = Integer.parseInt(map.getNamedItem("height").getNodeValue());
		
		System.out.println("Add Edge: id=" + id + " left=" + left + " right=" + right +" height=" + height);
		
		//This is where you should call the addEdgeController
		//new AddEdgeController(left, right, height);
		
		//need to update the view so will need to know about the panel or whatever that is being drawn on
	}


	public int getLeft() {
		return left;
	}


	public int getRight() {
		return right;
	}


	public int getHeight() {
		return height;
	}
	
	
	
}