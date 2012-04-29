package g1.MoonPie.Model;

import java.util.ArrayList;
import java.util.Collections;


/**This class represents a choice Line for a DecisionLines Event.
 * 
 * @author Eric Cobane
 * @author Janine Pizzimenti
 * @author Nigel Cochran
 * @author Chris Berthelette
 *
 */
public class Line {
	
	/**The minimum number of pixels between edges*/
	static int BUFFER = 7; //might have to change
	/**The X-position of the line.*/
	int xPosition;
	/**The name of the choice*/
	String choice;
	/**List of Edges that contact the Line.*/
	ArrayList<Edge> edges;
	/**Whether or not the choice Line is editable*/
	boolean choiceEditable;
	
	/**Construct for a choice Line.
	 * 
	 * @param xPos	The X-position of the line
	 */
	public Line(int xPos){
		this.xPosition = xPos;
		edges = new ArrayList<Edge>();
		choice = "";
	}
	
	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * This method returns the horizontal location of the Line.
	 * @return int The horizontal location (xPositon) of the Line
	 */
	public int getxPosition() {
		return xPosition;
	}
	
	/**
	 * Getter for the text of the choice
	 * @return String containing the choices text
	 */
	public String getChoice() {
		return choice;
	}
	
	/**Updates the name for the choice Line.
	 * 
	 * @param choice	Desired name for the choice Line.
	 */
	public void setChoice(String choice){
		this.choice = choice;
	}
	
	/**
	 * Add an edge to the arraylist of edges
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
	
	/**
	 * This method returns the Edge stored at the desired location of the Line.
	 * @param i int The desired location
	 * @return Edge The Edge at the desired location
	 */
	public Edge getEdge(int i){
		return edges.get(i);
	}
	
	/**
	 * This method checks to see if a height of an Edge is too close to the Edges already associated with the Line.
	 * @param height int The height of an Edge.
	 * @return boolean Returns true if the height is too close to an existing Edge.  False if it is a valid Edge and is not too close.
	 */
	public boolean checkCloseEdge(int height){
		sortEdges();
		for (int i = 0; i < edges.size(); i++) {
			if (Math.abs((edges.get(i).getHeight() - height)) <= BUFFER){
				return true; //too close
			}
			
		}
		return false;
	}
}
