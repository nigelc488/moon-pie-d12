package g1.MoonPie.Controller;

import g1.MoonPie.R;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AdminViewTypeController implements OnClickListener{
	Activity activity;
	int type;
	TextView EventType;
	TextView Vis1;
	TextView Vis2;
	TextView Vis3;
	TextView Vis4;
	TextView Vis5;
	TextView Vis6;
	EditText days;
	Button Remove;
	
	public AdminViewTypeController(Activity activity, int num){
		this.activity = activity;
		this.type = num;
	}
	
	@Override
	public void onClick(View v) {
		Vis1 = (TextView) activity.findViewById(R.id.textVis1);
		Vis1.setVisibility(0);
		Vis2 = (TextView) activity.findViewById(R.id.textVis2);
		Vis2.setVisibility(0);
		Vis3 = (TextView) activity.findViewById(R.id.textVis3);
		Vis3.setVisibility(0);
		Vis4 = (TextView) activity.findViewById(R.id.textVis4);
		Vis4.setVisibility(0);
		
		days = (EditText) activity.findViewById(R.id.EditDaysText);
		days.setVisibility(0);
		
		EventType = (TextView) activity.findViewById(R.id.texteventtype);
		
		Remove = (Button) activity.findViewById(R.id.RemoveButton);
		Remove.setVisibility(0);
		
		if(type == 1){
			EventType.setText("Unompeleted");
			Vis5 = (TextView) activity.findViewById(R.id.textVis5);
			Vis5.setVisibility(0);
			Vis6 = (TextView) activity.findViewById(R.id.textVis6);
			Vis6.setVisibility(0);
			
		}else if(type == 2){
			EventType.setText("Compeleted");
		}
		
	}
	
}
