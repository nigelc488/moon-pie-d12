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

// TODO: Auto-generated Javadoc
/**
 * The Class AdminDisplayController.
 */
public class AdminDisplayController implements OnClickListener{
	
	/** The Uncompleated Radio Button. */
	RadioButton UnComp;
	
	/** The Compleated Radio button. */
	RadioButton Comp;
	
	/** The activity. */
	Activity activity;
	
	/** The entries. */
	Entries entries;
	
	/** The type. */
	String type;
	
	/**
	 * Instantiates a new admin display controller.
	 *
	 * @param activity the activity
	 * @param entries the entries
	 */
	public AdminDisplayController(Activity activity, Entries entries){
		this.activity = activity;
		this.entries =entries;
		
	}
	
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		RadioGroup EventType = (RadioGroup) activity.findViewById(R.id.EventType);
		int checkedRadioButton = EventType.getCheckedRadioButtonId();
		if (checkedRadioButton == R.id.UncompletedEvent){
			type = "open";
			entries.setType(true);
		}
		else{
			type = "closed";
			entries.setType(false);
		}
	
		
		AdminView av = new AdminView(activity, entries, type);
		av.setTableValues();
		
	}
	
}
