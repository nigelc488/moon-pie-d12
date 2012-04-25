package g1.MoonPie.clientServer.sendMessages;

import g1.MoonPie.clientServer.client.ServerAccess;

/**
 * This class is used to ensure that there is only one ServerAccess and that it can be called from anywhere in the program.
 * @author ncochran
 *
 */
public class ServerAccessManager {

	static ServerAccess access;
	
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
		return access;
	}
	
}
