package g1.MoonPie.Controller;

import g1.MoonPie.View.JoinEventView;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;

public class CloseAppController implements android.view.View.OnClickListener {
	
	Activity activity;
	
	public CloseAppController(Activity a){
	activity = a;	
	}
	
	/**
	 * This method is ran when the button is clicked to start the join event form's view
	 */
	@Override
	public void onClick(View v) {
		System.exit(0);
		
	}

	}
