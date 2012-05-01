package g1.MoonPie.Controller;


import g1.MoonPie.Model.Event;
import g1.MoonPie.View.DecisionLinesForm;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.content.Loader.ForceLoadContentObserver;



/**
 * This controller takes in a raw x-coordinate and scaled y-coordinate
 * from the onTouch function in DecisionLinesFormActivity()
 * The scaled y-coordinate is on a range from 0 to 100
 * The raw x-coordinate will be converted into two integers,
 * leftLine and rightLine to define which lines an edge will touch
 * 
 * @author Chris Berthelette
 *
 */

public class AddEdgeController {
	Event event;
	DecisionLinesForm drawView;
	
	int height;
	public int rounds;
	/**
	 * 
	 * @param x int unscaled height
	 * @param height int scaled height
	 * @param e Event function call
	 * @param d DecisionLinesForm function call
	 * 
	 * AddEdgeController scales final values and defines 
	 * height, leftLine, and rightLine
	 * 
	 */
	public AddEdgeController (DecisionLinesForm d){
		this.event = Event.getInstance();
		this.drawView = d;
		
		if(event.isOpen() == true){
			rounds = event.getNumRounds();
		}
		else{
			rounds = event.getTotalEdges();
		}
	}
	
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
		return left;
	}
	
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
		return right;
	}

	public void AddEdge(int hght, int lLine, int rLine){ 
		//if(event.checkValidEdge(height, leftLine, rightLine) == true){
			SendMessageController.addEdgeRequest(Event.getInstance().getID(), lLine, rLine, hght);
			//System.out.println("height:  " + height);
			//System.out.println("ArrayPos:  " + event.getEdges().get(leftLine).getHeight());
			//System.out.println("edgeAdded");
			drawView.postInvalidate();
		//}else {
		//	System.out.println("invalid edge");
		//}

	}

	public int scaleHeight(float f){
		int scaledHeight;
		scaledHeight = (int) (((100)*(4)*(f-(drawView.offset+60)))/((3)*drawView.getHeight()));
		return scaledHeight;
	}

	public int unscaleHeight(int i){
		int unscaledHeight;
		unscaledHeight = (((event.getEdges().get(i).getHeight()*(3)*(drawView.getHeight()))/((100)*(4)))+(drawView.offset+60));
		return unscaledHeight;

	}

	public int scaledLeftLine(int i){
		int scaledLeftLine;
		scaledLeftLine = ((event.getEdges().get(i).getLeftLine()+1)*(drawView.getWidth()/(event.getNumChoices()+1)));
		return scaledLeftLine;
	}

	public int scaledRightLine(int i){
		int scaledRightLine;
		scaledRightLine = ((event.getEdges().get(i).getRightLine()+1)*(drawView.getWidth()/(event.getNumChoices()+1)));
		return scaledRightLine;
	}
}