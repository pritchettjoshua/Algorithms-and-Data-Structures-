import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Stopwatch {
	private final long start;

	public Stopwatch() {
		start = System.nanoTime();
	}

	// return time (in seconds) since this object was created
	public double elapsedTime() {
		long now = System.nanoTime();
		return (now - start);
	}

}

public class Driver {
	public static void main(String[] args) throws IOException {
		FileInputStream fs = new FileInputStream("src/mediumGraph.txt");
		//FileInputStream fs2 = new FileInputStream("src/smallG.txt");

		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		//BufferedReader br2 = new BufferedReader(new InputStreamReader(fs2));

		//DirectedGraph a = new DirectedGraph(br);
		//UndirectedGraph b = new UndirectedGraph(br);
//		UndirectedGraph c = new UndirectedGraph(br);
		WeightedGraph dg = new WeightedGraph(br);
		
		// System.out.print(a.tostring());
		// System.out.print(b.tostring());
		Stopwatch watch = new Stopwatch();
		dg.tostring();
		
		//b.printPath(0, b.v[7]);
		System.out.println();
		System.out.println("The execution time is: "+ watch.elapsedTime());
		System.out.println();
		
//		Stopwatch watch1 = new Stopwatch();
//		b.bfs(0);
//		System.out.println("The execution time is: "+ watch1.elapsedTime());
//		System.out.println();
//
//		
//		Stopwatch watch2 = new Stopwatch();
//		c.bfs(0);
//		System.out.println("The execution time is: "+ watch2.elapsedTime());
//		System.out.println();
//		
//		Stopwatch watch3 = new Stopwatch();
//		c.matrixBfs(0);
//		System.out.println("The execution time is: "+ watch3.elapsedTime());
//		System.out.println();
		
		
//		b.printPath(0, b.v[1]);
//		System.out.println();
//		b.printPath(0, b.v[2]);
//		System.out.println();
//		b.printPath(0, b.v[3]);
//		System.out.println();
//		b.printPath(0, b.v[4]);
//		System.out.println();
//		b.printPath(0, b.v[5]);
//		System.out.println();
//		b.printPath(0, b.v[6]);
//		System.out.println();
//		b.printPath(0, b.v[7]);

		// b.bfs(0);
		// System.out.println();
		// b.printPath(0, b.v[1]);
		// System.out.println();
		// b.printPath(0, b.v[2]);
		// System.out.println();
		// b.printPath(0, b.v[3]);
		// System.out.println();
		// b.printPath(0, b.v[4]);
		// System.out.println();
		// b.printPath(0, b.v[5]);
		// System.out.println();
		// b.printPath(0, b.v[6]);
		// System.out.println();
		// b.printPath(0, b.v[7]);
	}

}
