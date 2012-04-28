package g1.MoonPie.Controller;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.Line;

/**
 * 
 * @author J Lowrey
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
	

	EditText[] textBoxs = new EditText[7];
	TextView[] labels = new EditText[7];
	
	
	public AddChoiceController(Event e, Activity a){
		
		event = e;
		activity= a;
		
		textBoxs[0] = text1;
		textBoxs[1] = text2;
		textBoxs[2] = text3;
		textBoxs[3] = text4;
		textBoxs[4] = text5;
		textBoxs[5] = text6;
		textBoxs[6] = text7;
		textBoxs[7] = text8;
		
		for (int i = 0; i < textBoxs.length; i++){
//			textBoxs[i].VISIBLE = 0;
//			labels[i].VISIBLE = 0;
		}

	}

	public void sendAddChoiceController(){

	}

	public void recieveAddChoiceController(){

		lines = event.getLines();
		
		choiceTitle.setText(R.id.question);
	

		for (int i = 0; i < lines.length; i++){
			
//			textBoxs[i].VISIBLE = 1;
//			labels[i].VISIBLE = 1;

			lines[i].setChoice(textBoxs[i].getText().toString());
		}
		
		
	}
}
