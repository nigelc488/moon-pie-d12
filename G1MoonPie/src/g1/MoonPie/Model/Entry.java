package g1.MoonPie.Model;
// TODO: Auto-generated Javadoc
/**
 * This class is used to store the entry information when an admin generates a report.
 * @author ncochran
 *
 */
public class Entry {
	
	/** The id. */
	String id;
	
	/** The type. */
	String type;
	
	/** The question. */
	String question;
	
	/** The num choices. */
	int numChoices;
	
	/** The num rounds. */
	int numRounds;
	
	/** The created. */
	String created;
	
	/** The completed. */
	boolean completed;
	
	/**
	 * This constructor creates a new entry with the desired attributes.
	 *
	 * @param id String The id of the event
	 * @param type String The type of event (open or closed)
	 * @param question the question
	 * @param numChoices int The number of choices in the event
	 * @param numRounds int The number of rounds in the event
	 * @param created String The date when the event was created
	 * @param completed boolean If the event has been completed or not
	 */
	public Entry(String id, String type, String question, int numChoices, int numRounds, String created, boolean completed){
		this.id = id;
		this.type = type;
		this.numChoices = numChoices;
		this.numRounds = numRounds;
		this.created = created;
		this.completed = completed;
		this.question = question;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Gets the question.
	 *
	 * @return the question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Sets the question.
	 *
	 * @param question the new question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

	/**
	 * Gets the num choices.
	 *
	 * @return the num choices
	 */
	public int getNumChoices() {
		return numChoices;
	}

	/**
	 * Sets the num choices.
	 *
	 * @param numChoices the new num choices
	 */
	public void setNumChoices(int numChoices) {
		this.numChoices = numChoices;
	}

	/**
	 * Gets the num rounds.
	 *
	 * @return the num rounds
	 */
	public int getNumRounds() {
		return numRounds;
	}

	/**
	 * Sets the num rounds.
	 *
	 * @param numRounds the new num rounds
	 */
	public void setNumRounds(int numRounds) {
		this.numRounds = numRounds;
	}

	/**
	 * Gets the created.
	 *
	 * @return the created
	 */
	public String getCreated() {
		return created;
	}

	/**
	 * Sets the created.
	 *
	 * @param created the new created
	 */
	public void setCreated(String created) {
		this.created = created;
	}

	/**
	 * Checks if is completed.
	 *
	 * @return true, if is completed
	 */
	public boolean isCompleted() {
		return completed;
	}

	/**
	 * Sets the completed.
	 *
	 * @param completed the new completed
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
	
}
