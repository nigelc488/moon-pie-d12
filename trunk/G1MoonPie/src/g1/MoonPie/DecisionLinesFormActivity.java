package g1.MoonPie;


import g1.MoonPie.Controller.AddEdgeController;
import g1.MoonPie.Model.Event;
import g1.MoonPie.View.DecisionLinesForm;
import g1.MoonPie.clientServer.receiveMessages.ProcessThreadMessages;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
	DecisionLinesForm drawView;
	AddEdgeController addEdge;
	//TODO
	Event event;
	int edgeXPos;
	int edgeHeight;
	int maxHeight;

	/**
	 * Sets screen orientation to landscape,
	 * also modified in AndroidManifest.xml
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		event = Event.getInstance();
		ProcessThreadMessages.setActivity(this);
		

		//testing:    :)
//		event.getLines()[0].setChoice("one1");
//		event.getLines()[1].setChoice("two2");
//		event.getLines()[2].setChoice("three3");
//		event.getLines()[3].setChoice("i'm");
//		event.getLines()[4].setChoice("getting");
//		event.getLines()[5].setChoice("very");
//		event.getLines()[6].setChoice("tired");
//		event.getLines()[7].setChoice("blah");

		drawView = new DecisionLinesForm(this);

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
			int duration = Toast.LENGTH_SHORT;

			public boolean onTouch(View v, MotionEvent me) {
				int action = me.getAction();
				if (action == MotionEvent.ACTION_DOWN) {
					edgeXPos = (int) me.getX();	
					edgeHeight = addEdge.scaleHeight(me.getY());
					if(event.getNumEdges() < addEdge.rounds){
						if(edgeHeight < 0 | edgeHeight > 100 
								| edgeXPos < ((event.getLines()[0].getxPosition()+1)*(drawView.getWidth()/(event.getNumChoices() +1))) 
								| edgeXPos > ((event.getLines()[event.getNumChoices()-1].getxPosition()+1)*(drawView.getWidth()/(event.getNumChoices() +1)))
								){

							System.out.println("This is an invalid edge. Try Again.");
							Toast.makeText(context, invalidEdgeErrorMsg, duration).show();
						}else{
							CharSequence numRemainingEdges = ((addEdge.rounds - (event.getNumEdges()+1)) + " remaining");
							System.out.println("Call AddEdgeController");
							addEdge.AddEdge(edgeXPos, edgeHeight);
							Toast.makeText(context, numRemainingEdges, duration).show();
						}
					}else{
						System.out.println("finished adding edges");
						Toast.makeText(context, finishedAddingEdgesMsg, duration).show();
						
						//go back to old activity
						Intent intent = new Intent(ProcessThreadMessages.getActivity(), CompleteDecisionActivity.class);
						startActivity(intent);
						
						
						

						
					}
				}
				return true; 
			}

		});
	}

} 