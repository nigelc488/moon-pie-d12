package g1.MoonPie.Model;

import java.util.ArrayList;

/**This class represents a DecisionLines Event.
 * 
 * @author Eric Cobane
 *
 */

public class Event {

	/**Number of Users for the event.*/
	int numUsers;
	/**Number of rounds for the event.*/
	int numRounds;
	/**List of the users' names for the event.*/
	ArrayList<String> users;				//Should these be of type User instead of String?
	/**List of the lines for an event.*/
	ArrayList<Line> lines;
	/**The event ID.*/
	String ID;


	/**Construct for a DecisionLines Event.
	 * 
	 * @param numberOfUsers		The number of Users
	 * @param numberOfRounds	The number of Rounds
	 */
	public Event(int numberOfUsers, int numberOfRounds){

		this.numUsers = numberOfUsers;
		this.numRounds = numberOfRounds;
	}

	/**Adds a new edge to the event.
	 * 
	 * @param e		The new Edge to be added to the event
	 */
	public void addEdge(Edge e){
		//Need to write
	}

	/**Calculates the final solution for the event.*/
	public void calculateSolution(){
		//Need to write
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	
}
