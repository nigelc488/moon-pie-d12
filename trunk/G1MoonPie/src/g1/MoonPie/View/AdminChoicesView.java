package g1.MoonPie.View;

import g1.MoonPie.R;
import g1.MoonPie.Controller.AdminDisplayController;
import g1.MoonPie.Controller.AdminRemoveController;
import g1.MoonPie.Controller.AdminViewTypeController;
import g1.MoonPie.Controller.NewEventMessageController;
import g1.MoonPie.Model.Entries;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminChoicesView.
 * @author Catherine Coleman
 */
public class AdminChoicesView extends Activity {
	
	/** The activity. */
	Activity activity; 
	
	/** The key. */
	String key;
	
	/**
	 * Instantiates a new admin choices view.
	 *
	 * @param activity the activity
	 * @param k the admin key
	 */
	public AdminChoicesView (Activity activity, String k){
		this.activity = activity;
		this.key = k;
		
		activity.setContentView(R.layout.adminchoice);
	  
	    //RadioGroup EventType = (RadioGroup) activity.findViewById(R.id.EntryTable);
	    //EventType.setOnClickListener(new AdminViewTypeController(activity, key));
		
		RadioButton rbCompleted = (RadioButton) activity.findViewById(R.id.CompletedEvent);
		rbCompleted.setOnClickListener(new AdminViewTypeController(activity, key));
		
		RadioButton rbUncompleted = (RadioButton) activity.findViewById(R.id.UncompletedEvent);
		rbUncompleted.setOnClickListener(new AdminViewTypeController(activity, key));
		
		
		
	    
	}


}
