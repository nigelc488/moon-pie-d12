package g1.MoonPie.clientServer.heineman.client;



import android.os.Handler;

//import client.ServerAccess;
//import xml.Message;
import g1.MoonPie.clientServer.heineman.xml.*;
import g1.MoonPie.clientServer.receiveMessages.MoonPieClientMessageHandler;
import g1.MoonPie.clientServer.sendMessages.ServerAccessManager;

/**
 * This Class is a modified form of the ClientLauncher provided by Professor Heineman to allow integration with Android.
 * Th modifications are: the need for a static ip address for the server (localhost is not valid when running on same machine),
 * the use of a Handler the send internal Android messages,
 * the removal of all xml checking as it is incompatible with Android.
 * @author ncochran, heineman
 *
 */
public class ClientLauncher {
	boolean connected;

	/**
	 * This method handles the action of launching the client and establishing a connection with the server.
	 * @param handler Handler the Android Message Handler used to send messages to the main thread.
	 * @throws Exception If it cannot connect, it throws an exception.
	 */
	
	public ClientLauncher(Handler handler) throws Exception {
		// FIRST thing to do is register the protocol being used. There will be a single class protocol
		// that will be defined and which everyone will use. For now, demonstrate with skeleton protocol.
		if (!MessageXML.configure("decisionlines.xsd")) {
			System.exit(0);
		}
		
		//System.out.println("before new server acess");
		ServerAccess sa = new ServerAccess("130.215.29.32", 9371); //"127.0.0.1"/localhost doesnt work
		//System.out.println("after new server, before connect");
		connected = sa.connect(new MoonPieClientMessageHandler(handler));
		//System.out.println("did we connect? " + connected);
		if(!connected){
			System.out.println("Could not connect in client launcher");
			throw new Exception("Unable to Connect to Server");
		}
		ServerAccessManager.setAccess(sa);
		
		// send an introductory connect request 
		//System.out.println("try message");
		MessageXML m = new MessageXML (MessageXML.requestHeader() + "<connectRequest/></request>");
		sa.sendRequest(m);
	} 
}
