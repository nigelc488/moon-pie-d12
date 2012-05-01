package g1.MoonPie.Controller;

import g1.MoonPie.R;
import g1.MoonPie.Model.Entries;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;
import android.widget.RadioGroup;

/**
 * The Class AdminDataContorller.
 * @author Catherine Coleman
 */
public class AdminDataContorller {
	
	/** The activity. */
	Activity activity;
	
	/** The send message controller. */
	SendMessageController smc;
	
	/** The key. */
	String key;
	
	/** The type. */
	String type;
	
	/** The entries. */
	Entries entries;
	
	/**
	 * Instantiates a new admin data contorller.
	 *
	 * @param act the act
	 * @param key the key
	 */
	public AdminDataContorller(Activity act, String key){
		this.activity = act;
		this.key = key;
	}
	
	/**
	 * Request data from the server.
	 */
	public void requestData(){
		smc = new SendMessageController();
		
		RadioGroup EventType = (RadioGroup) activity.findViewById(R.id.EventType);
		int checkedRadioButton = EventType.getCheckedRadioButtonId();
		if (checkedRadioButton == R.id.UncompletedEvent){
			type = "open";
			System.out.println("Uncomplete event data requested from server");
		}if (checkedRadioButton == R.id.CompletedEvent){
			type= "closed";
			System.out.println("Complete event data requested from server");
		}
		smc.reportRequest(key, type);
	}
	

}
