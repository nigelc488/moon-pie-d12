package g1.MoonPie.Model;

public class Entry {
	String id;
	String type;
	String question;
	int numChoices;
	int numRounds;
	String created;
	boolean completed;
	
	public Entry(String id, String type, int numChoices, int numRounds, String created, boolean completed){
		this.id = id;
		this.type = type;
		this.numChoices = numChoices;
		this.numRounds = numRounds;
		this.created = created;
		this.completed = completed;
	}
}
