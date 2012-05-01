package g1.MoonPie.Model;

import junit.framework.TestCase;

public class TestEvent extends TestCase{
	
	int numC = 3;
	int numR = 3;
	String id = "testing123";
	String q = "What is it?";
	
	@Override
	public void setUp(){
		Event.getInstance().setNumChoices(numC);
		Event.getInstance().setNumRounds(numR);
		Event.getInstance().setID(id);
		Event.getInstance().setQuestion(q);
		Event.getInstance().setOpen(false);
	}
	
	public void testSetEventParams(){
		setUp();
		assertEquals(numC, Event.getInstance().getNumChoices());
		assertEquals(numR, Event.getInstance().getNumRounds());
		assertEquals(id, Event.getInstance().getID());
		assertEquals(q, Event.getInstance().getQuestion());
		assertFalse(Event.getInstance().isOpen());
	}
	
	public void testLines(){
		setUp();
		String name;
		int newLength = 4;
		
		for (int i = 0; i<Event.getInstance().getLines().length; i++){
			name = "t"+i;
			Event.getInstance().getLines()[i].setChoice(name);
			assertEquals(name, Event.getInstance().getLines()[i].getChoice());
		}
		
		Line[] newLines = new Line[newLength];
		for (int i = 0; i<newLines.length; i++){
			newLines[i] = new Line(i);
			newLines[i].setChoice("n"+i);
		}
		
		Event.getInstance().setLines(newLines);
		assertEquals(newLength, Event.getInstance().getLines().length);
		for (int i = 0; i<Event.getInstance().getLines().length; i++){
			name = "n"+i;
			assertEquals(name, Event.getInstance().getLines()[i].getChoice());
			assertEquals(i, Event.getInstance().getLines()[i].getxPosition());
		}
		
		assertTrue(Event.getInstance().checkValidChoice("New Name"));
		assertFalse(Event.getInstance().checkValidChoice(""));
		assertFalse(Event.getInstance().checkValidChoice("n1"));
	}
	
	public void testUsers(){
		setUp();
		String username = "name";
		String password = "";
		int position = 0;
		User user1 = new User(username, password, position);
		User user2 = new User("testusername", "testpassword");
		
		Event.getInstance().setUser(user2);
		Event.getInstance().getUser().setPostion(position);
		assertEquals(user1.getPostion(),Event.getInstance().getUser().getPostion());
		Event.getInstance().getUser().setUsername(username);
		assertEquals(user1.getUsername(),Event.getInstance().getUser().getUsername());
		Event.getInstance().getUser().setPassword(password);
		assertEquals(user1.getPassword(),Event.getInstance().getUser().getPassword());
	}
	
	public void testEdges(){
		setUp();
		int numEdgesToTest = 4;
		int[] heights = new int[numEdgesToTest];
		int leftLinePos; int rightLinePos;
		Edge[] edges = new Edge[numEdgesToTest];
		for (int i=0; i<numEdgesToTest; i++){
			if (i%2 == 0){
				leftLinePos = 1;
				rightLinePos = 2;
			}else{
				leftLinePos = 0;
				rightLinePos = 1;				
			}
			heights[i] = i*10+5;
			assertTrue(Event.getInstance().checkValidEdge(heights[i], leftLinePos, rightLinePos));
			Event.getInstance().addEdge(heights[i], leftLinePos, rightLinePos);			
		}
		Event.getInstance().calculateResults();
		assertFalse(Event.getInstance().checkValidEdge(15, 0, 1));
		assertFalse(Event.getInstance().checkValidEdge(15, 1, 2));
		assertFalse(Event.getInstance().checkValidEdge(25, 0, 1));
		assertEquals(numEdgesToTest, Event.getInstance().getNumEdges());
		assertEquals(numC*numR, Event.getInstance().getTotalEdges());
	}
	
}
