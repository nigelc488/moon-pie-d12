package g1.MoonPie.View;

import g1.MoonPie.R;
import g1.MoonPie.Controller.CompleteDecisionController;
import g1.MoonPie.Model.Entries;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.User;
import android.app.Activity;
import android.widget.TextView;

public class EventView {
	
	Activity activity;
	Event event;

	/**Constructor requires event, user, and activity.
	 * 
	 * @param e	event to access model objects.
	 * @param a	activity to access view objects.
	 */
	public EventView(Event e, Activity a){

		this.event = e;
		this.activity = a;
		
		CompleteDecisionController cdc = new CompleteDecisionController(event, activity);
	}
}
