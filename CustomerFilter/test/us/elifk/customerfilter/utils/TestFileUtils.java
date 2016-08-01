package us.elifk.customerfilter.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

public class TestFileUtils {

	@Test
	public void testReadFile() {
		String folderName = "resources";
		String fileName = "customers_01-08-2016.txt";
		String path = folderName + File.separator + fileName;
		int expectedSize = 32;
		String expectedFirstLine = "{\"latitude\": \"52.986375\", \"user_id\": 12, \"name\": \"Christina McArdle\", \"longitude\": \"-6.043701\"}";
		
		List<String> lineList = null;
		
		try {
			lineList = FileUtils.readFile(path);
		} catch (IOException e) {
			Assert.fail(e.getMessage());
		}
		
		Assert.assertNotNull(lineList);
		Assert.assertEquals(expectedSize, lineList.size());	
		Assert.assertEquals(expectedFirstLine, lineList.get(0));
	}

}
