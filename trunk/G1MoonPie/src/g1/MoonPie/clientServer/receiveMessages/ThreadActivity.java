package g1.MoonPie.clientServer.receiveMessages;

import g1.MoonPie.clientServer.heineman.client.ClientLauncher;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/**
 * The thread used for communication with the server.  Used so the communications are received in a separate thread and then passed to the main thread.
 * Constructor has a handler simply to pass it to the client launcher which then passes it to protocol handler.
 * @author ncochran
 *
 */
public class ThreadActivity implements Runnable{
	
	//Thread communicationThread;
	Handler handler;
	
	/**
	 * This method is used to create a new ThreadActivity using the handler it will use to send messages to the parent thread.
	 * @param handler Handler The handler used to send messages
	 */
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
			Message msg = Message.obtain();
			msg.obj = new String("Connection Failed");
			boolean worked = handler.sendMessage(msg);
			System.out.println("sent failure message? " + worked);
			e.printStackTrace();
			System.out.println("Connection Failed in thread");
		}
		//System.out.println("begin looper");
		Looper.loop();
		
		
	}
}


	



