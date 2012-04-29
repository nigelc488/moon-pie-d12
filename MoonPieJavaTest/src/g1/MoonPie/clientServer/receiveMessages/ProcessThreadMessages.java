package g1.MoonPie.clientServer.receiveMessages;



import g1.MoonPie.clientServer.receiveMessages.messageController.AddChoiceResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.AddEdgeResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.AdminResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.CloseResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.ConnectResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.CreateResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.ForceResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.RemoveResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.ReportResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.SignInResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.TurnResponseController;
import g1.MoonPie.clientServer.xml.MessageXML;

import org.w3c.dom.Node;


public class ProcessThreadMessages{
	MessageXML message;

	
	//This is just for right now
	public ProcessThreadMessages(){
		
	}
	
	public void process(MessageXML response){
		System.out.println("message received" + response);
		Node child = response.contents.getFirstChild();
		String type = child.getLocalName();
		
		if(type.equals("addChoiceResponse")){
			//Done
			System.out.println("in add choice response");
			System.out.println(type);
			new AddChoiceResponseController().process(response);
		}
		else if(type.equals("addEdgeResponse")){
			//Done
			System.out.println(type);
			new AddEdgeResponseController().process(response);
		}
		else if(type.equals("closeResponse")){
			//Done
			System.out.println(type);
			new CloseResponseController().process(response);
		}
		else if(type.equals("connectResponse")){
			//Done
			System.out.println(type);
			new ConnectResponseController().process(response);
		}
		else if(type.equals("createResponse")){
			//Done
			System.out.println(type);
			new CreateResponseController().process(response);
		}
		
		else if(type.equals("signInResponse")){
			//Done
			System.out.println(type);
			new SignInResponseController().process(response);
		}
		else if(type.equals("turnResponse")){
			//Done
			System.out.println(type);
			new TurnResponseController();
		}
		else if(type.equals("adminResponse")){
			//Done
			System.out.println(type);
			new AdminResponseController().process(response);
		}
		else if(type.equals("removeResponse")){
			//Done
			System.out.println(type);
			new RemoveResponseController().process(response);
		}
		else if(type.equals("forceResponse")){
			//Done
			System.out.println(type);
			new ForceResponseController().process(response);
		}
		else if(type.equals("reportResponse")){
			//cat is doing this one
			System.out.println(type);
			new ReportResponseController().process(response);
		}
		else if(type.equals("chatResponse")){
			//optional and we aren't doing it
			System.out.println(type);
		}
		else System.out.println("Not a valid message: " + type);

		//System.out.println("Received in main thread:" + response);
	}
	

}
