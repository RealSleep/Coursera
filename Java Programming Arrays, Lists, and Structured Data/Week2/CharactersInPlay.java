import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;

public class CharactersInPlay {

	private ArrayList<String> names;
	private ArrayList<Integer> counts;
	private String name_file;

	public CharactersInPlay(String name_file) {
		names = new ArrayList<>();
		counts = new ArrayList<>();
		this.name_file = name_file;
	}

	public void update(String person) {
		int index = names.indexOf(person);
		
		if( index == -1) {
			names.add(person);
			counts.add(1);
			return;
		}

		counts.set(index, counts.get(index)+1);

	}

	public void findAllCharacters() throws java.io.FileNotFoundException {

		File file = new File(name_file);
		Scanner read = new Scanner(file);
		String all = "";

		while (read.hasNext()) {
			all += read.nextLine() + "\t\t";
		}

		String[] split = all.split("\t\t");
	
		for (String line : split) {
			int indexOfDot = line.indexOf(".");
			if (indexOfDot != -1) {
				String person = line.substring(0, indexOfDot);
				update(person);
			}
		}

	}

	public void charactersWithNumParts(int num1, int num2) {
		for(int i = 0; i < names.size(); i++) {
			int count = counts.get(i);
			if (count >= num1 && count <= num2) {
				System.out.println(names.get(i) + " " +count);
			}
		}
	}

	public int findindexOfMax() {
		int index = 0;
		int max = counts.get(index);

		for (int i = 0; i < names.size(); i++) {
			if (counts.get(i) > max) {
				max = counts.get(i);
				index = i;
			}
		}

		return index;
	}

	public void test() throws java.io.FileNotFoundException {
		findAllCharacters();
		for(int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i) + " " + counts.get(i));
		}

		charactersWithNumParts(10,15);


		int k = findindexOfMax();

		System.out.println("The word that occurs most often and its count are: " + names.get(k) + " " + counts.get(k));
	}

	public static void main(String[] args) throws java.io.FileNotFoundException {
		CharactersInPlay cip = new CharactersInPlay("likeit.txt");
		cip.test();
	}

}