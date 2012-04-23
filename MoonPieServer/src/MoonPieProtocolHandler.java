
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import server.*;
import xml.*;

/**
 * Sample implementation of a protocol handler to respond to messages received from clients.
 * You should follow this template when designing YOUR protocol handler.
 */
public class MoonPieProtocolHandler implements IProtocolHandler {

	/** Protocol handler knows the server in question. */
	Server server;

	/** Associate a server object with this handler. */
	public void setServer (Server s) {
		this.server = s;
	}

	public synchronized Message process (ClientState st, Message request) {
		Node child = request.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();

		
		if (child.getLocalName().equals ("connectRequest")) {
			System.out.println("connected");
		}
		else if (child.getLocalName().equals ("addChoiceRequest")) {
			System.out.println(child.getLocalName());
			String id = map.getNamedItem("id").getNodeValue();
			String number = map.getNamedItem("number").getNodeValue();
			String choice = map.getNamedItem("choice").getNodeValue();
			String xmlString = Message.responseHeader(request.id()) + "<addChoiceResponse id='" + id + "' " + "number='" + number + "' " + "choice='" + choice + "'/></response>";
			Message r = new Message(xmlString);
			return r;
		}
		else if (child.getLocalName().equals ("addEdgeRequest")) {
			System.out.println(child.getLocalName());
			String id = map.getNamedItem("id").getNodeValue();
			String left = map.getNamedItem("left").getNodeValue();
			String right = map.getNamedItem("right").getNodeValue();
			String height = map.getNamedItem("height").getNodeValue();
			String xmlString = Message.responseHeader(request.id()) + "addEdgeResponse id='" + id + "' " + "left='" + left + "' " + "right ='" + right + "' " + "height='" + height + "'/></response>";
			Message r = new Message(xmlString);
		}
		else if (child.getLocalName().equals ("adminRequest")) {
			System.out.println(child.getLocalName());
			//cat is doing this one
		}
		else if (child.getLocalName().equals ("chatRequest")) {
			System.out.println(child.getLocalName());
			//optional and we arent doing
		}
		else if (child.getLocalName().equals ("closeRequest")) {
			System.out.println(child.getLocalName());
			String xmlString = Message.responseHeader(request.id()) + "closeResponse" + "/></response>";
			Message r = new Message(xmlString);
			return r;
		}
		else if (child.getLocalName().equals ("creatRequest")) {
			System.out.println(child.getLocalName());
			String id = "1234";
			String xmlString = Message.responseHeader(request.id()) + "createResponse id='" + id + "'/></response>";
			Message r = new Message(xmlString);
			return r;
		}
		else if (child.getLocalName().equals ("forceRequest")) {
			System.out.println(child.getLocalName());
			String numberAffected = "5";
			String xmlString = Message.responseHeader(request.id()) + "forceResponse numberAffected='" + numberAffected + "'/></response>";
			Message r = new Message(xmlString);
			return r;
		}
		else if (child.getLocalName().equals ("removeRequest")) {
			System.out.println(child.getLocalName());
			String numberAffected = "3";
			String xmlString = Message.responseHeader(request.id()) + "removeResponse numberAffected='" + numberAffected + "'/></response>";
			Message r = new Message(xmlString);
			return r;
		}
		else if(child.getLocalName().equals("reportRequest")){
			//cat does this
		}
		else if (child.getLocalName().equals ("signInRequest")) {
			System.out.println(child.getLocalName());
			String id = map.getNamedItem("id").getNodeValue();
			String type = "closed";
			String question = "Why?";
			int numChoices = 5;
			int numRounds = 3;
			int position = 4;
			String xmlString = Message.responseHeader(request.id()) + "signInResponse id='" + id + "' " + "type='" + type + "' " + "question='" + question + "' " + "numChoices='" + numChoices + "' " + "numRounds='" + numRounds + "' " + "position='" + position + "'/></response>";
		}

		// unknown? no idea what to do
		System.out.println("everything failed to recognize");
		System.err.println("Unable to handle message:" + request);
		return null;
	} 
}
