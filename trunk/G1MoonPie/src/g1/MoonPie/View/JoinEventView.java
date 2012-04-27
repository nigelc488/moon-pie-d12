package g1.MoonPie.View;

import g1.MoonPie.R;
import g1.MoonPie.Controller.JoinEventMessageController;
import g1.MoonPie.Controller.NewEventListener;
import g1.MoonPie.Controller.NumChoicesListener;
import g1.MoonPie.Controller.NumRoundsListener;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * This class is used to display the form for creating a new event.
 * It also adds action listeners to the drop down menus.
 * @author ncochran
 *
 */
public class JoinEventView{
	Activity activity;
	
public JoinEventView(Activity activity){
	
	this.activity = activity;
	
	activity.setContentView(R.layout.existingeventform);
	
	Button newEventButton = (Button) activity.findViewById(R.id.nextButton);
    newEventButton.setOnClickListener(new JoinEventMessageController(activity));
	
}


}
