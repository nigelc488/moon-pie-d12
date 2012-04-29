package g1.MoonPie.Controller;

import android.app.Activity;
import android.widget.TextView;
import g1.MoonPie.R;
import g1.MoonPie.Model.Event;

//Need a "DecisionLinesPanel" (per our UML) to initiate this controller.

/**This class is used to calculate the final decision for an event and display it on results.xml GUI.
 * 
 * @author Eric Cobane
 *
 */
public class CompleteDecisionController {

	/**Reference to the event for access to model objects.*/
	Event event;
	/**Reference to the activity for access to the GUI objects*/
	Activity activity;

	/**This constructor needs a reference of the event and activity to be worked on.
	 * 
	 * @param e	Event to get results from.
	 * @param a	Activity to display results on.
	 */
	public CompleteDecisionController(Event e, Activity a){

		this.event = e;
		this.activity  = a;
//	}
//
//
//	/**This method gets the calculated results for the event and displays them on the results screen.*/
//	public void calculateDecision(){

		activity.setContentView(R.layout.results);
		
		//get the array representing the ordered choice results
		String[] results = event.calculateResults();

		//set up an array of android TextViews to display choice results
		TextView[] choiceLabels = new TextView[8];

		//set up an array containing all possible choiceResult id's
		int[] choiceID = new int[8];
		choiceID[0] = R.id.choiceResult0;
		choiceID[1] = R.id.choiceResult1;
		choiceID[2] = R.id.choiceResult2;
		choiceID[3] = R.id.choiceResult3;
		choiceID[4] = R.id.choiceResult4;
		choiceID[5] = R.id.choiceResult5;
		choiceID[6] = R.id.choiceResult6;
		choiceID[7] = R.id.choiceResult7;

		for(int i=0; i<results.length; i++){

			//set each TextView to the correct result choice to display top to bottom
			choiceLabels[i] = (TextView) activity.findViewById(choiceID[i]);
			choiceLabels[i].setText((i + 1) + ")"+ "  " + results[i]);
		}
	}
}
