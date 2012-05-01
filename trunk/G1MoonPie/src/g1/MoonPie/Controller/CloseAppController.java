package g1.MoonPie.Controller;

import g1.MoonPie.View.JoinEventView;
import g1.MoonPie.clientServer.receiveMessages.ProcessThreadMessages;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;


/**
 * The Class CloseAppController closes the application when selected
 * 
 * @author J Lowrey
 */
public class CloseAppController implements android.view.View.OnClickListener {

	/** The activity. */
	Activity activity;

	/**
	 * Instantiates a new close app controller.
	 *
	 * @param a the a
	 */
	public CloseAppController(Activity a){
		activity = a;	
	}

	/**
	 * This method is ran when the button is clicked to kill the app
	 *
	 * @param v the v
	 */
	@Override
	public void onClick(View v) {
		//Force closes the app
		System.exit(0);


	}

}
