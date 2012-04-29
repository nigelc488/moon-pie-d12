package g1.MoonPie.Controller;

import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;

public class AdminDataContorller {
	Activity activity;
	SendMessageController smc;
	String key;
	String type;
	
	public AdminDataContorller(Activity act, String type, String key){
		this.activity = act;
		smc = new SendMessageController();
		this.key = key;
		this.type = type;
	}
	public void requestData(){
		smc.reportRequest(key, type);
	}

	

}
