package g1.MoonPie.Controller;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.Line;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;

/**
 * 
 * @author J Lowrey
 * @author Eric Cobane
 *
 */
public class AddChoiceController {

	Event event;
	Activity activity;
	Line[] lines;

	TextView choiceTitle = (TextView)activity.findViewById(R.id.questionLabel);

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


	EditText[] textBoxes = new EditText[7];
	TextView[] labels = new EditText[7];


	public AddChoiceController(Event e, Activity a){

		event = e;
		activity= a;

		textBoxes[0] = text1;
		textBoxes[1] = text2;
		textBoxes[2] = text3;
		textBoxes[3] = text4;
		textBoxes[4] = text5;
		textBoxes[5] = text6;
		textBoxes[6] = text7;
		textBoxes[7] = text8;

		for (int i = 0; i < textBoxes.length; i++){


			/** Visibility
			 * Visible = 0
			 * inVisible = 4
			 * GONE, invisible and doesn't take up any space 8
			 */
			textBoxes[i].setVisibility(4);
			labels[i].setVisibility(4);
		}

	}

	public void sendAddChoiceController(){

		lines = event.getLines();

		choiceTitle.setText(R.id.question);

		if (event.getIsOpen()){
			
			textBoxes[0].setVisibility(0);
			
			for(int i=0; i<lines.length; i++){
				
				if(lines[i].getChoice().equals("")){
					lines[i].setChoice(textBoxes[0].getText().toString());
					SendMessageController.addChoiceRequest(event.getID(), i, lines[i].getChoice());
				}
			}
		}
		else{

			for (int i = 0; i < lines.length; i++){

				textBoxes[i].setVisibility(0);
				labels[i].setVisibility(0);

				lines[i].setChoice(textBoxes[i].getText().toString());
				SendMessageController.addChoiceRequest(event.getID(), i, lines[i].getChoice());
			}
		}
	}

	public void recieveAddChoiceController(){


	}


}

