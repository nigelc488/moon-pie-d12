package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

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
		//Something about open or closed events
		String type = "closed"; //edit this
		//Find nigels stuff for num choices and rounds
		int numChoices = 3;
		int numRounds = 3;
		EditText usernameText = (EditText) activity.findViewById(R.id.username);
		String username = usernameText.getText().toString();
		EditText passwordText = (EditText) activity.findViewById(R.id.password);
		String password = passwordText.getText().toString();
		Event event = new Event(numChoices, numRounds);

		SendMessageController.createRequest(type, question, numChoices, numRounds, username, password, event);
		
		activity.setContentView(R.layout.welcome);
		
	}

}






