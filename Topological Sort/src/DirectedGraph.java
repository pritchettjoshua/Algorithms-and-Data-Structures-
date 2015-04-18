import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class DirectedGraph extends Graph {
	private LinkedList <Integer> list= new LinkedList<Integer>();

	public DirectedGraph(BufferedReader reader) throws IOException {
		super(reader);
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}
	public void DFS() {
		for (Vertex u : this.v) {
			u.color = "WHITE";
			u.pi = null;
		}
		time = 0;
		for(Vertex u : this.v){
			if(u.color=="WHITE")dfsVisit(u);
		}
		
	}
	
	private void dfsVisit(Vertex u) {
		time = time + 1;
		u.d = time;
		u.color = "GRAY";
		for (int i = 0; i < adj[u.node].size(); i++) {
			if (this.v[adj[u.node].get(i)].color.equals("WHITE")) {
				this.v[adj[u.node].get(i)].color = "WHITE";
				this.v[adj[u.node].get(i)].pi = this.v[u.node];
				dfsVisit(v[adj[u.node].get(i)]);
			}
		}
		u.color = "BLACK";
		time = time + 1;
		u.f = time;

	}
	
	public void printPath(int s, Vertex v) {
		if (v.node == s) {
			System.out.print(s + ", ");
		} else if (v.pi == null) {
			System.out.println("There is no path from " + s + " to " + v.node
					+ " that exists");
		} else {
			printPath(s, v.pi);
			System.out.print(v.node + ", ");
		}
	}
	public void TopologicalSort(){
		Arrays.sort(v);
		for(int i = 0; i < v.length; i++)
			list.addFirst(v[i].node);
		System.out.print(list.toString());
	}
}
