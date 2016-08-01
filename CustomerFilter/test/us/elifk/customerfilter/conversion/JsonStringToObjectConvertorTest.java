package us.elifk.customerfilter.conversion;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import us.elifk.customerfilter.data.Customer;
import us.elifk.customerfilter.utils.FileUtils;

public class JsonStringToObjectConvertorTest {
   
	
	@Test
	public void testConvertJsonCustomerListToCustomerList() {
		List<String> lineList = null;
		try {
			lineList = FileUtils.readAllLinesOfFile("resources//testdata-3.txt");
		} catch (IOException e) {
			fail("Test data could not be read");
		}
		
		List<Customer> customerList = null;
		try {
			customerList = JsonStringToObjectConvertor.convertJsonCustomerListToCustomerList(lineList);
		} catch (ConversionException e) {
			fail("Unexpected ConversionException received");
		}
	
		assertNotNull(customerList);
		assertEquals(7, customerList.size());
		assertEquals(12, customerList.get(0).getUserId());
	}

}
