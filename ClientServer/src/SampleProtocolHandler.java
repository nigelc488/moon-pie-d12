import org.w3c.dom.Node;

import server.*;
import xml.*;

/**
 * Sample implementation of a protocol handler to respond to messages received from clients.
 * You should follow this template when designing YOUR protocol handler.
 */
public class SampleProtocolHandler implements IProtocolHandler {

	/** Protocol handler knows the server in question. */
	Server server;

	/** Associate a server object with this handler. */
	public void setServer (Server s) {
		this.server = s;
	}

	public synchronized Message process (ClientState st, Message request) {
		Node child = request.contents.getFirstChild();
		
		if (child.getLocalName().equals ("connect")) {
			
		}

		// unknown? no idea what to do
		System.err.println("Unable to handle message:" + request);
		return null;
	} 
}
