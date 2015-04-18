import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileReaderDriver {
	public static ArrayList<String> ResultList = new ArrayList<String>();
	public static ArrayList<Long> KeyList = new ArrayList<Long>();

	public static void main(String[] args) throws IOException {
		SearchTest();
	}

	@SuppressWarnings("resource")
	public static void WriteOutput(String OutputFileName,
			Tree<Long, String> tree) throws IOException {
		BufferedWriter writer = null;
		File OutFile = new File(OutputFileName);
		writer = new BufferedWriter(new FileWriter(OutFile));
		for (int i = 0; i < ResultList.size(); i++) {
			writer.write(ResultList.get(i) + "");
			writer.newLine();
			writer.flush();
		}
		System.out.println("The output is written to: " + OutputFileName);
	}

	@SuppressWarnings("resource")
	public static Tree<Long, String> fileRead(Tree<Long, String> tree,
			String InputFileName) throws IOException {
		FileInputStream InputFile = new FileInputStream(InputFileName);
		BufferedReader reader = null;
		String line;
		reader = new BufferedReader(new InputStreamReader(InputFile));
		while ((line = reader.readLine()) != null) {
			String[] thisLine = line.split(",");
			if (thisLine[0].contains("E+")) {
				String[] newNumber = thisLine[0].split("E+");
				long a;
				if (newNumber[0].contains(".")) {
					a = Long.parseLong(newNumber[0].replace(".", ""));
				} else {
					a = Long.parseLong(newNumber[0]);
				}
				long b = 10 ^ Long.parseLong(newNumber[1]);
				long c = a * b;
				String res = Long.toString(c);
				thisLine[0] = res;
			}
			Type temp = new Type();
			temp.setNumber(Long.parseLong(thisLine[0]));
			temp.setSize(thisLine[1]);
			temp.setName(thisLine[2]);
			tree.Insert(temp.getNumber(),
					temp.getSize() + " , " + temp.getName());
		}
		return tree;
	}

	public static void SearchTest() throws IOException {
		String FilePath = "src/";
		String InputKeyFileName = "Key.txt";
		String InputFileName = "UPC.csv";
		String OutputFileName = "Output.txt";
		ReadKey(FilePath + InputKeyFileName);
		Tree<Long, String> tree = new Tree<Long, String>();
		tree = fileRead(tree, FilePath + InputFileName);
		long startTime = System.nanoTime();
		for (int i = 0; i < KeyList.size(); i++) {
			System.out.println(KeyList.get(i));
			String result = tree.TreeSearch(KeyList.get(i));
			ResultList.add(result);
		}
		long endTime = System.nanoTime();
		long FinalTime = endTime - startTime;
		System.out.println("The total search time is: " + FinalTime);
		WriteOutput(FilePath + OutputFileName, tree);
	}

	@SuppressWarnings("resource")
	public static void ReadKey(String InputKeyFileName) throws IOException {
		FileInputStream InputFile = new FileInputStream(InputKeyFileName);
		BufferedReader reader;
		String line;
		reader = new BufferedReader(new InputStreamReader(InputFile));
		while ((line = reader.readLine()) != null) {
			KeyList.add(Long.parseLong(line));
		}
	}
}
