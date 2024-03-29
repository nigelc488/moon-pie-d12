package g1.MoonPie.clientServer.receiveMessages.messageController;

import g1.MoonPie.Controller.AdminDataContorller;
import g1.MoonPie.Model.Entries;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;
import android.widget.Toast;

/**
 * This class is used to process removeResponse xml messages and call the necessary controller.
 * @author ncochran
 * @author Catherine Coleman
 *
 */
public class RemoveResponseController {
	Event event;
	Activity activity;
	Entries entries;
	
	/**
	 * This constructor requires an event and activity so they can be passed to the next controller.
	 * @param event Event The event used to access model objects
	 * @param activity Activity the activity used to access GUI objects
	 */
	public RemoveResponseController(Event event, Activity activity, Entries entries){
		this.event = event;
		this.activity = activity;
		this.entries = entries;
	}

	
	/**
	 * This method is used to do the actual processing of the message and calling of the controller.
	 * @param response MessageXML The message to be processed and reacted to.
	 */
	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		int numberAffected = Integer.parseInt(map.getNamedItem("numberAffected").getNodeValue());

		//Let the Admin know the requests has been processed
		Toast.makeText(activity, "Event(s) removed", Toast.LENGTH_SHORT).show();

		
		System.out.println("removed" + numberAffected);
		//new AdminController(event, activity, key);
		new AdminDataContorller(activity, entries.getKey());
		
		
	}
}
