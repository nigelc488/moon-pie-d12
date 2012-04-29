package g1.MoonPie.clientServer.receiveMessages;

//import xml.Message;
//import client.IMessageHandler;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


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

	@Override
	public void process(MessageXML response) {
		new ProcessThreadMessages().process(response);
		//System.out.println("Was the thread message sent?: " + worked);
		//System.out.println("Received in child thread:" + response);
		
	}

}
