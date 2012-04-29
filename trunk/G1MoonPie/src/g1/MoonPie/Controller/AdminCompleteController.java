package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Entries;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;

import java.util.Calendar;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AdminCompleteController implements OnClickListener{
Activity activity;
Entries entries;
String key;
	
	public AdminCompleteController(Activity activity, Entries ent, String k){
		this.activity = activity;
		this.key = k; 
	}
	
	@Override
	public void onClick(View v) {
		EditText days = (EditText) activity.findViewById(R.id.EditDaysText);
		int DaysOld = Integer.parseInt(days.getText().toString());
		SendMessageController smc = new SendMessageController();
		smc.forceRequest(key, "", DaysOld);
		
	}

}