package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.View.ChoiceFormView;
import g1.MoonPie.View.NewEventView;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class is used as a listener for the create join event button.
 * @author jpizz
 *
 */
public class NewEventMessageController implements OnClickListener {

	Activity activity;

	public NewEventMessageController(Activity activity){
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		EditText questionText = (EditText) activity.findViewById(R.id.question);
		String question = questionText.getText().toString();

		String type; boolean isOpen;
		RadioGroup availability = (RadioGroup) activity.findViewById(R.id.availability);
		int checkedRadioButton = availability.getCheckedRadioButtonId();
		if (checkedRadioButton == R.id.openEvent){
			type = "open";
			isOpen = true;
		}
		else{
			type = "closed";
			isOpen = false;
		}

		Spinner choicesSpinner = (Spinner) activity.findViewById(R.id.numChoices);
		Spinner roundsSpinner = (Spinner) activity.findViewById(R.id.numRounds);
		int numChoices = Integer.parseInt(choicesSpinner.getSelectedItem().toString());
		int numRounds = Integer.parseInt(roundsSpinner.getSelectedItem().toString());
		Toast.makeText(activity, "c:"+numChoices+" r:"+numRounds+" a:"+type, Toast.LENGTH_LONG).show();

		EditText usernameText = (EditText) activity.findViewById(R.id.username);
		String username = usernameText.getText().toString();

		EditText passwordText = (EditText) activity.findViewById(R.id.password);
		String password = passwordText.getText().toString();

		Event event = new Event(numChoices, numRounds, question, isOpen);
		//SendMessageController.createRequest(type, question, numChoices, numRounds, username, password, event);

		//the following code should be executed after a response from the server
		ChoiceFormView view = new ChoiceFormView(event,activity);
		activity.setContentView(R.layout.choiceform);
		view.setChoicesVisibility();

	}

}






