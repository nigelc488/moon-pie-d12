package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.View.ChoiceFormView;
import g1.MoonPie.View.JoinEventView;
import g1.MoonPie.View.NewEventView;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class is used as a listener for the create join event button.
 * @author jpizz
 *
 */
public class JoinEventMessageController implements OnClickListener {

	Activity activity;

	public JoinEventMessageController(Activity activity){
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		boolean valid = true;

		EditText eventIDText = (EditText) activity.findViewById(R.id.EventID);
		String eventID = eventIDText.getText().toString();
		if (eventID.equals("")){
			Toast.makeText(activity, "Please enter a value for the Event ID", Toast.LENGTH_SHORT).show();
			valid = false;
		}

		EditText usernameText = (EditText) activity.findViewById(R.id.Username);
		String username = usernameText.getText().toString();
		if (username.equals("")){
			Toast.makeText(activity, "Please enter a value for the username", Toast.LENGTH_SHORT).show();
			valid = false;
		}

		EditText passwordText = (EditText) activity.findViewById(R.id.Password);
		String password = passwordText.getText().toString();
		if (password.equals("")){
			Toast.makeText(activity, "Please enter a value for the password", Toast.LENGTH_SHORT).show();
			valid = false;
		}

		if (valid){

			//check if user is admin (admin's username is admin, password is key)
			if(username.equals("admin") && password.equals("key")){

				//SendMessageController.adminRequest("admin", "key");

			}

			else{

				//SendMessageController.signInRequest(eventID, username, password);

				activity.setContentView(R.layout.choiceform);

				//the following code should be executed after a response from the server
				//ChoiceFormView view = new ChoiceFormView(event,activity);		
				//view.setChoicesVisibility();
			}
		}


	}

}






