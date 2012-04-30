package g1.MoonPie.Controller;

import g1.MoonPie.Model.Entries;
import g1.MoonPie.View.AdminView;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TableRow;

public class AdminTableController implements OnClickListener {
	Activity activity;
	int id;
	AdminView av;
	
	public AdminTableController(Activity activity, int num, AdminView av){
		this.activity = activity;
		this.id = num;
		this.av = av;
	}
	
	@Override
	public void onClick(View arg0) {
		av.clicked(id);
		TableRow temprow = (TableRow) activity.findViewById(id);
		temprow.setBackgroundColor(3355444);
		
	}
}
