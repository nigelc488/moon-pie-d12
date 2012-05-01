package g1.MoonPie;

import g1.MoonPie.Controller.AddEdgeController;
import g1.MoonPie.Model.Event;
import g1.MoonPie.View.DecisionLinesForm;
import g1.MoonPie.clientServer.receiveMessages.ProcessThreadMessages;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * This is the activity call for the DecisionLinesForm.
 * It calls DecisionLinesForm to paint a canvas with lines.
 * It creates an OnTouchListener and allows the user to select to add edges if within bounds.
 * 
 * @author Chris Berthelette
 *
 */ 
public class DecisionLinesFormActivity extends Activity {

	/** Declares DecisionLinesForm. */
	DecisionLinesForm drawView;

	/** Declares AddEdgeController. */
	AddEdgeController addEdge;
	//TODO
	/** Declares Event. */
	Event event;

	/** The x-position set onTouch. */
	int edgeXPos;

	/** The edge height set onTouch. */
	int edgeHeight;

	/** The max height of the screen. */
	int maxHeight;

	/** The line to the left of the x-position onTouch event. */
	int left;

	/** The line to the right of the x-position onTouch event */
	int right;

	/**
	 * Sets screen orientation to landscape,
	 * also modified in AndroidManifest.xml
	 *
	 * @param newConfig the new configuration
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

	/**
	 * Called when the activity is first created.
	 *
	 * @param savedInstanceState the saved instance state
	 */
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		event = Event.getInstance();
		ProcessThreadMessages.setActivity(this);
		DecisionLinesForm.setContext(this);
		drawView = DecisionLinesForm.getInstance();
		addEdge = new AddEdgeController(drawView);
		drawView.setBackgroundColor(Color.BLACK);
		setContentView(drawView);

		/**
		 * Instantiates onTouch listener.
		 * On MotionEvent.ACTION_DOWN, gets x-coordinate and y-coordinate,
		 * scales y-coordinate to scale from 0 to 100
		 * if touch method falls within bounds, calls AddEdgeController
		 * else calls short toaster error message
		 */
		drawView.setOnTouchListener(new View.OnTouchListener() {
			Context context = getApplicationContext();
			CharSequence invalidEdgeErrorMsg = "This is an invalid edge. Try Again.";
			CharSequence finishedAddingEdgesMsg = "No more edges needed";			
 
			public boolean onTouch(View v, MotionEvent me) {
				int action = me.getAction();
				if (action == MotionEvent.ACTION_DOWN) {
					edgeXPos = (int) me.getX();	
					edgeHeight = addEdge.scaleHeight(me.getY());
					int duration = Toast.LENGTH_SHORT;

					if(event.getNumEdges() < addEdge.rounds){
						if(edgeHeight < 0 | edgeHeight > 100 
								| edgeXPos < ((event.getLines()[0].getxPosition()+1)*(drawView.getWidth()/(event.getNumChoices() +1))) 
								| edgeXPos > ((event.getLines()[event.getNumChoices()-1].getxPosition()+1)*(drawView.getWidth()/(event.getNumChoices() +1)))
								){
							System.out.println("This is an invalid edge. Try Again.");
							Toast.makeText(context, invalidEdgeErrorMsg, duration).show();
						}else{  
							left = addEdge.findLeftLine(edgeXPos);
							right = addEdge.findRightLine(edgeXPos);
							if(event.checkValidEdge(edgeHeight, left, right) == true){
								addEdge.AddEdge(edgeHeight, left, right);
								if((addEdge.rounds - (event.getNumEdges()+1))== 0){
									Toast.makeText(context, "Touch Anywhere To Continue", Toast.LENGTH_LONG).show();
								}else{
									Toast.makeText(context, ((addEdge.rounds - (event.getNumEdges()+1)) + " remaining"), duration).show();
								}
							}else{
								Toast.makeText(context, invalidEdgeErrorMsg, duration).show();
							}
						}
					}else{
						System.out.println("finished adding edges");
						Toast.makeText(context, finishedAddingEdgesMsg, duration).show();

						Intent intent = new Intent(ProcessThreadMessages.getActivity(), CompleteDecisionActivity.class);
						startActivity(intent);	
					}
				}
				return true; 
			}
		});
	}
} 