import java.util.ArrayList;
import java.util.Collections;

public class MinPQ<T extends Comparable<T>> 
implements MinPQueueInterface<T> {
	private ArrayList<T> heapArr;
	private ArrayList<T> valueTemp = new ArrayList<T>();

	
	 // Constructor
	 
	public MinPQ() {
		heapArr = new ArrayList<T>();
	}
	
	
	/*
	 methods in charge to help with sorting the queue using min heapArr
	 */
	

	 // Restore the min-heapArr property.  At the time that this method is called, the min-heapArr
	 // property holds everywhere, except possibly at node (node) and its children.
	 // When this method returns, the min-heapArr property holds everywhere.
	 // the parameter node  is the position of the possibly bad spot in the heapArr
	 
	private static <T extends Comparable<T>> void minHeapify(ArrayList<T> a, int node) {
		int left = leftChildNode(node);    // return index of the node's left child
		int right = rightChildNode(node);  // return index of the node's right child
		int smallest;    // will be the index of the node with the smallest element between node, leftChildNode and rightChildNode

		// do left child exist,and, does the left child have an element smaller than node?
		if (left <= a.size()-1 && a.get(left).compareTo(a.get(node)) < 0)
			smallest = left;   // if true, the left child is the largest thus far
		else
			smallest = node;      // if false, node is the smallest thus far

		// do right child exist, and, does the right child have an element smaller than the larger of node and the left child?
		if (right <= a.size()-1 && a.get(right).compareTo(a.get(smallest)) < 0)
			smallest = right;  // if true, right child is the largest

		// If node holds an element smaller than both the left and right children, then the max-heapArr property is already true
		// and the work is done.
		//Otherwise, exchange node with the larger of the right and left child and then repeat or recurse downward the heapArr.
		if (smallest != node) {
			exchange(a, node, smallest);
			minHeapify(a, smallest);
		}
	} 

	
	 // exchange two locations i and j in ArrayList a.
	 
	private static <T> void exchange(ArrayList<T> a, int i, int j) {
		T t = a.get(i);
		a.set(i, a.get(j));
		a.set(j, t);
	}

	
	 //Return the index of the left child of the node i.
	 
	private static int leftChildNode(int i) {
		return 2*i + 1;
	}


	
	 // Return the index of the right child of the node i.
	
	private static int rightChildNode(int i) {
		return 2*i + 2;
	}

	
	  //Return the index of the parentNode of the node i
	  //(Parent of root will be -1)
	
	private static int parentNode(int i) {
		return (i-1)/2;
	}
	
	/*
	 end of methods that sort queue using min heapArr
	 */
	
	
	
	 // Return true if the key is found and is sucessfully deleted, otherwise return false.
	 
	public boolean delete(T a) {
		if (heapArr.size() <= 0)
			return false;
		else {
			int loc =-1;
			for(int i = 0; i<heapArr.size();i++){
				if(heapArr.get(i).equals(a)){loc=i;break;}
			}
			
			if(loc!=-1){
				heapArr.remove(loc);
				for(int i = 0; i<heapArr.size();i++){
					valueTemp.add(heapArr.get(i));
				}
				heapArr.clear();
				for(int i = 0; i<valueTemp.size();i++){
					insert(valueTemp.get(i));
				}
				valueTemp.clear();
				
			return true;
			}
			else return false;
		}
	}
	
	 // Return the element with the minimum key, and delete it from the queue.
	 
	public T extractMin() {
		if (heapArr.size() <= 0)
			return null;
		else {
			T minVal = heapArr.get(0);
			heapArr.set(0, heapArr.get(heapArr.size()-1));  // Move last to position 0
			heapArr.remove(heapArr.size()-1);
			minHeapify(heapArr, 0);
			return minVal;
		}
	}

	  //Insert an element into the priority queue while keeping the min heapArr.  
	 
	public int insert(T a) {
		heapArr.add(a);        // enter new value at end;
		int location = heapArr.size()-1;  // and retrieve its location

		// Swap with parentNode until parentNode not larger
		while (location > 0 && heapArr.get(location).compareTo(heapArr.get(parentNode(location))) < 0) {
			exchange(heapArr, location, parentNode(location));
			location = parentNode(location);
		}
		return location;
	}

	
	 // returns true if the priority queue is empty, otherwise returns false
	 
	public boolean isEmpty() {
		return heapArr.size() == 0;
	}

	public <T> void printArray(){
		for(int i=0;i<heapArr.size();i++){
			System.out.print(heapArr.get(i)+ " ");
		}
		System.out.println();
	}
	
	 //Return the element with the minimum key, but it does not delete it from the queue.
	
	public T minimum() {
		
		if (heapArr.size() <= 0)
			return null;
		else
			return heapArr.get(0);
	}

}
