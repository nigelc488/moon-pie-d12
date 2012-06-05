package g1.MoonPie.Controller;

import g1.MoonPie.MoonPieActivity;
import g1.MoonPie.Model.Event;
import g1.MoonPie.View.NewEventView;
import g1.MoonPie.clientServer.receiveMessages.ProcessThreadMessages;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class StartNewEventListener implements OnClickListener {

	
	/**
	 * Constructor which takes in the current activity
	 * 
	 * @param activity The current activity
	 */
	public StartNewEventListener(){
	}
	
	/**
	 * This method is ran when the button is clicked to start the create event form's view
	 */
	@Override
	public void onClick(View v) {
		System.out.println("start new event button Pressed");
		Event.setInstance();
		Intent intent = new Intent(ProcessThreadMessages.getActivity(),
				MoonPieActivity.class);
		ProcessThreadMessages.getActivity().startActivity(intent);
	}

}






