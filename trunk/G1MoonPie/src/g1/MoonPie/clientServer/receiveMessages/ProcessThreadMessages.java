package g1.MoonPie.clientServer.receiveMessages;

import java.nio.channels.ClosedByInterruptException;

import org.w3c.dom.Node;

import g1.MoonPie.R;
import g1.MoonPie.Model.Entries;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.heineman.xml.MessageXML;
import g1.MoonPie.clientServer.receiveMessages.messageController.AddChoiceResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.AddEdgeResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.AdminResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.CloseResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.ConnectResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.CreateResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.ForceResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.RemoveResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.ReportResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.SignInResponseController;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This method receives the thread message and converts it back to an XML style message. It then parses the message and calls the 
 * necessary controller based upon the request.  This is the actual equivalent to any of his MessageHandlers.
 * @author ncochran
 *
 */
public class ProcessThreadMessages extends Handler{
	MessageXML message;
	Event event;
	static Activity activity;
	Entries entries;
	
	/**
	 * This constructor us used so that the event and activity can be later sent to other controllers that will be called.
	 * @param event Event The Event for the application used to access model objects
	 * @param activity Activity The activity for the application used to access GUI objects
	 */
	public ProcessThreadMessages(Activity activity, Entries entries){
		ProcessThreadMessages.activity = activity;
		this.entries = entries;
	}
	
	//makes the activity a singleton.  should really have done this somewhere else but too late now...
	
	/**
	 * This method is used to change the activity to be passed to called controllers.
	 * @param active Activity The current activity
	 */
	public static void setActivity(Activity active){
		activity = active;
	}
	/**
	 * This method is used to get the current activity.
	 * @return Activity The current activity
	 */
	public static Activity getActivity(){
		return activity;
	}
	
	/**
	 * This method is used for the logic of processing the xml message to see which message it is and which controller should be called.
	 * @param response MessageXML The message received from the server.
	 */
	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		String type = child.getLocalName();
		
		if(type.equals("addChoiceResponse")){
			//Done
			System.out.println(type);
			new AddChoiceResponseController(Event.getInstance(), ProcessThreadMessages.getActivity()).process(response);
		}
		else if(type.equals("addEdgeResponse")){
			//Done
			System.out.println(type);
			new AddEdgeResponseController(event, activity).process(response);
		}
		else if(type.equals("closeResponse")){
			//Done
			System.out.println(type);
			new CloseResponseController(Event.getInstance(), ProcessThreadMessages.getActivity()).process(response);
		}
		else if(type.equals("connectResponse")){
			//Done
			System.out.println(type);
			new ConnectResponseController(event, activity).process(response);
		}
		else if(type.equals("createResponse")){
			//Done
			System.out.println(type);
			new CreateResponseController(event, activity).process(response);
		}
		
		else if(type.equals("signInResponse")){
			//Done
			System.out.println(type);
			new SignInResponseController(event, activity).process(response);
		}
		else if(type.equals("adminResponse")){
			//Done
			System.out.println(type);
			new AdminResponseController(event, activity, entries).process(response);
		}
		else if(type.equals("removeResponse")){
			//Done
			System.out.println(type);
			new RemoveResponseController(event, activity, entries).process(response);
		}
		else if(type.equals("forceResponse")){
			//Done
			System.out.println(type);
			new ForceResponseController(event, activity, entries).process(response);
		}
		else if(type.equals("reportResponse")){
			//cat is doing this one
			System.out.println(type);
			new ReportResponseController(event, activity, entries).process(response);
		}
		else System.out.println("Not a valid message: " + type);

		//System.out.println("Received in main thread:" + response);
	}
	
	
	@Override
	public void handleMessage(Message msg){
		if(msg.obj.toString().equals("Connection Failed")){
			System.out.println("Connection Failed from message");
			Toast.makeText(activity, "Could not Connect to Server", Toast.LENGTH_LONG);
			activity.finish();
		}else{
		message = (MessageXML) msg.obj;
		process(message);
		}
	}

}
