import java.io.File;
import java.util.Scanner;

public class WordLengths {
	
	public static void main(String[] args) throws java.io.FileNotFoundException {
		countWordLengths(new File("manywords.txt"), 20);
	}

	public static void countWordLengths(File file, int count) throws java.io.FileNotFoundException {
		Scanner read = new Scanner(file);
		String all = "";

		while(read.hasNext()) {
			all += read.next() + " ";
		}

		String[] words = all.split(" ");

		int[] counts = new int[count+1];
		
		for (String word : words) {  	
			int wordlength = word.length();

			if (wordlength >= counts.length) {  	    	   
				wordlength = counts.length - 1;  	  	
			}

			wordlength = check(word);
			
			if (wordlength > 0 ) {  	   	   
				counts[wordlength] ++;  	  	
			}
		}

		System.out.println(java.util.Arrays.toString(words));
		System.out.println(java.util.Arrays.toString(counts));
		
	}

	public static int check(String word) {
		int wordlength = word.length();
		boolean first = !Character.isLetter(word.charAt(0));
		boolean last = !Character.isLetter(word.charAt(word.length()-1));
		boolean quates = word.charAt( word.length()-1 ) == '"';
		if (quates || (first && last)) {
			wordlength -= 2;
		} else if (first || last) {      
			wordlength--; 
		}
		return wordlength;
	}
}







