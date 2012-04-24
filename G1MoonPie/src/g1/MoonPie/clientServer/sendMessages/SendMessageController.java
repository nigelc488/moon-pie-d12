package g1.MoonPie.clientServer.sendMessages;

import java.util.ArrayList;

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
	
	//this one is a bitch too...
	public void createRequest(String type, String question, int numChoices, int numRounds, String userName, String password, ArrayList<String> choices){
		
		
	}
	
	

}
