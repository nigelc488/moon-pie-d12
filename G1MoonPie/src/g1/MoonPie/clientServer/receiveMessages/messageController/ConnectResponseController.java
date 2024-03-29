package g1.MoonPie.clientServer.receiveMessages.messageController;

import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;

/**
 * This class is used to process the connectResponse xml message.
 * @author ncochran
 *
 */
public class ConnectResponseController {
	Event event;
	Activity activity;
	
	/**
	 * This constructor is used pass the event and activity to the next controller.
	 * @param event Event The event used to access model objects
	 * @param activity The activity used to access GUI objects
	 */
	public ConnectResponseController(Event event, Activity activity){
		this.event = event;
		this.activity = activity;
	}
	
	/**
	 * This method is used to do the actual processing of the message and calling of the controller.
	 * @param response MessageXML The message to be processed and reacted to.
	 */
	public void process(MessageXML response){
		
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		//This id is not the event id.  This id shouldn't actually be used for anything.
		String id = EncodeXML.decodeString(map.getNamedItem("id").getNodeValue());
		System.out.println("The connect ID is: " + id);
		
		
		

		
	}

}
