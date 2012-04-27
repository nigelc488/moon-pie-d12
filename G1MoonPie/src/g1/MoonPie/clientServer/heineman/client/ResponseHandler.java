package g1.MoonPie.clientServer.heineman.client;

//import xml.*;
import g1.MoonPie.clientServer.heineman.xml.*;

/**
 * This class is unmodified from Professor Heineman's code.
 * @author heineman
 */

/** Respond to server responses. */
public class ResponseHandler implements IMessageHandler {

	// process messages coming back from the server
	public void process(MessageXML response) {
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
