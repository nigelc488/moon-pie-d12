package g1.MoonPie.Model;


/**This class represents an edge in a DecisionLines Event.
 * 
 * @author Eric Cobane
 *
 */
public class Edge {

	/**The choice line to the left of the edge.*/
	int leftLine;
	/**The choice line to the right of the edge.*/
	int rightLine;
	/**The height of the edge.*/
	int height;

	/**Construct for an Edge, with the left and right lines that it connects,
	 * and its height.
	 * 
	 * @param lLine		Left line the edge contacts.
	 * @param rLine		Right line the edge contacts.
	 * @param height	The height of the Edge.
	 */
	public Edge(int lLine, int rLine, int height){

		this.leftLine = lLine;
		this.rightLine = rLine;
		this.height = height;
	}
}
