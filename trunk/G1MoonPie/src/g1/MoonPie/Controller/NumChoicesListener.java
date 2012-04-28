package g1.MoonPie.Controller;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

/**
 * This class is used as a listener for the drop down menu for the number of choices.
 * @author ncochran
 *
 */
public class NumChoicesListener implements OnItemSelectedListener {

	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {
		//Toast.makeText(parent.getContext(), "The choice is " + parent.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG).show();
	}

	@Override
	public void onNothingSelected(AdapterView parent) {
		// Do Nothing.
		
	}

}
