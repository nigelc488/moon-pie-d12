package g1.MoonPie.clientServer.receiveMessages;

import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.xml.MessageXML;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;

public class AddEdgeResponseController {
	Event event;
	Activity activity;
	
	public AddEdgeResponseController(Event event, Activity activity){
		this.event = event;
		this.activity = activity;
	}

	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		String id = map.getNamedItem("id").getNodeValue();
		int left = Integer.parseInt(map.getNamedItem("left").getNodeValue());
		int right = Integer.parseInt(map.getNamedItem("right").getNodeValue());
		int height = Integer.parseInt(map.getNamedItem("height").getNodeValue());
		
		System.out.println("Add Edge: id=" + id + " left=" + left + " right=" + right +" height=" + height);
		
		//This is where you should call the addEdgeController
		//new AddEdgeController(left, right, height);
		
		//need to update the view so will need to know about the panel or whatever that is being drawn on
	}
	
}
