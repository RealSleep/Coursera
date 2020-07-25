import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;

public class WordFrequencies {

	private ArrayList<String> myWords;
	private ArrayList<Integer> myFreqs;
	private String name_file;

	public WordFrequencies(String name_file) {
		myWords = new ArrayList<>();
		myFreqs = new ArrayList<>();
		this.name_file = name_file;
	}

	public void findUnique() throws java.io.FileNotFoundException {
		myWords.clear();
		myFreqs.clear();

		File file = new File(name_file);
		Scanner read = new Scanner(file);
		String all = "";

		while (read.hasNext()) {
			all += (read.next()).trim() + " ";
		}

		String[] split = all.split(" ");

		for (String str : split) {

			str = str.toLowerCase();
			int index = myWords.indexOf(str);

			if ( index == -1 ) {
				myWords.add(str);
				myFreqs.add(1);
			} else {
				int val = myFreqs.get(index);
				myFreqs.set(index, ++val);
			}
		}
	}

	public int findindexOfMax() {
		int index = 0;
		int max = myFreqs.get(index);

		for (int i = 0; i < myFreqs.size(); i++) {
			if (myFreqs.get(i) > max) {
				max = myFreqs.get(i);
				index = i;
			}
		}

		return index;
	}

	public void test() throws java.io.FileNotFoundException {
		findUnique();
		System.out.println("Number of unique words: " + myWords.size());
		for (int k = 0; k < myWords.size(); k++) {
			System.out.println(myFreqs.get(k) + " " + myWords.get(k));
		}

		int k = findindexOfMax();

		System.out.println("The word that occurs most often and its count are: " + myWords.get(k) + " " + myFreqs.get(k));
	}

	public static void main(String[] args) throws java.io.FileNotFoundException {
		WordFrequencies wf = new WordFrequencies("likeit.txt");
		wf.test();
	}
}