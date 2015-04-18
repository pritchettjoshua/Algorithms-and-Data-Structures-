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

public class Graph {
	public int V;
	public int E;
	public LinkedList<Integer>[] adj;
	public boolean[][] matrix;
	public Vertex[] v;
	public int time;

	public Graph() {
		V = 0;
		E = 0;
	}

	public Graph(BufferedReader reader) throws IOException {
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
			adj[v] = new LinkedList<Integer>();
		}
		while ((line = reader.readLine()) != null) {
			int tempV1, tempV2;
			StringTokenizer st = new StringTokenizer(line, " ");
			tempV1 = Integer.parseInt(st.nextToken());
			tempV2 = Integer.parseInt(st.nextToken());
			addEdge(tempV1, tempV2);
		}
	}

	public void addEdge(int v, int w) {

	}

	public String tostring() {
		String s = new String();
		s = "There are " + V + " vertices and " + E + " edges\n";
		for (int i = 0; i < V; i++) {
			s = s + i + ": ";
			for (int j = 0; j < adj[i].size(); j++) {
				s = s + adj[i].get(j) + " ";
			}
			s = s + "\n";

		}
		return s;
	}

}
