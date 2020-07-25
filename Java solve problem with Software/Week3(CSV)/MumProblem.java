import org.apache.commons.csv.*;
import java.io.*;

public class MumProblem {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader data = new BufferedReader(new FileReader("data.csv"));
		BufferedReader main = new BufferedReader(new FileReader("main.csv"));

		CSVParser dataParser = CSVFormat.EXCEL.withHeader().parse(data);
		CSVParser mainParser = CSVFormat.EXCEL.withHeader().parse(main);

		print(dataParser, mainParser);
	}

	public static void print(CSVParser f, CSVParser s) {
		for (CSVRecord rec : f) {
			String first = rec.get("First");
			String second = rec.get("Second");
			String third = rec.get("Third");
			System.out.println(first+" "+second+" "+third);
			break;
		}
		for (CSVRecord rec : s) {
			
		}
	}

}