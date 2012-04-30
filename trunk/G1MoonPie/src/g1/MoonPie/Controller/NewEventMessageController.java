package g1.MoonPie.Controller;

import java.util.ArrayList;

import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.User;
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
		System.out.println("button clicked");
		boolean valid = true;
		
		EditText questionText = (EditText) activity.findViewById(R.id.question);
		String question = questionText.getText().toString();
		if (question.equals("")){
			Toast.makeText(activity, "Please enter a value for the question", Toast.LENGTH_SHORT).show();
			valid = false;
		}

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

		EditText usernameText = (EditText) activity.findViewById(R.id.username);
		String username = usernameText.getText().toString();
		if (username.equals("")){
			Toast.makeText(activity, "Please enter a value for the username", Toast.LENGTH_SHORT).show();
			valid = false;
		}

		EditText passwordText = (EditText) activity.findViewById(R.id.password);
		String password = passwordText.getText().toString();
		if (password.equals("")){
			Toast.makeText(activity, "Please enter a value for the password", Toast.LENGTH_SHORT).show();
			valid = false;
		}

		if (valid){
			
			//LAUNCH NEXT STEP
			
			
			//SendMessageController.createRequest(type, question, numChoices, numRounds, username, password);
			
			Event.getInstance().setOpen(isOpen);
			Event.getInstance().setNumChoices(numChoices);
			Event.getInstance().setNumRounds(numRounds);
			Event.getInstance().setUser(new User(username, password, 0));
			
	
			//Event event = new Event(numChoices, numRounds, question, isOpen);
			
			//SendMessageController.createRequest(type, question, numChoices, numRounds, username, password, event);
			
			//the following code should be executed after a response from the server
			ChoiceFormView view = new ChoiceFormView(Event.getInstance(), activity);		
			view.setChoicesVisibility();
		}

	}

}






