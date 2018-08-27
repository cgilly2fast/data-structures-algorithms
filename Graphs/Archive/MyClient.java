import java.io.*;     // for File, FileNotFoundException
import java.util.*;

public class MyClient {
	
	public final static String VERTEX_FILE = "my_vertices.txt";
	public final static String EDGE_FILE = "my_edges.txt";
	public static MyGraph graph;
	
	public static void main(String[] args) throws FileNotFoundException {
		
        List<String> vLines = readLines(VERTEX_FILE);
        List<String> eLines = readLines(EDGE_FILE);
        
        Set<Vertex> vSet = new HashSet<Vertex>();
        Set<Edge> eSet = new HashSet<Edge>();
        
        for(String v : vLines ) {
        	vSet.add(new Vertex( v ));
        }
        
        for(String line : eLines) {
            // split non-terminal form terminals
        	String[] terminals = line.trim().split("[|]"); 
            Vertex v1 = new Vertex( terminals[ 0 ] );
            // split each terminal up into individual terminals
            Vertex v2 = new Vertex( terminals[ 1 ] );
            Edge e  = new Edge( v1, v2, Integer.parseInt( terminals[ 2 ] ) );
            eSet.add( e );
        }          
        
        graph = new MyGraph( vSet, eSet );
        
        verticesTest();
        edgesTest( eSet );
   //     adjacentVerticesTest( vSet );
 //       edgeCostTest();
	}
	
	public static void adjacentVerticesTest( Set<Vertex> v ) {
		for(Vertex vertex : v ) {
			
		}
		
	}
	
	public static void verticesTest() {
		Collection vSet = graph.vertices();
		for(int i = 1; i <= 16; i++) {
			String test = "" + i;
			Vertex v = new Vertex( test );
			if( !vSet.contains( v ) ) {
				System.out.println("verticesTest:\tfail");
				System.out.println( v.getLabel() );
			}
		}
		System.out.println("verticesTest:\tpass");
	}
	
	public static void edgesTest( Set<Edge> e) {
		Collection eSet = graph.edges();
		for(Edge edge : e) {
			if( !eSet.contains( edge ) ) {
				System.out.println("edgesTest:\tfail");
			}
        }
		System.out.println("edgesTest:\tpass");
	}
	
	public static List<String> readLines(String fileName) throws FileNotFoundException {
	       List<String> lines = new ArrayList<String>();
	       Scanner input = new Scanner(new File(fileName));
	       while (input.hasNextLine()) {
	           String line = input.nextLine().trim();
	           if (line.length() > 0) {
	               lines.add(line);
	           }
	       }
	       return lines;
    }
}
