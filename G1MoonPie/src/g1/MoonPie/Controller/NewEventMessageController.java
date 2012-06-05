package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.User;
import g1.MoonPie.View.ChoiceFormView;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * This controller implements a OnClickListener for the "Next" Button on the Join Existing Event Screen
 * When the button is clicked this controller view containing a waiting screen
 * 
 * @author jpizz
 *
 */
public class NewEventMessageController implements OnClickListener {


	/**The current Activity running this controller*/
	Activity activity;
	/**The current event being used*/
	Event event;
	
	
	/**
	 * Constructor which takes in the current activity and event
	 * 
	 * @param activity The current activity
	 * @param event The current event
	 */
	public NewEventMessageController(Event event, Activity activity){
		this.activity = activity;
	}

	/**
	 * This method is ran when the button is clicked to update the event if all values in the form are valid
	 */
	@Override
	public void onClick(View v) {
		System.out.println("create join event button selected");
		boolean valid = true;
		
		//Get values from form and check if they are valid
		EditText questionText = (EditText) activity.findViewById(R.id.question);
		String question = questionText.getText().toString();
		if (question.equals("")){
			System.out.println("blank question");
			Toast.makeText(activity, "Please enter a value for the question", Toast.LENGTH_SHORT).show();
			valid = false;
		}

		boolean isOpen;
		
		isOpen = false;
		//can be used with new_event_form_old.xml
//		RadioGroup availability = (RadioGroup) activity.findViewById(R.id.availability);
//		int checkedRadioButton = availability.getCheckedRadioButtonId();
//		if (checkedRadioButton == R.id.openEvent){
//			System.out.println("radio button on Open");
//			isOpen = true;
//		}
//		else{
//			System.out.println("radio button on closed");
//			isOpen = false;
//		}

		Spinner choicesSpinner = (Spinner) activity.findViewById(R.id.numChoices);
		Spinner roundsSpinner = (Spinner) activity.findViewById(R.id.numRounds);
		int numChoices = Integer.parseInt(choicesSpinner.getSelectedItem().toString());
		System.out.println("numChoices = "+numChoices);
		int numRounds = Integer.parseInt(roundsSpinner.getSelectedItem().toString());
		System.out.println("numRounds = "+numRounds);
		
	//can be changed if use new_event_form_old.xml
//		EditText usernameText = (EditText) activity.findViewById(R.id.username);
//		String username = usernameText.getText().toString();
		String username = "Nigel";
		
		System.out.println("username = "+ username);
		if (username.equals("")){
			System.out.println("Blank username");
			Toast.makeText(activity, "Please enter a value for the username", Toast.LENGTH_SHORT).show();
			valid = false;
		}

		
		//can be changed if use new_event_form_old.xml
//		EditText passwordText = (EditText) activity.findViewById(R.id.password);
//		String password = passwordText.getText().toString();
		String password = "greenRobot";
		System.out.println("password = "+password);
		
		//If there are errors do nothing else, but if everything is valid send the appropriate messages to the server
		if (valid){
			//Update the event to the values from the form
			Event.getInstance().setQuestion(question);
			Event.getInstance().setOpen(isOpen);
			Event.getInstance().setNumChoices(numChoices);
			Event.getInstance().setNumRounds(numRounds);
			Event.getInstance().setUser(new User(username, password, 0));
			Event.getInstance().setQuestion(question);

			//Set the view to the choice form view
			
			System.out.println("vaild new event");
			ChoiceFormView view = new ChoiceFormView(Event.getInstance(), activity);		
			view.setChoicesVisibility();
		}
	}

}






