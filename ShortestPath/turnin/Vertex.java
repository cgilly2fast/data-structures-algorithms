/**
 * Representation of a graph vertex
 */
public class Vertex {
	private final String label;   // label attached to this vertex
	private boolean known;
	private int dist;
	private Vertex path;

	/**
	 * Construct a new vertex
	 * @param label the label attached to this vertex
	 */
	public Vertex(String label) {
		if(label == null)
			throw new IllegalArgumentException("null");
		this.label = label;
		this.known = false;
		this.dist = 0;
		this.path = null;
	}
	
	/**
	 * Get next vertex in path to shortest distance from origin
	 * @return the vertex next attached to this vertex
	 */
	public Vertex getPath() {
		return this.path;
	}
	
	/**
	 * Set the next vertex in path to shortest distance from origin
	 */
	public void setPath( Vertex v) {
		this.path = v;
	}
	
	/**
	 * Get a vertex distance from origin
	 * @return the distance attached to this vertex
	 */
	public int getDist() {
		return this.dist;
	}
	
	/**
	 * Set a vertex distance from origin
	 */
	public void setDist( int d) {
		this.dist = d;
	}
	
	/**
	 * Is the vertex known 
	 * @return true is known false is unkown
	 */
	public boolean isKnown() {
		return this.known;
	}
	
	/**
	 * Set the vertex to be known (true) or unkown (false) 
	 */
	public void setKnown( boolean k) {
		this.known = k;
	}
	
	/**
	 * Get a vertex label
	 * @return the label attached to this vertex
	 */
	public String getLabel() {
		return this.label;
	}
	
	/**
	 * A string representation of this object
	 * @return the label attached to this vertex
	 */
	public String toString() {
		return this.label;
	}

	//auto-generated: hashes on label
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	//auto-generated: compares labels
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Vertex other = (Vertex) obj;
		if (label == null) {
                    return other.label == null;
		} else {
		    return label.equals(other.label);
		}
	}


}
