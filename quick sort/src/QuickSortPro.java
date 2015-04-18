public class QuickSortPro {
	

	public static void QuickSort(int[] A, int p, int r) {
		if (p < r){
			int q = Partition(A, p, r);
		QuickSort(A, p, q - 1);
		QuickSort(A, q + 1, r);
		}
	}

	public static int Partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p - 1;
		int temp = 0;
		for (int j = p; j < r ; j++) {
			if (A[j] <= x) {
				i = i + 1;
				temp = A[i];
				A[i] = A[j];
				A[j]=temp;
			}
		}
		int temp2= A[i+1];
		A[i + 1] = A[r];
		A[r]=temp2;
		return i + 1;

	}

}
