package us.elifk.customerfilter.data;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest {

	@Test
	public void testDistance() {
		Location a = new Location(0.0f, 0.0f);
		Location b = new Location(90.0f, 0.0f);
		
		float distance = a.distanceTo(b);
		
		assertEquals(10000, distance, 50);
		
	}

}
