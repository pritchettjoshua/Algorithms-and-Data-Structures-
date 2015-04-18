import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class UndirectedGraph extends Graph {
	private static final int INFINITY = Integer.MAX_VALUE;

	public UndirectedGraph(BufferedReader reader) throws IOException {
		super(reader);
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		matrix[v][w] = true;
		matrix[w][v] = true;
	}

	public void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (Vertex v : this.v) {
			v.color = "WHITE";
			v.d = Integer.MAX_VALUE;
			v.pi = null;
		}
		this.v[s].color = "GRAY";
		this.v[s].d = 0;
		this.v[s].pi = null;
		q.add(s);
		while (!q.isEmpty()) {
			int u = q.remove();
			for (int i = 0; i < adj[u].size(); i++) {
				if (this.v[adj[u].get(i)].color.equals("WHITE")) {
					this.v[adj[u].get(i)].color = "GRAY";
					this.v[adj[u].get(i)].d = (this.v[u].d + 1);
					this.v[adj[u].get(i)].pi = this.v[u];
					q.add(adj[u].get(i));
				}
			}
		}
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

	public void matrixBfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		for (Vertex v : this.v) {
			v.color = "WHITE";
			v.d = Integer.MAX_VALUE;
			v.pi = null;
		}
		this.v[s].color = "GRAY";
		this.v[s].d = 0;
		this.v[s].pi = null;
		q.add(s);
		while (!q.isEmpty()) {
			int u = q.remove();
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[u][i]) {
					if (this.v[i].color.equals("WHITE")) {
						this.v[i].color = "GRAY";
						this.v[i].d = (this.v[u].d + 1);
						this.v[i].pi = this.v[u];
						q.add(i);
					}
				}
			}
		}
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
}
