package g1.MoonPie.clientServer.receiveMessages;


import android.os.Handler;
import android.os.Message;

import g1.MoonPie.clientServer.heineman.client.*;
import g1.MoonPie.clientServer.heineman.xml.*;


/**
 * This class is really only a go-between.  It is called in the communications thread and simply forwards the message to the main thread for processing.
 * @author ncochran
 *
 */
public class MoonPieClientMessageHandler implements IMessageHandler {
	Handler childHandler;
	
	/**
	 * This method is used to create a new MoonPieClientMessageHandler with the Handler used to communicate to the parent thread.
	 * @param handler Handler The handler used to send messages to the parent thread.
	 */
	public MoonPieClientMessageHandler(Handler handler){
		childHandler = handler;
	}

	@Override
	public void process(MessageXML response) {
		Message msg = Message.obtain();
		msg.obj = response;
		childHandler.sendMessage(msg);
		
		//boolean worked = childHandler.sendMessage(msg);
		//System.out.println("Was the thread message sent?: " + worked);
		//System.out.println("Received in child thread:" + response);
		
	}

}
