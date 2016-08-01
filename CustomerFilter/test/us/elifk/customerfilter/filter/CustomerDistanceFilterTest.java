package us.elifk.customerfilter.filter;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import us.elifk.customerfilter.conversion.ConversionException;
import us.elifk.customerfilter.conversion.JsonStringToObjectConvertor;
import us.elifk.customerfilter.data.Customer;
import us.elifk.customerfilter.data.Location;
import us.elifk.customerfilter.utils.FileUtils;

public class CustomerDistanceFilterTest {
	private static List<Customer> customerList;

    @BeforeClass
    public static void setup() {
        try {
			List<String> lineList = FileUtils.readAllLinesOfFile("resources//testdata-3.txt");
			customerList = JsonStringToObjectConvertor.convertJsonCustomerListToCustomerList(lineList);

		} catch (IOException | ConversionException e) {
			fail("Setup failed");
		}
    }
	@Test
	public void testFilterByMaxDistanceFromLocation() {
        Location location = new Location(0,0);
        float maxDistance = 6000;
		List<Customer> filteredList = CustomerDistanceFilter.filterByMaxDistanceFromLocation(customerList, location, maxDistance);

	    assertNotNull(filteredList);
	    assertEquals(4, filteredList.size());
	    
	}

}
