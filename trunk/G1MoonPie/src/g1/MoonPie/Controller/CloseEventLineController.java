package g1.MoonPie.Controller;

import android.app.Activity;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.Line;
import g1.MoonPie.clientServer.receiveMessages.ProcessThreadMessages;

/**This class modifies the number of lines in an event if the moderator closes it before all users have joined.
 * 
 * @author Eric Cobane
 *
 */
public class CloseEventLineController {

	/**Event used for accessing model objects.*/
	Event event;
	/**Activity used for accessing view objects.*/
	Activity activity;

	/**Constructor needs access to event and activity.
	 * 
	 * @param e	the event to modify
	 * @param a	the activity
	 */
	public CloseEventLineController(Event e, Activity a){
		this.event = e;
		this.activity = a;

		//array containing the current lines for the event
		Line[] currentLines;
		currentLines = event.getLines();
		
		//array to carry over current lines that have choices already set
		Line[] newLines;
	
		int lineCount = 0;

		for(int i=0; i<currentLines.length; i++){
			if(!currentLines[i].getChoice().equals("")){
				lineCount++;
			}
		}
		//instantiate new line array at the correct size for lines that will be carried over
		newLines = new Line[lineCount];
		for (int i = 0; i<lineCount; i++){
			newLines[i] = new Line(i);
		}

		for(int j=0; j<newLines.length; j++){
			newLines[j].setChoice(currentLines[j].getChoice());
		}
		Event.getInstance().setLines(newLines);
		
		//not correct
		new CompleteDecisionController(Event.getInstance(), ProcessThreadMessages.getActivity());
	}
}
