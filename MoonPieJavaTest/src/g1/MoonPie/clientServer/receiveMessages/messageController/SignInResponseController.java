package g1.MoonPie.clientServer.receiveMessages.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.xml.MessageXML;

public class SignInResponseController {
	int numChoices;
	int numRounds;
	int position;
	
	String id, type, question;
	
	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		id = EncodeXML.decodeString(map.getNamedItem("id").getNodeValue());
		type = EncodeXML.decodeString(map.getNamedItem("type").getNodeValue());
		question = EncodeXML.decodeString(map.getNamedItem("question").getNodeValue());
		numChoices = Integer.parseInt(map.getNamedItem("numChoices").getNodeValue());
		numRounds = Integer.parseInt(map.getNamedItem("numRounds").getNodeValue());
		position = Integer.parseInt(map.getNamedItem("position").getNodeValue());
		
		System.out.println("SignIn with id=" + id + " type=" + type + " question=" + question + " numChoices=" + numChoices + " numRounds=" + numRounds + " position=" + position);
		
		//new SignInController(event, activity, id, type, question, numChoices, numRounds, position);
		
		//somehow needs to update view though, so will probably need to be passed the right text box as well
		
	}

	public int getNumChoices() {
		return numChoices;
	}

	public int getNumRounds() {
		return numRounds;
	}

	public int getPosition() {
		return position;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getQuestion() {
		return question;
	}
	
	

}
