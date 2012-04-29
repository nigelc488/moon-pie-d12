package g1.MoonPie.clientServer;

import junit.framework.TestCase;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.client.ClientLauncher;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;

public class TestCommunication extends TestCase {
	
	protected void setUp(){
		try {
			new ClientLauncher();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void testCommunication(){
		
		SendMessageController send = new SendMessageController();
		send.addChoiceRequest("id'number", 1, "the & ring");
		send.addEdgeRequest("id'number2", 2, 3, 75);
		send.adminRequest("nig'el", "");
		send.adminRequest("nig'el", "passWoRD");
		send.closeRequest("id'number3");
		Event event = new Event(5, 3);
		event.getLines()[0].setChoice("first's choice");
		send.createRequest("open", "who am < I", 5, 3, "nigel>", "password", event);
		event.getLines()[1].setChoice("second & choice");
		event.getLines()[3].setChoice("four'th choice");
		send.createRequest("closed", "weee&ee", 5, 3, "jani'ne", "pa'ss", event);
		send.forceRequest("key's here", "myi'd", 7);
		send.removeRequest("key'key", "idt'ime", true, 60);
		send.signInRequest("idn'umber", "cathe'rine", "past ten'se");
		send.reportRequest("key'here", "closed");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
