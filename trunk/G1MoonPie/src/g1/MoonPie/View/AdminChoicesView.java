package g1.MoonPie.View;

import g1.MoonPie.R;
import g1.MoonPie.Controller.AdminDisplayController;
import g1.MoonPie.Controller.AdminRemoveController;
import g1.MoonPie.Controller.AdminViewTypeController;
import g1.MoonPie.Controller.NewEventMessageController;
import g1.MoonPie.Controller.NumChoicesListener;
import g1.MoonPie.Controller.NumRoundsListener;
import g1.MoonPie.Model.Entries;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class AdminChoicesView extends Activity {
	
	Activity activity; 
	String key;
	
	public AdminChoicesView (Activity activity, String k){
		this.activity = activity;
		this.key = k;
		
		activity.setContentView(R.layout.adminchoice);
	  
	    RadioGroup EventType = (RadioGroup) activity.findViewById(R.id.EventType);
	    EventType.setOnClickListener(new AdminViewTypeController(activity, key));
	    
	}


}
