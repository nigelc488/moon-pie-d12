package g1.MoonPie.clientServer;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import junit.framework.TestCase;
import g1.MoonPie.Model.Event;
import g1.MoonPie.clientServer.client.ClientLauncher;
import g1.MoonPie.clientServer.receiveMessages.ProcessThreadMessages;
import g1.MoonPie.clientServer.receiveMessages.messageController.AddChoiceResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.AddEdgeResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.AdminResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.CloseResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.CreateResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.ForceResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.RemoveResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.ReportResponseController;
import g1.MoonPie.clientServer.receiveMessages.messageController.SignInResponseController;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import g1.MoonPie.clientServer.xml.MessageXML;

public class TestCommunication extends TestCase {
	ProcessThreadMessages process;
	
	@Override
	protected void setUp(){
		try {
			new ClientLauncher();
			process = new ProcessThreadMessages();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	
	public void testAddChoice(){
		
		
		AddChoiceResponseController add = new AddChoiceResponseController();
		add.process(SendMessageController.addChoiceRequest("id'number", 1, "the & ring"));
		assertEquals("the & ring", add.getChoice());
		assertEquals(1, add.getLine());
		

	}
	
	public void testAddEdge(){
		AddEdgeResponseController edge = new AddEdgeResponseController();
		MessageXML request = SendMessageController.addEdgeRequest("id'number2", 2, 3, 75);
		edge.process(SendMessageController.addEdgeRequest("id'number2", 2, 3, 75));
		assertEquals(75, edge.getHeight());
		assertEquals(2, edge.getLeft());
		assertEquals(3, edge.getRight());
	}
	
	public void testCreate(){
		CreateResponseController create = new CreateResponseController();
		Event event = new Event(5, 3);
		event.getLines()[0].setChoice("first's choice");
		MessageXML request = SendMessageController.createRequest("open", "who am < I", 5, 3, "nigel>", "password", event);
		
		Node child = request.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		Node myChild = request.contents.getFirstChild().getLastChild();
		NamedNodeMap map2 = myChild.getAttributes();
		
		String type = map.getNamedItem("type").getNodeValue();
		String question = map.getNamedItem("question").getNodeValue();
		question = EncodeXML.decodeString(question);
		int numChoices = Integer.parseInt(map.getNamedItem("numChoices").getNodeValue());
		int numRounds = Integer.parseInt(map.getNamedItem("numRounds").getNodeValue());
		String userName = map2.getNamedItem("name").getNodeValue();
		userName = EncodeXML.decodeString(userName);
		String password = map2.getNamedItem("password").getNodeValue();
		
		assertEquals("open", type);
		assertEquals("who am < I", question);
		assertEquals(5, numChoices);
		assertEquals(3, numRounds);
		assertEquals("nigel>", userName);
		assertEquals(EncryptPassword.getSuperSecrectPassword("password"), password);
		
	
		String id = "1234";
		String xmlString = MessageXML.responseHeader(request.id()) + "<createResponse id='" + id + "'/></response>";
		System.out.println(xmlString);
		MessageXML r = new MessageXML(xmlString);
		
		create.process(r);
		assertEquals("1234", create.getId());
	}
	
	public void testAdmin(){
		AdminResponseController admin = new AdminResponseController();
		
		MessageXML request = SendMessageController.adminRequest("nig'el", "");
		
		Node child = request.contents.getFirstChild().getFirstChild();
		NamedNodeMap map = child.getAttributes();
		String userName = map.getNamedItem("name").getNodeValue();
		userName = EncodeXML.decodeString(userName);
		String password = map.getNamedItem("password").getNodeValue();
		assertEquals("nig'el", userName);
		assertTrue(password.isEmpty());
		
		String xmlString = MessageXML.responseHeader(SendMessageController.adminRequest("nig'el", "").id()) + "<adminResponse key='" +  "abc123" + "'/></response>";
		MessageXML r = new MessageXML(xmlString);
		admin.process(r);
		assertFalse(admin.getKey().isEmpty());

		request = SendMessageController.adminRequest("nig'el", "passWoRD");
		
		child = request.contents.getFirstChild().getFirstChild();
		map = child.getAttributes();
		userName = map.getNamedItem("name").getNodeValue();
		userName = EncodeXML.decodeString(userName);
		password = map.getNamedItem("password").getNodeValue();
		assertEquals("nig'el", userName);
		assertEquals(EncryptPassword.getSuperSecrectPassword("passWoRD"), password);
		
	}
	
	public void testClose(){
		CloseResponseController close = new CloseResponseController();
		close.process(SendMessageController.closeRequest("id'number3"));
		assertTrue(close.isClosed());
	}
	
	public void testForce(){
		ForceResponseController force = new ForceResponseController();
		MessageXML request = SendMessageController.forceRequest("key's here", "myi'd", 7);
		
		Node child = request.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		String key = map.getNamedItem("key").getNodeValue();
		key = EncodeXML.decodeString(key);
		String id = map.getNamedItem("id").getNodeValue();
		id = EncodeXML.decodeString(id);
		assertEquals("key's here", key);
		assertEquals("myi'd", id);
		
		String numberAffected = "5";
		String xmlString = MessageXML.responseHeader(request.id()) + "<forceResponse numberAffected='" + numberAffected + "'/></response>";
		System.out.println(xmlString);
		MessageXML r = new MessageXML(xmlString);
		force.process(r);
		assertEquals(5, force.getNumberAffected());
		
	}
	
	public void testRemove(){
		RemoveResponseController remove = new RemoveResponseController();
		MessageXML request = SendMessageController.removeRequest("key'key", "idt'ime", true, 60);
		
		Node child = request.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		String key = map.getNamedItem("key").getNodeValue();
		key = EncodeXML.decodeString(key);
		String id = map.getNamedItem("id").getNodeValue();
		id = EncodeXML.decodeString(id);
		assertEquals("key'key", key);
		assertEquals("idt'ime", id);
		
		String numberAffected = "5";
		String xmlString = MessageXML.responseHeader(request.id()) + "<removeResponse numberAffected='" + numberAffected + "'/></response>";
		System.out.println(xmlString);
		MessageXML r = new MessageXML(xmlString);
		remove.process(r);
		assertEquals(5, remove.getNumberAffected());
		
	}
	
	public void testSignIn(){
		SignInResponseController sign = new SignInResponseController();
		
		MessageXML request = SendMessageController.signInRequest("idn'umber", "cathe'rine", "past ten'se");
		
		Node child = request.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		
		Node myChild = request.contents.getFirstChild().getLastChild();
		NamedNodeMap map2 = myChild.getAttributes();
		String name = map2.getNamedItem("name").getNodeValue();
		name = EncodeXML.decodeString(name);
		String password = map2.getNamedItem("password").getNodeValue();
		String id = map.getNamedItem("id").getNodeValue();
		String id2 = EncodeXML.decodeString(id);
		
		assertEquals("idn'umber", id2);
		assertEquals("cathe'rine", name);
		assertEquals(EncryptPassword.getSuperSecrectPassword("past ten'se"), password);
		

		String type = "closed";
		String question = "Why?";
		int numChoices = 5;
		int numRounds = 3;
		int position = 4;
		String xmlString = MessageXML.responseHeader(request.id()) + "<signInResponse id='" + id + "' " + "type='" + type + "' " + "question='" + question + "' " + "numChoices='" + numChoices + "' " + "numRounds='" + numRounds + "' " + "position='" + position + "'/></response>";
		System.out.println(xmlString);
		MessageXML r = new MessageXML(xmlString);
		sign.process(r);
		
		assertEquals("closed", sign.getType());
		assertEquals("Why?", sign.getQuestion());
		assertEquals("idn'umber", sign.getId());
		assertEquals(5, sign.getNumChoices());
		assertEquals(3, sign.getNumRounds());
		assertEquals(4, sign.getPosition());
		
	}
	
	public void testReport(){
		ReportResponseController report = new ReportResponseController();
		
		MessageXML request = SendMessageController.reportRequest("key'here", "closed");
		
		Node child = request.contents.getFirstChild();
		NamedNodeMap map = child.getAttributes();
		String key = map.getNamedItem("key").getNodeValue();
		key = EncodeXML.decodeString(key);
		String type = map.getNamedItem("type").getNodeValue();
		assertEquals("key'here", key);
		assertEquals("closed", type);
		
		String id = "myid";
		type = "closed";
		String question = "question";
		int numChoices = 5;
		int numRounds = 3;
		String created = "a date?";
		boolean completed = false;
		String entry = "<entry id='" + id +"' " + "type='" + type + "' " + "question='" + question + "' " + "numChoices='" + numChoices + "' " + "numRounds='" + numRounds + "' " + "created='" + created + "' " + "completed='" + completed + "'/>";
		
		id = "myid2";
		type = "closed";
		question = "question2";
		numChoices = 5;
		numRounds = 3;
		created = "a date?2";
		completed = false;
		String entry2 = "<entry id='" + id +"' " + "type='" + type + "' " + "question='" + question + "' " + "numChoices='" + numChoices + "' " + "numRounds='" + numRounds + "' " + "created='" + created + "' " + "completed='" + completed + "'/>";
		
		String xmlString = MessageXML.responseHeader(request.id()) + "<reportResponse>" + entry + entry2 + "</reportResponse></response>";
		System.out.println(xmlString);
		MessageXML r = new MessageXML(xmlString);
		report.process(r);
		
		assertEquals(2, report.getEntries().size());
		assertEquals("myid", report.getEntries().get(0).getId());
		assertEquals("closed", report.getEntries().get(0).getType());
		assertEquals("question", report.getEntries().get(0).getQuestion());
		assertEquals(5, report.getEntries().get(0).getNumChoices());
		assertEquals(3, report.getEntries().get(0).getNumRounds());
		assertEquals("a date?", report.getEntries().get(0).getCreated());
		assertTrue(report.getEntries().get(0).isCompleted());
	}
	
	public void testProcessThreadMessage(){
		
	}
}