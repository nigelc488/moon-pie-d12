package g1.MoonPie.Controller;

import g1.MoonPie.Model.Entries;
import g1.MoonPie.View.AdminChoicesView;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminBackController.
 * @author catherinec
 */
public class AdminBackController implements OnClickListener {
	
	/** The activity. */
	Activity activity;
	
	/** The entries. */
	Entries entries;
	
	/**
	 * Instantiates a new admin back controller that respons to the back button.
	 *
	 * @param activity the activity
	 * @param entries the entries
	 */
	public AdminBackController(Activity activity, Entries entries){
		this.activity= activity;
		this.entries = entries;
	}
	
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		AdminChoicesView acv = new AdminChoicesView(activity, entries.getKey());
	}

}
