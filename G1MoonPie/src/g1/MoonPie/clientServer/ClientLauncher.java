package g1.MoonPie.clientServer;


import java.util.Scanner;

//import client.ServerAccess;
//import xml.Message;
import g1.MoonPie.clientServer.xml.*;
import g1.MoonPie.clientServer.client.*;

/** Launch command-line Client to show minimal access needs. */
public class ClientLauncher {

	/**
	 * Note that to simplify the coding of this command-client, it declares that it can throw an Exception,
	 * which is typically the failed connection to a server.
	 */
	public ClientLauncher() throws Exception {
		// FIRST thing to do is register the protocol being used. There will be a single class protocol
		// that will be defined and which everyone will use. For now, demonstrate with skeleton protocol.
		
		System.out.println("before if");
		if (!Message.configure("MoonPie.xsd")) {
			System.out.println("before exit");
			System.exit(0);
		}
		
		//InetAddress test = 
		System.out.println("before new server acess");
		ServerAccess sa = new ServerAccess("127.0.0.1", 9200);
		sa.connect(new MoonPieClientMessageHandler());
		
		// send an introductory connect request 
		Message m = new Message ("<request><connectRequest/></request>");
		
		sa.sendRequest(m);
		
		// await response. If we don't stop ServerAccess manually, there will be a background thread
		// the continually runs and the program will never terminate. 
		// This problem is not as noticeable in GUI-based clients.
		System.err.println("Press Return to terminate client.");
		Scanner sc = new Scanner (System.in);
		sc.nextLine();
		
		System.out.println("Client disconnected.");
		sa.disconnect();
	} 
}
