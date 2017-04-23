import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {
	
	Graph g;

	public FileParser(String filename){
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			g = new Graph();
		    String line;
		    while ((line = br.readLine()) != null) {
		       String[] parts =line.split(" ");
		       if (parts.length == 3){
		    	   String deck1 = parts[0];
			       String deck2 = parts[1];
			       double winRate = Double.parseDouble(parts[2]);
			       System.out.println(deck1 + " beats " + deck2 + " with " + winRate);
		       }
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
