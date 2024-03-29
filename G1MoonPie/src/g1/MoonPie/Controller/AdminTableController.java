package g1.MoonPie.Controller;

import g1.MoonPie.View.AdminView;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * The Class AdminTableController.
 * @author Catherine Coleman
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
		System.out.println("row"+String.valueOf(id)+ " has ben clicked");
//		av.changeColor(id);

	}
}
