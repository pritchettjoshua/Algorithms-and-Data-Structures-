public class Driver {
	public static void main(String[] args) {

		int[] array = { 5, 2, 7, 4, 10, 699 };
		RBTree<Integer> st = new RBTree<Integer>();
		for (int i = 0; i < array.length; i++) {
			st.Insert(array[i]);
		}
		st.Traversal();
		System.out.println();
		System.out.println(st);
		int a = st.Search(7);
		System.out.println(a);
		System.out.println(st.Search(9));
	}

}
