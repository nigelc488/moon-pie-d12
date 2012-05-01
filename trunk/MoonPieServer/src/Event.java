

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**This class represents a DecisionLines Event.
 * 
 * @author Eric Cobane
 * @author Janine Pizzimenti
 * @author Nigel Cochran
 * @author J Lowrey
 *
 */

public class Event {
	private static Event instance = null;

	/**Number of Users for the event.*/
	int numChoices;
	/**Number of rounds for the event.*/
	int numRounds;
	/**List of the lines for an event.*/
	//Line[] lines; //change to array
	/**The event ID.*/
	String ID;
	/** States if an event is open or closed */
	boolean isOpen = false;
	/**The Question for the event*/
	String question;
	//User user;
	String[] choices;
	
	
	



	/**Construct for a DecisionLines Event.
	 * 
	 * @param numberOfChoices		The number of Users
	 * @param numberOfRounds	The number of Rounds
	 */
//	public Event(int numberOfChoices, int numberOfRounds, String question, boolean isOpen){
//		this.numChoices = numberOfChoices;
//		this.numRounds = numberOfRounds;
//		lines = new Line[numberOfChoices];
//		for (int i = 0; i<numberOfChoices; i++){
//			lines[i] = new Line(i);
//		}	
//		this.question = question;
//		this.isOpen = isOpen;
//	}

	/**
	 * This constructor does not take in any variables but instantiates the lines, edges, results, number of rounds, and number of choices.
	 */

	protected Event(){
		numRounds = 0;
		numChoices = 0;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	

	/**
	 * getter for isOpen
	 */
	public boolean getIsOpen(){
		return isOpen;
	}
	
	/**
	 * Sets the availability of the Event
	 * True, open
	 * false, closed
	 * default, closed
	 */
	public void closeEvent(){
		this.isOpen = false;
	}

	
	/**
	 * Set the number of rounds in an event
	 * @param numR number of rounds
	 */
	public void setNumRounds(int numR){
		numRounds = numR;
	}
	
	/**
	 * Set the number of users in an event
	 * @param numC number of users
	 */
	public void setNumChoices(int numC){
		numChoices = numC;
		choices = new String[numC];
		for (int i = 0; i<numC; i++){
			choices[i] = new String();
		}
	}
	
	/**
	 * Get the number of rounds in an event
	 */
	public int getNumRounds(){
		return numRounds;
	}
	
	/**
	 * Get the number of choices in an event
	 */
	public int getNumChoices(){
		return numChoices;
	}
	
	/**
	 * Get the number of users in an event
	 */
	public int getNumUsers(){
		return numChoices;//users.size();
	}
	
	/**
	 * Getter for the array of Lines in the Event
	 * @return Array containing all of the lines
	 */
	public String[] getChoices(){
		return choices;
	}
	
	public void setChoice(int index, String choice){
		choices[index] = choice;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public static Event getInstance(){
	if(instance == null) instance = new Event();
	return instance;
	}
	
	public void setInstance(Event event){
		instance = event;
	}
	


	
	
}
