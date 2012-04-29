package g1.MoonPie.View;

import g1.MoonPie.R;
import g1.MoonPie.Controller.AdminDisplayController;
import g1.MoonPie.Controller.AdminRemoveController;
import g1.MoonPie.Controller.AdminViewTypeController;
import g1.MoonPie.Controller.NewEventMessageController;
import g1.MoonPie.Controller.NumChoicesListener;
import g1.MoonPie.Controller.NumRoundsListener;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class AdminChoicesView extends Activity {
	
	Activity activity; 
	
	public AdminChoicesView (Activity activity){
		
		this.activity = activity;
		Button DisplayButton;
		Button RemoveButton;
		RadioButton UnComp;
		RadioButton Comp;
		
		activity.setContentView(R.layout.adminchoice);
	    
		DisplayButton = (Button) activity.findViewById(R.id.DisplayButton);
	    DisplayButton.setOnClickListener(new AdminDisplayController(activity));
	    
	    RemoveButton = (Button) activity.findViewById(R.id.RemoveButton);
	    RemoveButton.setOnClickListener(new AdminRemoveController(activity));
	    
	    UnComp = (RadioButton) activity.findViewById(R.id.UncompletedEvent);
	    UnComp.setOnClickListener(new AdminViewTypeController(activity, 1));
	    
	    Comp = (RadioButton) activity.findViewById(R.id.CompletedEvent);
	    Comp.setOnClickListener(new AdminViewTypeController(activity, 2));
	    
	}


}
