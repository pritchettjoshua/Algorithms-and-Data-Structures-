/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dibya
 */
public class FileReadSortCheck {

    /**
     * @param args the command line arguments
     */
   static int[] array;

    public static void main(String[] args) {
        // TODO code application logic here
//     	String[] files = {
//
//    		    "input_2_4.txt" , "input_2_5.txt" , "input_2_6.txt", "input_2_7.txt",
//
//    		    "input_2_8.txt" , "input_2_9.txt" , "input_2_10.txt" , "input_2_11.txt" , "input_2_12.txt",
//
//    		    "input_2_13.txt" , "input_2_14.txt" , "input_2_15.txt" , "input_2_16.txt" , "input_2_17.txt",
//
//    		    "input_2_18.txt" , "input_2_19.txt" , "input_2_20.txt" , "input_2_21.txt", "input_2_22.txt" ,
//
//    		    "input_2_23.txt" , "input_2_24.txt"
//
//    		    	
//
//    		    }; 
//    	for(int i=0; i<files.length;i++){
//    		System.out.println(files[i]);
//        fileRead(files[i]);
    	fileRead();
        int p = 0;
        int r= array.length-1;
        Stopwatch sortTime=new Stopwatch();
        QuickSortM3.QuickSort(array, p, r);
        System.out.println("Mili-seconds to complete Quicksort W/M3: "+ sortTime.elapsedTime());
        boolean result = sortCheckAsc(array);
//        for(int y = 0; y <array.length; y++){
//        	System.out.println(array[y]+ " ");
//        }
        System.out.println("is in ascending order: "+result);
        
     
       // int[] a = {1,2,3,4,5};
       result = sortCheckDesc(array);
       System.out.println("is in descending order: " +result);
       System.out.println();
    	
    }

    public static void fileRead() {
        FileInputStream fis = null;
        try {
            File f = new File("src/"+"input_2_18.txt");
            byte[] bytes = new byte[(int) f.length()];
            fis = new FileInputStream(f);
            fis.read(bytes);
            fis.close();
            String[] valueStr = new String(bytes).trim().split("\\s+");
            array = new int[valueStr.length];
            for (int i = 0; i < valueStr.length; i++) {
                array[i] = Integer.parseInt(valueStr[i]);
                //System.out.println(array[i]);
            }
            //System.out.println(Arrays.asList(array));
        } catch (IOException ex) {
            Logger.getLogger(FileReadSortCheck.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(FileReadSortCheck.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static boolean sortCheckAsc(int[] a) {
        int  N = a.length;
        int prev = a[0];
        boolean isSorted = true;
        for(int i=1; i< N; i++){
            if(a[i] >= prev) {
				prev = a[i];
                continue;
            }
            else {
                isSorted = false;
                return isSorted;
            }
        }
        return isSorted;
    }
    
    public static boolean sortCheckDesc(int[] a) {
        int  N = a.length;
        int prev = a[0];
        boolean isSorted = true;
        for(int i=1; i< N; i++){
            if(a[i] <= prev) {
				prev = a[i];
                continue;
            }
            else {
                isSorted = false;
                return isSorted;
            }
        }
        return isSorted;
    }
}