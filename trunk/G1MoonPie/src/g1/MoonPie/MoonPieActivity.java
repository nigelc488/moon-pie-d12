package g1.MoonPie;

import g1.MoonPie.Controller.*;
import g1.MoonPie.Model.Edge;
import g1.MoonPie.View.NewEventView;
import g1.MoonPie.clientServer.ClientLauncher;
import g1.MoonPie.clientServer.ThreadActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MoonPieActivity extends Activity {
	Thread communicationThread;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        try{
        //System.out.println("try thread");
        	communicationThread = new Thread(new ThreadActivity());
        	communicationThread.start();
        	
        }
        catch (Exception e){
        	//System.out.println("thread failed");
        	e.printStackTrace();
        }
        //System.out.println("after thread");
        
        /*try {
        	System.out.println("try connect");
			ClientLauncher client = new ClientLauncher();
			System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
        setContentView(R.layout.welcome);
        
        Button existingButton = (Button) findViewById(R.id.newButton);
        existingButton.setOnClickListener(new NewEventListener(this)); 
    }
}