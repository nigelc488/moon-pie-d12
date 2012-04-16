package g1.MoonPie.clientServer;

//import xml.Message;
//import client.IMessageHandler;
import g1.MoonPie.clientServer.xml.*;
import g1.MoonPie.clientServer.client.*;
/**
 * Sample implementation of a protocol handler to respond to messages received from the server.
 * You should follow this template when designing YOUR message handler.
 */
public class MoonPieClientMessageHandler implements IMessageHandler {

	@Override
	public void process(Message response) {

		System.out.println("Received:" + response);
	}

}
