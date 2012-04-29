package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.Line;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class ForceChoiceController implements OnClickListener {

	public ForceChoiceController(Event event, Activity activity) {
		
		EditText forceText1 = (EditText)activity.findViewById(R.id.Force1TB);
		EditText forceText2 = (EditText)activity.findViewById(R.id.Force2TB);
		EditText forceText3 = (EditText)activity.findViewById(R.id.Force3TB);
		EditText forceText4 = (EditText)activity.findViewById(R.id.Force4TB);
		EditText forceText5 = (EditText)activity.findViewById(R.id.Force5TB);
		EditText forceText6 = (EditText)activity.findViewById(R.id.Force6TB);
		EditText forceText7 = (EditText)activity.findViewById(R.id.Force7TB);
		EditText forceText8 = (EditText)activity.findViewById(R.id.Force8TB);

		TextView forceLabel1 = (TextView)activity.findViewById(R.id.Force1Label);
		TextView forceLabel2 = (TextView)activity.findViewById(R.id.Force2Label);
		TextView forceLabel3 = (TextView)activity.findViewById(R.id.Force3Label);
		TextView forceLabel4 = (TextView)activity.findViewById(R.id.Force4Label);
		TextView forceLabel5 = (TextView)activity.findViewById(R.id.Force5Label);
		TextView forceLabel6 = (TextView)activity.findViewById(R.id.Force6Label);
		TextView forceLabel7 = (TextView)activity.findViewById(R.id.Force7Label);
		TextView forceLabel8 = (TextView)activity.findViewById(R.id.Force8Label);

		EditText[] forceTextBoxes = new EditText[8];
		TextView[] forceLabels = new TextView[8];
		TextView[] finishedChoices = new TextView[8];
		Line[] lines = event.getLines();

		forceTextBoxes[0] = forceText1;
		forceTextBoxes[1] = forceText2;
		forceTextBoxes[2] = forceText3;
		forceTextBoxes[3] = forceText4;
		forceTextBoxes[4] = forceText5;
		forceTextBoxes[5] = forceText6;
		forceTextBoxes[6] = forceText7;
		forceTextBoxes[7] = forceText8;

		forceLabels[0] = forceLabel1;
		forceLabels[1] = forceLabel2;
		forceLabels[2] = forceLabel3;
		forceLabels[3] = forceLabel4;
		forceLabels[4] = forceLabel5;
		forceLabels[5] = forceLabel6;
		forceLabels[6] = forceLabel7;
		forceLabels[7] = forceLabel8;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
