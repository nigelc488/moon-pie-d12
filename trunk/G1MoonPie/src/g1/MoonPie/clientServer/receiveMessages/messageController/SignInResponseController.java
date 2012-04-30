package g1.MoonPie.clientServer.receiveMessages.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;
import android.widget.EditText;
import g1.MoonPie.R;
import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.Model.Event;
import g1.MoonPie.View.ChoiceFormView;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;

/**
 * this class is used to process signInResponse xml messages and call the necessary controller.
 * @author ncochran
 *
 */
public class SignInResponseController {
	Event event;
	Activity activity;
	
	/**
	 * This constructor requires an event and activity so they can be passed to the next controller.
	 * @param event Event The event used to access model objects
	 * @param activity Activity the activity used to access GUI objects
	 */
	public SignInResponseController(Event event, Activity activity){
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
		String type = EncodeXML.decodeString(map.getNamedItem("type").getNodeValue());
		String question = EncodeXML.decodeString(map.getNamedItem("question").getNodeValue());
		int numChoices = Integer.parseInt(map.getNamedItem("numChoices").getNodeValue());
		int numRounds = Integer.parseInt(map.getNamedItem("numRounds").getNodeValue());
		int position = Integer.parseInt(map.getNamedItem("position").getNodeValue());
		
		System.out.println("SignIn with id=" + id + " type=" + type + " question=" + question + " numChoices=" + numChoices + " numRounds=" + numRounds + " position=" + position);
		
		event.setPos(position);
		
		if(event.getIsOpen()){
			
			ChoiceFormView view = new ChoiceFormView(event,activity);		
			view.setChoicesVisibility();
		}
		else{
			
			//Send to EventView (Chris's stuff)
		}
		
		
		//the following code should be executed after a response from the server
		//new SignInController(event, activity, id, type, question, numChoices, numRounds, position);
		//somehow needs to update view though, so will probably need to be passed the right text box as well
		
	}

}
