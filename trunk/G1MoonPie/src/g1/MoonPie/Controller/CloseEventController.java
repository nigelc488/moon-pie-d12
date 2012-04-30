package g1.MoonPie.Controller;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.User;
import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;
import g1.MoonPie.clientServer.receiveMessages.ProcessThreadMessages;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import g1.MoonPie.clientServer.sendMessages.ServerAccessManager;

/**This class is used to submit a close event request to the server upon the moderators click of the close event button.
 * 
 * @author Eric Cobane
 * @author Janine Pizzimenti
 *
 */
public class CloseEventController implements OnClickListener {

	Event event;
	Activity activity;
	User user;

	public CloseEventController(Event e,User u, Activity a){
		this.event = e;
		this.activity = a;
		this.user = u;
	}

	@Override
	public void onClick(View arg0) {
		
		System.out.println("close event button");
		
		new CloseEventLineController(Event.getInstance(), ProcessThreadMessages.getActivity());
		SendMessageController.closeRequest(event.getID());
		
	}
}

