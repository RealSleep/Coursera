import java.util.HashMap;
import java.util.Scanner;

public class CodonCount {

	private HashMap<String, Integer> codonCount;

	public CodonCount() {
		codonCount = new HashMap<>();
	}

	public void buildCodonMap(int start, String dna) {
		codonCount.clear();
		for (int i = start ; i < dna.length() ; i += 3) {
			if (i + 3 >= dna.length())
				break;
			String codon = dna.substring(i, i + 3);
			if (!codonCount.containsKey(codon)) {
				codonCount.put(codon , 1);
				continue;
			}
			codonCount.put(codon, codonCount.get(codon) + 1);
		}
	}

	public String getMostCommonCodon() {
		int countMax = 0;
		String codonMax = "";
		for (String codon : codonCount.keySet()) {
			int count = codonCount.get(codon);
			if (countMax < count) {
				countMax = count;
				codonMax = codon;
			}
		}
		return codonMax;
	}

	public void printCodonCounts(int start, int end) {
		System.out.printf("Counts of codons between %d and %d inclusive are: ", start, end);
		System.out.println();
		for (String codon : codonCount.keySet()) {
			int count = codonCount.get(codon);
			if (count >= start && count <= end) {
				System.out.println(codon + "  " + count);
			}
		}
	}	

	public void test() {
		String dna = readDNA();
		for (int i = 0 ; i < 3 ; i++) {
			buildCodonMap(i, dna);
			int len = codonCount.size();			
			String maxC = getMostCommonCodon();
			int max = codonCount.get(maxC);
			System.out.printf("Reading frame starting with %d results in %d unique codons and most common codon is %s with count %d", i, len, maxC, max);
			System.out.println();
			printCodonCounts(5, 6);
		}
		// buildCodonMap(0,dna);
		// System.out.println(getMostCommonCodon());
		// System.out.println(codonCount.get(getMostCommonCodon()));
	}

	public String readDNA() {
		String s = "";
		
		try {

			Scanner read = new Scanner(new java.io.File("dnaMystery1.txt"));

			while (read.hasNext()) {
				s += read.next() + " ";
			}

		} catch (Exception e) {
			
		}
			
		return s;

	}

	public static void main(String[] args) {
		CodonCount cc = new CodonCount();
		cc.test();
	}
}