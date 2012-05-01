package g1.MoonPie.View;

import g1.MoonPie.R;
import g1.MoonPie.Controller.JoinEventMessageController;
import android.app.Activity;
import android.widget.Button;

/**
 * This class is used to display the form for joining an existing event.
 * 
 * @author ncochran
 * @author jpizz
 *
 */
public class JoinEventView{
	
	/**The current Activity running this controller*/
	Activity activity;
	
	/**
	 * Constructor which takes in the current activity
	 * Sets to view to the form, and adds controller to the next button
	 * 
	 * @param activity The current activity
	 */
	public JoinEventView(Activity activity){
		this.activity = activity;
		
		activity.setContentView(R.layout.existingeventform);
		
		Button newEventButton = (Button) activity.findViewById(R.id.nextButton);
	    newEventButton.setOnClickListener(new JoinEventMessageController(activity));
		
	}


}
