package g1.MoonPie.View;

import g1.MoonPie.R;
import g1.MoonPie.Controller.NumChoicesListener;
import g1.MoonPie.Controller.NumRoundsListener;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewEventView{
	Activity activity;
public NewEventView(Activity activity){
	
	this.activity = activity;
	
	activity.setContentView(R.layout.new_event_form);
	
    Spinner choicesSpinner = (Spinner) activity.findViewById(R.id.numChoices);
    ArrayAdapter<CharSequence> choicesAdapter = ArrayAdapter.createFromResource(activity, R.array.choices_array, android.R.layout.simple_spinner_item);
    choicesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    choicesSpinner.setAdapter(choicesAdapter);
    choicesSpinner.setOnItemSelectedListener(new NumChoicesListener());
    
    Spinner roundsSpinner = (Spinner) activity.findViewById(R.id.numRounds);
    ArrayAdapter<CharSequence> roundsAdapter = ArrayAdapter.createFromResource(activity, R.array.choices_array, android.R.layout.simple_spinner_item);
    roundsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    roundsSpinner.setAdapter(roundsAdapter);
    roundsSpinner.setOnItemSelectedListener(new NumRoundsListener());
}


}
