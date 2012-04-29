package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.View.ChoiceFormView;
import g1.MoonPie.View.NewEventView;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class is used as a listener for the create join event button.
 * @author jpizz
 *
 */
public class NewEventMessageController implements OnClickListener {

	Activity activity;

	public NewEventMessageController(Activity activity){
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		EditText questionText = (EditText) activity.findViewById(R.id.question);
		String question = questionText.getText().toString();

		String type; boolean isOpen;
		RadioGroup availability = (RadioGroup) activity.findViewById(R.id.availability);
		int checkedRadioButton = availability.getCheckedRadioButtonId();
		if (checkedRadioButton == R.id.openEvent){
			type = "open";
			isOpen = true;
		}
		else{
			type = "closed";
			isOpen = false;
		}

		Spinner choicesSpinner = (Spinner) activity.findViewById(R.id.numChoices);
		Spinner roundsSpinner = (Spinner) activity.findViewById(R.id.numRounds);
		int numChoices = Integer.parseInt(choicesSpinner.getSelectedItem().toString());
		int numRounds = Integer.parseInt(roundsSpinner.getSelectedItem().toString());
		Toast.makeText(activity, "c:"+numChoices+" r:"+numRounds+" a:"+type, Toast.LENGTH_LONG).show();

		EditText usernameText = (EditText) activity.findViewById(R.id.username);
		String username = usernameText.getText().toString();

		EditText passwordText = (EditText) activity.findViewById(R.id.password);
		String password = passwordText.getText().toString();

		Event event = new Event(numChoices, numRounds, question, isOpen);
		//SendMessageController.createRequest(type, question, numChoices, numRounds, username, password, event);

		//the following code should be executed after a response from the server
		ChoiceFormView view = new ChoiceFormView(event,activity);
		activity.setContentView(R.layout.choiceform);
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
		
		EditText[] textBoxes = new EditText[7];
		TextView[] labels = new EditText[7];
		
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
		}
		else{
			for (int i = 0; i < event.getLines().length; i++){			
				textBoxes[i].setVisibility(0);
				labels[i].setVisibility(0);
			}
		}

	}

}






