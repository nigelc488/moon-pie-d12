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

	/**Event used for accessing model objects.*/
	Event event;
	/**Activity used for accessing view objects.*/
	Activity activity;
	/**User for determining moderator privelages.*/
	User user;

	/**This constructor creates the CloseEventController with an event, a user, and an activity.
	 * 
	 * @param e	The event to be used to update model objects
	 * @param u	The User who is requesting the close to be used to check if Moderator
	 * @param a	The Activity to be used to update GUI objects.
	 */
	public CloseEventController(Event e,User u, Activity a){
		this.event = e;
		this.activity = a;
		this.user = u;
	}

	/**This method is a listener for the CloseEventButton.  On click event, a new CloseEventLineController will be created, 
	 * and a closeRequest will be sent to the server.
	 */
	@Override
	public void onClick(View arg0) {
		
		System.out.println("close event button clicked");
		
		SendMessageController.closeRequest(event.getID());
		new CloseEventLineController(Event.getInstance(), ProcessThreadMessages.getActivity());

		
	}
}

