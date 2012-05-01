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

// TODO: Auto-generated Javadoc
/**
 * The Class AdminRemoveController.
 * @author catherinec
 */
public class AdminRemoveController implements OnClickListener {

/** The activity. */
Activity activity;

/** The entries. */
Entries entries;

/** The s. */
String s;

/** The key. */
String key;
	
	/**
	 * Instantiates a new admin remove controller.
	 *
	 * @param activity the activity
	 * @param ent the ent
	 * @param k the k
	 */
	public AdminRemoveController(Activity activity, Entries ent, String k){
		this.entries = ent;
		this.activity = activity;
		this.s = "hello";
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
		RadioGroup EventType = (RadioGroup) activity.findViewById(R.id.EventType);
		int checkedRadioButton = EventType.getCheckedRadioButtonId();
		if (checkedRadioButton == R.id.UncompletedEvent){
			smc.removeRequest(key, "", false, DaysOld);
			System.out.println("Remove Button clicked to remove uncompleted entries "+String.valueOf(DaysOld)+" days old");
		}else if(checkedRadioButton == R.id.CompletedEvent){
			smc.removeRequest(key, "", true, DaysOld);
			System.out.println("Remove Button clicked to remove completed entries "+String.valueOf(DaysOld)+" days old");
		}
		
	}
}
