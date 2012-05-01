package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.User;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

/**
 * This controller implements a OnClickListener for the "Next" Button on the Join Existing Event Screen
 * When the button is clicked this controller view containing a waiting screen
 * 
 * @author jpizz
 * @author ncochran
 * 
 */
public class JoinEventMessageController implements OnClickListener {

	/**The current Activity running this controller*/
	Activity activity;

	/**
	 * Constructor which takes in the current activity
	 * 
	 * @param activity The current activity
	 */
	public JoinEventMessageController(Activity activity){
		this.activity = activity;
	}

	/**
	 * This method is ran when the button is clicked to send appropriate messages to the server if all values in the form are valid
	 */
	@Override
	public void onClick(View v) {
		boolean valid = true;

		System.out.println("button clicked");
		//Get Values from Text Boxes
		EditText eventIDText = (EditText) activity.findViewById(R.id.EventID);
		String eventID = eventIDText.getText().toString();
		EditText usernameText = (EditText) activity.findViewById(R.id.Username);
		String username = usernameText.getText().toString();
		EditText passwordText = (EditText) activity.findViewById(R.id.Password);
		String password = passwordText.getText().toString();
		
		//Check for valid values and alert users if there are any errors
		if (eventID.equals("")){
			System.out.println("Blank Event ID");
			Toast.makeText(activity, "Please enter a value for the Event ID", Toast.LENGTH_SHORT).show();
			valid = false;
		}
		if (username.equals("")){
			System.out.println("Blank Username");
			Toast.makeText(activity, "Please enter a value for the username", Toast.LENGTH_SHORT).show();
			valid = false;
		}
		
		//If there are errors do nothing else, but if everything is valid send the appropriate messages to the server
		if (valid){
			System.out.println("valid username and password");
			//check if user is admin (eventID is admin and admin's username is admin, password is key)
			if(eventID.equals("admin") && username.equals("admin") && password.equals("key")){
				System.out.println("user is an Admin, request sent");
				SendMessageController.adminRequest("admin", "key");
			}else{
				
				System.out.println("added user,sent sign in request");
				//add the user to the event and send the sign in request to the server
				Event.getInstance().setUser(new User(username, password));
				SendMessageController.signInRequest(eventID, username, password);
			}
		}
	}

}






