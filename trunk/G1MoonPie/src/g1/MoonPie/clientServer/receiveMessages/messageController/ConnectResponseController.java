package g1.MoonPie.clientServer.receiveMessages.messageController;

import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.xml.MessageXML;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;

public class ConnectResponseController {
	Event event;
	Activity activity;
	
	public ConnectResponseController(Event event, Activity activity){
		this.event = event;
		this.activity = activity;
	}
	
	public void process(MessageXML response){
		
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		String id = map.getNamedItem("id").getNodeValue();
	
		System.out.println("Connected: id=" + id);
		
		//This is where you should call the ConnectController
		//new ConnectController(id);
		
	}

}
