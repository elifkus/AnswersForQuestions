package us.elifk.customerfilter.actions;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import us.elifk.customerfilter.conversion.ConversionException;
import us.elifk.customerfilter.data.Location;

public class ListCustomersWithinDistanceActionTest {

	@Test
	public void testListCustomersWithinDistanceFromLocation1() {
		 String filename = "resources//testdata-2.txt";
		 Location location = new Location(0,0);
		 try {
			ListCustomersWithinDistanceAction.listCustomersWithinDistanceFromLocation(filename, 100, location);
		} catch (IOException e) {
			fail("Test should have thrown ConversionException of IOException");
		} catch (ConversionException e) {
			//Do nothing - test passed
			return;
		}
		
		fail("Test should have thrown ConversionException");
	}

	@Test
	public void testListCustomersWithinDistanceFromLocation2() {
		 String filename = "resources//testdata-1.txt";
		 Location location = new Location(0,0);
		 try {
			ListCustomersWithinDistanceAction.listCustomersWithinDistanceFromLocation(filename, 100, location);
		} catch (IOException e) {
			fail("Test shouldn't throw IOException");
		} catch (ConversionException e) {
			fail("Test shouldn't throw ConversionException");
		}
		
		return;
	}

}
