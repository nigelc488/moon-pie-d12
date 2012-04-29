package g1.MoonPie.Model;

import java.util.ArrayList;

public class Entries {
	private ArrayList<Entry> entries;
	String key;
	
	public Entries(){
	}

	public ArrayList<Entry> getEntires(){
		return entries;
	}
	
	public void setEntires(ArrayList<Entry> ent){
		entries = ent;
	}
	
	public int getsize(){
		return entries.size();
	}
	
	public void setKey(String k){
		key = k;
	}
	
	public String getDate(int num){
		Entry temp = entries.get(num);
		return temp.created;
		
	}
	
	public Entry getEntry(int num){
		return entries.get(num);
	}
	
	public String getKey(){
		return key;
	}


}
