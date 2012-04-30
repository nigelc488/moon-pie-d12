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

public class AdminRemoveOneController implements OnClickListener {

Activity activity;
Entries entries;
ArrayList<Integer> clicked;
AdminView av;
	
	public AdminRemoveOneController(Activity activity, Entries ent, ArrayList<Integer> clicked, AdminView av){
		this.entries = ent;
		this.activity = activity;
		this.clicked = clicked;
		this.av = av;

	}
	
	@Override
	public void onClick(View v) {
		SendMessageController smc = new SendMessageController();
		int size = clicked.size();
		for(int i=0; i< size; i++){
			smc.removeRequest(entries.getKey(), entries.getEntry(clicked.get(i)).getId(), false, 0);
		}
		av.clearArray();
		av.setTableValues();
	}
}