import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;


public class WordsInFiles {

	private HashMap<String, ArrayList<String>> wordsAndFileNames;

	public WordsInFiles() {
		wordsAndFileNames = new HashMap<>();
	}

	private void addWordsFromFile(File f) {

	}

	public static void main(String[] args) {
		WordsInFiles w = new WordsInFiles();
		w.read(new File("testIt.txt"));
	}

	private void read(File f) {
		try {
			Scanner readIO = new Scanner(f,"UTF-8");
			File newF = newчё File("prActice.txt");
			PrintWriter write = new PrintWriter(newF);
			String s = (readIO.nextLine());
			write.print("ad");
			write.print("\n");
			write.print(s);
			write.close();
					}catch (Exception e) {
			
		}
	}
}