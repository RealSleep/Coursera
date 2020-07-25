import java.util.HashMap;
import edu.duke.*;

public class DNAProblem {

	private HashMap<String, Integer> codonCount;
	private String source;

	public DNAProblem(String source) {
		codonCount = new HashMap<>();
		this.source = source;
	}

	public void buildCodonMap(int start, String dna) {
		codonCount.clear();
		for (int i = start; i < dna.length() ; i += 3) {
			if ( i + 3 > dna.length())
				break;
			String codon = dna.substring(i, i + 3);
			
			if (!codonCount.containsKey(codon)) {
				codonCount.put(codon,1);
			} else {
				int val = codonCount.get(codon) + 1;
				codonCount.put(codon, val);
			}
		}
	}

	public String getMostCommonCodon() {
		int max = 0;
		String most = "";

		for (String codon : codonCount.keySet()) {
			int some = codonCount.get(codon);
			if ( some > max) {
				max = some;
				most = codon;
			}
		}
		return most;
	}

	public void printCodonCounts(int start, int end) {
		for (String codon : codonCount.keySet()) {
			int count = codonCount.get(codon);
			if (count >= start && count <= end) {
				System.out.println("Codon: " + codon + " Times: " + count);
			}
		}
	}

	public void test() {
		String dna = readIt();
		int start = 1;
		int end = 5;
		for (int i = 0; i < 3; i++) {
			buildCodonMap(i, dna);
			String most = getMostCommonCodon();
			System.out.printf("Reading frame starting with %d results in %d unique codons and most common codon is %s with count %d\nCounts of codons between %d and %d inclusive are:\n", i, codonCount.size(), most, codonCount.get(most), start, end);
			printCodonCounts(start, end);
		}
	}

	private String readIt(){
		String list = "";
		FileResource resource = new FileResource(source);
		for(String line : resource.lines()){
			list += line.trim();
		}
		return list;
	}

}