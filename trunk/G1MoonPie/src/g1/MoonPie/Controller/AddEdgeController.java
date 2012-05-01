package g1.MoonPie.Controller;

import g1.MoonPie.Model.Event;
import g1.MoonPie.View.DecisionLinesForm;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;

/**
 * This controller takes in a raw x-coordinate and scaled y-coordinate
 * from the onTouch function in DecisionLinesFormActivity()
 * The scaled y-coordinate is on a range from 0 to 100
 * The raw x-coordinate will be converted into two integers,
 * leftLine and rightLine to define which lines an edge will touch.
 *
 * @author Chris Berthelette
 */

public class AddEdgeController {
	
	/** Declares Event. */
	Event event;
	
	/** Declares DecisionLinesForm. */
	DecisionLinesForm drawView;
	
	/** The height. */
	int height;
	
	/** The rounds variable determines the number of rounds in an event based on the Open or Closed attribute of an Event. */
	public int rounds;
	
	/**
	 * Instantiates a new adds the edge controller.
	 *
	 * @param d DecisionLinesForm function call
	 * 
	 * AddEdgeController scales final values and defines
	 * height, leftLine, and rightLine
	 */
	public AddEdgeController (DecisionLinesForm d){
		this.event = Event.getInstance();
		this.drawView = d;
		if(event.isOpen() == true){
			rounds = event.getNumRounds();
		}else{
			rounds = event.getTotalEdges();
		}
	}
	
	/**
	 * Find left line.
	 *
	 * @param x x-coordinate used to find Left Line
	 * @return the line to the left of the x-coordinate
	 */
	public int findLeftLine (int x){
		int i = 0;
		int j = i+1;
		int left = 0;
		while(i < event.getNumChoices()-1){
			if (x > ((event.getLines()[i].getxPosition()+1)*(drawView.getWidth()/(event.getNumChoices() +1))) && x < ((event.getLines()[j].getxPosition()+1)*(drawView.getWidth()/(event.getNumChoices() +1))) )
			{
				left = i;
				break;
			}else{
				i++;
				j++;
			}
		}
		System.out.println("Found Left Line.");
		return left;
	}
	
	/**
	 * Find right line.
	 *
	 * @param x x-coordinate used to find Left Line
	 * @return the line to the right of the x-coordinate
	 */
	public int findRightLine (int x){
		int i = 0;
		int j = i+1;
		int right = 0;
		while(i < event.getNumChoices()-1){
			if (x > ((event.getLines()[i].getxPosition()+1)*(drawView.getWidth()/(event.getNumChoices() +1))) && x < ((event.getLines()[j].getxPosition()+1)*(drawView.getWidth()/(event.getNumChoices() +1))) )
			{
				right = j;
				break;
			}else{
				i++;
				j++;
			}
		}
		System.out.println("Found Right Line.");
		return right;
	}

	/**
	 * Adds the edge.
	 *
	 * @param hght the height inputed when the function is called to create a new edge.
	 * @param lLine the left line inputed when the function is called to create a new edge.
	 * @param rLine the right line inputed when the function is called to create a new edge.
	 */
	public void AddEdge(int hght, int lLine, int rLine){ 
			SendMessageController.addEdgeRequest(Event.getInstance().getID(), lLine, rLine, hght);
			drawView.postInvalidate();
			System.out.println("Redrew Canvas.");
	}

	/**
	 * Scales height.
	 *
	 * @param f the floating number inputed and converted to a height based on a scale from 0 to 100.
	 * @return the returned height converted to the scale of 0 to 100. 
	 */
	public int scaleHeight(float f){
		int scaledHeight;
		scaledHeight = (int) (((100)*(4)*(f-(drawView.offset+60)))/((3)*drawView.getHeight()));
		System.out.println("Scaled Height.");
		return scaledHeight;
	}

	/**
	 * Unscales height.
	 *
	 * @param i the integer inputed from a scale of 0 to 100 and converted to a height based on the scale of the canvas.
	 * @return the returned height converted from a scale of 0 to 100 to the scale of the canvas. 
	 */
	public int unscaleHeight(int i){
		int unscaledHeight;
		unscaledHeight = (((event.getEdges().get(i).getHeight()*(3)*(drawView.getHeight()))/((100)*(4)))+(drawView.offset+60));
		System.out.println("Unscaled Height.");
		return unscaledHeight;

	}

	/**
	 * Scaled left line.
	 *
	 * @param i the integer grabbed from the array of edges and converted to an integer on the scale of the canvas.
	 * @return the integer returned on the scale of the canvas.
	 */
	public int scaledLeftLine(int i){
		int scaledLeftLine;
		scaledLeftLine = ((event.getEdges().get(i).getLeftLine()+1)*(drawView.getWidth()/(event.getNumChoices()+1)));
		System.out.println("Scaled Left Line");
		return scaledLeftLine;
	}

	/**
	 * Scaled right line.
	 *
	 * @param i the integer grabbed from the array of edges and converted to an integer on the scale of the canvas.
	 * @return the integer returned on the scale of the canvas.
	 */
	public int scaledRightLine(int i){
		int scaledRightLine;
		scaledRightLine = ((event.getEdges().get(i).getRightLine()+1)*(drawView.getWidth()/(event.getNumChoices()+1)));
		System.out.println("Scaled Right Line.");
		return scaledRightLine;
	}
}