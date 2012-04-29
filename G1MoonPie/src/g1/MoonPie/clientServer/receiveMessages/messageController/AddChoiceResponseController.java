package g1.MoonPie.clientServer.receiveMessages.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;

import g1.MoonPie.R;
import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.Controller.AddChoiceController;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;

/**
 * This controller is used to parse the addChoiceResponse and call the necessary controller.
 * @author ncochran
 *
 */
public class AddChoiceResponseController {
	Activity activity;
	Event event;
	
	/**
	 * This constructor creates the controller with an event and activity which can be passed to other controllers.
	 * @param event Event The event used to access model objects
	 * @param activity The activity used to access GUI objects
	 */
	public AddChoiceResponseController(Event event, Activity activity){
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
		
		int line = Integer.parseInt(map.getNamedItem("number").getNodeValue());
		String choice = EncodeXML.decodeString(map.getNamedItem("choice").getNodeValue());
		System.out.println("Add Choice: Line: " + line + " choice: " + choice);
		
		//This is where you should call the addChoiceController
		new AddChoiceController(event, activity);
		
		
		
		//______________________________________________________
		//This code is just for testing but it shows how to retrieve text from a text field and also how to set the text.
		
		
		
		//sample code for how to update a text field
		
		//EditText text = (EditText)activity.findViewById(R.id.question);
		
		//EditText text = (EditText)activity.findViewById(R.id.choice1TB);
		//text.setText(choice);
		//text.setFocusable(false);
		
		//EditText text2 = (EditText)activity.findViewById(R.id.question);
		
		//EditText text2 = (EditText)activity.findViewById(R.id.choice1TB);
		//System.out.println("question text is: " + text2.getText());
		
		
		//somehow needs to update view though, so will probably need to be passed the right text box as well
		
	}
}
