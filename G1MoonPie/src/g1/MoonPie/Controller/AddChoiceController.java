package g1.MoonPie.Controller;

import java.util.ArrayList;
import java.util.HashSet;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.Line;
import g1.MoonPie.Model.User;
import g1.MoonPie.View.CloseEventView;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;

/**This class is called when attempting to add choices to an event.
 * 
 * @author J Lowrey
 * @author Eric Cobane
 * @author Janine Pizzimenti
 *
 */
public class AddChoiceController implements android.view.View.OnClickListener{

	/** The event. */
	Event event;

	/** The activity. */
	Activity activity;

	/** The lines. */
	Line[] lines;

	/** The names valid */
	boolean namesValid = true;

	/**  An array of all the textBoxes gathered from the choiceform layout */
	EditText[] textBoxes = new EditText[8];

	/** An array of all the Labels gathered from the choiceform layout */
	TextView[] labels = new TextView[8];

	/** The choices in an array. */
	String[] choices;

	/**This constructor creates an AddChoiceController with an event and an activity.
	 * It also sets all of the android widgets; TextView and EditText as variables in the class
	 * 
	 * @param e	Event to access model objects.
	 * @param a	Activity to access GUI objects.
	 */
	public AddChoiceController(Event e, Activity a){

		event = e;
		activity= a;

		EditText text1 = (EditText)activity.findViewById(R.id.choice1TB);
		EditText text2 = (EditText)activity.findViewById(R.id.choice2TB);
		EditText text3 = (EditText)activity.findViewById(R.id.choice3TB);
		EditText text4 = (EditText)activity.findViewById(R.id.choice4TB);
		EditText text5 = (EditText)activity.findViewById(R.id.choice5TB);
		EditText text6 = (EditText)activity.findViewById(R.id.choice6TB);
		EditText text7 = (EditText)activity.findViewById(R.id.choice7TB);
		EditText text8 = (EditText)activity.findViewById(R.id.choice8TB);

		TextView label1 = (TextView)activity.findViewById(R.id.choice1Label);
		TextView label2 = (TextView)activity.findViewById(R.id.choice2Label);
		TextView label3 = (TextView)activity.findViewById(R.id.choice3Label);
		TextView label4 = (TextView)activity.findViewById(R.id.choice4Label);
		TextView label5 = (TextView)activity.findViewById(R.id.choice5Label);
		TextView label6 = (TextView)activity.findViewById(R.id.choice6Label);
		TextView label7 = (TextView)activity.findViewById(R.id.choice7Label);
		TextView label8 = (TextView)activity.findViewById(R.id.choice8Label);

		textBoxes[0] = text1;
		textBoxes[1] = text2;
		textBoxes[2] = text3;
		textBoxes[3] = text4;
		textBoxes[4] = text5;
		textBoxes[5] = text6;
		textBoxes[6] = text7;
		textBoxes[7] = text8;

		labels[0] = label1;
		labels[1] = label2;
		labels[2] = label3;
		labels[3] = label4;
		labels[4] = label5;
		labels[5] = label6;
		labels[6] = label7;
		labels[7] = label8;

	}


	/**
	 * onClick creates a send message createRequest from SendMessageController
	 * only if the names are valid it will check to see if you are a moderator if you are then set the choices based on if it is open or close
	 * open will set only the first choice, closed will set all
	 * 
	 * @param v the current view where the click is taking place
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {

		namesValid = true;
		lines = Event.getInstance().getLines();
		String choice;
		choices = getChoices();

		if(namesValid){
			//if moderator then send create request
			if(Event.getInstance().getUser().getPostion() == 0){
				SendMessageController.createRequest(Event.getInstance().isOpen(), Event.getInstance().getQuestion(), Event.getInstance().getNumChoices(), Event.getInstance().getNumRounds(), Event.getInstance().getUser().getUsername(), Event.getInstance().getUser().getPassword(), choices);
				if (!Event.getInstance().isOpen()){
					for (int i = 0; i < Event.getInstance().getLines().length; i++){
						Event.getInstance().getLines()[i].setChoice(choices[i]);
					}
				}else{
					Event.getInstance().getLines()[0].setChoice(choices[0]);
				}
			}
			//if not moderator then send add choice request
			else{
				if(choices.length > 1){
					System.out.println("ERROR SOMETHING IS BAD");
					choice = null;
				}else {
					choice = choices[0];
				}
				SendMessageController.addChoiceRequest(Event.getInstance().getID(), Event.getInstance().getUser().getPostion(), choice);
			}
			if (event.isOpen()) new CloseEventView(event, activity);
		}
	}

	/**
	 * This returns the choices. If any are blank or duplicates, then they are invalid.
	 *
	 * @return the choices
	 */
	public String[] getChoices(){
		String[] choices;

		// if the event is open
		if(Event.getInstance().isOpen()){
			choices = new String[1];
		}
		//if it is closed, it will check to see if there are any duplicates
		else choices = new String[Event.getInstance().getNumChoices()];
		ArrayList<String> linesWithDuplicates = new ArrayList<String>();
		HashSet<String> linesNoDuplicates = new HashSet<String>();
		for (int i = 0; i < choices.length; i++){

			String namedLine = textBoxes[i].getText().toString();
			int choiceNum = i+1;

			linesWithDuplicates.add(namedLine);
			int sizeWithDuplicates = linesWithDuplicates.size();
			linesNoDuplicates.addAll(linesWithDuplicates);
			int sizeWithoutDuplicates = linesNoDuplicates.size();
			if (sizeWithDuplicates != sizeWithoutDuplicates){
				//Toast.makeText(activity, "Choice "+choiceNum+" is a duplicate, please change it", Toast.LENGTH_SHORT).show();
				namesValid = false;
			}

			//if there is no dupocates it will then check if there are any blank strings in the textbox
			if(namesValid && Event.getInstance().checkValidChoice(namedLine)){
				choices[i] = namedLine;
			}else{
				namesValid = false;
				if (namedLine.equals("")){
					Toast.makeText(activity, "Choice "+choiceNum+" is empty, please complete", Toast.LENGTH_SHORT).show();
				}else{
					Toast.makeText(activity, "Choice "+choiceNum+" is a duplicate, please change it", Toast.LENGTH_SHORT).show();
				}
				return choices;
			}
		}
		return choices;
	}
}