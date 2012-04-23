package g1.MoonPie.Controller;

import g1.MoonPie.View.NewEventView;
import g1.MoonPie.clientServer.SendMessageController;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class NewEventListener implements OnClickListener {

	Activity activity;
	
	public NewEventListener(Activity activity){
		this.activity = activity;
	}
	
	@Override
	public void onClick(View v) {
		//this part only for testing sending messages
		SendMessageController send = new SendMessageController();
		send.addChoiceRequest("idnumber", 1, "the ring");
		System.out.println("sent message");
		//end this part
		NewEventView view = new NewEventView(activity);
		
	}

}






