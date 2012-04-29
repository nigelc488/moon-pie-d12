package g1.MoonPie.clientServer.receiveMessages.messageController;

import java.util.ArrayList;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import g1.MoonPie.Model.Entry;
import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.xml.MessageXML;

public class ReportResponseController {

	public void process(MessageXML response){
		System.out.println("response: " + response );
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		ArrayList<Entry> entries = new ArrayList<Entry>();
		
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
