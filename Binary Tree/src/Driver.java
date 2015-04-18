
public class Driver {
	public static void main(String[] args) {
		Integer[] a = {  5, 2, 7, 4, 10, 699,0,44 ,1, 693, 1000, 62, 40, 22, 6, 5, 8, 90 };
		BinaryTree<Integer> bst = new BinaryTree<Integer>();
		for (Integer n : a)
			bst.insert(n);

		bst.inOrderTraversal();
		System.out.println();
		System.out.println();
		System.out.println(bst.toString());
		
		System.out.println(bst.search(699));
		System.out.println(bst.search(88));
		System.out.println();
		Stopwatch watch = new Stopwatch();
		bst.delete(693);
		System.out.println("Time to delete in nano seconds: " + watch.elapsedTime());
		bst.inOrderTraversal();
		System.out.println();
		System.out.println();
		System.out.println(bst.toString());
		
		Stopwatch watch1 = new Stopwatch();
		bst.delete(699);
		System.out.println("Time to delete in nano seconds: " + watch1.elapsedTime());
		bst.inOrderTraversal();
		System.out.println();
		System.out.println();
		System.out.println(bst.toString());
		
		Stopwatch watch2 = new Stopwatch();
		bst.delete(1000);
		System.out.println("Time to delete in nano seconds: " + watch2.elapsedTime());
		bst.inOrderTraversal();
		System.out.println();
		System.out.println();
		System.out.println(bst.toString());
		
		Stopwatch watch3 = new Stopwatch();
		bst.delete(0);
		System.out.println("Time to delete in nano seconds: " + watch3.elapsedTime());
		bst.inOrderTraversal();
		System.out.println();
		System.out.println();
		System.out.println(bst.toString());
		
		Stopwatch watch4 = new Stopwatch();
		bst.delete(62);
		System.out.println("Time to delete in nano seconds: " + watch4.elapsedTime());
		bst.inOrderTraversal();
		System.out.println();
		System.out.println();
		System.out.println(bst.toString());
		
		Stopwatch watch5 = new Stopwatch();
		bst.delete(4);
		System.out.println("Time to delete in nano seconds: " + watch5.elapsedTime());
		bst.inOrderTraversal();
		System.out.println();
		System.out.println();
		System.out.println(bst.toString());
	}
}
