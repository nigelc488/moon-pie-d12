package g1.MoonPie;

import g1.MoonPie.Model.Edge;
import g1.MoonPie.clientServer.ClientLauncher;
import android.app.Activity;
import android.os.Bundle;

public class MoonPieActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        System.out.println("above try");
        try {
        	System.out.println("before client");
			ClientLauncher client = new ClientLauncher();
			System.out.println("after client");
		} catch (Exception e) {
			System.out.println("FAILED");
			e.printStackTrace();
		}
        System.out.println("below try");
        setContentView(R.layout.welcome);
        
    }
}