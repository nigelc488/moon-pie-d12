package g1.MoonPie.clientServer.receiveMessages.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;
import android.content.Intent;


import g1.MoonPie.DecisionLinesFormActivity;
import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.Controller.AddChoiceController;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.Line;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;
import g1.MoonPie.clientServer.receiveMessages.ProcessThreadMessages;

/**
 * This controller is used to parse the addChoiceResponse and then call the add choice controller.
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
		System.out.println("response: " + response );
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		int line = Integer.parseInt(map.getNamedItem("number").getNodeValue());
		String choice = EncodeXML.decodeString(map.getNamedItem("choice").getNodeValue());
		System.out.println("Add Choice: Line: " + line + " choice: " + choice);
		
		//This is where you should call the addChoiceController
		Event.getInstance().getLines()[line].setChoice(choice);
		
		//check to see if is the last choice
		//if so then display edge form
		
		Line[] currentLines;
		currentLines = event.getLines();
		
		int lineCount = 0;
	
		//check to see how many choices
		for(int i=0; i<currentLines.length; i++){
			if(!currentLines[i].getChoice().equals("")){
				lineCount++;
			}
		}
		
		if(lineCount == Event.getInstance().getNumChoices()){
			Intent intent = new Intent(ProcessThreadMessages.getActivity(),
					DecisionLinesFormActivity.class);
			ProcessThreadMessages.getActivity().startActivity(intent);
		}
		
		new AddChoiceController(event, activity);
		
	}
}
