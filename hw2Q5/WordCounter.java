import java.io.*;
import java.util.*;
public class WordCounter {
	public static void main (String[] args) throws IOException {
	    String file = "inputs.txt";
	    BufferedReader reader = new BufferedReader(new FileReader(file));
	    String[] target = {"hackathon", "Dec", "Chicago", "Java"};
	    String line = reader.readLine();
	    HashMap<String, Integer> map = new HashMap<>();
	    //init
	    for (int i = 0; i < target.length; i++) {
	    	map.put(target[i], 0);
	    }
		while (line != null){
			String[] strs = line.split("[^a-zA-Z]");
			for (String t : target){
				for (String str: strs){
				    if (str.toLowerCase().equals(t.toLowerCase())) {
				    	map.put(t, map.getOrDefault(t, 0)+1);
						break;
				    }
				}
			}
			line = reader.readLine();
	    }
		//output
		for(HashMap.Entry<String, Integer> entry: map.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	    reader.close();
	}
}
