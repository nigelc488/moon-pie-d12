package g1.MoonPie.Model;

import java.util.ArrayList;
import java.util.Collections;


/**This class represents a choice Line for a DecisionLines Event.
 * 
 * @author Eric Cobane
 * @author Janine Pizzimenti
 * @author J Lowrey
 * @author Chris Berthelette
 *
 */
public class Line {

	/**The X-position of the line.*/
	int xPosition;
	/**The name of the choice*/
	String choice;
	/**List of Edges that contact the Line.*/
	ArrayList<Edge> edges;

	/**
	 * Construct for a choice Line.
	 * 
	 * @param xPos	The X-position of the line
	 */
	public Line(int xPos){
		this.xPosition = xPos;
		edges = new ArrayList<Edge>();
		choice = "";
	}

	/**
	 * Gets the horizontal location of the Line.
	 * 
	 * @return int The horizontal location (xPositon) of the Line
	 */
	public int getxPosition() {
		return xPosition;
	}
	
	/**
	 * Sets the name for the choice Line.
	 * 
	 * @param choice	Desired name for the choice Line.
	 */
	public void setChoice(String choice){
		this.choice = choice;
	}
	
	/**
	 * Gets for the text of the choice
	 * 
	 * @return String containing the choices text
	 */
	public String getChoice() {
		return choice;
	}
	
	/**
	 * Add an edge to the arraylist of edges
	 * 
	 * @param e edge to be added
	 */
	public void addEdge(Edge e){
		edges.add(e);
	}
	
	/**
	 * This method sorts the Edges from lowest to highest based upon height.
	 */
	public void sortEdges(){
		Collections.sort(edges);
	}
	
	/**
	 * Getter for the ArrayList of Edges connected to the line
	 * @return the ArrayList of Edges
	 */
	public ArrayList<Edge> getEdges() {
		return edges;
	}
}