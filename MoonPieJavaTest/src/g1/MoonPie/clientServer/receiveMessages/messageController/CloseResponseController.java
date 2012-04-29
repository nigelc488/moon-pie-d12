package g1.MoonPie.clientServer.receiveMessages.messageController;

import g1.MoonPie.clientServer.xml.MessageXML;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;



public class CloseResponseController {


	public void process(MessageXML response){
		//for this request, any message works so there is no need to process the message itself
		
		System.out.println("Close the event");
		
		//This is where you should call the closeEventController
		//new CloseEventController();
		
		//needs to know what button to hide so will need to know about the Activity
		
	}
	
}
