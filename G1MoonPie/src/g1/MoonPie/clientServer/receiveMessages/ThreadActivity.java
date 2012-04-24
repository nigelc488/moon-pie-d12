package g1.MoonPie.clientServer.receiveMessages;

import g1.MoonPie.clientServer.client.ClientLauncher;
import android.os.Handler;
import android.os.Looper;

/**
 * The thread used for communication with the server.  Needed because android didn't allow doing the communication in the main thread.  
 * Constructor has a handler simply to pass it to the clien launcher which then passes it to protocol handler.
 * Need to find way to stop looper.
 * @author ncochran
 *
 */
public class ThreadActivity implements Runnable{
	
	//Thread communicationThread;
	Handler handler;
	
	public ThreadActivity(Handler handler){
		this.handler = handler;
	}
	
	
	@Override
	public void run() {
		//System.out.println("inside thread");
		//new AddChoiceResponseController();
		Looper.prepare();
		try {
        	//System.out.println("try connect");
			ClientLauncher client = new ClientLauncher(handler);
			//System.out.println("Connected");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Connection Failed");
		}
		Looper.loop();
		
		
	}
}


	



