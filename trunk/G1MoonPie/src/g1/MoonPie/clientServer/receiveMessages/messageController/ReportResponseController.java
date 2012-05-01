package g1.MoonPie.clientServer.receiveMessages.messageController;

import java.util.ArrayList;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.Controller.AdminViewTypeController;
import g1.MoonPie.Model.Entries;
import g1.MoonPie.Model.Entry;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;

/**
 * This class is used to process reportResponse xml messages and call the necessary controller.
 * @author ncochran
 * @author Catherine Coleman
 */
public class ReportResponseController {
	Event event;
	Entries ent;
	Activity activity;
	ArrayList<Entry> entries;
	
	/**
	 * This constructor requires an event and activity so they can be passed to the next controller.
	 * @param event Event The event used to access model objects
	 * @param activity Activity the activity used to access GUI objects
	 */
	public ReportResponseController(Event event, Activity activity, Entries entries){
		this.event = event;
		this.activity = activity;
		this.ent = entries;
	}
	
	/**
	 * This method is used to do the actual processing of the message and calling of the controller.
	 * @param response MessageXML The message to be processed and reacted to.
	 */
	public void process(MessageXML response){
		//System.out.println("response: " + response );
		Node child = response.contents.getFirstChild();
		
		entries = new ArrayList<Entry>();
		
		NodeList list = child.getChildNodes();

		for (int i = 0; i < list.getLength(); i++) {
			Node node = list.item(i);
			NamedNodeMap map2 = node.getAttributes();
			
			String id = EncodeXML.decodeString(map2.getNamedItem("id").getNodeValue());
			String type = EncodeXML.decodeString(map2.getNamedItem("type").getNodeValue());
			String question = EncodeXML.decodeString(map2.getNamedItem("question").getNodeValue());
			int numChoices = Integer.parseInt(map2.getNamedItem("numChoices").getNodeValue());
			int numRounds = Integer.parseInt(map2.getNamedItem("numRounds").getNodeValue());
			String created = EncodeXML.decodeString(map2.getNamedItem("created").getNodeValue());
			boolean completed = Boolean.parseBoolean(map2.getNamedItem("completed").getNodeValue());
			entries.add(new Entry(id, type, question, numChoices, numRounds, created, completed));
			
		}
		
		ent.setEntires(entries);
		AdminViewTypeController avtc = new AdminViewTypeController(activity, ent.getKey());
		avtc.EnableVisability(ent);
		
	}
	
	

}
