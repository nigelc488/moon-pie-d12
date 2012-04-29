package g1.MoonPie.Controller;

import g1.MoonPie.R;

import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class AdminRemoveController implements OnClickListener {

Activity activity;
	
	public AdminRemoveController(Activity activity){
		this.activity = activity;
	}
	
	@Override
	public void onClick(View v) {
		EditText days = (EditText) activity.findViewById(R.id.EditDaysText);
		int Num = Integer.parseInt(days.getText().toString());
		Calendar cal = Calendar.getInstance();
		cal.add(cal.DATE, -Num);
		
		
	}
}
