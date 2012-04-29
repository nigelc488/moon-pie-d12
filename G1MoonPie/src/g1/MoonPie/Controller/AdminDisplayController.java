package g1.MoonPie.Controller;

import g1.MoonPie.R;
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
	
	String type;
	
	public AdminDisplayController(Activity activity){
		this.activity = activity;
		RadioGroup EventType = (RadioGroup) activity.findViewById(R.id.EventType);
		int checkedRadioButton = EventType.getCheckedRadioButtonId();
		if (checkedRadioButton == R.id.UncompletedEvent){
			type = "open";
		}
		else{
			type = "closed";
		}
	}
	
	@Override
	public void onClick(View v) {
		activity.setContentView(R.layout.adminview);
		AdminDataContorller adc = new AdminDataContorller(activity, type, "454");
		adc.requestData();
	}
	
}
