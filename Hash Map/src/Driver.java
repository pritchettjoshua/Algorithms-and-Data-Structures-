import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Driver {
	public static HashElement[] InputData = new HashElement[100];
	public static ArrayList<String> LinearResultarraylist = new ArrayList<String>();
	public static ArrayList<String> QuadraticResultarraylist = new ArrayList<String>();
	public static ArrayList<Long> Keyarraylist = new ArrayList<Long>();

	public static void main(String[] args) throws IOException {
		String FilePath = "src/";
		String InputFileName = "UPC.csv";
		String LinearOutputFileName = "LinearOut.txt";
		String LinearHashMapName = "LinearHashMap.txt";
		String QuadraOutputFileName = "QuadraticOut.txt";
		String QuadraHashMapName = "QuadraticHashMap.txt";
		String KeyFileName = "Keys.txt";
		
		
		
		KeyReader(FilePath + KeyFileName);
		Hashmap Linearmap = new Hashmap();
		linearFReader(Linearmap, FilePath + InputFileName);
		linearWriteOutput(Linearmap, FilePath + LinearHashMapName);
		System.out.println("The linear hash map is printed to:  " + FilePath
				+ LinearHashMapName);

		long LinearstartTime = System.nanoTime();
		for (int i = 0; i < Keyarraylist.size(); i++) {
			String result = Linearmap.linearGet(Keyarraylist.get(i));
			LinearResultarraylist.add(Keyarraylist.get(i).toString() + ": "
					+ result);
		}
		
		
		long LinearstopTime = System.nanoTime();
		long LinearTotalTime = LinearstopTime - LinearstartTime;
		System.out
				.println("The total time of searching - - Linear hash map is: "
						+ LinearTotalTime);
		OutputWriter(FilePath + LinearOutputFileName, LinearResultarraylist);
		System.out.println("Linear hash map search result is printed to:  "
				+ FilePath + LinearOutputFileName);

		System.out.println();

		Hashmap Quadramap = new Hashmap();
		QuadraticFReader(Quadramap, FilePath + InputFileName);
		QuadraticWriterOutput(Quadramap, FilePath + QuadraHashMapName);
		System.out.println("The Quadratic hash map is printed to:  " + FilePath
				+ QuadraHashMapName);
		
		
		long QuadrastartTime = System.nanoTime();
		for (int i = 0; i < Keyarraylist.size(); i++) {
			String result = Quadramap.quadraticGet(Keyarraylist.get(i));
			QuadraticResultarraylist.add(Keyarraylist.get(i).toString() + ": "
					+ result);
		}
		long QuadrastopTime = System.nanoTime();
		long QuadraTotalTime = QuadrastopTime - QuadrastartTime;
		System.out
				.println("The total time of searching - - Quadratic hash map is: "
						+ QuadraTotalTime);
		
		
		OutputWriter(FilePath + QuadraOutputFileName, QuadraticResultarraylist);
		System.out.println("Quadratic hash map search result is printed to:  "
				+ FilePath + QuadraOutputFileName);
	}

	public static void linearWriteOutput(Hashmap newmap, String OutputFileName)
			throws IOException {
		File OutFile = new File(OutputFileName);
		FileWriter out = new FileWriter(OutFile.getAbsoluteFile());
		BufferedWriter writer = new BufferedWriter(out);
		writer.write(newmap.toString());
		writer.close();
	}

	@SuppressWarnings("resource")
	public static void linearFReader(Hashmap input, String InputFileName)
			throws IOException {
		FileInputStream InputFile = new FileInputStream(InputFileName);
		BufferedReader reader = null;
		String line;
		reader = new BufferedReader(new InputStreamReader(InputFile));
		while ((line = reader.readLine()) != null) {
			String[] thisLine = line.split(",");
			long key = Long.parseLong(thisLine[0]);
			if (!input.isFull())
				input.linearPut(key, thisLine[1] + ", " + thisLine[2]);
			else
				break;
		}
	}
	@SuppressWarnings("resource")
	public static void KeyReader(String InputKeyFileName) throws IOException {
		FileInputStream InputFile = new FileInputStream(InputKeyFileName);
		BufferedReader reader;
		String line;
		reader = new BufferedReader(new InputStreamReader(InputFile));
		while ((line = reader.readLine()) != null) {
			Keyarraylist.add(Long.parseLong(line));
		}
	}

	@SuppressWarnings("resource")
	public static void OutputWriter(String OutputFileName,
			ArrayList<String> Resultarraylist) throws IOException {
		BufferedWriter writer = null;
		File OutFile = new File(OutputFileName);
		writer = new BufferedWriter(new FileWriter(OutFile));
		for (int i = 0; i < Resultarraylist.size(); i++) {
			writer.write(Resultarraylist.get(i) + "");
			writer.newLine();
			writer.flush();
		}
	}
	public static void QuadraticWriterOutput(Hashmap newmap, String OutputFileName)
			throws IOException {
		File OutFile = new File(OutputFileName);
		FileWriter out = new FileWriter(OutFile.getAbsoluteFile());
		BufferedWriter writer = new BufferedWriter(out);
		writer.write(newmap.toString());
		writer.close();
	}

	@SuppressWarnings("resource")
	public static void QuadraticFReader(Hashmap input, String InputFileName)
			throws IOException {
		FileInputStream InputFile = new FileInputStream(InputFileName);
		BufferedReader reader = null;
		String line;
		reader = new BufferedReader(new InputStreamReader(InputFile));
		while ((line = reader.readLine()) != null) {
			if (!input.isFull()) {
				String[] thisLine = line.split(",");
				long key = Long.parseLong(thisLine[0]);
				input.quadraticPut(key, thisLine[1] + ", " + thisLine[2]);
			} else
				break;
		}
	}

	
}