import java.util.*;

public class MergeSortPro {
	public static void mergeSort(int[] a, int[] tmp, int p, int r) {
		//if (r-p <= 8)
		//	InsertionSort.sorter(a,r ,p);
		//else 
			if (p < r) {
			int center = (p + r) / 2;
			mergeSort(a, tmp, p, center);
			mergeSort(a, tmp, center + 1, r);
			merge(a, tmp, p, center, r);
		}
	}

	private static void merge(int[] a, int[] tmp, int p, int q, int r) {
		int i = p;
		int j = q + 1;
		for (int k = p; k <= r; k++) {
			tmp[k] = a[k];

		}
		for (int k = p; k <= r; k++) {
			if (i > q) {
				a[k] = tmp[j];
				j = j + 1;
			} else if (j > r) {
				a[k] = tmp[i];
				i = i + 1;
			} else if (tmp[j] < tmp[i]) {
				a[k] = tmp[j];
				j = j + 1;
			} else {
				a[k] = tmp[i];
				i = i + 1;

			}

		}
	}

}
