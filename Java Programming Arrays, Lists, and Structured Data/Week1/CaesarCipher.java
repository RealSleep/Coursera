import java.io.File;
import java.util.Scanner;

public class CaesarCipher  {
	
	public static void main(String[] args) throws java.io.FileNotFoundException {
		File file = new File("mysteryTwoKeysPractice.txt");
		Scanner read = new Scanner(file);
		String all = "";

		while(read.hasNext()) {
			all += read.next() + " ";
		}

		// System.out.println(decryptTwoKeys(all));	
		// String mess = "Hello My dear frinedS";
		// String mess = "Akag tjw Xibhr awoa aoee xakex znxag xwko";
		// System.out.println(encryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.", 26-14,26-24));
		// System.out.println(mess);
		System.out.println(decryptTwoKeys(all));	
		// System.out.println(encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?",21,8));
	}

	public static String encrypt(String input, int key) {
		StringBuilder message = new StringBuilder(input);

		String alphabet = "";

		for (int i =0;i<26 ;i++ ) {
			alphabet += (char)('A'+i);
		}

		String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);

		for (int i = 0 ; i < message.length() ; i++) {
			char currChar = message.charAt(i);
			boolean isUpper = Character.isUpperCase(currChar);
			int idx = alphabet.indexOf(Character.toUpperCase(currChar));
			if (idx != -1 ) {
				char newChar = shiftedAlphabet.charAt(idx);
				if(!isUpper)
					newChar = Character.toLowerCase(newChar);
				message.setCharAt(i, newChar);
			}
		}

		return message.toString();
	}

	public static String encryptTwoKeys(String input, int key1, int key2) {

		String encrypt1 = encrypt(input,key1);
		String encrypt2 = encrypt(input,key2);

		StringBuilder encrypted = new StringBuilder(input);
 
	    for (int i=0; i< input.length();i=i+1){
	        if (isEven(i))
	            encrypted.setCharAt(i, encrypt1.charAt(i));
	            
	        if (!isEven(i))
	        	encrypted.setCharAt(i, encrypt2.charAt(i));
	    }

		return encrypted.toString();
	}

	public static String decryptTwoKeys(String encrypted) {

		String message1 = halfOfString(encrypted,0);
		String message2 = halfOfString(encrypted,1);
		StringBuilder theAnswer = new StringBuilder(encrypted);
		int key1= getKey(message1);
		int key2= getKey(message2);


		String d_message1= encrypt(message1,(26-key1));
		String d_message2= encrypt(message2,(26-key2));
			
		System.out.println(key1);
		System.out.println(key2);

		for (int k=0; k<(message1.length());k++){
			theAnswer.setCharAt((2*k), d_message1.charAt(k) );
		}

		for (int k=0; k<(message2.length());k++){
			theAnswer.setCharAt((2*k)+1, d_message2.charAt(k) );
		}

		return theAnswer.toString();       
	}

	public String decrypt(String encrypted){
		int key = getKey(encrypted);
		return encrypt(encrypted,(26-key));
    }

	public static String halfOfString(String message, int start){
       String halfMessage = "";
        for (int i= start; i<message.length(); i=i+2){
           halfMessage = halfMessage + message.charAt(i);
        }
        return halfMessage;
    }

    public static int getKey(String e_message){
       int[] freqs = countLetters(e_message);
       int maxDex = maxIndex(freqs);
       int dkey = maxDex-4;
       if (maxDex < 4) {
           dkey = 26 - (4-maxDex);
        }
        return dkey;
    }
    

		public static int[] countLetters(String message) {
		char[] chs = message.toCharArray();
		int[] alph = new int[26];

		for (char ch : chs) {
			ch = Character.toLowerCase(ch);
			if ( Character.isLetter(ch))
				alph[ch - 'a']++;
		}

		return alph;
	}

	public static int maxIndex(int[] arr) {
		int index = 0;
		int max = arr[index]; 

		for (int i = 1 ; i < arr.length ; i++) {
			if(arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}

		return index;
	}

	public static String getHalfOfString(String str, int start) {
		String strRet = "";

		for (int i = start ; i < str.length() ; i+=2) {
			strRet += str.charAt(i);
		}

		return strRet;
	}

	public static boolean isEven(int n){
    	if ((n % 2) == 0) 
    		return true;
    	else
    	 	return false; 
	}
}