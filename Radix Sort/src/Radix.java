
public class Radix {
	// extended ASCII size
    private static final int R             = 256;  
    private static final int CUTOFF        =  20;   
   
    private static void insertion(String[] array, int low, int high, int k) {
        for (int i = low; i <= high; i++){
            for (int j = i; j > low && less(array[j], array[j-1], k); j--){
                exchange(array, j, j-1);
            }}
    }

    private static void exchange(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static boolean less(String str, String j, int k) {
        for (int i = k; i < Math.min(str.length(), j.length()); i++) {
            if (str.charAt(i) < j.charAt(i)) return true;
            if (str.charAt(i) > j.charAt(i)) return false;
        }return str.length() < j.length();
    }
    public static void sort(String[] array) {
        int N = array.length;
        String[] aux = new String[N];
        sort(array, 0, N-1, 0, aux);
    }

    private static int charAt(String str, int k) {
        assert k >= 0 && k <= str.length();
        if (k == str.length()) return -1;
        return str.charAt(k);
    }

    private static void sort(String[] array, int low, int high, int k, String[] aux) {

        if (high <= low + CUTOFF) {
            insertion(array, low, high, k);
            return;
        }

        int[] count = new int[R+2];
        for (int i = low; i <= high; i++) {
            int h = charAt(array[i], k);
            count[h+2]++;
        }

        for (int r = 0; r < R+1; r++)
            count[r+1] += count[r];

        for (int i = low; i <= high; i++) {
            int c = charAt(array[i], k);
            aux[count[c+1]++] = array[i];
        }

        for (int i = low; i <= high; i++) 
            array[i] = aux[i - low];


        for (int r = 0; r < R; r++)
            sort(array, low + count[r], low + count[r+1] - 1, k+1, aux);
    }

   
 
        
}
