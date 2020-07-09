import org.apache.commons.csv.*;
import java.io.*;

public class BirthDays  {


	public static void main(String[] args) throws FileNotFoundException, IOException {
		BufferedReader in = new BufferedReader(new FileReader("us_babynames/us_babynames_by_year/yob1905.csv"));
		System.out.println(yearOfHighestRank("Mich","M",1880,2014));
	}

	public static void totalBirths(BufferedReader in) throws IOException {
		int total = 0;
		int totalM = 0;
		int totalF = 0;
		for(CSVRecord r : CSVFormat.EXCEL.parse(in)) {
			if((r.get(1)).equals("M")) {
				totalM ++;//= Integer.parseInt(r.get(2));
			}else {
				totalF ++;//= Integer.parseInt(r.get(2));
			}
			total += Integer.parseInt(r.get(2));
		}
		System.out.printf("total = %d\ntotalM = %d\ntotalF = %d\n",total,totalM,totalF);
	}
	
	public static int getRank(String year, String name, String gender) throws IOException  {
		BufferedReader in = new BufferedReader(new FileReader("us_babynames/us_babynames_by_year/yob"+year+".csv"));
		int countM = 1;
		int countF = 1;
		for(CSVRecord r : CSVFormat.EXCEL.parse(in)) {
			if(r.get(0).equals(name) && r.get(1).equals(gender)) {
				return (gender.equals("M"))? countM:countF;
			}

			if((r.get(1)).equals("M")) {
				countM++;
			}else {
				countF++;
			}
			
		}
		return -1;
	}

	public static String getName(String year, String rank, String gender) throws IOException  {
		BufferedReader in = new BufferedReader(new FileReader("us_babynames/us_babynames_by_year/yob"+year+".csv"));
		int countM = 1;
		int countF = 1;
		for(CSVRecord r : CSVFormat.EXCEL.parse(in)) {

			if((rank.equals(countF+"") || rank.equals(countM+"")) && r.get(1).equals(gender)) {
				return r.get(0);
			}

			if((r.get(1)).equals("M")) {
				countM++;
			}else {
				countF++;
			}
			
		}
		return "NO NAME";
	}

	public static void whatIsNameInYear(String name, String year, String newYear, String gender) throws IOException  {
		BufferedReader in = new BufferedReader(new FileReader("us_babynames/us_babynames_by_year/yob"+year+".csv"));
		BufferedReader inNew = new BufferedReader(new FileReader("us_babynames/us_babynames_by_year/yob"+newYear+".csv"));
		String newName = "";
		int countM = 1;
		int countF = 1;
		for(CSVRecord r : CSVFormat.EXCEL.parse(in)) {
			if(r.get(0).equals(name) && r.get(1).equals(gender)) {
				break;
			}
			if((r.get(1)).equals("M")) {
				countM++;
			}else {
				countF++;
			}
			
		}
		newName = getName(newYear,((gender.equals("M"))? countM+"":countF+""),gender);
		System.out.println(name + " born in " + year + " would be " + newName + " if she was born in " + newYear + ".");
	}

	public static int yearOfHighestRank(String name, String gender, int start, int end) throws IOException {
		int min = Integer.MAX_VALUE;
		int minYear = Integer.MAX_VALUE;
		for(int i = start; i <= end; i++) {
			BufferedReader in = new BufferedReader(new FileReader("us_babynames/us_babynames_by_year/yob"+i+".csv"));
			int countM = 1;
			int countF = 1;
			boolean here = true;
			for(CSVRecord r : CSVFormat.EXCEL.parse(in)) {
				if(r.get(0).equals(name) && r.get(1).equals(gender)) {
					here = false;
					int dif = ((gender.equals("M"))? countM:countF);
					//System.out.println(dif);
					if(min > dif) {
						min = dif;
						minYear = i;
					}
				}
				if((r.get(1)).equals("M")) {
					countM++;
				}else {
					countF++;
				}}
			// }
			// if(here) {
			// 	return -1;
			// }

		}
		return minYear;
	}

	public static double getAverageRank(String name, String gender, int start, int end) throws IOException {
		int min = Integer.MAX_VALUE;
		int minYear = Integer.MAX_VALUE;
		int mean = 0;
		for(int i = start; i <= end; i++) {
			BufferedReader in = new BufferedReader(new FileReader("us_babynames/us_babynames_by_year/yob"+i+".csv"));
			int countM = 1;
			int countF = 1;
			boolean here = true;
			for(CSVRecord r : CSVFormat.EXCEL.parse(in)) {
				if(r.get(0).equals(name) && r.get(1).equals(gender)) {
					here = false;
					int dif = ((gender.equals("M"))? countM:countF);
					mean += dif;
				}
				if((r.get(1)).equals("M")) {
					countM++;
				}else {
					countF++;
				}
			}
			if(here) {
				return -1;
			}

		}
		return mean*1.0/(end-start+1);
	}

	public static int getTotalBirthsRankedHigher(String year, String name, String gender) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("us_babynames/us_babynames_by_year/yob"+year+".csv"));
		int total = 0;
		for(CSVRecord r : CSVFormat.EXCEL.parse(in)) {
			if(r.get(0).equals(name) && r.get(1).equals(gender)) {
				break;
			}
			if(r.get(1).equals(gender)) {
				total += Integer.parseInt(r.get(2));
			}
		}

		return total;
	}

}