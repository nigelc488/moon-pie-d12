package g1.MoonPie;

import g1.MoonPie.Controller.*;
import g1.MoonPie.Model.Entries;
import g1.MoonPie.Model.Event;
import g1.MoonPie.Model.Global;
import g1.MoonPie.clientServer.receiveMessages.ProcessThreadMessages;
import g1.MoonPie.clientServer.receiveMessages.ThreadActivity;
import g1.MoonPie.clientServer.sendMessages.SendMessageController;
import g1.MoonPie.clientServer.sendMessages.ServerAccessManager;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/**
 * This is the main function for the applicaiton.
 * It creates a new event, the child thread used for communicating with the server, the classes to perform communication, and launches the welcome screen.
 * @author ncochran
 *
 */
public class MoonPieActivity extends Activity {
	Thread communicationThread;
	SendMessageController send;
	ProcessThreadMessages processThread;
	Event event;
	Entries entries;
	
	/**
	 * I still need to figure out how and when to close the looper. processThread is the handler used to send messages between threads.
	 * Send should be used to send all of the messages. may need to find a way to change this.  Consider making it part of the Event.
	 * 
	 */
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        entries = new Entries();
        
        //only run if want client server
        if (!Global.getSTANDALONE()){
        	ServerAccessManager.setActivity(this);
        	try{
        		//System.out.println("try thread");
        		processThread = new ProcessThreadMessages(this, entries);
        		communicationThread = new Thread(new ThreadActivity(processThread));
        		communicationThread.start();

        	}
        	catch (Exception e){
        		e.printStackTrace();
        	}
        }
        else{
        	processThread = new ProcessThreadMessages(this, entries);
        	ProcessThreadMessages.setActivity(this);
        }
        
        setContentView(R.layout.welcome);
        Button newEventButton = (Button) findViewById(R.id.newButton);
        newEventButton.setOnClickListener(new NewEventListener(this , event));
        
        //can be used with welcome_old.xml
       // Button joinEventButton = (Button) findViewById(R.id.joinButton);  
        //joinEventButton.setOnClickListener(new JoinEventListener(this)); 
       
    }
    
    
}