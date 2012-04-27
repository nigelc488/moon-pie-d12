package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.View.JoinEventView;
import g1.MoonPie.View.NewEventView;
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
public class JoinEventMessageController implements OnClickListener {

	Activity activity;
	
	public JoinEventMessageController(Activity activity){
		this.activity = activity;
	}
	
	@Override
	public void onClick(View v) {
		
		EditText eventIDText = (EditText) activity.findViewById(R.id.EventID);
		String eventID = eventIDText.getText().toString();
		EditText usernameText = (EditText) activity.findViewById(R.id.Username);
		String username = usernameText.getText().toString();
		EditText passwordText = (EditText) activity.findViewById(R.id.Password);
		String password = passwordText.getText().toString();
		
		SendMessageController.signInRequest(eventID, username, password);
		
		activity.setContentView(R.layout.welcome);
		
	}

}






