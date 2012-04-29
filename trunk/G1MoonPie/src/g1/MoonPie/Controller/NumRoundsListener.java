package g1.MoonPie.Controller;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

/**
 * This class is used as a listener for the drop down menu for the number of rounds.
 * @author ncochran
 * @author jpizz
 *
 */
public class NumRoundsListener implements OnItemSelectedListener {

	
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
		//value = Integer.parseInt(parent.getItemAtPosition(pos).toString());
		//Toast.makeText(parent.getContext(), "The rounds is " + value, Toast.LENGTH_LONG).show();
		//Toast.makeText(parent.getContext(), "The number of rounds is " + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onNothingSelected(AdapterView parent) {
		// Do Nothing.
		
	}
}
