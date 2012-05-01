package g1.MoonPie.View;

import g1.MoonPie.R;
import g1.MoonPie.Controller.CloseEventController;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.User;
import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;

/**This class is used to set up the waiting view, and allow moderators only to close event.
 * 
 * @author Eric Cobane
 * @author Janine Pizzimenti
 * @author Jeremy Lowrey
 */
public class CloseEventView {

	/**The current Activity running this controller*/
	Activity activity;
	/**The current event being used*/
	Event event;
	/**The current user*/
	User user;

	/**Constructor which takes event, user, and activity.
	 * Also sets adds controller to and sets visibility for close button
	 * 
	 * @param e	event to access model objects.
	 * @param u	user to access privileges (moderator or not).
	 * @param a	activity to access view objects.
	 */
	public CloseEventView(Event e, Activity a){
		this.event = e;
		this.activity = a;

		activity.setContentView(R.layout.waiting);
		Button closeButton = (Button) activity.findViewById(R.id.closeButton);
		
		TextView eventID = (TextView) activity.findViewById(R.id.EventIDDisp);
		eventID.setText("Event ID: "+event.getID());
		
		//if the user is not a moderator hide the close event button
		if(!(Event.getInstance().getUser().getPostion() == 0)){
			closeButton.setVisibility(4);
			eventID.setVisibility(4);
		}
		//if user is a moderator display close vent button and add listener
		else{
			closeButton.setOnClickListener(new CloseEventController(event, user, activity));
		}
	}
}





