import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class customSort {


    public static void sortb(int[] a, int start, int end){

        if(start < end){
            int biggest = start;
            int smallest = start;

            for(int i = start; i <= end; i++){
                if(a[i] < a[smallest]){
                    smallest = i;
                }
                if(a[i] > a[biggest]){
                    biggest = i;
                }
            }

            exchange(a,start, end, smallest, biggest);
            sortb(a, start+1,end-1);
        }
    }
    public static void exchange(int[] a, int start, int end, int smallest, int biggest){
        int max = a[biggest];
        int min = a[smallest];

        a[smallest] = a[start];
        a[biggest] = a[end];

        a[start] = min;
        a[end] = max;
    }


}
