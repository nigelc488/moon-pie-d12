package g1.MoonPie.clientServer.client;


import java.util.Scanner;



//import client.ServerAccess;
//import xml.Message;

import g1.MoonPie.clientServer.receiveMessages.MoonPieClientMessageHandler;
import g1.MoonPie.clientServer.sendMessages.ServerAccessManager;
import g1.MoonPie.clientServer.xml.*;
import g1.MoonPie.clientServer.client.*;

/** Launch command-line Client to show minimal access needs. */
public class ClientLauncher {

	/**
	 * Note that to simplify the coding of this command-client, it declares that it can throw an Exception,
	 * which is typically the failed connection to a server.
	 */
	
	/**
	 * Different from his:
	 * pass it a Handler so can send messages between threads
	 * need the actual ip address of where the server is (localhost doesnt work)
	 * doesnt have any of the checking or closing of stuff
	 * @param handler
	 * @throws Exception
	 */
	public ClientLauncher() throws Exception {
		// FIRST thing to do is register the protocol being used. There will be a single class protocol
		// that will be defined and which everyone will use. For now, demonstrate with skeleton protocol.
		
		//System.out.println("before if");
		if (!MessageXML.configure("decisionlines.xsd")) {
			//System.out.println("before exit");
			System.exit(0);
		}
		
		//System.out.println("before new server acess");
		ServerAccess sa = new ServerAccess("130.215.29.32", 9371); //"127.0.0.1", "130.215.29.32"
		sa.connect(new MoonPieClientMessageHandler());
		ServerAccessManager.setAccess(sa);
		
		// send an introductory connect request 
		MessageXML m = new MessageXML (MessageXML.requestHeader() + "<connectRequest/></request>");
		//System.out.println("message created, try sending");
		sa.sendRequest(m);
		//System.out.println(sa.sendRequest(m));
		//System.out.println("message sent");
		// await response. If we don't stop ServerAccess manually, there will be a background thread
		// the continually runs and the program will never terminate. 
		// This problem is not as noticeable in GUI-based clients.
		//System.err.println("Press Return to terminate client.");
		//Scanner sc = new Scanner (System.in);
		//sc.nextLine();
		
		//System.out.println("Client disconnected.");
		//sa.disconnect();
	} 
}
