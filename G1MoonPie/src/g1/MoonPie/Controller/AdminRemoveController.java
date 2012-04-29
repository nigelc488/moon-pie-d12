package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Entries;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AdminRemoveController implements OnClickListener {

Activity activity;
Entries entries;
String s;
	
	public AdminRemoveController(Activity activity, Entries ent){
		this.entries = ent;
		this.activity = activity;
		this.s = "hello";
	}
	
	@Override
	public void onClick(View v) {
		EditText days = (EditText) activity.findViewById(R.id.EditDaysText);
		int DaysOld = Integer.parseInt(days.getText().toString());
		SendMessageController smc = new SendMessageController();
		RadioGroup EventType = (RadioGroup) activity.findViewById(R.id.EventType);
		int checkedRadioButton = EventType.getCheckedRadioButtonId();
		if (checkedRadioButton == R.id.UncompletedEvent){
			smc.removeRequest("445", "", false, DaysOld);
		}else if(checkedRadioButton == R.id.CompletedEvent){
			smc.removeRequest("445", "", true, DaysOld);
		}
		
	}
}
