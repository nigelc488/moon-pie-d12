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

// TODO: Auto-generated Javadoc
/**
 * The Class AdminCompleteController.
 * @author Catherine Coleman
 */
public class AdminCompleteController implements OnClickListener{

/** The activity. */
Activity activity;

/** The entries. */
Entries entries;

/** The key. */
String key;
	
	/**
	 * Instantiates a new admin complete controller.
	 *
	 * @param activity the activity
	 * @param ent the ent
	 * @param k the k
	 */
	public AdminCompleteController(Activity activity, Entries ent, String k){
		this.activity = activity;
		this.key = k; 
	}
	
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		EditText days = (EditText) activity.findViewById(R.id.EditDaysText);
		int DaysOld = Integer.parseInt(days.getText().toString());
		SendMessageController smc = new SendMessageController();
		smc.forceRequest(key, "", DaysOld);
		System.out.println("Complete Button clicked to compleate entries "+String.valueOf(DaysOld)+" days old");
	}

}
