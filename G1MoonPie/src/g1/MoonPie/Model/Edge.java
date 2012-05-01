package g1.MoonPie.Model;



/**This class represents an edge in a DecisionLines Event.
 * 
 * @author Eric Cobane
 * @author Janine Pizzimenti
 * @author Nigel Cochran
 *
 */
public class Edge implements Comparable<Edge>{

	/**The choice line to the left of the edge.*/
	int leftLine;
	/**The choice line to the right of the edge.*/
	int rightLine;
	/**The height of the edge [from 0-100]*/
	int height;
	
	/**Construct for an Edge, with the left and right lines that it connects,
	 * and its height.
	 * 
	 * @param lLine		Left line the edge contacts.
	 * @param rLine		Right line the edge contacts.
	 * @param height	The height of the Edge.
	 */
	public Edge(int height, int lLine, int rLine){

		this.leftLine = lLine;
		this.rightLine = rLine;
		this.height = height;
	}

	/**
	 * Getter for the height of the Edge
	 * @return int for the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Getter for the position of the left Line connected to the Edge
	 * @return int for the position of the left Line
	 */
	public int getLeftLine() {
		return leftLine;
	}

	/**
	 * Getter for the position of the right Line connected to the Edge
	 * @return int for the position of the right Line
	 */
	public int getRightLine() {
		return rightLine;
	}
	
	/**
	 * This method makes it so that two Edges can be compared based on their height
	 * It modifies the existing compareTo method from the Comparable interface.
	 * @param o Edge The Edge to be compared to this Edge
	 * @return int The difference between the heights (this Edge minus specified Edge)
	 */
	@Override
	public int compareTo(Edge o) {
		return this.height - o.height;
	}
	
}
