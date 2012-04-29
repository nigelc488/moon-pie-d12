package g1.MoonPie.View;

import g1.MoonPie.R;
import g1.MoonPie.Controller.AddChoiceController;
import g1.MoonPie.Controller.BeginRoundController;
import g1.MoonPie.Controller.JoinEventMessageController;
import g1.MoonPie.Model.Event;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**This class is used to run the begin rounds controller upon clicking the next button on the choice form.
 * 
 * @author Eric Cobane
 * @author jpizz
 *
 */
public class ChoiceFormView {

	Activity activity;
	Event event;

	public ChoiceFormView(Event e, Activity a){

		this.event = e;
		this.activity = a;

		activity.setContentView(R.layout.choiceform);

		Button beginRoundButton = (Button) activity.findViewById(R.id.toDLFormButton);
		beginRoundButton.setOnClickListener(new AddChoiceController(event, activity));
	}
	
	public void setChoicesVisibility(){
		TextView choiceTitle = (TextView) activity.findViewById(R.id.questionLabel);
		choiceTitle.setText(event.getQuestion());
		
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
		
		EditText[] textBoxes = new EditText[8];
		TextView[] labels = new TextView[8];
		
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
		
		for (int i = 0; i < textBoxes.length; i++){

			/* Visibility
			 * Visible = 0
			 * inVisible = 4
			 * GONE, invisible and doesn't take up any space 8
			 */
			textBoxes[i].setVisibility(4);
			labels[i].setVisibility(4);
		}
		
		if (event.getIsOpen()){
			textBoxes[0].setVisibility(0);
		}else{
			for (int i = 0; i < event.getLines().length; i++){			
				textBoxes[i].setVisibility(0);
				labels[i].setVisibility(0);
			}
		}

	}
}
