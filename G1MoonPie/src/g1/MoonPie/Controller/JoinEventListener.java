package g1.MoonPie.Controller;

import g1.MoonPie.Model.Event;
import g1.MoonPie.View.JoinEventView;
import g1.MoonPie.View.NewEventView;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * This class is used as a listener for the create join event button.
 * @author jpizz
 *
 */
public class JoinEventListener implements OnClickListener {

	Activity activity;
	
	public JoinEventListener(Activity activity){
		this.activity = activity;
	}
	
	@Override
	public void onClick(View v) {
		
	
		JoinEventView view = new JoinEventView(activity);
		
	}

}






