package g1.MoonPie.clientServer.receiveMessages.messageController;

import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;

/**
 * This controller is used to process the closeResponse message and call the necessary controller.
 * @author ncochran
 *
 */
public class CloseResponseController {
	Event event;
	Activity activity;
	
	/**
	 * This constructor requires an event and activity so they can be passed to the next controller.
	 * @param event Event The event used to access model objects
	 * @param activity Activity the activity used to access GUI objects
	 */
	public CloseResponseController(Event event, Activity activity){
		this.event = event;
		this.activity = activity;
	}

	/**
	 * This method is used to do the actual processing of the message and calling of the controller.
	 * @param response MessageXML The message to be processed and reacted to.
	 */
	public void process(MessageXML response){
		//for this request, any message works so there is no need to process the message itself
		
		System.out.println("Close the event");
		
		//This is where you should call the closeEventController
		//new CloseEventController();
		
		//needs to know what button to hide so will need to know about the Activity
		
	}
	
}
