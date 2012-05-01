package g1.MoonPie.clientServer.receiveMessages.messageController;

import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.Model.Event;
import g1.MoonPie.View.DecisionLinesForm;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;
import g1.MoonPie.clientServer.receiveMessages.ProcessThreadMessages2;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;

/**
 * This controller is used to process the addEdgeRespone, adds the Edge, and updates the GUI.
 * @author ncochran
 *
 */
public class AddEdgeResponseController {
	Event event;
	Activity activity;
	
	/**
	 * This constructor is used to pass the event and activity on to the next controller.
	 * @param event Event The event used to access model objects
	 * @param activity Activity The activity used to access GUI objects
	 */
	public AddEdgeResponseController(Event event, Activity activity){
		this.event = event;
		this.activity = activity;
	}

	/**
	 * This method is used to do the actual processing of the message and calling of the controller.
	 * It adds the Edge to the Event and tells the Canvas to redraw.
	 * @param response MessageXML The message to be processed and reacted to
	 */
	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		String id = EncodeXML.decodeString(map.getNamedItem("id").getNodeValue());
		int left = Integer.parseInt(map.getNamedItem("left").getNodeValue());
		int right = Integer.parseInt(map.getNamedItem("right").getNodeValue());
		int height = Integer.parseInt(map.getNamedItem("height").getNodeValue());
		
		System.out.println("Add Edge: id=" + id + " left=" + left + " right=" + right +" height=" + height);
		
		Event.getInstance().addEdge(height, left, right);
		DecisionLinesForm.getInstance().postInvalidate();
		
	}
	
}
