import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

import java.io.File;
import java.io.FileNotFoundException;

public class WordsInFiles {

	private HashMap<String, ArrayList<String>> wordsListNames;

	public WordsInFiles() {
		wordsListNames = new HashMap<>();
	}

	private void addWordsFromFile(File f) {
		Scanner read = null;
		String fileName = f.getName();
		try {
			read = new Scanner(f);
		}catch (Exception e) {
			
		}

		while(read.hasNext()) {
			String s = read.next();
			ArrayList<String> fileNames = new ArrayList<>();
			if (!wordsListNames.containsKey(s)) {
				fileNames.add(fileName);
				wordsListNames.put(s, fileNames);
				continue;
			}

			fileNames = wordsListNames.get(s);
			if (! fileNames.contains(fileName))
				fileNames.add(fileName);
		}
	}

	public void buildWordMap() {
		wordsListNames.clear();

		for (int i = 1 ; i <= 5 ; i++) {
			File f = new File("brief" + i + ".txt");
			addWordsFromFile(f);
		}
	}

	public int maxNumber() {
		int max = 0;

		for (String word : wordsListNames.keySet()) {
			int count = wordsListNames.get(word).size();
			if (max < count) {
				max = count;
			}
		}

		return max;
	}

	public ArrayList<String> wordsInNumFiles(int number) {
		String name = "brief"+number+".txt";
		ArrayList<String> words = new ArrayList<>();
		
		for (String word : wordsListNames.keySet()) {
			ArrayList<String> cur = wordsListNames.get(word);
			if(cur.contains(name)) {
				words.add(word);
			}
		}

		return words;	
	}

	public void printFileIn(String word) {
		ArrayList<String> fileName = wordsListNames.get(word);
		for (String name : fileName) {
			System.out.println(name);
		}
	}

	public int howMane(int a) {
		int sum = 0;

		for (String word : wordsListNames.keySet()) {
			ArrayList<String> cur = wordsListNames.get(word);
			if(cur.size() == a) {
				sum++;
			}
		}
		return sum;
	}

	public void tester() {
		buildWordMap();
		System.out.println(maxNumber());

		for (int i = 1 ; i <= 5 ; i++) {
			System.out.println(wordsInNumFiles(i));
		}

		System.out.println(howMane(4));

		System.out.println();

		printFileIn("red");
		
	}

	public static void main(String[] args) {
		(new WordsInFiles()).tester();
	}
}