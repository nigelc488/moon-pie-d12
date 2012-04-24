package g1.MoonPie.clientServer.receiveMessages;

import org.w3c.dom.Node;

import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.xml.MessageXML;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

/**
 * This method receives the thread message and converts it back to an XML style message. It then parses the message and calls the 
 * necessary controller based upon the request.  This is the actual equivalent to any of his MessageHandlers.
 * @author ncochran
 *
 */
public class ProcessThreadMessages extends Handler{
	MessageXML message;
	Event event;
	Activity activity;
	
	// I think this constructor will be needed to play nice with updating the layouts
	public ProcessThreadMessages(Event event, Activity activity){
		this.event = event;
		this.activity = activity;
	}
	
	public ProcessThreadMessages(Activity activity){
		this.activity = activity;
	}
	
	//This is just for right now
	public ProcessThreadMessages(){
		
	}
	
	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		String type = child.getLocalName();
		
		if(type.equals("addChoiceResponse")){
			//Done
			System.out.println(type);
			new AddChoiceResponseController(event, activity).process(response);
		}
		else if(type.equals("addEdgeResponse")){
			//Done
			System.out.println(type);
			new AddEdgeResponseController(event, activity).process(response);
		}
		else if(type.equals("closeResponse")){
			//Done
			System.out.println(type);
			new CloseResponseController(event, activity).process(response);
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
		else if(type.equals("turnResponse")){
			//Done
			System.out.println(type);
			new TurnResponseController(event, activity);
		}
		else if(type.equals("adminResponse")){
			//Done
			System.out.println(type);
			new AdminResponseController(event, activity).process(response);
		}
		else if(type.equals("removeResponse")){
			//Done
			System.out.println(type);
			new RemoveResponseController(event, activity).process(response);
		}
		else if(type.equals("forceResponse")){
			//Done
			System.out.println(type);
			new ForceResponseController(event, activity).process(response);
		}
		else if(type.equals("reportResponse")){
			//cat is doing this one
			System.out.println(type);
		}
		else if(type.equals("chatResponse")){
			//optional and we aren't doing it
			System.out.println(type);
		}
		else System.out.println("Not a valid message: " + type);

		System.out.println("Received in main thread:" + response);
	}
	
	
	@Override
	public void handleMessage(Message msg){
		message = (MessageXML) msg.obj;
		process(message);
	}

}
