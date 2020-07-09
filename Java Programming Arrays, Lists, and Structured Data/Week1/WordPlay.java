public class WordPlay {
	public static void main(String[] args) {
		System.out.println(emphasize("dna ctgaaactga", 'a'));
		System.out.println(emphasize("Mary Bella Abracadabra",'a'));
	}

	public static boolean isVowel(char ch) {
		String check = "aeiou";
		return check.indexOf(Character.toLowerCase(ch)) != -1;
	}

	public static String replaceVowels(String phrase, char ch) {
		StringBuilder phraseSB = new StringBuilder(phrase);
		for (int i = 0 ; i < phrase.length() ; i++) {
			if(isVowel(phrase.charAt(i))) {
				phraseSB.setCharAt(i,ch);
			}		
		}	
		return phraseSB.toString();
	}

	public static String emphasize(String phrase, char ch) {
		StringBuilder phraseSB = new StringBuilder(phrase);
		for (int i = 0 ; i < phrase.length() ; i++) {
			if (Character.toLowerCase(phraseSB.charAt(i)) == Character.toLowerCase(ch)) {
				phraseSB.setCharAt(i , (i%2==0) ? '*':'+');
			}
		}
		return phraseSB.toString();
	}
}