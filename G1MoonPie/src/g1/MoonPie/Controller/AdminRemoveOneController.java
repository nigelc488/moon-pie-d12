package g1.MoonPie.Controller;

import java.util.ArrayList;

import g1.MoonPie.R;
import g1.MoonPie.Model.Entries;
import g1.MoonPie.Model.Entry;
import g1.MoonPie.View.AdminView;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioGroup;

// TODO: Auto-generated Javadoc
/**
 * The Class AdminRemoveOneController.
 * @author catherinec
 */
public class AdminRemoveOneController implements OnClickListener {

/** The activity. */
Activity activity;

/** The entries. */
Entries entries;

/** The clicked. */
ArrayList<Integer> clicked;

/** The Admin view. */
AdminView av;

/** The type. */
String type;
	
	/**
	 * Instantiates a new admin remove one controller.
	 *
	 * @param activity the activity
	 * @param ent the entries
	 * @param clicked the clicked
	 * @param av the admin veiw
	 * @param ty the type
	 */
	public AdminRemoveOneController(Activity activity, Entries ent, ArrayList<Integer> clicked, AdminView av, String ty){
		this.entries = ent;
		this.activity = activity;
		this.clicked = clicked;
		this.av = av;
		this.type = ty;

	}
	
	/* (non-Javadoc)
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		SendMessageController smc = new SendMessageController();
		int size = clicked.size();
		if(type == "open"){
			for(int i=0; i< size; i++){
				smc.removeRequest(entries.getKey(), entries.getEntry(clicked.get(i)).getId(), false, 0);
			}
		}else{
			for(int i=0; i< size; i++){
				smc.removeRequest(entries.getKey(), entries.getEntry(clicked.get(i)).getId(), true, 0);
			}
		}
		
		System.out.println("Remove Button clicked to compleate selected entries");
		System.out.println("Table reset");
		
		av.clearArray();
		av.setTableValues();
	}
}