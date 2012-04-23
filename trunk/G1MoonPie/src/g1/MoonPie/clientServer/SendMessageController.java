package g1.MoonPie.clientServer;

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
	

}
