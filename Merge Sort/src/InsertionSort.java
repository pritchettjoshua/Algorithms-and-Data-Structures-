
public class InsertionSort {
	public static int counter=0;
	
	public static void sorter(int[]array,int hi, int low){
		for(int j = low+1; j<hi +1; j++){
			int key = array[j];
			int i = j-1;
			while(i >= 0 && array[i] > key){
				counter++;
				array[i+1] = array[i];
				i = i-1;
			}
			array[i+1] = key;
			
		}
		//System.out.println(counter);
		counter=0;
		
	}
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		
//		int[]arr1 = {1,2,3,4,5,6};
//		int[]arr2 = {6,5,4,3,2,1};
//		
//		Stopwatch sortTime=new Stopwatch();
//		sorter(arr1);
//		System.out.println("Nano seconds to complete insertion sort: "+ sortTime.elapsedTime());
//
//		for(int i =0; i< arr1.length; i++)
//			System.out.print(arr1[i]);
//		System.out.println();
//		
//		Stopwatch sortTime2=new Stopwatch();
//		sorter(arr2);
//		System.out.println("Nano seconds to complete insertion sort: "+ sortTime2.elapsedTime());
//		
//		for(int i =0; i< arr2.length; i++)
//			System.out.print(arr2[i]);
//		System.out.println();
//
//	}

}

