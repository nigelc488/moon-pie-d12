package g1.MoonPie;

import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.receiveMessages.ProcessThreadMessages;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;
import android.os.Bundle;

/**
 * This activity is just for testing how to do the interactions between multiple activies and
 * specifically how to handle the message handling.
 * @author ncochran
 *
 */
public class MyActivity extends Activity {
	static ProcessThreadMessages processMessage;
	
	public void setProcessThreadMessages(ProcessThreadMessages process){
		processMessage = process;
	}
	
	@Override
	public void onCreate(Bundle savedInstance){
		super.onCreate(savedInstance);
		ProcessThreadMessages.setActivity(this);
		setContentView(R.layout.choiceform);
		
		//this part only for testing sending messages
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
		
		{
			
		}
		
	}

}
