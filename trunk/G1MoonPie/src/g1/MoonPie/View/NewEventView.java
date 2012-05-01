package g1.MoonPie.View;

import g1.MoonPie.R;
import g1.MoonPie.Controller.NewEventMessageController;
import g1.MoonPie.Model.Event;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * This class is used to display the form for creating a new event.
 * 
 * @author ncochran
 * @author jpizz
 *
 */
public class NewEventView{

	/**The current Activity running this controller*/
	Activity activity;
	/**The current event being used*/
	Event event;
	
	/**
	 * Constructor which takes in the current activity and event
	 * Also sets view to the new event form, and adds listener to next button
	 * 
	 * @param activity The current activity
	 * @param event The current event
	 */
	public NewEventView(Event event,Activity activity){
		this.event = event;
		this.activity = activity;
		
		activity.setContentView(R.layout.new_event_form);
		
	    Spinner choicesSpinner = (Spinner) activity.findViewById(R.id.numChoices);
	    ArrayAdapter<CharSequence> choicesAdapter = ArrayAdapter.createFromResource(activity, R.array.choices_array, android.R.layout.simple_spinner_item);
	    choicesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    choicesSpinner.setAdapter(choicesAdapter);
	    
	    Spinner roundsSpinner = (Spinner) activity.findViewById(R.id.numRounds);
	    ArrayAdapter<CharSequence> roundsAdapter = ArrayAdapter.createFromResource(activity, R.array.choices_array, android.R.layout.simple_spinner_item);
	    roundsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    roundsSpinner.setAdapter(roundsAdapter);
	    
		Button newEventButton = (Button) activity.findViewById(R.id.nextButton);
	    newEventButton.setOnClickListener(new NewEventMessageController(event, activity));
	}


}
