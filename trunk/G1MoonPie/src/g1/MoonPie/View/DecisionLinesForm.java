package g1.MoonPie.View;
import g1.MoonPie.Controller.AddEdgeController;
import g1.MoonPie.Model.Edge;
import g1.MoonPie.Model.Event;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
/**
 * DecisionLinesForm adds a canvas to the application and draws text and lines to model choices, lines, and edges
 * 
 * @author Chris Berthelette
 *
 */
public class DecisionLinesForm extends View {
	AddEdgeController addEdge; 
	Paint paint = new Paint();	
	Event event;
	public int offset;
	/**
	 * 
	 * @param context function call for Context.
	 * @param e function call for Event.
	 */
	public DecisionLinesForm(Context context) {
		super(context);
		this.event = Event.getInstance();
		paint.setColor(Color.WHITE);
		addEdge = new AddEdgeController(this); 
	}
	/**
	 * onDraw sets up the canvas and paints attributes.
	 */
	@Override 
	public void onDraw(Canvas canvas) {
		int height = getHeight();
		int width = getWidth();
		int lineHeight = (5*height)/6;
		offset = (height/25);
		
		for (int i = 0; i < event.getNumChoices(); i++){
			int xpos = (i+1)*(width/(event.getNumChoices() +1));
			canvas.drawText(event.getLines()[i].getChoice(), xpos - 10, offset+10, paint);	
			canvas.drawLine(xpos, offset+30, xpos, offset+30 + lineHeight, paint);
		}
		for (int i = 0; i < event.getEdges().size(); i++) {
			ArrayList<Edge> edgesList = event.getEdges();
			Edge thisEdge = edgesList.get(i);
			event.getEdges().get(i);
			
			int rescaledLeftLine = addEdge.scaledLeftLine(i);
			int rescaledRightLine = addEdge.scaledRightLine(i);
			int unscaledHeight = addEdge.unscaleHeight(i);
			
			canvas.drawLine(rescaledLeftLine, unscaledHeight, rescaledRightLine, unscaledHeight, paint);
		}
	}
}

