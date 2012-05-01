package g1.MoonPie.clientServer.sendMessages;

import java.util.ArrayList;

import g1.MoonPie.clientServer.EncodeXML;
import g1.MoonPie.clientServer.EncryptPassword;
import g1.MoonPie.clientServer.xml.MessageXML;

/**
 * This class is used to send all of the messages to the server.
 * Each individual message has its own method.
 * @author ncochran
 *
 */
public class SendMessageController {
	/**
	 * This constructor creates the SendMessageController.
	 */
	public SendMessageController(){
	}
	
	
	/**
	 * This message creates an addChoiceRequest xml message.
	 * @param id String The unique id of this Event
	 * @param line int The line associated with this choice
	 * @param choice String The text to be used for this choice
	 */
	public static MessageXML addChoiceRequest(String id, int line, String choice){
		id = EncodeXML.encodeString(id);
		choice = EncodeXML.encodeString(choice);
		
		String xmlString = MessageXML.requestHeader() + "<addChoiceRequest id='" + id + "' " + 
	"number='" + line + "' " + "choice='" + choice + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		//ServerAccessManager.getAccess().sendRequest(req);
		return req;
	}
	
	/**
	 * This method creates an addEdgeRequest xml message.
	 * @param id String The id of the Event
	 * @param left int The left end point line for the edge
	 * @param right int The right end point line for the edge
	 * @param height int The vertical location of the edge
	 */
	public static MessageXML addEdgeRequest(String id, int left, int right, int height){
		id = EncodeXML.encodeString(id);
		
		String xmlString = MessageXML.requestHeader() + "<addEdgeRequest id ='" + id + "' " + "left='" + left + "' " + "right='" + right + "' " + "height='" + height + "'/></request>";
		
		MessageXML req = new MessageXML(xmlString);
		//ServerAccessManager.getAccess().sendRequest(req);
		return req;
	}
	
	/**
	 * This method creates an adminRequest xml message.
	 * @param userName String The username of the admin
	 * @param password Password The password of the admin.  The password is encrypted using SHA1 before being sent to the server.
	 */
	public static MessageXML adminRequest(String userName, String password){
		//password doesn't need to be xml encoded since it is being encrypted
		userName = EncodeXML.encodeString(userName);
		
		String passwordXML = "";
		if(!password.isEmpty()){
			String pass = EncryptPassword.getSuperSecrectPassword(password);
			passwordXML = "password='" + pass + "'";
		}else passwordXML = "password='" + "" + "'";
		String user = "<user name='" + userName + "' " + passwordXML + "/>";
		//not sure if this string is right
		String xmlString = MessageXML.requestHeader() + "<adminRequest>" + user + "</adminRequest></request>";
		MessageXML req = new MessageXML(xmlString);
		return req;
		//ServerAccessManager.getAccess().sendRequest(req);
	}
	
	/**
	 * This method creates a closeRequest xml message.
	 * @param id String The id of the Event to change from open to closed
	 */
	public static MessageXML closeRequest(String id){
		id = EncodeXML.encodeString(id);
		String xmlString = MessageXML.requestHeader() + "<closeRequest id='" + id + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		return req;
		//ServerAccessManager.getAccess().sendRequest(req);
	}
	
	/**
	 * This method creates a createRequest xml message.
	 * @param type String Either "open" or "closed"
	 * @param question String The question to be answered by this event
	 * @param numChoices int The number of choices for this event
	 * @param numRounds int The number of edges a participant can add
	 * @param userName String The username of the person creating the event
	 * @param password String The password of the person creating the event.  The password is encrypted using SHA1 before being sent to the server.
	 * @param event The event to be created.  This is used to gain access to the choices for the event.
	 */
	public static MessageXML createRequest(String type, String question, int numChoices, int numRounds, String userName, String password, String[] choices){
		//NEED TO FIGURE OUT WHAT INDEX SHOULD BE
		//dont need to do password
		type = EncodeXML.encodeString(type);
		question = EncodeXML.encodeString(question);
		userName = EncodeXML.encodeString(userName);
		
		//very well may be wrong...
		String xmlString = MessageXML.requestHeader() + "<createRequest type='" + type + "' " + "question='" + question + "' " + "numChoices='" + numChoices + "' " + "numRounds='" + numRounds+ "'>";
		//setup choices
		//may need some code to handle when open event and therefore just 1 choice
		for (int i = 0; i < choices.length; i++) {
			String choice = "<choice value='" + EncodeXML.encodeString(choices[i]) + "' " + "index='" + i + "'/>";
			xmlString += choice;
		} 
		String passwordXML = "";
		if(!password.isEmpty()){
			String pass = EncryptPassword.getSuperSecrectPassword(password);
			passwordXML = " password='" + pass + "'";
		}
		String user = "<user name=\"" + userName + "\"" + passwordXML + "/>";
		
		xmlString += user + "</createRequest></request>";
		MessageXML req = new MessageXML(xmlString);
		return req;
		//ServerAccessManager.getAccess().sendRequest(req);
	}
	
	/**
	 * This method is used to create and send a forceRequest xml message.
	 * @param key String The key for the admin
	 * @param id String The id for the event.
	 * @param daysOld int The number of days old after which all events will be deleted.
	 */
	public static MessageXML forceRequest(String key, String id, int daysOld){
		key = EncodeXML.encodeString(key);
		id = EncodeXML.encodeString(id);
		
		String xmlString = MessageXML.requestHeader() + "<forceRequest key='" + key + "' " + "id='" + id + "' " + "daysOld='" + daysOld + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		return req;
		//ServerAccessManager.getAccess().sendRequest(req);
	}
	
	/**
	 * This method is used to generate a removeRequest xml message.
	 * @param key String the admin's key
	 * @param id String the ide of the event
	 * @param completed boolean If removing open events or closed events
	 * @param daysOld int The number of days after which all events will be deleted
	 */
	public static MessageXML removeRequest(String key, String id, boolean completed, int daysOld){
		key = EncodeXML.encodeString(key);
		id = EncodeXML.encodeString(id);
		
		String xmlString = MessageXML.requestHeader() + "<removeRequest key='" + key + "' " + "id='" + id + "' " + "completed='" + completed + "' " + "daysOld='" + daysOld + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		return req;
		//ServerAccessManager.getAccess().sendRequest(req);
	}
	
	/**
	 * This method is used to create and send a reportRequest xml message.
	 * @param key String The amin key
	 * @param type String The type of event to be viewed.  Either open or closed
	 */
	public static MessageXML reportRequest(String key, String type){
		key = EncodeXML.encodeString(key);
		type = EncodeXML.encodeString(type);
		
		String xmlString= MessageXML.requestHeader() + "<reportRequest key='" + key + "' " + "type='" + type + "'/></request>";
		MessageXML req = new MessageXML(xmlString);
		return req;
		//ServerAccessManager.getAccess().sendRequest(req);
	}
	
	/**
	 * This method is used to create and send a signInRequest xml message.
	 * @param id String The id of the event the user wants to sign into
	 * @param userName The username of the participant
	 * @param password The password (optional) for the participant.  The password is encrypted using SHA1 before being sent to the server.
	 */
	public static MessageXML signInRequest(String id, String userName, String password){
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
		return req;
		//ServerAccessManager.getAccess().sendRequest(req);
	}
	
	

}
