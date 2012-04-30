package g1.MoonPie.Controller;

import g1.MoonPie.Model.Entries;
import g1.MoonPie.View.AdminView;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TableRow;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminTableController.
 */
public class AdminTableController implements OnClickListener {
	
	/** The activity. */
	Activity activity;
	
	/** The id. */
	int id;
	
	/** The av. */
	AdminView av;
	
	/**
	 * Instantiates a new admin table controller.
	 *
	 * @param activity the activity
	 * @param num the num
	 * @param av the av
	 */
	public AdminTableController(Activity activity, int num, AdminView av){
		this.activity = activity;
		this.id = num;
		this.av = av;
	}
	
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View arg0) {
		av.clicked(id);
		//TableRow temprow = (TableRow) activity.findViewById(id);
		//temprow.setBackgroundColor(3355444);
		av.setTableValues();
//		av.changeColor(id);

	}
}
