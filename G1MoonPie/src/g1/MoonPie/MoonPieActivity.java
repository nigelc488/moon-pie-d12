package g1.MoonPie;

import g1.MoonPie.Controller.*;
import g1.MoonPie.Model.Edge;
import g1.MoonPie.View.NewEventView;
import g1.MoonPie.clientServer.ClientLauncher;
import g1.MoonPie.clientServer.ProcessThreadMessages;
import g1.MoonPie.clientServer.SendMessageController;
import g1.MoonPie.clientServer.ThreadActivity;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MoonPieActivity extends Activity {
	Thread communicationThread;
	SendMessageController send;
	ProcessThreadMessages processThread;
	
	/**
	 * I still need to figure out how and when to close the looper. processThread is the handler used to send messages between threads.
	 * Send should be used to send all of the messages. may need to find a way to change this.  Consider making it part of the Event.
	 * 
	 */
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        try{
        //System.out.println("try thread");
        	processThread = new ProcessThreadMessages();
        	communicationThread = new Thread(new ThreadActivity(processThread));
        	communicationThread.start();
        	
        }
        catch (Exception e){
        	//System.out.println("thread failed");
        	e.printStackTrace();
        }
        setContentView(R.layout.welcome);
        send = new SendMessageController();
        Button existingButton = (Button) findViewById(R.id.newButton);
        existingButton.setOnClickListener(new NewEventListener(this)); 
    }
}