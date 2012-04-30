package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Entries;
import g1.MoonPie.View.AdminView;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class AdminDisplayController implements OnClickListener{
	RadioButton UnComp;
	RadioButton Comp;
	
	Activity activity;
	Entries entries;
	String type;
	
	public AdminDisplayController(Activity activity, Entries entries){
		this.activity = activity;
		this.entries =entries;
		
	}
	
	@Override
	public void onClick(View v) {
		RadioGroup EventType = (RadioGroup) activity.findViewById(R.id.EventType);
		int checkedRadioButton = EventType.getCheckedRadioButtonId();
		if (checkedRadioButton == R.id.UncompletedEvent){
			type = "open";
		}
		else{
			type = "closed";
		}
		
		AdminView av = new AdminView(activity, entries, type);
		av.setTableValues();
		
	}
	
}
