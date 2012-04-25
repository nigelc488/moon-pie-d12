package g1.MoonPie.Controller;

import g1.MoonPie.Model.Event;
import g1.MoonPie.View.NewEventView;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
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
		send.addEdgeRequest("idnumber2", 2, 3, 75);
		send.adminRequest("nigel", null);
		send.closeRequest("idnumber3");
		Event event = new Event(5, 3);
		event.getLines()[0].setChoice("first choice");
		send.createRequest("open", "who am I", 5, 3, "nigel", "password", event);
		event.getLines()[1].setChoice("second choice");
		event.getLines()[3].setChoice("fourth choice");
		send.createRequest("closed", "weeeee", 5, 3, "janine", "pass", event);
		send.forceRequest("keyhere", "myid", 7);
		send.removeRequest("keykey", "idtime", true, 60);
		send.signInRequest("idnumber", "catherine", "past tense");
		send.reportRequest("keyhere", "closed");
		System.out.println("sent message");
		//end this part
		NewEventView view = new NewEventView(activity);
		
	}

}






