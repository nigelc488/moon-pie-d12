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
 * @author Chris Berthelette
 *
 */
 
public class Event {
	/**Singleton instance of event */
	private static Event instance = null;

	/**Number of Users for the event.*/
	int numChoices;
	/**Number of rounds for the event.*/
	int numRounds;
	/**List of the lines for an event.*/
	Line[] lines;
	/**The event ID.*/
	String ID;
	/**True if an event is open, false if it is closed */
	boolean isOpen = false;
	/**The Question for the event*/
	String question;
	/**The local user of the event*/
	User user;
	
	

	/**
	 * This constructor does not take in any variables but instantiates the lines, edges, results, number of rounds, and number of choices.
	 */
	protected Event(){
		numRounds = 0;
		numChoices = 0;
	}
	
	/**
	 * Set the singleton instance of the event
	 * 
	 * @param event Event that the singleton is set to
	 */
	public void setInstance(Event event){
		instance = event;
	}
	
	/**
	 * Get the singleton instance of the event
	 * @return the singleton instance of the Event
	 */
	public static Event getInstance(){
	if(instance == null) instance = new Event();
	return instance;
	}

	/**
	 * Set the number of rounds in an event
	 * 
	 * @param numR number of rounds
	 */
	public void setNumRounds(int numR){
		numRounds = numR;
	}
	
	/**
	 * Get the number of rounds in an event
	 * 
	 * @return numRounds integer representing number of rounds in an event
	 */
	public int getNumRounds(){
		return numRounds;
	}
	
	/**
	 * Set the number of choices in an event
	 * 
	 * @param numC number of choices
	 */
	public void setNumChoices(int numC){
		numChoices = numC;
		lines = new Line[numC];
		for (int i = 0; i<numC; i++){
			lines[i] = new Line(i);
		}
	}

	/**
	 * Get the number of choices in an event
	 */
	public int getNumChoices(){
		return numChoices;
	}
	
	/**
	 * Set the lines to a new array of lines and update the number of choices accordingly
	 * 
	 * @param lines Array containing new lines for the event
	 */
	public void setLines(Line[] lines) {
		this.lines = lines;
		numChoices = lines.length;
	}

	/**
	 * Get the array of Lines in the Event
	 * 
	 * @return Array containing all of the lines
	 */
	public Line[] getLines(){
		return lines;
	}

	/**
	 * Set the ID for an event
	 * 
	 * @param iD String containing the event's ID
	 */
	public void setID(String iD) {
		ID = iD;
	}

	/**
	 * Get the ID for an event
	 * 
	 * @return String conataining the event's ID
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Set whether or not an event is open
	 * 
	 * @param isOpen boolean true when event is open, false when event is closed
	 */
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	
	/**
	 * Get whether or not an event is open
	 * 
	 * @return true if event is open, false if event is closed
	 */
	public boolean isOpen(){
		return isOpen;
	}

	/**
	 * Set the event's question
	 * 
	 * @param question String containing the question of the event
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Get the event's question
	 * 
	 * @return String containing the question of the event
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Get the local user of the event
	 * 
	 * @return User representing the local user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * Set the local user of the event
	 * 
	 * @param user User representing the local user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Get the total number of edges allowed in the event
	 * 
	 * @return int representing the total edges possible in the event
	 */
	public int getTotalEdges(){
		return this.numRounds*this.lines.length;
	}
	
	/**
	 * Get the current number of Edges in an Event
	 * @return int representing the number of edges
	 */
	public int getNumEdges(){
		ArrayList<Edge> allEdges = this.getEdges();
		HashSet<Edge> edgesNoDoubles = new HashSet<Edge>();
		edgesNoDoubles.addAll(allEdges);
		return edgesNoDoubles.size();
	}
	
	/**
	 * Get a complete ArrayList containing all of the Edges in an Event
	 * 
	 * @return the ArrayList of all the Event's Edges
	 */
	public ArrayList<Edge> getEdges(){
		ArrayList<Edge> allEdges = new ArrayList<Edge>(); 
		for (int i = 0; i<lines.length; i++){
			allEdges.addAll(lines[i].getEdges());
		}
		HashSet<Edge> edgesNoDoubles = new HashSet<Edge>();
		edgesNoDoubles.addAll(allEdges);
		allEdges.removeAll(allEdges);
		allEdges.addAll(edgesNoDoubles);
	    return allEdges;
	}

	/**
	 * Add an Edge to the appropriate Lines
	 * 
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
	 * Checks if an edge is valid (not adjacent to any neighboring edges
	 * 
	 * @param height int representing the height of the edge
	 * @param leftLinePos int representing the left line position 
	 * @param rightLinePos int representing the right lin position
	 * 
	 * @return true if the edge is valid, false otherwise
	 */
	public boolean checkValidEdge(int height, int leftLinePos, int rightLinePos){
		boolean valid = true;

		for(int i=0; i< this.getNumChoices(); i++){//iterates trough choices
			for(int z=0; z<this.getLines()[i].getEdges().size(); z++){//iterates through edges of that choice
				if(this.getLines()[i].getEdges().get(z).getHeight() < height+2 &&  
						this.getLines()[i].getEdges().get(z).getHeight() > height-2){

					if(this.getLines()[i].getEdges().get(z).getLeftLine() == leftLinePos ){
						valid = false;
					}
					if(this.getLines()[i].getEdges().get(z).getLeftLine() == rightLinePos ){
						valid = false;
					}
					if(this.getLines()[i].getEdges().get(z).getRightLine() == leftLinePos ){
						valid = false;
					}
				}
			}
		}
		return valid;
	}
	
	/**
	 * Checks to see if the given string is unique (not empty and not already a choice)
	 * 
	 * @param choice The string to be checked.
	 * @return boolean If the string does not match any of the current choices then this method returns true.  If it is the same as another choice then it returns false.
	 */
	public boolean checkValidChoice(String choice){
		boolean valid = true;
		
		// checks to see if the passed string is null
		if(choice.isEmpty()){
			valid = false;
		}else{
			//converts the choice to lower case for consistency
			choice = choice.toLowerCase();
			//this for loop first checks to see if the string in the line is null, if not, it compares to see if the two are equal
			for (int i = 0; i < lines.length; i++) {
				if(lines[i].choice != null  && !lines[i].choice.isEmpty()){
					valid = !lines[i].getChoice().toLowerCase().equals(choice);
					if(!valid){
						return valid;
					}
				}
			}		
		}
		return valid;
	}

	/**
	 * This method determines the order of the specified Choices based upon the added Edges.
	 * The algorithm determines the order by descending each Vertical Line until it encounters a horizontal Edge.  It then follows this Edge to the next vertical Line.
	 * It then descends this Line to the next Edge, following this pattern until there are no more Edges to be traveled.  The position of the Line it ends on is the final result
	 * for that Choice.  It does this for each Choice.
	 * 
	 * @return array of Strings containing the title for each choice is the order that the decision lines algorithm determines the results
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
				if (allEdges.get(j).getLeftLine()==currentLine){
					currentLine = allEdges.get(j).getRightLine();
				} else if (allEdges.get(j).getRightLine()==currentLine){
					currentLine = allEdges.get(j).getLeftLine();
				}
			}
			results[currentLine] = getLines()[startLine].getChoice();
		}
		return results;
	}


}
