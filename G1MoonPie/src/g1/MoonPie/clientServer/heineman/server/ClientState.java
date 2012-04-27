package g1.MoonPie.clientServer.heineman.server;

//import xml.Message;
import g1.MoonPie.clientServer.heineman.xml.*;


/** Server-side interface to per-client state. Exposes only the methods of ServerThread that are safe. */
public interface ClientState {
	
	/** 
	 * Send the given message to the client on whose behalf this thread is executing and return true
	 * on success, false on error. 
	 */
	boolean sendMessage (MessageXML m);
	
	/**
	 * Associate new object data as the user-defined data for the thread and return the old previous value.
	 */
	public Object setData(Object newData);
	
	/**
	 * Retrieve user-defined data associated with this thread.
	 */
	public Object getData();
	
	/**
	 * Retrieve our unique id.
	 */
	public String id();
	
}