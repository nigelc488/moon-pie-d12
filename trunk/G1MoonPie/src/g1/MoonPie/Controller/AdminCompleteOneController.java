package g1.MoonPie.Controller;

import g1.MoonPie.Model.Entries;
import g1.MoonPie.View.AdminView;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;

import java.util.ArrayList;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * The Class AdminCompleteOneController.
 * @author Catherine Coleman
 */
public class AdminCompleteOneController implements OnClickListener {
	
	/** The activity. */
	Activity activity;
	
	/** The entries. */
	Entries entries;
	
	/** The clicked. */
	ArrayList<Integer> clicked;
	
	/** The admin view. */
	AdminView av;
		
		public AdminCompleteOneController(Activity activity, Entries ent, ArrayList<Integer> clicked, AdminView av){
			this.entries = ent;
			this.activity = activity;
			this.clicked = clicked;
			this.av = av;

		}
		
		/* (non-Javadoc)
		 * @see android.view.View.OnClickListener#onClick(android.view.View)
		 */
		@Override
		public void onClick(View v) {
			SendMessageController smc = new SendMessageController();
			int size = clicked.size();
			for(int i=0; i< size; i++){
				smc.forceRequest(entries.getKey(), entries.getEntry(clicked.get(i)).getId(), 0);
			}
			av.clearArray();
			av.setTableValues();
			System.out.println("Complete Button clicked to compleate selected entries");
			System.out.println("Table reset");
			
		}
}
