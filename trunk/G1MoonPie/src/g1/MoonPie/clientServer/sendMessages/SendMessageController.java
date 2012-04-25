package g1.MoonPie.clientServer.sendMessages;

import java.util.ArrayList;

import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.xml.MessageXML;

public class SendMessageController {

	
	public SendMessageController(){
	}
	
	public void addChoiceRequest(String id, int line, String choice){
		String xmlString = MessageXML.requestHeader() + "<addChoiceRequest id='" + id + "' " + 
	"number='" + line + "' " + "choice='" + choice + "'/></request>";
		
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
		
	}
	
	public void addEdgeRequest(String id, int left, int right, int height){
		String xmlString = MessageXML.requestHeader() + "<addEdgeRequest id ='" + id + "' " + "left='" + left + "' " + "right='" + right + "' " + "height='" + height + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void adminRequest(String userName, String password){
		String passwordXML = "";
		//need code here to transform password into SHA1 hashed password
		//no fucking clue how to do this....
		passwordXML = "password='" + password + "'";
		String user = "<user name='" + userName + "' " + passwordXML + "/>";
		//not sure if this string is right
		String xmlString = MessageXML.requestHeader() + "<adminRequest>" + user + "</adminRequest></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void closeRequest(String id){
		String xmlString = MessageXML.requestHeader() + "<closeRequest id='" + id + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void createRequest(String type, String question, int numChoices, int numRounds, String userName, String password, Event event){
		//very well may be wrong...
		String xmlString = MessageXML.requestHeader() + "<createRequest type='" + type + "' " + "question='" + question + "' " + "numChoices='" + numChoices + "' " + "numRounds='" + numRounds+ "'>";
		//setup choices
		//may need some code to handle when open event and therefore just 1 choice
		for (int i = 0; i < numChoices; i++) {
			String choice = "<choice value='" + event.getLines()[i].getChoice() + "' " + "index='" + (i+1) + "'/>";
			xmlString += choice;
		}
		//need same password handling stuff here 
		String xmlPassword = password;
		
		xmlString += "<user name='" + userName + "' " + "password='" + xmlPassword +"'/></createRequest></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void forceRequest(String key, String id, int daysOld){
		String xmlString = MessageXML.requestHeader() + "<forceRequest key='" + key + "' " + "id='" + id + "' " + "daysOld='" + daysOld + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void removeRequest(String key, String id, boolean completed, int daysOld){
		String xmlString = MessageXML.requestHeader() + "<forceRequest key='" + key + "' " + "id='" + id + "' " + "completed='" + completed + "' " + "daysOld='" + daysOld + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void reportRequest(String key, String type){
		String xmlString= MessageXML.requestHeader() + "<reportRequest key='" + key + "' " + "type='" + type + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void signInRequest(String id, String userName, String password){
		//possible this one is wrong
		String passwordXML = "password='" + password + "'";
		String user = "<user name='" + userName + "' " + passwordXML + "/>";
		//not sure if this string is right
		String xmlString = MessageXML.requestHeader() + "<signInRequest id='" + id + "'>" + user + "</signInRequest></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	

}
