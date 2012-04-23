package g1.MoonPie.clientServer;

//import xml.Message;
//import client.IMessageHandler;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import android.os.Handler;
import android.os.Message;

import g1.MoonPie.clientServer.xml.*;
import g1.MoonPie.clientServer.client.*;
/**
 * Sample implementation of a protocol handler to respond to messages received from the server.
 * You should follow this template when designing YOUR message handler.
 */

/**
 * This class is really only a go-between.  It is called in the communications thread and simply forwards the message to the main thread for processing.
 * @author ncochran
 *
 */
public class MoonPieClientMessageHandler implements IMessageHandler {
	Handler childHandler;
	
	public MoonPieClientMessageHandler(Handler handler){
		childHandler = handler;
	}

	@Override
	public void process(MessageXML response) {
		Message msg = Message.obtain();
		msg.obj = response;
		boolean worked = childHandler.sendMessage(msg);
		//System.out.println("Was the thread message sent?: " + worked);
		System.out.println("Received in child thread:" + response);
		
	}

}
