package g1.MoonPie.clientServer.receiveMessages;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.xml.MessageXML;

public class AdminResponseController {
	Event event;
	Activity activity;
	
	public AdminResponseController(Event event, Activity activity){
		this.event = event;
		this.activity = activity;
	}
	
	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		String key = map.getNamedItem("key").getNodeValue();
		
		System.out.println("Admin with key=" + key);
		//new AdminController(event, activity, key);
		
		
	}

}
