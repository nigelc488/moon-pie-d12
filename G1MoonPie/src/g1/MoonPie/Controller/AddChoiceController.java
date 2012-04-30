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

/**This class is used called when attempting to add choices to an event.
 * 
 * @author J Lowrey
 * @author Eric Cobane
 * @author Janine Pizzimenti
 *
 */
public class AddChoiceController implements android.view.View.OnClickListener{

	Event event;
	Activity activity;
	Line[] lines;
	boolean namesValid = true;
	EditText[] textBoxes = new EditText[8];
	TextView[] labels = new TextView[8];
	String[] choices;

	/**This constructor creates an AddChoiceController with an event and an activity.
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


//	NOT NEEDED ANYMORE
//		for (int i = 0; i < textBoxes.length; i++){
//
//
//			/** Visibility
//			 * Visible = 0
//			 * inVisible = 4
//			 * GONE, invisible and doesn't take up any space 8
//			 */
//			textBoxes[i].setVisibility(4);
//			labels[i].setVisibility(4);
//		}

	}

	
	@Override
	public void onClick(View v) {
		namesValid = true;
		lines = Event.getInstance().getLines();
		String choice;
		
		//get and validate choices
		choices = getChoices();
		
		if(namesValid){
			//if moderator then sent create request
			if(Event.getInstance().getUser().getPostion() == 0){
				SendMessageController.createRequest(Event.getInstance().getIsOpen(), Event.getInstance().getQuestion(), Event.getInstance().getNumChoices(), Event.getInstance().getNumRounds(), Event.getInstance().getUser().getUsername(), Event.getInstance().getUser().getPassword(), choices);
				if (!Event.getInstance().getIsOpen()){
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
			if (event.getIsOpen()) new CloseEventView(event, activity);
		}
	}
		
		
//		/* if the event is open */
//		if (event.getIsOpen()){
//			
//			
//			
//			//THIS IS ACTUALLY STILL WRONG
//			for(int i=0; i<lines.length; i++){
//				if(lines[i].getChoice().equals("")){
//					lines[i].setChoice(textBoxes[0].getText().toString());
//					
//					//if you are the moderator then need to send create message
//					if(Event.getInstance().getUser().getPostion() == 0){
//						SendMessageController.createRequest(Event.getInstance().getIsOpen(), Event.getInstance().getQuestion(), Event.getInstance().getNumChoices(), Event.getInstance().getNumRounds(), Event.getInstance().getUser().getUsername(), Event.getInstance().getUser().getPassword());
//					}
//					//if you are not moderator then send add choice message
//					else{
//						SendMessageController.addChoiceRequest(Event.getInstance().getID(), i, lines[i].getChoice());
//					}	
//				}
//			}
//		//	User mod = new User("username", "password", true);					//This was used to test close event controller
//		//	CloseEventView view = new CloseEventView(event, mod, activity);  	//This was used to test close event controller
//		}
//
//		/*If the event is closed*/
//		else{
//			ArrayList<String> namesOfLines = new ArrayList<String>();
//			for (int i = 0; i < lines.length; i++){
//				String namedLine = textBoxes[i].getText().toString();
//				namesOfLines.add(namedLine);
//			}
//			
////			SendMessageController.createRequest(type, question, numChoices, numRounds, userName, password, event);
//			
//			
////			SendMessageController.createRequest(Event., question, numChoices, numRounds, userName, password, event)
//
//			namesValid = true;
//			if (namesOfLines.contains("")){
//				Toast.makeText(activity, "Please fill in empty boxes", Toast.LENGTH_SHORT).show();
//				namesValid = false;
//			}
//
//			int sizeWithDuplicates = namesOfLines.size();
//			HashSet<String> linesNoDuplicates = new HashSet<String>();
//			linesNoDuplicates.addAll(namesOfLines);
//			int sizeWithoutDuplicates = linesNoDuplicates.size();
//
//			if (sizeWithDuplicates != sizeWithoutDuplicates){
//				Toast.makeText(activity, "Please change duplicate choices", Toast.LENGTH_SHORT).show();
//				namesValid = false;
//			}
//
//			if (namesValid == true){
//				
//				//this means everything worked so should do next step:
//				
//				//if it is closed then you are definately the moderator and send create request
//				SendMessageController.createRequest(Event.getInstance().getIsOpen(), Event.getInstance().getQuestion(), Event.getInstance().getNumChoices(), Event.getInstance().getNumRounds(), Event.getInstance().getUser().getUsername(), Event.getInstance().getUser().getPassword());
//
//				//User mod = new User("username", "password", true);					//This was used to test close event controller
//				//CloseEventView view = new CloseEventView(event, mod, activity);  	//This was used to test close event controller
//
//				//CompleteDecisionController results = new CompleteDecisionController(event, activity);	//This was used to test the complete decisions controller
//
//			}
//		}

	
	//This returns the choices. If any are blank or duplicates, then they are invalid.
	String[] getChoices(){
		String[] choices;
		if(Event.getInstance().getIsOpen()){
			choices = new String[1];
		} else choices = new String[Event.getInstance().getNumChoices()];
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
			
			//check to see if it is a valid edge
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



	public void recieveAddChoiceController(){


	}

}

