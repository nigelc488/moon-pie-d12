package g1.MoonPie.View;

import g1.MoonPie.R;
import g1.MoonPie.Controller.AddChoiceController;
import g1.MoonPie.Controller.CloseEventController;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.User;
import android.app.Activity;
import android.widget.Button;

/**This class is used to set up the waiting view, and allow moderators only to close event.
 * 
 * @author Eric Cobane
 * @author Janine Pizzimenti
 * @author Jeremy Lowrey
 * @author Nigel Cochran
 */
public class CloseEventView {

	Activity activity;
	Event event;
	User user;

	/**Constructor requires event, user, and activity.
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

		//if the user is not a moderator hide the close event button
		if(!(Event.getInstance().getUser().getPostion() == 0)){
			closeButton.setVisibility(4);
		}
		//if user is a moderator display close vent button and add listener
		else{
			closeButton.setOnClickListener(new CloseEventController(event, user, activity));
		}
	}
}





