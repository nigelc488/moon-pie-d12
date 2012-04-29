package g1.MoonPie.View;

import java.util.ArrayList;

import g1.MoonPie.R;
import g1.MoonPie.Controller.AdminDisplayController;
import g1.MoonPie.Controller.AdminRemoveController;
import g1.MoonPie.Controller.AdminViewTypeController;
import g1.MoonPie.Controller.NewEventMessageController;
import g1.MoonPie.Controller.NumChoicesListener;
import g1.MoonPie.Controller.NumRoundsListener;
import g1.MoonPie.Model.Entry;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class AdminView {
	Activity activity;
	TextView tv;
	
	ArrayList<Entry> entries;
	
	public AdminView(Activity act) {
		this.activity = act;
		
//		activity.setContentView(R.layout.adminview);
		activity.setContentView(R.layout.adminchoice);
	//	tv = (TextView) activity.findViewById(R.id.tvInfo);
	}
	
	public void setTableValues(ArrayList<Entry> En){
		this.entries = En;
	}

}
