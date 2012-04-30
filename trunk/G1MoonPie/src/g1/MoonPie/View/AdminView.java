package g1.MoonPie.View;

import java.util.ArrayList;

import g1.MoonPie.R;
import g1.MoonPie.Controller.AdminDisplayController;
import g1.MoonPie.Controller.AdminRemoveController;
import g1.MoonPie.Controller.AdminRemoveOneController;
import g1.MoonPie.Controller.AdminTableController;
import g1.MoonPie.Controller.AdminViewTypeController;
import g1.MoonPie.Controller.NewEventMessageController;
import g1.MoonPie.Controller.NumChoicesListener;
import g1.MoonPie.Controller.NumRoundsListener;
import g1.MoonPie.Model.Entries;
import g1.MoonPie.Model.Entry;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class AdminView {
	Activity activity;
	TextView tv;
	String ty;
	Entries entries;
	ArrayList<Integer> clicked;
	TableRow[] row;
	
	public AdminView(Activity act, Entries ent, String ty) {
		this.entries = ent;
		this.activity = act;
		this.ty = ty;
		clicked = new ArrayList<Integer>();
//		activity.setContentView(R.layout.adminview);
		//activity.setContentView(R.layout.adminchoice);
	//	tv = (TextView) activity.findViewById(R.id.tvInfo);
	}
	
	public void setTableValues(){
		activity.setContentView(R.layout.adminview);
		TableLayout EntryData = (TableLayout) activity.findViewById(R.id.EntryTable);
	    
		EntryData.setStretchAllColumns(true);  
		EntryData.setShrinkAllColumns(true);  
		
		int size = entries.getsize();
		row = new TableRow [size];
		TextView[] eID = new TextView [size];
		TextView[] type = new TextView [size];
		TextView[] numChoices = new TextView [size];
		TextView[] numRounds = new TextView [size];
		TextView[] Date = new TextView [size];
		for(int i =0; i < size; i++){
			row[i]= new TableRow(activity);
			eID[i] = new TextView(activity);
			eID[i].setText(entries.getEntry(i).getId());
			row[i].addView(eID[i]);
			type[i] = new TextView(activity);
			type[i].setText(entries.getEntry(i).getType());
			row[i].addView(type[i]);
			numChoices[i] = new TextView(activity);
			numChoices[i].setText(entries.getEntry(i).getNumChoices());
			row[i].addView(numChoices[i]);
			numRounds[i] = new TextView(activity);
			numRounds[i].setText(entries.getEntry(i).getNumRounds());
			row[i].addView(numRounds[i]);
			Date[i] = new TextView(activity);
			Date[i].setText(entries.getEntry(i).getCreated());
			row[i].addView(Date[i]);
			row[i].setId(i);
			row[i].setOnClickListener(new AdminTableController(activity,i, this));
			EntryData.addView(row[i]);
		}
		
		Button bRemove = (Button) activity.findViewById(R.id.bRemove);
		bRemove.setOnClickListener(new AdminRemoveOneController(activity,entries,clicked));
		Button bComplete = (Button) activity.findViewById(R.id.bComplete);
		
		if(ty == "open"){
			bComplete.setVisibility(0);
			bComplete.setOnClickListener(new AdminRemoveOneController(activity,entries, clicked));
		}else{
			bComplete.setVisibility(1);
		}
		
		
	}
	
	public void clicked(int Id){
		clicked.add(Id);
	}

}
