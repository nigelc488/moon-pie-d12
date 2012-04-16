package client;

import xml.*;

/** Respond to server responses. */
public class ResponseHandler implements IMessageHandler {

	// process messages coming back from the server
	public void process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();

		// handle loginResponse specially
		if (type.equals(Parser.connectRequest)) {
			boolean ok = response.success();
			if (!ok) {
				System.out.println("Unable to login:" + response.reason());
			} else {
				System.out.println("Connected to server.");
			}

			return;
		}

		System.out.println("Not handling received message:" + response);
	}
}
