import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//"../test.txt"
		FileParser fp = new FileParser(sc.next());
		Graph g = fp.getGraph();

//	      for (Vertex v : g.adjList.keySet()){
//		    	System.out.println(v);
//		    }
//	      System.out.println(g.edges.size());
		
		GraphApplet graphVisual = new GraphApplet();
		graphVisual.init(g);
		JFrame frame = new JFrame("MyPanel");
		frame.getContentPane().add(graphVisual);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		PageRank pr = new PageRank(g);
		pr.executePageRank(2000);
		
		Iterator<Entry<Vertex, Double>> itr = pr.scores.entrySet().stream().sorted(Entry.comparingByValue()).iterator();
		while (itr.hasNext()){
			System.out.println(itr.next());
		}
	}

}
