package g1.MoonPie.clientServer.receiveMessages.messageController;

import g1.MoonPie.DecisionLinesFormActivity;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.Line;
import g1.MoonPie.View.EventView;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;
import g1.MoonPie.clientServer.receiveMessages.ProcessThreadMessages;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

/**
 * This controller is used to process the closeResponse message and call the necessary controller.
 * @author ncochran
 *
 */
public class CloseResponseController {
	Event event;
	Activity activity;
	
	/**
	 * This constructor requires an event and activity so they can be passed to the next controller.
	 * @param event Event The event used to access model objects
	 * @param activity Activity the activity used to access GUI objects
	 */
	public CloseResponseController(Event event, Activity activity){
		this.event = event;
		this.activity = activity;
	}

	/**
	 * This method is used to do the actual processing of the message and calling of the controller.
	 * @param response MessageXML The message to be processed and reacted to.
	 */
	public void process(MessageXML response){
		
		//System.out.println("Close the event");
		
		Line[] currentLines;
		currentLines = event.getLines();
		
		int lineCount = 0;
		
		for(int i=0; i<currentLines.length; i++){
			if(!currentLines[i].getChoice().equals("")){
				lineCount++;
			}
		}
		
		if(lineCount > 2){
		Intent intent = new Intent(ProcessThreadMessages.getActivity(), DecisionLinesFormActivity.class);
		ProcessThreadMessages.getActivity().startActivity(intent);
		}else{
			Toast.makeText(ProcessThreadMessages.getActivity(), "There are only " + (lineCount+1) + " Choices.  Need at least 3.", Toast.LENGTH_SHORT).show();
			System.out.println("Too few");
		}
		
		
		
		
//		Activity dummy = new Activity();
//		
//		EventView eventView = new EventView(event, dummy);
		
		
		//This is where you should call the closeEventController
		//new CloseEventController();
		
		//needs to know what button to hide so will need to know about the Activity
		
	}
	
}
