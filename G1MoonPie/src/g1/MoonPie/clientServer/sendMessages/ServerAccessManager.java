package g1.MoonPie.clientServer.sendMessages;

import android.app.Activity;
import android.widget.Toast;
import g1.MoonPie.clientServer.heineman.client.ServerAccess;

/**
 * This class is used to ensure that there is only one ServerAccess and that it can be called from anywhere in the program.
 * @author ncochran
 *
 */
public class ServerAccessManager {

	static ServerAccess access;
	static Activity activity;
	
	/**
	 * This method is used to set the ServerAccess and can only be used once.
	 * @param sa ServerAccess The object used to communicate with the server.
	 */
	public static void setAccess(ServerAccess sa){
		access = sa;
	}
	
	/**
	 * This method is used to get the ServerAccess so messages can be sent.
	 * @param sa ServerAccess The object used to communicate with the server.
	 */
	public static ServerAccess getAccess(){
		try{
		if(access == null)throw new Exception("Unable to Connect");
		else return access;
		}catch(Exception e){
			
			Toast.makeText(activity.getApplicationContext(), "Could not Connect to Server.", Toast.LENGTH_SHORT).show();
			activity.finish();
			return new ServerAccess("no host");
		}
	}
	
	/**
	 * Sets the activity to send toast messages to.
	 * @param active Activity The Activity currently being viewed
	 */
	public static void setActivity(Activity active){
		activity = active;
	}
	
}
