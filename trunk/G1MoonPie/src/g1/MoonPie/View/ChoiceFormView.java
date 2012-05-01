package g1.MoonPie.View;

import g1.MoonPie.R;
import g1.MoonPie.Controller.AddChoiceController;
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

	/**Event to access model objects.*/
	Event event;
	/**Activity to access GUI objects.*/
	Activity activity;

	/**This constructor creates a new ChoiceFormView, with access to an event and an activity.
	 * 
	 * @param e	Event to access model objects.
	 * @param a	Activity to acess GUI objects.
	 */
	public ChoiceFormView(Event e, Activity a){

		this.event = e;
		this.activity = a;

		//set the view to choiceform
		activity.setContentView(R.layout.choiceform);

		//add listener to beginRoundButton
		Button beginRoundButton = (Button) activity.findViewById(R.id.toDLFormButton);
		beginRoundButton.setOnClickListener(new AddChoiceController(event, activity));
	}

	/**This method sets the visibility of choices for the client based on if the event is open or closed.*/
	public void setChoicesVisibility(){

		//set the title label to the event question
		TextView choiceTitle = (TextView) activity.findViewById(R.id.questionLabel);
		choiceTitle.setText(event.getQuestion());

		//create 8 edit text boxes
		EditText text1 = (EditText)activity.findViewById(R.id.choice1TB);
		EditText text2 = (EditText)activity.findViewById(R.id.choice2TB);
		EditText text3 = (EditText)activity.findViewById(R.id.choice3TB);
		EditText text4 = (EditText)activity.findViewById(R.id.choice4TB);
		EditText text5 = (EditText)activity.findViewById(R.id.choice5TB);
		EditText text6 = (EditText)activity.findViewById(R.id.choice6TB);
		EditText text7 = (EditText)activity.findViewById(R.id.choice7TB);
		EditText text8 = (EditText)activity.findViewById(R.id.choice8TB);

		//create 8 choice labels
		TextView label1 = (TextView)activity.findViewById(R.id.choice1Label);
		TextView label2 = (TextView)activity.findViewById(R.id.choice2Label);
		TextView label3 = (TextView)activity.findViewById(R.id.choice3Label);
		TextView label4 = (TextView)activity.findViewById(R.id.choice4Label);
		TextView label5 = (TextView)activity.findViewById(R.id.choice5Label);
		TextView label6 = (TextView)activity.findViewById(R.id.choice6Label);
		TextView label7 = (TextView)activity.findViewById(R.id.choice7Label);
		TextView label8 = (TextView)activity.findViewById(R.id.choice8Label);

		//create arrays for the text boxes and labels created above
		EditText[] textBoxes = new EditText[8];
		TextView[] labels = new TextView[8];

		//add the text boxes and labels to the arrays
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

		//iterate through all the text boxes and labels setting them invisible
		for (int i = 0; i < textBoxes.length; i++){

			/* Visibility
			 * Visible = 0
			 * inVisible = 4
			 * GONE, invisible and doesn't take up any space 8
			 */
			textBoxes[i].setVisibility(4);
			labels[i].setVisibility(4);
		}

		/*if the event is open, only set one text box and label visible, otherwise set the correct amount visible for the
		 *moderator to be able to fill in all choices*/
		if (event.isOpen()){
			textBoxes[0].setVisibility(0);
			labels[0].setVisibility(0);
			int choiceNum = Event.getInstance().getUser().getPostion() + 1;
			labels[0].setText("Choice "+choiceNum+": ");
		}
		else{
			for (int i = 0; i < event.getLines().length; i++){			
				textBoxes[i].setVisibility(0);
				labels[i].setVisibility(0);
			}
		}

	}
}
