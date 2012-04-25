package g1.MoonPie.clientServer.receiveMessages.messageController;

import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.xml.MessageXML;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;

/**
 * This controller is used to process the addEdgeResponse and call the necessary controller.
 * @author ncochran
 *
 */
public class AddEdgeResponseController {
	Event event;
	Activity activity;
	
	/**
	 * This constructor is used to pass the event and activity on to the next controller.
	 * @param event Event The event used to access model objects.
	 * @param activity Activity The activity used to access GUI objects.
	 */
	public AddEdgeResponseController(Event event, Activity activity){
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
		String id = EncodeXML.decodeString(map.getNamedItem("id").getNodeValue());
		int left = Integer.parseInt(map.getNamedItem("left").getNodeValue());
		int right = Integer.parseInt(map.getNamedItem("right").getNodeValue());
		int height = Integer.parseInt(map.getNamedItem("height").getNodeValue());
		
		System.out.println("Add Edge: id=" + id + " left=" + left + " right=" + right +" height=" + height);
		
		//This is where you should call the addEdgeController
		//new AddEdgeController(left, right, height);
		
		//need to update the view so will need to know about the panel or whatever that is being drawn on
	}
	
}
