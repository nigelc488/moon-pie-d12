package g1.MoonPie.Model;


/**This class represents a User for a DecisionLines event, containing
 * a username, optional password, and number of edges remaining to add.
 * 
 * @author Eric Cobane
 *
 */
public class User {

	/**The User's username.*/
	String username;
	/**The User's password(optional).*/
	String password;
	/**The number of edges the User has lft to ad.*/
	int remaingEdges;


	/**Construct for a User, which contains a username, an optional password
	 * and the number of remaining edges for the user to add.
	 * 
	 * @param name		The username for the User
	 * @param pw		The User's password (optional) 
	 * @param remainingEdges	The number of edges the User has left to add.	
	 */
	public User(String name, String pw, int remainingEdges){

		this.username = name;
		this.password = pw;
		this.remaingEdges = remainingEdges;
	}

	/**Checks to make sure the password entered by the User matches the 
	 * password stored in the system for that user.
	 * 
	 * @param pw	The password entered by the User.
	 * @return		True if the password is correct, else false.	
	 */
	private boolean validatePassword(String pw){	//Made this private because its for a password, is that ok?

		if(!pw.equals(this.password)){
			return false;
		}
		else return true;
	}

}
