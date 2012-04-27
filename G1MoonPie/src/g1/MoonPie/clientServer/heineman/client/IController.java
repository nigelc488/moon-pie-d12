package g1.MoonPie.clientServer.heineman.client;

//import xml.*;
import g1.MoonPie.clientServer.heineman.xml.*;
/**
 * This method is unmodified from Professor Heineman's code but needs to be local to the project because the Android project cannot be 
 * dependent on a pure Java project.
 * Specialized client-side controller that is asked to respond to a specific response Message
 * received from the server in response to one of our client's request Message 
 * 
 * A response is detected by comparing the IDs of a request sent by the client with the ID of 
 * a response received from the server.
 * @author heineman
 */
public interface IController {
	
	/** 
	 * Process the server response given the original request. 
	 *
	 * @param  request    The message that this client had originally sent
	 * @param  response   The response received in response to the request.
	 */
	void process (MessageXML request, MessageXML response);
}
