package g1.MoonPie.clientServer.sendMessages;

import java.util.ArrayList;

import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.EncryptPassword;
import g1.MoonPie.clientServer.xml.MessageXML;

public class SendMessageController {

	
	public SendMessageController(){
	}
	
	public void addChoiceRequest(String id, int line, String choice){
		id = EncodeXML.encodeString(id);
		System.out.println(id);
		choice = EncodeXML.encodeString(choice);
		
		String xmlString = MessageXML.requestHeader() + "<addChoiceRequest id='" + id + "' " + 
	"number='" + line + "' " + "choice='" + choice + "'/></request>";
		System.out.println("xmlString= " + xmlString);
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
		
	}
	
	public void addEdgeRequest(String id, int left, int right, int height){
		id = EncodeXML.encodeString(id);
		
		String xmlString = MessageXML.requestHeader() + "<addEdgeRequest id ='" + id + "' " + "left='" + left + "' " + "right='" + right + "' " + "height='" + height + "'/></request>";
		
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void adminRequest(String userName, String password){
		//password doesn't need to be xml encoded since it is being encrypted
		userName = EncodeXML.encodeString(userName);
		
		String passwordXML = "";
		if(!password.isEmpty()){
			String pass = EncryptPassword.getSuperSecrectPassword(password);
			passwordXML = "password='" + pass + "'";
		}
		String user = "<user name='" + userName + "' " + passwordXML + "/>";
		//not sure if this string is right
		String xmlString = MessageXML.requestHeader() + "<adminRequest>" + user + "</adminRequest></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void closeRequest(String id){
		id = EncodeXML.encodeString(id);
		String xmlString = MessageXML.requestHeader() + "<closeRequest id='" + id + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void createRequest(String type, String question, int numChoices, int numRounds, String userName, String password, Event event){
		//NEED TO FIGURE OUT WHAT INDEX SHOULD BE
		//dont need to do password
		type = EncodeXML.encodeString(type);
		question = EncodeXML.encodeString(question);
		userName = EncodeXML.encodeString(userName);
		
		//very well may be wrong...
		String xmlString = MessageXML.requestHeader() + "<createRequest type='" + type + "' " + "question='" + question + "' " + "numChoices='" + numChoices + "' " + "numRounds='" + numRounds+ "'>";
		//setup choices
		//may need some code to handle when open event and therefore just 1 choice
		for (int i = 0; i < numChoices; i++) {
			String choice = "<choice value='" + EncodeXML.encodeString(event.getLines()[i].getChoice()) + "' " + "index='" + (i+1) + "'/>";
			xmlString += choice;
		} 
		String passwordXML = "";
		if(!password.isEmpty()){
			String pass = EncryptPassword.getSuperSecrectPassword(password);
			passwordXML = "password='" + pass + "'";
		}
		String user = "<user name='" + userName + "' " + passwordXML + "/>";
		
		xmlString += user + "</createRequest></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void forceRequest(String key, String id, int daysOld){
		key = EncodeXML.encodeString(key);
		id = EncodeXML.encodeString(id);
		
		String xmlString = MessageXML.requestHeader() + "<forceRequest key='" + key + "' " + "id='" + id + "' " + "daysOld='" + daysOld + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void removeRequest(String key, String id, boolean completed, int daysOld){
		key = EncodeXML.encodeString(key);
		id = EncodeXML.encodeString(id);
		
		String xmlString = MessageXML.requestHeader() + "<removeRequest key='" + key + "' " + "id='" + id + "' " + "completed='" + completed + "' " + "daysOld='" + daysOld + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void reportRequest(String key, String type){
		key = EncodeXML.encodeString(key);
		type = EncodeXML.encodeString(type);
		
		String xmlString= MessageXML.requestHeader() + "<reportRequest key='" + key + "' " + "type='" + type + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	public void signInRequest(String id, String userName, String password){
		id = EncodeXML.encodeString(id);
		userName = EncodeXML.encodeString(userName);

		String passwordXML = "";
		if(!password.isEmpty()){
			String pass = EncryptPassword.getSuperSecrectPassword(password);
			passwordXML = "password='" + pass + "'";
		}
		String user = "<user name='" + userName + "' " + passwordXML + "/>";
		//not sure if this string is right
		String xmlString = MessageXML.requestHeader() + "<signInRequest id='" + id + "'>" + user + "</signInRequest></request>";
		MessageXML req = new MessageXML(xmlString);
		ServerAccessManager.getAccess().sendRequest(req);
	}
	
	

}
