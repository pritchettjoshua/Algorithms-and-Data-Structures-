public class Edge implements Comparable<Edge> {

	private final int v;
	private final int w;
	private final int edgeID;
	private final double weight;

	public Edge(int v, int w, int edgeID, double weight) {
		
		this.v = v;
		this.w = w;
		this.edgeID = edgeID;
		this.weight = weight;
	}

	public double weight() {
		return weight;
	}

	public int edgeID() {
		return edgeID;
	}
	public int v(){
		return v;
	}
	public int w(){
		return w;
	}
	public int compareTo(Edge that) {
		if (this.weight() < that.weight())
			return -1;
		else if (this.weight() > that.weight())
			return +1;
		else
			return 0;
	}


}