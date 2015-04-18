import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class WeightedGraph {
	public int V;
	public int E;
	public LinkedList<Edge>[] adj;
	public boolean[][] matrix;
	public Vertex[] v;
	public int time;

	public WeightedGraph() {
		V = 0;
		E = 0;
	}

	public WeightedGraph(BufferedReader reader) throws IOException {
		String line;
		line = reader.readLine();
		V = Integer.parseInt(line);
		line = reader.readLine();
		E = Integer.parseInt(line);
		adj = new LinkedList[V];
		matrix = new boolean[V][V];
		v = new Vertex[V];
		for (int i = 0; i < V; i++) {
			v[i] = new Vertex("WHITE", Integer.MAX_VALUE, null,0, i);
		}
		for (int v = 0; v < V; v++) {
			adj[v] = new LinkedList<Edge>();
		}
		while ((line = reader.readLine()) != null) {
			int tempV1, tempV2;
			double tempV3;
			StringTokenizer st = new StringTokenizer(line, " ");
			tempV1 = Integer.parseInt(st.nextToken());
			tempV2 = Integer.parseInt(st.nextToken());
			tempV3 = Double.parseDouble(st.nextToken());
			Edge a = new Edge(tempV1,tempV2, 0,tempV3);
			addEdge(a);
		}
	}

	public void addEdge(Edge a) {
		//note uncomment if you want to see the undirected implementation
		int v = a.v();
		int w = a.w();
		adj[v].add(a);
		//adj[w].add(a);
		
	}

	public void tostring() {
		String s = new String();
		System.out.print("There are " + V + " vertices and " + E + " edges\n");
		for (int i = 0; i < V; i++) {
			System.out.print(i + ": ");
			for (int j = 0; j < adj[i].size(); j++) {
				if(i == adj[i].get(j).v() )
				{
				System.out.print( adj[i].get(j).w() + " | " + adj[i].get(j).weight()+" ");
				}
				else
					System.out.print( adj[i].get(j).v() + " | " + adj[i].get(j).weight()+" ");
			}
			System.out.println();

		}
	
	}

}
