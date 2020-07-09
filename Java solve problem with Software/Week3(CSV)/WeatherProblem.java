import org.apache.commons.csv.*;
import java.io.*;

public class WeatherProblem {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		File f = fileWithColdestTemperature();
		BufferedReader in = new BufferedReader(new FileReader(f));
		CSVParser parser = CSVFormat.EXCEL.withHeader().parse(in);
		CSVRecord csv = coldestHourInFile(parser);
		System.out.println(csv.get("TemperatureF"));
				// System.out.println(averageTemperatureInFile(parser));
		// double num = averageTemperatureWithHighHumidityInFile(parser,80);
		// if("NaN".equals(num+""))
		// 	System.out.println("No temperatures with that humidity");
		// else
		// 	System.out.println(num);

	}

	public static double averageTemperatureWithHighHumidityInFile(CSVParser parser,int val) {
		int count = 0;
		double sum = 0;
		for(CSVRecord r : parser) {
			String s = r.get("Humidity");
			if(!s.equals("N/A") && Integer.parseInt(r.get("Humidity")) >= val){
				count++;
				sum += Double.parseDouble(r.get("TemperatureF"));
			}
			
		}
		return sum/count;
	}

	public static double averageTemperatureInFile(CSVParser parser) {
		int count = 0;
		double sum = 0;
		for(CSVRecord r : parser) {
			count++;
			sum += Double.parseDouble(r.get("TemperatureF"));
			
		}
		return sum/count;
	}

	public static CSVRecord lowestHumidityInFile(CSVParser parser) {
		CSVRecord max = null;

		for(CSVRecord r : parser) {
			max = getMaxH(r,max);
		}
		return max;
	}

	public static File fileWithColdestTemperature() throws FileNotFoundException, IOException {
		CSVRecord max = null;
		File maxFile = null;
		File f = new File("nc_weather/2013");

		for(File ff : f.listFiles()) {
			BufferedReader in = new BufferedReader(new FileReader(ff));
			CSVParser parser = CSVFormat.EXCEL.withHeader().parse(in);
			CSVRecord current = coldestHourInFile(parser);
			Object[] s = getMax(current,max,ff,maxFile);
			max = (CSVRecord)s[0];
			maxFile = (File)s[1];
		}
		return maxFile;
	}

	public static CSVRecord fileWithColdestTemperatureH() throws FileNotFoundException, IOException {
		CSVRecord max = null;
		File maxFile = null;
		File f = new File("nc_weather/2013");

		for(File ff : f.listFiles()) {
			BufferedReader in = new BufferedReader(new FileReader(ff));
			CSVParser parser = CSVFormat.EXCEL.withHeader().parse(in);
			CSVRecord current = lowestHumidityInFile(parser);
			max = getMaxH(current,max);
		}
		return max;
	}

	public static CSVRecord coldestHourInFile(CSVParser parser) {
		CSVRecord max = null;

		for(CSVRecord r : parser) {
			max = getMax(r,max);
		}
		return max;
	}

	public static CSVRecord getMax(CSVRecord curr, CSVRecord max) {
		if(max == null) {
			max = curr;
		}else{
			double currTemp = Double.parseDouble(curr.get("TemperatureF"));
			double maxTemp = Double.parseDouble(max.get("TemperatureF"));
			if(currTemp < maxTemp) {
				max = curr;
			}
		}
		return max;
	}

	public static CSVRecord getMaxH(CSVRecord curr, CSVRecord max) {
		if(max == null) {
			max = curr;
		}else{
			try{
				double currTemp = Double.parseDouble(curr.get("Humidity"));
				double maxTemp = Double.parseDouble(max.get("Humidity"));
				if(currTemp < maxTemp) {
					max = curr;
				}
			}catch (Exception e) {
				
			}
		}
		return max;
	}

	
	public static Object[] getMax(CSVRecord curr, CSVRecord max,File cur,File maxF) {
		Object[] s = new Object[2];
		if(max == null) {
			max = curr;
			maxF = cur;
		}else{
			double currTemp = Double.parseDouble(curr.get("TemperatureF"));
			double maxTemp = Double.parseDouble(max.get("TemperatureF"));
			if(currTemp < maxTemp) {
				max = curr;
				maxF = cur;
			}
		}
		s[0] = max;
		s[1] = maxF;
		return s;
	}

}