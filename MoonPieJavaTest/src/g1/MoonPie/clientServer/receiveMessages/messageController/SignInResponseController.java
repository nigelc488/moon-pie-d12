package g1.MoonPie.clientServer.receiveMessages.messageController;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.xml.MessageXML;

public class SignInResponseController {
	
	public void process(MessageXML response){
		Node child = response.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		String id = EncodeXML.decodeString(map.getNamedItem("id").getNodeValue());
		String type = EncodeXML.decodeString(map.getNamedItem("type").getNodeValue());
		String question = EncodeXML.decodeString(map.getNamedItem("question").getNodeValue());
		int numChoices = Integer.parseInt(map.getNamedItem("numChoices").getNodeValue());
		int numRounds = Integer.parseInt(map.getNamedItem("numRounds").getNodeValue());
		int position = Integer.parseInt(map.getNamedItem("position").getNodeValue());
		
		System.out.println("SignIn with id=" + id + " type=" + type + " question=" + question + " numChoices=" + numChoices + " numRounds=" + numRounds + " position=" + position);
		
		//new SignInController(event, activity, id, type, question, numChoices, numRounds, position);
		
		//somehow needs to update view though, so will probably need to be passed the right text box as well
		
	}

}
