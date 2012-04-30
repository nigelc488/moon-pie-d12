package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Entries;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;
import android.widget.RadioGroup;

public class AdminDataContorller {
	Activity activity;
	SendMessageController smc;
	String key;
	String type;
	Entries entries;
	
	public AdminDataContorller(Activity act, String key){
		this.activity = act;
		this.key = key;
	}
	
	public void requestData(){
		smc = new SendMessageController();
		
		RadioGroup EventType = (RadioGroup) activity.findViewById(R.id.EventType);
		int checkedRadioButton = EventType.getCheckedRadioButtonId();
		if (checkedRadioButton == R.id.UncompletedEvent){
			type = "open";
		}if (checkedRadioButton == R.id.CompletedEvent){
			type= "closed";
		}
		smc.reportRequest(key, type);
	}
	

}
