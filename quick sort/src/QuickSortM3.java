public class QuickSortM3 {
	private static int CUTOFF = 30;

	public static void QuickSort(int[] A, int p, int r) {
		if(p<r){
		int N = r-p +1 ;
		if (N <= CUTOFF) {
			InsertionSort.sorter(A, r , p);
		}
		int m = Median3(A, p, p + N/2, r);
		int temp = A[m];
		A[m] = A[p];
		A[p] = temp;
		
		int q = Partition(A, p, r);
		QuickSort(A, p, q - 1);
		QuickSort(A, q + 1, r);
		}

	}

	public static int Median3(int[] A, int i, int j, int k) {
		if (A[i] < A[j]) {
			if (A[i] < A[k]) {
				if (A[k] < A[j]) {
					return k;
				} else return j;
			} else return i;
		} else if (A[i] < A[k]) {
			return i;
		} else if (A[j] < A[k]) {
			return j;
		} else return k;
	}

	public static int Partition(int[] A, int p, int r) {
		int x = A[r];
		int i = p - 1;
		int temp = 0;
		for (int j = p; j < r; j++) {
			if (A[j] <= x) {
				i = i + 1;
				temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
		int temp2 = A[i + 1];
		A[i + 1] = A[r];
		A[r] = temp2;
		return i + 1;

	}

}
