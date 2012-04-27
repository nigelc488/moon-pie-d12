package g1.MoonPie.Controller;

import g1.MoonPie.MoonPieActivity;
import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.View.NewEventView;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/**
 * This class is used as a listener for the create new event button.
 * Right now it is being used to test sending and receiving messages and displaying text upon my command (the button press).
 * @author ncochran
 *
 */
public class NewEventListener implements OnClickListener {

	Activity activity;
	
	public NewEventListener(Activity activity){
		this.activity = activity;
	}
	
	@Override
	public void onClick(View v) {
		
		//this part only for testing sending messages
		//SendMessageController send = new SendMessageController();
		
//		activity.setContentView(R.layout.results);
//		Toast.makeText(activity.getApplicationContext(), "send messages", Toast.LENGTH_LONG);
		
		SendMessageController.addChoiceRequest("id'number", 1, "the & ring");
		SendMessageController.addEdgeRequest("id'number2", 2, 3, 75);
		SendMessageController.adminRequest("nig'el", "");
		SendMessageController.closeRequest("id'number3");
		Event event = new Event(5, 3);
		event.getLines()[0].setChoice("first's choice");
		SendMessageController.createRequest("open", "who am < I", 5, 3, "nigel>", "password/>", event);
		event.getLines()[1].setChoice("second & choice");
		event.getLines()[3].setChoice("four'th choice");
		SendMessageController.createRequest("closed", "weee&ee", 5, 3, "jani'ne", "pa'ss", event);
		SendMessageController.forceRequest("key's here", "myi'd", 7);
		SendMessageController.removeRequest("key'key", "idt'ime", true, 60);
		SendMessageController.signInRequest("idn'umber", "cathe'rine", "past ten'se");
		SendMessageController.reportRequest("key'here", "closed");
		//end this part
	
		new NewEventView(activity);
		
		//Toast.makeText(new NoServerActicty(), "Could not Connect to Server.", Toast.LENGTH_LONG);
		
	}

}






