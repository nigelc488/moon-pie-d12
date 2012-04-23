package g1.MoonPie.clientServer;

import org.w3c.dom.Node;

import g1.MoonPie.clientServer.xml.MessageXML;
import android.os.Handler;
import android.os.Message;

/**
 * This method receives the thread message and converts it back to an XML style message. It then parses the message and calls the 
 * necessary controller based upon the request.  This is the actual equivalent to any of his MessageHandlers.
 * @author ncochran
 *
 */
public class ProcessThreadMessages extends Handler{
	MessageXML message;
	
	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		String type = child.getLocalName();
		
		if(type.equals("addChoiceResponse")){
			System.out.println(type);	
		}
		else if(type.equals("addEdgeResponse")){
			System.out.println(type);
		}
		else if(type.equals("adminResponse")){
			//cat should be doing this one
			System.out.println(type);
		}
		else if(type.equals("chatResponse")){
			//optional and we aren't doing it
			System.out.println(type);
		}
		else if(type.equals("closeResponse")){
			System.out.println(type);
		}
		else if(type.equals("connectResponse")){
			System.out.println(type);
		}
		else if(type.equals("createResponse")){
			System.out.println(type);
		}
		else if(type.equals("removeResponse")){
			//should be cat again
			System.out.println(type);
		}
		else if(type.equals("forceResponse")){
			//should be cat again
			System.out.println(type);
		}
		else if(type.equals("reportResponse")){
			//cat again
			System.out.println(type);
		}
		else if(type.equals("signInResponse")){
			System.out.println(type);
		}
		else if(type.equals("turnResponse")){
			System.out.println(type);
		}
		else System.out.println("Not a valid message: " + type);

		System.out.println("Received in main thread:" + response);
	}
	
	
	@Override
	public void handleMessage(Message msg){
		System.out.println("message received in main thread");
		message = (MessageXML) msg.obj;
		process(message);
	}

}
