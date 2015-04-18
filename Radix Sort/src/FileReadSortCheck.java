/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
   static String[] array;

    public static void main(String[] args) throws IOException {
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
    	Radix.sort(array);
       // customSort.sortb(array, 0, array.length-1);
       // boolean result = sortCheckAsc(array);
        for(int y = 0; y <array.length; y++){
        	System.out.println(array[y]+ " ");
        }
      //  System.out.println("is in ascending order: "+result);
       
    	
    }

    public static void fileRead() throws IOException {
		FileInputStream fs = new FileInputStream("src/"+"LOG.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		String line = "";
		ArrayList<String> tempArr = new ArrayList<String>();

		while ((line = br.readLine()) != null) { 
			String mine = line.trim();
			tempArr.add(mine);
		}
        array = new String[tempArr.size()];
		for(int i=0;i<tempArr.size();i++)
			array[i]=tempArr.get(i);
		
		br.close();
	}
}