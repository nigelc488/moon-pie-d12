package g1.MoonPie.Model;

import java.util.ArrayList;

/**This class represents a choice Line for a DecisionLines Event.
 * 
 * @author Eric Cobane
 *
 */
public class Line {
	
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
	}
	
	/**Sorts the edges associated with the choice Line.*/
	public void sortEdges(){
		//Need to write
	}
	
	/**Updates the name for the choice Line.
	 * 
	 * @param choice	Desired name for the choice Line.
	 */
	public void updateChoices(String choice){
		this.choice = choice;
	}

}
