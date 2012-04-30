package g1.MoonPie.Model;

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
	Line[] lines; //change to array
	/**The event ID.*/
	String ID;
	/** States if an event is open or closed */
	boolean isOpen = false;
	/**The Question for the event*/
	String question;
	User user;
	
	
	



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
		lines = new Line[numC];
		for (int i = 0; i<numC; i++){
			lines[i] = new Line(i);
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
	public Line[] getLines(){
		return lines;
	}
	
	/**
	 * Getter for the total number of edges allowed in the event
	 * @return int representing the total edges possible in the event
	 */
	public int getTotalEdges(){
		return this.numRounds*this.lines.length;
	}
	
	/**
	 * Getter for the number of Edges in an Event
	 * @return int representing the number of edges
	 */
	public int getNumEdges(){
		ArrayList<Edge> allEdges = this.getEdges();
		HashSet<Edge> edgesNoDoubles = new HashSet<Edge>();
		edgesNoDoubles.addAll(allEdges);
		return edgesNoDoubles.size();
	}
	
	/**
	 * Getter for a complete ArrayList containing all of the Edges in an Event
	 * @return the ArrayList of all the Event's Edges
	 */
	public ArrayList<Edge> getEdges(){
		ArrayList<Edge> allEdges = new ArrayList<Edge>(); 
		for (int i = 0; i<lines.length; i++){
			allEdges.addAll(lines[i].getEdges());
		}
	    return allEdges;
	}
	
	/**
	 * Getter for an ArrayList containing all of the Edges for a given Line
	 * @param linePos the position of the Line containing the desired Edges
	 * @return an ArrayList of all of the Edges connected to the given Line
	 */
	public ArrayList<Edge> getEdges(int linePos){
		ArrayList<Edge> allEdges = new ArrayList<Edge>(); 
		allEdges.addAll(lines[linePos].getEdges());
		HashSet<Edge> edgesNoDoubles = new HashSet<Edge>();
		edgesNoDoubles.addAll(allEdges);
		allEdges.removeAll(allEdges);
		allEdges.addAll(edgesNoDoubles);
	    return allEdges;
	}
	
	/**
	 * Add an Edge to the appropriate Lines
	 * @param height int for the height of the edge
	 * @param leftLinePos int for the position of the line to the left of the edge
	 * @param rightLinePos int for the position of the line to the right of the edge
	 */
	public void addEdge(int height, int leftLinePos, int rightLinePos){
		Edge e = new Edge(height, leftLinePos, rightLinePos);
		lines[leftLinePos].addEdge(e);
		lines[rightLinePos].addEdge(e);
	}
	
	/**
	 * Retrieve a list of the heights of all edges connected to two Lines
	 * @param leftLinePos the position of the left line
	 * @param rightLinePos the position of the right line
	 * @return an ArrayList containing integers of the heights of all of the edges connected to the two given lines
	 */
	public ArrayList<Integer> getEdgeHeights(int leftLinePos, int rightLinePos){
		ArrayList<Integer> heights = new ArrayList<Integer>();
		ArrayList<Edge> allEdges = this.getEdges(leftLinePos);
		allEdges.addAll(this.getEdges(rightLinePos));
		for (int i = 0; i < allEdges.size(); i++){
			  heights.add(allEdges.get(i).getHeight());
		}
		return heights;
	}
	
	/**
	 * This method checks to see if the given string is unique (not empty and not already a choice).
	 * @param choice The string to be checked.
	 * @return boolean If the string does not match any of the current choices then this method returns true.  If it is the same as another choice then it returns false.
	 */
	public boolean checkValidChoice(String choice){
		boolean valid = true;
		
		// checks to see if the passed string is null
		if(choice.isEmpty()){
			valid = false;
			//alert users somehow
		}else{
			//converts the choice to lower case for consistency
			choice = choice.toLowerCase();
			//this for loop first checks to see if the string in the line is null, if not, it compares to see if the two are equal
			for (int i = 0; i < lines.length; i++) {
				if(lines[i].choice != null  && !lines[i].choice.isEmpty()){
					valid = !lines[i].getChoice().toLowerCase().equals(choice);
					if(!valid){
						//alert user somehow
						return valid;
					}
				}
			}		
		}
		return valid;
	}
	
	/**
	 * This method checks to see if all of the choices have been entered successfully.
	 * @return boolean Returns true if all choices are full.  If they are not, returns false.
	 */
	public boolean checkChoicesFull(){
		boolean full = false;
		for (int i = 0; i < lines.length; i++) {
			if(lines[i].choice == null){
				full = false;
				break;
			}
			else full = true;
		}
		return full;
	}

	/**
	 * This method determines the order of the specified Choices based upon the added Edges.
	 * The algorithm determines the order by descending each Vertical Line until it encounters a horizontal Edge.  It then follows this Edge to the next vertical Line.
	 * It then descends this Line to the next Edge, following this pattern until there are no more Edges to be traveled.  The position of the Line it ends on is the final result
	 * for that Choice.  It does this for each Choice.  The results are displayed in the console.
	 */
	public String[] calculateResults(){
		String[] results = new String[lines.length];
		int startLine; int currentLine;
		ArrayList<Edge> allEdges = getEdges();
		Collections.sort(allEdges);
		for (int i = 0; i < lines.length; i++){
			startLine = i;
			currentLine = startLine;
			for (int j = 0; j < allEdges.size(); j++){
				if (allEdges.get(i).getLeftLine()==currentLine){
					currentLine = allEdges.get(i).getRightLine();
				} else if (allEdges.get(i).getRightLine()==currentLine){
					currentLine = allEdges.get(i).getLeftLine();
				}
			}
			results[currentLine] = getLines()[startLine].getChoice();
		}
		return results;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public static Event getInstance(){
	if(instance == null) instance = new Event();
	return instance;
	}
	
	public void setInstance(Event event){
		instance = event;
	}


	
	
}
