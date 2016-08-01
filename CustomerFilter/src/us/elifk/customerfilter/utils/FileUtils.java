package us.elifk.customerfilter.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for File utilities
 * @author elif
 *
 */
public class FileUtils {
	
	/**
	 * Method that reads string from a file line by line and returns a List
	 * of Strings containing each line.
	 * @param filename
	 * @return list of line strings
	 * @throws IOException
	 */
	public static List<String> readAllLinesOfFile(String filename) throws IOException {
		List<String> lineList = new ArrayList<String>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
		    String line = reader.readLine();

		    while (line != null) {
			    lineList.add(line);
		    	line = reader.readLine();
		    }
		}
		
		return lineList;
	}
	
}
