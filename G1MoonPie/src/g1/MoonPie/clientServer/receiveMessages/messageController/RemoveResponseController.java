package g1.MoonPie.clientServer.receiveMessages.messageController;

import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.xml.MessageXML;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;

/**
 * This class is used to process removeResponse xml messages and call the necessary controller.
 * @author ncochran
 *
 */
public class RemoveResponseController {
	Event event;
	Activity activity;
	
	/**
	 * This constructor requires an event and activity so they can be passed to the next controller.
	 * @param event Event The event used to access model objects
	 * @param activity Activity the activity used to access GUI objects
	 */
	public RemoveResponseController(Event event, Activity activity){
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
		
		int numberAffected = Integer.parseInt(map.getNamedItem("numberAffected").getNodeValue());
		
		System.out.println("removed" + numberAffected);
		//new AdminController(event, activity, key);
		
		
	}
}
