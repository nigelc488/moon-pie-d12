package g1.MoonPie;

import g1.MoonPie.Model.Edge;
import android.app.Activity;
import android.os.Bundle;

public class MoonPieActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        try {
			//ClientLauncher client = new ClientLauncher();
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
        setContentView(R.layout.welcome);
        
    }
}