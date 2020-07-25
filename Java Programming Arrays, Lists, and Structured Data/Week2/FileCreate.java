import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class FileCreate {

	static String[] pattern = { 
		"cats are funny and cute",
		"dogs are silly",
		"love animals cats and dogs",
		"love birds and cats"};

	public static void main(String[] args) throws FileNotFoundException {
		for (int i = 1 ; i < 5 ; i++) {
			File f = new File("brief"+i+".txt");
			PrintWriter pw = new PrintWriter(f);
			pw.print(pattern[i-1]);
			pw.close();
		}
	}
}