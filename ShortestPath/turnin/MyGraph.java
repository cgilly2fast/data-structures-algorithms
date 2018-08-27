import java.util.*;

/**
 * A representation of a graph.
 * Assumes that we do not have negative cost edges in the graph.
 */
public class MyGraph implements Graph {
    // you will need some private fields to represent the graph
    // you are also likely to want some private helper methods
	
	private Map<Vertex, Set<Edge> > graph;


    /**
     * Creates a MyGraph object with the given collection of vertices
     * and the given collection of edges.
     * @param v a collection of the vertices in this graph
     * @param e a collection of the edges in this graph
     * @throws IllegalArgumentException if params are null
     * @throws IllegalArgumentException only edges that point to and 
     * from vertex given in Vertex set allowed must have edge weight 
     * greater than zero.
     * 
     */
    public MyGraph(Collection<Vertex> v, Collection<Edge> e) {
    	
    	//
    	if( v == null || e == null) {
    		throw new IllegalArgumentException("null");
    	}
    	
    	this.graph = new HashMap <Vertex, Set<Edge>>();
    	
    	
    	for( Vertex vertex : v) {
    		// if graph does not contain key
    		if( !this.graph.containsKey( vertex ) )  {
    			// add key (vertex) and empty HashSet for edges 
    			Set<Edge> eSet = new HashSet<Edge>();
    			this.graph.put( new Vertex( vertex.getLabel() ), eSet);
    		}
    	}
    	
    	Set<Vertex> allVertices = this.graph.keySet();
    	
    	for( Edge edge : e) {
    		// only edges that point to and from vertex given in 
    		// Vertex set allowed must have edge weight greater 
    		// than zero.
    		if( ( v.contains( edge.getSource() ) ) && 
    			( v.contains( edge.getDestination() ) ) && 
    			( edge.getWeight() >= 0 ) ) {
   
    			Vertex newV1 = new Vertex( edge.getSource().getLabel() );
    			Vertex newV2 = new Vertex( edge.getDestination().getLabel() );
    			
    			Edge newE = new Edge( newV1, newV2, edge.getWeight() );
    			
    			Set<Edge> eSet = this.graph.get( newV1 );
    			
    			// Ensures no repeated edges with different weights
    			for( Edge a :  eSet ) {
    				if( !( a.equals( newE ) ) ) {
    					if( ( a.getDestination().equals( newV2 ) ) && 
    	    				( a.getWeight() != newE.getWeight() ) ) {
    							throw new IllegalArgumentException("illegal "
    									+ "edges, no repeated edges with "
    									+ "different weights");
    	    			}
    					
    				}	
    			}
    			
    			eSet.add( newE );
    			
    		} else {
    			 throw new IllegalArgumentException("illegal edges, no "
    			 		+ "edge with negative weights or vertices not in set");
    		}
    	}

    }

    /** 
     * Return the collection of vertices of this graph
     * @return the vertices as a collection (which is anything iterable)
     */
    public Collection<Vertex> vertices() {
    	// Retrieves a set of keys (vertices)
    	Set<Vertex> vert = this.graph.keySet();
    	
    	// initalize new set to be returned to client
    	Set<Vertex> returnSet = new HashSet<Vertex>();
     	
    	// Copy each vertex to new set
    	for( Vertex v : vert ) {
    		returnSet.add( new Vertex( v.getLabel() ) );	
    	}
    	
    	return returnSet;

    }

    /** 
     * Return the collection of edges of this graph
     * @return the edges as a collection (which is anything iterable)
     */
    public Collection<Edge> edges() {
    	Set<Edge> returnSet = new HashSet<Edge>();
    	Collection<Vertex> vSet = this.vertices();
     	
    	for( Vertex v : vSet ) {
    		// retrieve edges for of Vertex v
    		Set<Edge> eSet = this.graph.get( v );
    		
    		// Deep copy each edge the set to be return to client
    		for( Edge e : eSet ) {
    			Vertex newV1 = new Vertex( e.getSource().getLabel() );
    			Vertex newV2 = new Vertex( e.getDestination().getLabel() );
    			Edge newE = new Edge( newV1, newV2, e.getWeight() );
    			returnSet.add( newE );	
    		}
    	}
    	
    	return returnSet;
	

    }

    /**
     * Return a collection of vertices adjacent to a given vertex v.
     *   i.e., the set of all vertices w where edges v -> w exist in the graph.
     * Return an empty collection if there are no adjacent vertices.
     * @param v one of the vertices in the graph
     * @return an iterable collection of vertices adjacent to v in the graph
     * @throws IllegalArgumentException if v does not exist.
     */
    public Collection<Vertex> adjacentVertices(Vertex v) {
    	if( v == null ) {
    		throw new IllegalArgumentException("null");
    	}
    	
    	Set<Vertex> returnSet = new HashSet<Vertex>();
    	
		// Retrieve edges for of Vertex v
    	Set<Edge> eSet = this.graph.get( v );
    	
    	
		for( Edge e : eSet ) {
			// Deep copy each Vertex adjacent to v
			Vertex newV = new Vertex( e.getDestination().getLabel() );
			returnSet.add( newV );	
		}
		
		return returnSet;
    }

    /**
     * Test whether vertex b is adjacent to vertex a (i.e. a -> b) in a directed graph.
     * Assumes that we do not have negative cost edges in the graph.
     * @param a one vertex
     * @param b another vertex
     * @return cost of edge if there is a directed edge from a to b in the graph, 
     * return -1 otherwise.
     * @throws IllegalArgumentException if a or b do not exist.
     */
    public int edgeCost(Vertex a, Vertex b) {
    	if( a == null || b == null) {
    		throw new IllegalArgumentException("null");
    	}
    	
    	// Retrieve edges for of Vertex v
    	Set<Edge> eSet = this.graph.get( a );
    	
		for( Edge edge :  eSet ) {
			// Find if edge exists
			if( edge.getDestination().equals( b ) ) {
				return edge.getWeight();
    		}	
		}
    	
		return -1;
    }
    

    /**
     * Returns the shortest path from a to b in the graph, or null if there is
     * no such path.  Assumes all edge weights are nonnegative.
     * Uses Dijkstra's algorithm.
     * @param a the starting vertex
     * @param b the destination vertex
     * @return a Path where the vertices indicate the path from a to b in order
     *   and contains a (first) and b (last) and the cost is the cost of 
     *   the path. Returns null if b is not reachable from a.
     * @throws IllegalArgumentException if a or b does not exist.
     */
    public Path shortestPath(Vertex a, Vertex b) {
    	if( a == null || b == null) {
    		return null;
    	}
    	
    	if( a.equals( b ) ) {
    		List<Vertex> equ = new ArrayList<Vertex>();
    		equ.add( b );
    		return new Path( equ, 0 );
    	}
    			
    	Collection<Vertex> unknownV = this.vertices();
    	Comparator<Vertex> comparator = new distComparator();
    	PriorityQueue<Vertex> pQueue = new PriorityQueue<Vertex>( 11, comparator);
    	Map<String, Vertex> org = new HashMap<String, Vertex>();
    	
    	for( Vertex v : unknownV ) {
    		if( a.equals( v ) ){
    			v.setDist(0);
    		} else {
    			v.setDist( Integer.MAX_VALUE );
        		v.setKnown( false );
    		}
    		pQueue.add( v );
    		org.put(v.getLabel(), v);
    	}
    	
    	while( !unknownV.isEmpty() ) {
    		Vertex v = pQueue.poll();
    		if( v.equals( b ) ) {
    			// found destination
    			break;
    		} else {
    			// remove from possible unknowns
    			// org.get( v.getLabel() ).setKnown( true );
	    		unknownV.remove( v );
	    		// get adjacent vertices to explore
	    		Collection<Vertex> adjVertex = this.adjacentVertices( v );
	    		
	    		for( Vertex adjV : adjVertex ) {
	    			// if not unexplored
	    			if( unknownV.contains( adjV ) ) {

	    				int cvw = this.edgeCost( v, adjV);
	    				
	    				// check if new edge is cheap than explored options
	    				if( ( v.getDist() + cvw ) < org.get( adjV.getLabel() ).getDist() ) {
	    					// update paths
	    					org.get( adjV.getLabel() ).setDist( v.getDist() + cvw );
	    					org.get( adjV.getLabel() ).setPath ( v );
	    					pQueue.remove( org.get( adjV.getLabel() ) );
	    					pQueue.add( org.get( adjV.getLabel() ) );
	    				}
	    			}
	    		}
    		}	
    	}
    	
    	Vertex update = b;
    	List<Vertex> pathList = new ArrayList<Vertex>();
    	
    	while( update != null ) {
    		pathList.add(org.get( update.getLabel() ) );
    		update = org.get( update.getLabel() ).getPath();
    	}
    	
    	if(pathList.size() == 1 ) {
    		return null;
    	}
    	
    	Collections.reverse(pathList);
    	return new Path( pathList, org.get( b.getLabel() ).getDist() );
    }
    
//    private Path createPath(Map<String, Vertex> map, Vertex b) {
//    	if( map.get( b.getLabel() ) != null) {
//    		createPath( map, map.get( b.getLabel() ).getPath() );
//    		
//    	}
//    	
//    }
    
    public class distComparator implements Comparator<Vertex> {
        public int compare(Vertex x, Vertex y) {
        	 if (x.getDist() < y.getDist())
             {
                 return -1;
             }
             if (x.getDist() > y.getDist())
             {
                 return 1;
             }
             return 0;
        }
    }

}
