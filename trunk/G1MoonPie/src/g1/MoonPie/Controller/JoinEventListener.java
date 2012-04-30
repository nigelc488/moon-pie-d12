package g1.MoonPie.Controller;

import g1.MoonPie.Model.Event;
import g1.MoonPie.View.JoinEventView;
import g1.MoonPie.View.NewEventView;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * This class is used as a listener for the create join event button.
 * @author jpizz
 *
 */
public class JoinEventListener implements OnClickListener {

	Activity activity;
	
	public JoinEventListener(Activity activity){
		this.activity = activity;
	}
	
	@Override
	public void onClick(View v) {
		
		//this part only for testing sending messages
		SendMessageController.addChoiceRequest("id'number", 1, "the & ring");
		SendMessageController.addEdgeRequest("id'number2", 2, 3, 75);
		SendMessageController.adminRequest("nig'el", "");
		SendMessageController.closeRequest("id'number3");
		SendMessageController.reportRequest("key'here", "closed");
		SendMessageController.forceRequest("key's here", "myi'd", 7);
		SendMessageController.removeRequest("key'key", "idt'ime", true, 60);
		Event.getInstance().setNumChoices(5);
		Event.getInstance().setNumRounds(3);
		Event.getInstance().setQuestion("question");
		Event.getInstance().setOpen(false);
		Event.getInstance().getLines()[0].setChoice("first's choice");
		SendMessageController.createRequest("open", "who am < I", 5, 3, "nigel>", "password/>");
		Event.getInstance().getLines()[1].setChoice("second & choice");
		Event.getInstance().getLines()[3].setChoice("four'th choice");
		SendMessageController.createRequest("closed", "weee&ee", 5, 3, "jani'ne", "pa'ss");
		SendMessageController.signInRequest("idn'umber", "cathe'rine", "past ten'se");
		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//end this part
		
		//System.out.println("send messages now:");
		//for testing having multiple activities
		//intent(activity currently running, activity you want to start.class)
       //Intent intent = new Intent(activity, MyActivity.class);
       //activity.startActivity(intent);
        

		//SendMessageController.addChoiceRequest(event.getID(), 1, "the & ring");
		//SendMessageController.addEdgeRequest(event.getID(), 2, 3, 75);
//		SendMessageController.adminRequest("nig'el", "");
//		
//		Event event = new Event(5, 3);
//		event.getLines()[0].setChoice("first's choice");
//		SendMessageController.createRequest("open", "who am < I", 5, 3, "nigel>", "password/>", event);
//		event.getLines()[1].setChoice("second & choice");
//		event.getLines()[3].setChoice("four'th choice");
//		SendMessageController.createRequest("closed", "weee&ee", 5, 3, "jani'ne", "pa'ss", event);
//		SendMessageController.forceRequest("key's here", "myi'd", 7);
//		SendMessageController.removeRequest("key'key", "idt'ime", true, 60);
//		SendMessageController.signInRequest("idn'umber", "cathe'rine", "past ten'se");
//		SendMessageController.reportRequest("key'here", "closed");
//		SendMessageController.closeRequest("id'number3");
		//System.out.println("all messages sent");
		//end this part
		
		
		
		
		
		JoinEventView view = new JoinEventView(activity);
		
	}

}






