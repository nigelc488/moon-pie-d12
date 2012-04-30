package g1.MoonPie.Model;

import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Entries.
 */
public class Entries {
	
	/** The entries. */
	private ArrayList<Entry> entries;
	
	/** The key. */
	String key;
	
	/** The type. */
	boolean type;
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public boolean getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(boolean type) {
		this.type = type;
	}

	/**
	 * Instantiates a new entries.
	 */
	public Entries(){
	}

	/**
	 * Gets the entires.
	 *
	 * @return the entires
	 */
	public ArrayList<Entry> getEntires(){
		return entries;
	}
	
	/**
	 * Sets the entires.
	 *
	 * @param ent the new entires
	 */
	public void setEntires(ArrayList<Entry> ent){
		entries = ent;
	}
	
	/**
	 * Gets the size.
	 *
	 * @return the size
	 */
	public int getsize(){
		return entries.size();
	}
	
	/**
	 * Sets the key.
	 *
	 * @param k the new key
	 */
	public void setKey(String k){
		key = k;
	}
	
	/**
	 * Gets the date.
	 *
	 * @param num the num
	 * @return the date
	 */
	public String getDate(int num){
		Entry temp = entries.get(num);
		return temp.created;
		
	}
	
	/**
	 * Gets the entry.
	 *
	 * @param num the num
	 * @return the entry
	 */
	public Entry getEntry(int num){
		return entries.get(num);
	}
	
	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public String getKey(){
		return key;
	}


}
