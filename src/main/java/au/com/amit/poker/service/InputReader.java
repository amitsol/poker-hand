package au.com.amit.poker.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
	
	public List<String> getFileContents(BufferedReader reader) {
		Scanner scanner = new Scanner(reader);
		return readContent(scanner);
	}

	private List<String> readContent(Scanner scanner) {
		List<String> retVal = new ArrayList<>();
		try {
			while(scanner.hasNextLine()) {
				String nextLine = scanner.nextLine();
				retVal.add(nextLine);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to read input", e);
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}
		return retVal;
	}

	public List<String> getFileContents(String filePath) {
		Scanner scanner = null;
		try {
			File file = new File(filePath);
			scanner = new Scanner(file);
			return readContent(scanner);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File not found or cannot read the file", e);
		} finally {
		}
	}
	

}
