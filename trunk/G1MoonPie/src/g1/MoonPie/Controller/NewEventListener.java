package g1.MoonPie.Controller;

import g1.MoonPie.Model.Event;
import g1.MoonPie.View.NewEventView;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * This controller implements a OnClickListener for the "Create New Event" Button on the Welcome Screen
 * When the button is clicked this controller launches the view containing the form to create a new event
 * 
 * @author jpizz
 */
public class NewEventListener implements OnClickListener {

	/**The current Activity running this controller*/
	Activity activity;
	/**The current event being used*/
	Event event;
	
	/**
	 * Constructor which takes in the current activity
	 * 
	 * @param activity The current activity
	 */
	public NewEventListener(Activity activity){
		this.activity = activity;
	}
	
	/**
	 * Constructor which takes in the current activity and event
	 * 
	 * @param activity The current activity
	 * @param event The current event
	 */
	public NewEventListener(Activity activity, Event event){
		this.activity = activity;
		this.event = event;
	}
	
	/**
	 * This method is ran when the button is clicked to start the create event form's view
	 */
	@Override
	public void onClick(View v) {
		new NewEventView(event, activity);		
	}

}






