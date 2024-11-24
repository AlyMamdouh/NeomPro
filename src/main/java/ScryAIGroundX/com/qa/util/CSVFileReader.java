package ScryAIGroundX.com.qa.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVFileReader {

	public static CSVRecord readFromCsv(String testCaseName, String path) throws IOException {
//		FileReader in = new FileReader("C:\\Users\\srikanth_mallela\\eclipse-workspace\\ScryAIGroundX\\src\\main\\resources\\testData\\GroundXLoginPageTestCases.csv",
//				StandardCharsets.UTF_8);
//		
		File file = new File(path);
		FileReader in = new FileReader(file, StandardCharsets.UTF_8);
		CSVFormat cSVFormat = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(false).build();
		Iterable<CSVRecord> records = CSVParser.parse(in, cSVFormat);
		for (CSVRecord testData : records) {

			if (testCaseName.equalsIgnoreCase(testData.get("Test Case Name"))) {
				return testData;
			}
		}
		return null;
	}
}
