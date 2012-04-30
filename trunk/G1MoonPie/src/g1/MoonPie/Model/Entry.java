package g1.MoonPie.Model;
/**
 * This class is used to store the entry information when an admin generates a report.
 * @author ncochran
 *
 */
public class Entry {
	String id;
	String type;
	String question;
	int numChoices;
	int numRounds;
	String created;
	boolean completed;
	
	/**
	 * This constructor creates a new entry with the desired attributes.
	 * @param id String The id of the event
	 * @param type String The type of event (open or closed)
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getNumChoices() {
		return numChoices;
	}

	public void setNumChoices(int numChoices) {
		this.numChoices = numChoices;
	}

	public int getNumRounds() {
		return numRounds;
	}

	public void setNumRounds(int numRounds) {
		this.numRounds = numRounds;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
	
}
