package g1.MoonPie.clientServer.receiveMessages.messageController;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;

/**
 * This class is used to process createResponse xml messages and call the necessary controller.
 * @author ncochran
 * @author jpizz
 *
 */
public class CreateResponseController {
	Event event;
	Activity activity;
	
	/**
	 * This constructor requires an event and activity so they can be passed to the next controller.
	 * @param event Event The event used to access model objects
	 * @param activity Activity the activity used to access GUI objects
	 */
	public CreateResponseController(Event event, Activity activity){
		this.event = Event.getInstance();
		this.activity = activity;
	}
	
	/**
	 * This method is used to do the actual processing of the message and calling of the controller.
	 * @param response MessageXML The message to be processed and reacted to.
	 */
	public void process(MessageXML response){
		
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		String id = EncodeXML.decodeString(map.getNamedItem("id").getNodeValue());
		Event.getInstance().setID(id);
		System.out.println("Created: id=" + id);
		
		//always need to sign in after creating (but only if server works so just leave this commented out
		SendMessageController.signInRequest(id, Event.getInstance().getUser().getUsername(), Event.getInstance().getUser().getPassword());
		
	}

}
