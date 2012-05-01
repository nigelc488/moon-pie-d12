package g1.MoonPie.Model;


/**
 * This class represents a User for a DecisionLines event, containing
 * a username, optional password, and number of edges remaining to add.
 * 
 * @author Eric Cobane
 * @author jpizz
 *
 */
public class User {

	/**The User's username.*/
	String username;
	/**The User's password(optional).*/
	String password;
	/**Integer representing order in which the user joined the event*/
	int position;
	

	/**
	 * Construct for a User, which contains a username, an optional password
	 * and the number of remaining edges for the user to add.
	 * 
	 * @param name		The username for the User
	 * @param pw		The User's password (optional) 
	 * @param position	The order in which the user joined the event	
	 */
	public User(String name, String pw, int position){
		this.username = name;
		this.password = pw;
		this.position = position;
	}
	
	/**
	 * Construct for a User, which contains a username, an optional password
	 * and the number of remaining edges for the user to add.
	 * 
	 * @param name		The username for the User
	 * @param pw		The User's password (optional) 
	 * @param remainingEdges	The number of edges the User has left to add.	
	 */
	public User(String name, String pw){
		this.username = name;
		this.password = pw;
	}

	/**
	 * Set the user's username
	 * 
	 * @param username String containing the user's username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Get the user's username
	 * 
	 * @return String containing the user's username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * Set the user's optional password
	 * 
	 * @param password String containing the user's password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Get the user's optional password
	 * 
	 * @return String containing the user's password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the user's position in the event
	 * 
	 * @param postion Integer representing order in which the user joined the event
	 */
	public void setPostion(int postion) {
		this.position = postion;
	}
	
	/**
	 * Get the user's position in the event
	 * 
	 * @return Integer representing order in which the user joined the event
	 */
	public int getPostion() {
		return position;
	}



}
