package us.elifk.customerfilter.filter;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import us.elifk.customerfilter.data.Location;

public class CustomerDistanceFilterTest {
	private CustomerDistanceFilter filter;
	
	@Before
	public void setUp() throws Exception {
		this.filter = new CustomerDistanceFilter();
	}

	
	@Test
	public void testCalculateDistance() {
		Location location1 = new Location(53.3381985f, -6.2592576f);
		Location location2 = new Location(54.0894797f, -6.18671f);
		double expected = 83.67495313536664d;
		
		double distance = 0;//this.filter.calculateDistance(location1, location2);
		Assert.assertEquals(expected, distance, 0.00001d);
	}

}
