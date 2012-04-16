package g1.MoonPie.Controller;

import g1.MoonPie.View.NewEventView;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

public class NewEventListener implements OnClickListener {

	Activity activity;
	
	public NewEventListener(Activity activity){
		this.activity = activity;
	}
	
	@Override
	public void onClick(View v) {
		NewEventView view = new NewEventView(activity);
		
	}

}






