package g1.MoonPie.Controller;

import g1.MoonPie.Model.Entries;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TableRow;

public class AdminTableController implements OnClickListener {
	Activity activity;
	int id;
	
	public AdminTableController(Activity activity, int num){
		this.activity = activity;
		this.id = num;
	}
	
	@Override
	public void onClick(View arg0) {
		TableRow temprow = (TableRow) activity.findViewById(id);
		temprow.setBackgroundColor(3355444);
		
	}
}
