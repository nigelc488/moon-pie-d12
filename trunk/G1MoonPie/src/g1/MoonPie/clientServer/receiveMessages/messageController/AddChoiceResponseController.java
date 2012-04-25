package g1.MoonPie.clientServer.receiveMessages.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.xml.MessageXML;

public class AddChoiceResponseController {
	Activity activity;
	Event event;
	
	public AddChoiceResponseController(Event event, Activity activity){
		this.event = event;
		this.activity = activity;
	}

	public void process(MessageXML response){
		System.out.println("response: " + response );
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		int line = Integer.parseInt(map.getNamedItem("number").getNodeValue());
		String choice = EncodeXML.decodeString(map.getNamedItem("choice").getNodeValue());
		System.out.println("Add Choice: Line: " + line + " choice: " + choice);
		
		//This is where you should call the addChoiceController
		//new AddChoiceController(activity, event, line, choice);
		
		
		//______________________________________________________
		//This code is just for testing but it shows how to retrieve text from a text field and also how to set the text.
		
		EditText text = (EditText)activity.findViewById(R.id.question);
		text.setText(choice);
		text.setFocusable(false);
		EditText text2 = (EditText)activity.findViewById(R.id.question);
		System.out.println("question text is: " + text2.getText());
		
		
		//somehow needs to update view though, so will probably need to be passed the right text box as well
		
	}
}