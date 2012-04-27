package g1.MoonPie.clientServer.receiveMessages.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;
import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;

/**
 * This class is used to process the adminResponse message and call the necessary controller.
 * @author ncochran
 *
 */
public class AdminResponseController {
	Event event;
	Activity activity;
	
	/**
	 * This constructor is used so the controller can pass the event and activity to the next controller.
	 * @param event Event The event used to access model objects
	 * @param activity Activity The activity used to access GUI objects
	 */
	public AdminResponseController(Event event, Activity activity){
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
		
		String key = EncodeXML.decodeString(map.getNamedItem("key").getNodeValue());
		
		System.out.println("Admin with key=" + key);
		//new AdminController(event, activity, key);
		
		
	}

}
