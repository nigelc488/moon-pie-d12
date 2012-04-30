package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Entries;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AdminViewTypeController implements OnClickListener{
	Activity activity;
	Entries entries;
	String key;
	TextView EType;
	TextView Vis1;
	TextView Vis2;
	TextView Vis3;
	TextView Vis4;
	TextView Vis5;
	TextView Vis6;
	EditText days;
	Button Remove;
	Button Complete;
	Button Display;
	
	public AdminViewTypeController(Activity activity, String k){
		this.activity = activity;
		this.key = k;
		
	}
	
	@Override
	public void onClick(View v) {
		AdminDataContorller adc = new AdminDataContorller(activity,key);
		adc.requestData();
	}
	
	public void EnableVisability(Entries ent){
		this.entries = ent;
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
		
		EType = (TextView) activity.findViewById(R.id.texteventtype);
		
		Remove = (Button) activity.findViewById(R.id.RemoveButton);
		Remove.setVisibility(0);
		Remove.setOnClickListener(new AdminRemoveController(activity, entries, key));
		
		Complete = (Button) activity.findViewById(R.id.CompleteButton);
		Complete.setOnClickListener(new AdminCompleteController(activity, entries, key));
		
		Display = (Button) activity.findViewById(R.id.DisplayButton);
		Display.setVisibility(0);
		Display.setOnClickListener(new AdminDisplayController(activity, entries));
		
		RadioGroup EventType = (RadioGroup) activity.findViewById(R.id.EventType);
		int checkedRadioButton = EventType.getCheckedRadioButtonId();
		if (checkedRadioButton == R.id.UncompletedEvent){
			EType.setText("Uncompeleted");
			Vis5 = (TextView) activity.findViewById(R.id.textVis5);
			Vis5.setVisibility(0);
			Vis6 = (TextView) activity.findViewById(R.id.textVis6);
			Vis6.setVisibility(0);
			Complete.setVisibility(0);
		}else{
			EType.setText("Compeleted");
		}
	}
	
}
