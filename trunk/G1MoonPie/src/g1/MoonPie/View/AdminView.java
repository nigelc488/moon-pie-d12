package g1.MoonPie.View;

import java.util.ArrayList;

import g1.MoonPie.R;
import g1.MoonPie.Controller.AdminBackController;
import g1.MoonPie.Controller.AdminCompleteOneController;
import g1.MoonPie.Controller.AdminDisplayController;
import g1.MoonPie.Controller.AdminRemoveController;
import g1.MoonPie.Controller.AdminRemoveOneController;
import g1.MoonPie.Controller.AdminTableController;
import g1.MoonPie.Controller.AdminViewTypeController;
import g1.MoonPie.Controller.NewEventMessageController;
import g1.MoonPie.Model.Entries;
import g1.MoonPie.Model.Entry;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

/**
 * The Class AdminView.
 * @author Catherine Coleman
 */
public class AdminView {
	
	/** The activity. */
	Activity activity;
	
	/** The Textview. */
	TextView tv;
	
	/** The type. */
	String ty;
	
	/** The entries. */
	Entries entries;
	
	/** The ID's of clicked rows. */
	ArrayList<Integer> clicked;
	
	/** The rows in the tables. */
	TableRow[] row;
	
	/**
	 * Instantiates a new admin view.
	 *
	 * @param act the activity
	 * @param ent the entries
	 * @param ty the type
	 */
	public AdminView(Activity act, Entries ent, String ty) {
		this.entries = ent;
		this.activity = act;
		this.ty = ty;
		clicked = new ArrayList<Integer>();
//		activity.setContentView(R.layout.adminview);
		//activity.setContentView(R.layout.adminchoice);
	//	tv = (TextView) activity.findViewById(R.id.tvInfo);
	}
	
	/**
	 * Creates the Table and fills it with information. it also add the action liseners
	 */
	public void setTableValues(){
		activity.setContentView(R.layout.adminview);
		TableLayout EntryData = (TableLayout) activity.findViewById(R.id.EntryTable);
	    
		EntryData.setStretchAllColumns(true);  
		EntryData.setShrinkAllColumns(true);  
		
		EntryData.removeAllViews();

		int size = entries.getsize();
		TableRow rowtitle = new TableRow(activity);
		TextView eventID = new TextView(activity);
		eventID.setText("Event ID");
		rowtitle.addView(eventID);
		
		TextView typeV = new TextView(activity);
		typeV.setText("Type");
		rowtitle.addView(typeV);
		
		TextView NC = new TextView(activity);
		NC.setText("NumChoices");
		rowtitle.addView(NC);
		
		TextView NR = new TextView(activity);
		NR.setText("NumRounds");
		rowtitle.addView(NR);
		
		TextView dates = new TextView(activity);
		dates.setText("Date");
		rowtitle.addView(dates);
		
		EntryData.addView(rowtitle);
		if(size != 0){
		row = new TableRow [size];
		TextView[] eID = new TextView [size];
		TextView[] type = new TextView [size];
		TextView[] numChoices = new TextView [size];
		TextView[] numRounds = new TextView [size];
		TextView[] Date = new TextView [size];
		for(int i = 0; i < size; i++){
			row[i]= new TableRow(activity);
			eID[i] = new TextView(activity);
			eID[i].setText(entries.getEntry(i).getId());
			row[i].addView(eID[i]);
			type[i] = new TextView(activity);
			type[i].setText(entries.getEntry(i).getType());
			row[i].addView(type[i]);
			numChoices[i] = new TextView(activity);
			numChoices[i].setText(String.valueOf(entries.getEntry(i).getNumChoices()));
			row[i].addView(numChoices[i]);
			numRounds[i] = new TextView(activity);
			numRounds[i].setText(String.valueOf(entries.getEntry(i).getNumRounds()));
			row[i].addView(numRounds[i]);
			Date[i] = new TextView(activity);
			Date[i].setText(entries.getEntry(i).getCreated());
			row[i].addView(Date[i]);
			row[i].setId(i);
			row[i].setOnClickListener(new AdminTableController(activity,i, this));
			if(clicked.contains(i)){
				row[i].setBackgroundColor(0xff363636);
			}
			EntryData.addView(row[i]);
			
		}
		}
		
		Button bRemove = (Button) activity.findViewById(R.id.bRemove);
		bRemove.setOnClickListener(new AdminRemoveOneController(activity,entries,clicked,this,ty));
		Button bComplete = (Button) activity.findViewById(R.id.bComplete);
		Button bBack = (Button) activity.findViewById(R.id.bBack);
		bBack.setOnClickListener(new AdminBackController(activity,entries));
		
		if(ty == "open"){
			bComplete.setVisibility(0);
			bComplete.setOnClickListener(new AdminCompleteOneController(activity,entries, clicked, this));
		}else{
			bComplete.setVisibility(1);
		}
		
		
	}
	
	/**
	 * Clicked.
	 *
	 * @param Id the id
	 */
	public void clicked(int Id){
		if(!clicked.contains(Id)){
			clicked.add(Id);
		}else
			clicked.remove(Id);
	}
	
//	public void changeColor(int Id){
//		row[Id].setBackgroundColor(0xff363636);
//	}
	
/**
 * Clear array.
 */
public void clearArray(){
		int size = clicked.size();
		for(int i=size; i > 0;i--){
			entries.removeEntry(entries.getEntry(i - 1));
		}
		clicked.clear();
	}

}
