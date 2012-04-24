package g1.MoonPie.clientServer.receiveMessages;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.xml.MessageXML;

public class TurnResponseController {
	Event event;
	Activity activity;
	
	public TurnResponseController(Event event, Activity activity){
		this.event = event;
		this.activity = activity;
	}
	
	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		boolean completed = Boolean.parseBoolean(map.getNamedItem("completed").getNodeValue());
		
		System.out.println("Turn completed?=" + completed);
		
		//new TurnController(event, activity, completed);
		
	}

}
