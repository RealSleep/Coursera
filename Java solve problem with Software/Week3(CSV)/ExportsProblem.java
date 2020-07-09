import org.apache.commons.csv.*;
import java.io.*;

public class ExportsProblem {
	public static void listExporter(CSVParser parser, String exportOfInterest) {
		for(CSVRecord rec : parser) {
			String exportOfRec = rec.get("Exports");
			if(exportOfRec.contains(exportOfInterest)) {
				String country = rec.get("Country");
				System.out.println(country);
			}
		}
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("exportdata.csv"));
		CSVParser parser = CSVFormat.EXCEL.withHeader().parse(in);
		bigExporters(parser," $999,999,999,999");
	}

	public static String countryInfo(CSVParser parser, String country) {
		for(CSVRecord r : parser) {
			if(country.equals(r.get("Country"))) {
				return r.get("Country") +  ": " 
					 + r.get("Exports") + ": "
					 + r.get("Value (dollars)");
 			}
		}
		return "NOT FOUND";
	}

	public static void listExportersTwoProducts(CSVParser parser, String export1, String export2) {
		for(CSVRecord rec : parser) {
			String exportOfRec = rec.get("Exports");
			if(exportOfRec.contains(export1) && exportOfRec.contains(export2)) {
				String country = rec.get("Country");
				System.out.println(country);
			}
		}
	}

	public static int numberOfExporters(CSVParser parser, String exportOfInterest) {
		int count = 0;
		for(CSVRecord rec : parser) {
			String exportOfRec = rec.get("Exports");
			if(exportOfRec.contains(exportOfInterest)) {
				count++;
			}
		}
		return count;
	}

	public static void bigExporters(CSVParser parser, String value) {
		for(CSVRecord r : parser) {
			if(greater(r.get("Value (dollars)"),value)) {
				System.out.println(r.get("Country") + " "
								 + r.get("Value (dollars)"));
 			}
		}
	}

	public static boolean greater(String str1, String str2) {
		long val1 = getVal(str1);
		long val2 = getVal(str2);
		return val1>val2;
	}

	public static long getVal(String str) {
		String newStr  = "";
		for (int i = 0 ; i < str.length() ; i++ ) {
			if(Character.isDigit(str.charAt(i))) {
				newStr += str.charAt(i);
			}
		}
		return Long.parseLong(newStr);
	}	
}