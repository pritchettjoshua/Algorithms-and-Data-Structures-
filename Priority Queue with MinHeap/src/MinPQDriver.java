
public class MinPQDriver {
	public static void main (String [] args)  {
		// this begins the test using PQ with min heap sort to satisfy the min heap property 
		System.out.println("Test of PQ using Min Heap with merge sort");
		System.out.println();
		MinPQ pq = new MinPQ();
		System.out.println("The position inserted to : " +pq.insert(4));
		System.out.println("The position inserted to : " +pq.insert(6));
		System.out.println("The position inserted to : " +pq.insert(1));
		System.out.println("The position inserted to : " +pq.insert(0));
		System.out.println("The position inserted to : " +pq.insert(33));
		System.out.println("The position inserted to : " +pq.insert(900));
		System.out.println("The position inserted to : " +pq.insert(500));
		System.out.println("The position inserted to : " +pq.insert(333));
		System.out.println("The position inserted to : " +pq.insert(743));
		System.out.println("The position inserted to : " +pq.insert(333));
		System.out.println("The position inserted to : " +pq.insert(1));
		System.out.println("The position inserted to : " +pq.insert(677));
		
		System.out.println("Delete T a, was it sucessful: " +pq.delete(333));
		System.out.println("Delete T a, was it sucessful: " +pq.delete(1));
		System.out.println("Delete T a, was it sucessful: " +pq.delete(677));
		pq.printArray();
		

		
		System.out.println("Delete T a, was it sucessful: " + pq.delete(90));
		System.out.println("Smallest element: " + pq.minimum());
		System.out.println("Extract min: " + pq.extractMin());
		System.out.println("Extract min: " + pq.extractMin());
		System.out.println("Is it empty? : " + pq.isEmpty());
		pq.printArray();
		
		
		System.out.println("Delete T a, was it sucessful: " + pq.delete(33));
		System.out.println("The position inserted to : " +pq.insert(400));
		System.out.println("The position inserted to : " +pq.insert(9));
		System.out.println("The position inserted to : " +pq.insert(1));
		System.out.println("Is it empty? : " + pq.isEmpty());
		pq.printArray();
		
		System.out.println("Delete T a, was it sucessful: " + pq.delete(5));
		System.out.println("Delete T a, was it sucessful: " + pq.delete(0));
		System.out.println("Delete T a, was it sucessful: " + pq.delete(1));
		pq.printArray();
		System.out.println("Extract min: " + pq.extractMin());
		System.out.println("Extract min: " + pq.extractMin());
		System.out.println("Extract min: " + pq.extractMin());
		System.out.println("Extract min: " + pq.extractMin());
		pq.printArray();
		System.out.println("Delete T a, was it sucessful: " + pq.delete(500));
		System.out.println("Delete T a, was it sucessful: " + pq.delete(743));
		pq.printArray();
		System.out.println("Extract min: " + pq.extractMin());
		pq.printArray();
		System.out.println("Delete T a, was it sucessful: " + pq.delete(743));
		System.out.println("Delete T a, was it sucessful: " + pq.delete(900));
		pq.printArray();
		
		
		
	}

}
