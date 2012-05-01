

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
		System.out.println("request to server=" + request);
		Node child = request.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();

		
		if (child.getLocalName().equals ("connectRequest")) {
			System.out.println("connected");
		}
		else if (child.getLocalName().equals ("addChoiceRequest")) {
			System.out.println(child.getLocalName());
			String id = (map.getNamedItem("id").getNodeValue());
			System.out.println(id);
			String number = map.getNamedItem("number").getNodeValue();
			String choice = (map.getNamedItem("choice").getNodeValue());
			String xmlString = Message.responseHeader(request.id()) + "<addChoiceResponse id='" + id + "' " + "number='" + number + "' " + "choice='" + choice + "'/></response>";
			System.out.println(xmlString);
			Message r = new Message(xmlString);
			return r;
		}
		else if (child.getLocalName().equals ("addEdgeRequest")) {
			System.out.println(child.getLocalName());
			String id = map.getNamedItem("id").getNodeValue();
			String left = map.getNamedItem("left").getNodeValue();
			String right = map.getNamedItem("right").getNodeValue();
			String height = map.getNamedItem("height").getNodeValue();
			String xmlString = Message.responseHeader(request.id()) + "<addEdgeResponse id='" + id + "' " + "left='" + left + "' " + "right ='" + right + "' " + "height='" + height + "'/></response>";
			Message r = new Message(xmlString);
			return r;
		}
		else if (child.getLocalName().equals ("adminRequest")) {
			System.out.println(child.getLocalName());
			String xmlString = Message.responseHeader(request.id()) + "<adminResponse key='" +  "abc123" + "'/></response>";
			Message r = new Message(xmlString);
			return r;
			//cat is doing this one
		}
		else if (child.getLocalName().equals ("chatRequest")) {
			System.out.println(child.getLocalName());
			//optional and we arent doing
		}
		else if (child.getLocalName().equals ("closeRequest")) {
			System.out.println(child.getLocalName());
			String xmlString = Message.responseHeader(request.id()) + "<closeResponse" + "/></response>";
			Message r = new Message(xmlString);
			return r;
		}
		else if (child.getLocalName().equals ("createRequest")) {
			boolean isOpen;
			System.out.println(child.getLocalName());
			
			String id = "1234";
			Event.getInstance().setID(id);
			
			String type = map.getNamedItem("type").getNodeValue();
			if(type.equals("open")){
				isOpen = true;
			}else isOpen = false;
			Event.getInstance().setOpen(isOpen);
			
			int numChoices = Integer.parseInt(map.getNamedItem("numChoices").getNodeValue());
			Event.getInstance().setNumChoices(numChoices);
			
			int numRounds = Integer.parseInt(map.getNamedItem("numRounds").getNodeValue());
			Event.getInstance().setNumRounds(numRounds);
			
			String question = map.getNamedItem("question").getNodeValue();
			Event.getInstance().setQuestion(question);
			
			NodeList list = child.getChildNodes();
			System.out.println(list.getLength());
			for (int i = 0; i < list.getLength(); i++) {
				Node node = list.item(i);
				NamedNodeMap map2 = node.getAttributes();
				
				//need to check if is a choice or user because both equal level
				if(node.getNodeName().equals("choice")){
				
				String choice = map2.getNamedItem("value").getNodeValue();
				int index = Integer.parseInt(map2.getNamedItem("index").getNodeValue());
				Event.getInstance().setChoice(index, choice);
				}
			}
			
			
			
			String xmlString = Message.responseHeader(request.id()) + "<createResponse id='" + id + "'/></response>";
			System.out.println(xmlString);
			Message r = new Message(xmlString);
			return r;
		}
		else if (child.getLocalName().equals ("forceRequest")) {
			System.out.println(child.getLocalName());
			String numberAffected = "5";
			String xmlString = Message.responseHeader(request.id()) + "<forceResponse numberAffected='" + numberAffected + "'/></response>";
			System.out.println(xmlString);
			Message r = new Message(xmlString);
			return r;
		}
		else if (child.getLocalName().equals ("removeRequest")) {
			System.out.println(child.getLocalName());
			String numberAffected = "3";
			String xmlString = Message.responseHeader(request.id()) + "<removeResponse numberAffected='" + numberAffected + "'/></response>";
			System.out.println(xmlString);
			Message r = new Message(xmlString);
			return r;
		}
		else if(child.getLocalName().equals("reportRequest")){
			System.out.println(child.getLocalName());
			String id = "myid";
			String type = "open";
			String question = "question";
			int numChoices = 5;
			int numRounds = 3;
			String created = "a date?";
			boolean completed = false;
			String entry = "<entry id='" + id +"' " + "type='" + type + "' " + "question='" + question + "' " + "numChoices='" + numChoices + "' " + "numRounds='" + numRounds + "' " + "created='" + created + "' " + "completed='" + completed + "'/>";
			
			id = "myid2";
			type = "open";
			question = "question2";
			numChoices = 5;
			numRounds = 3;
			created = "a date?2";
			completed = false;
			String entry2 = "<entry id='" + id +"' " + "type='" + type + "' " + "question='" + question + "' " + "numChoices='" + numChoices + "' " + "numRounds='" + numRounds + "' " + "created='" + created + "' " + "completed='" + completed + "'/>";
			
			String xmlString = Message.responseHeader(request.id()) + "<reportResponse>" + entry + entry2 + "</reportResponse></response>";
			System.out.println(xmlString);
			Message r = new Message(xmlString);
			return r;
		}
		else if (child.getLocalName().equals ("signInRequest")) {
			String[] choices;
			String type;
			System.out.println(child.getLocalName());
			String id = map.getNamedItem("id").getNodeValue();
			
			String question = "Why?";
			int numChoices = 5;
			int numRounds = 3;
			int position = 4;
			
			
			if (id.equals("Open")){
				type = "open";
				choices = new String[position];
				choices[0] = "one";
				choices[1] = "two";
				choices[2] = "three";
				choices[3] = "four";
			}
			//closed event
			else if (id.equals("Closed")){
				type = "closed";
				choices = new String[numChoices];
				choices[0] = "one";
				choices[1] = "two";
				choices[2] = "three";
				choices[3] = "four";
				choices[4] = "five";
			}
			
			//event created by user
			else if(id.equals("1234")){
				if(Event.getInstance().getIsOpen()){
					type = "open";
				}
				else type = "closed";
				numChoices = Event.getInstance().getNumChoices();
				numRounds = Event.getInstance().getNumRounds();
				question = Event.getInstance().getQuestion();
				position = 0;
				choices = Event.getInstance().getChoices();
			}
			
			//not a valid id
			else{
				type = "closed";
				id = "no";
				choices = new String[0];
			}
			

			String xmlString = Message.responseHeader(request.id()) + "<signInResponse id='" + id + "' " + "type='" + type + "' " + "question='" + question + "' " + "numChoices='" + numChoices + "' " + "numRounds='" + numRounds + "' " + "position='" + position + "'>";
			for (int i = 0; i < choices.length; i++) {
				if(!choices[i].isEmpty()){
				String choice = "<choice value='" + choices[i] + "' " + "index='" + i + "'/>";
				xmlString += choice;
				}
			
			}
			xmlString +="</signInResponse></response>";
			System.out.println(xmlString);
			Message r = new Message(xmlString);
			return r;
		}

		// unknown? no idea what to do
		System.out.println("everything failed to recognize");
		System.err.println("Unable to handle message:" + request);
		return null;
	} 
}
