package g1.MoonPie.clientServer.receiveMessages.messageController;

import java.util.ArrayList;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.widget.EditText;
import g1.MoonPie.R;
import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.Model.Entry;
import g1.MoonPie.Model.Event;
import g1.MoonPie.View.AdminView;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;

/**
 * This class is used to process reportResponse xml messages and call the necessary controller.
 * @author ncochran
 *
 */
public class ReportResponseController {
	Event event;
	Activity activity;
	ArrayList<Entry> entries;
	
	/**
	 * This constructor requires an event and activity so they can be passed to the next controller.
	 * @param event Event The event used to access model objects
	 * @param activity Activity the activity used to access GUI objects
	 */
	public ReportResponseController(Event event, Activity activity){
		this.event = event;
		this.activity = activity;
	}
	
	/**
	 * This method is used to do the actual processing of the message and calling of the controller.
	 * @param response MessageXML The message to be processed and reacted to.
	 */
	public void process(MessageXML response){
		//System.out.println("response: " + response );
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		entries = new ArrayList<Entry>();
		
		NodeList list = child.getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			NamedNodeMap map2 = node.getAttributes();
			
			String id = EncodeXML.decodeString(map2.getNamedItem("id").getNodeValue());
			String type = EncodeXML.decodeString(map2.getNamedItem("type").getNodeValue());
			int numChoices = Integer.parseInt(map2.getNamedItem("numChoices").getNodeValue());
			int numRounds = Integer.parseInt(map2.getNamedItem("numRounds").getNodeValue());
			String created = EncodeXML.decodeString(map2.getNamedItem("created").getNodeValue());
			boolean completed = Boolean.parseBoolean(map2.getNamedItem("completed").getNodeValue());
			entries.add(new Entry(id, type, numChoices, numRounds, created, completed));
			
		}
		
		AdminView av = new AdminView(activity);
		av.setTableValues(entries);

		//}
		
		
//		int line = Integer.parseInt(map.getNamedItem("number").getNodeValue());
//		String choice = map.getNamedItem("choice").getNodeValue();
//		System.out.println("Add Choice: Line: " + line + " choice: " + choice);
		
		//This is where you should call the addChoiceController
		//new AddChoiceController(activity, event, line, choice);
		
		
		//______________________________________________________
		//This code is just for testing but it shows how to retrieve text from a text field and also how to set the text.
		
		
		
		//somehow needs to update view though, so will probably need to be passed the right text box as well
		
	}
	
	

}
