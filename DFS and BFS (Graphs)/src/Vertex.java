public class Vertex implements Comparable <Vertex> {

	protected String color;
	protected int d;
	protected int node;
	protected Vertex pi;
	public int f;

	public Vertex(String color, int d, Vertex pi, int f, int node){
		this.color = color;
		this.d = d;
		this.pi = pi;
		this.f = f;
		this.node = node;
		
	}

	public int compareTo(Vertex a) {
		if(this.f < a.f)
		return -1 ;
		else if(this.f > a.f)
		return 1;
		else return 0;
	}

}
