package g1.MoonPie.Controller;

import g1.MoonPie.View.JoinEventView;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * This controller implements a OnClickListener for the "Join Existing Event" Button on the Welcome Screen
 * When the button is clicked this controller launches the view containing the form to join an existing event
 * 
 * @author jpizz
 */
public class JoinEventListener implements OnClickListener {

	/**The current Activity running this controller*/
	Activity activity;
	
	/**
	 * Constructor which takes in the current activity
	 * 
	 * @param activity The current activity
	 */
	public JoinEventListener(Activity activity){
		this.activity = activity;
	}
	
	/**
	 * This method is ran when the button is clicked to start the join event form's view
	 */
	@Override
	public void onClick(View v) {
		new JoinEventView(activity);
	}

}






