package g1.MoonPie.clientServer.sendMessages;

import g1.MoonPie.clientServer.client.ServerAccess;

public class ServerAccessManager {

	static ServerAccess access;
	
	public static void setAccess(ServerAccess sa){
		access = sa;
	}
	
	public static ServerAccess getAccess(){
		return access;
	}
	
}
