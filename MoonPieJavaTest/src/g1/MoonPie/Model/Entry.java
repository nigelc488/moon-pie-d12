package g1.MoonPie.Model;

public class Entry {
	String id;
	String type;
	String question;
	int numChoices;
	int numRounds;
	String created;
	boolean completed;
	
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

	public String getType() {
		return type;
	}

	public String getQuestion() {
		return question;
	}

	public int getNumChoices() {
		return numChoices;
	}

	public int getNumRounds() {
		return numRounds;
	}

	public String getCreated() {
		return created;
	}

	public boolean isCompleted() {
		return completed;
	}
	
	
}
