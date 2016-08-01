package us.elifk.customerfilter.actions;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import us.elifk.customerfilter.conversion.ConversionException;
import us.elifk.customerfilter.conversion.JsonStringToObjectConvertor;
import us.elifk.customerfilter.data.Customer;
import us.elifk.customerfilter.data.Location;
import us.elifk.customerfilter.filter.CustomerDistanceFilter;
import us.elifk.customerfilter.utils.FileUtils;

public class ListCustomersWithinDistanceAction {
    private static final Logger logger = LogManager.getLogger(ListCustomersWithinDistanceAction.class.getCanonicalName());
    
	public static List<Customer> listCustomersWithin100Kms() throws IOException, ConversionException {
		String filename = "resources//customers_01-08-2016.txt";
		float maxDistance = 100.0f;
		Location location = new Location(53.3381985f, -6.2592576f);
		
		return listCustomersWithinDistanceFromLocation(filename, maxDistance, location);
	}
	
	private static List<Customer> listCustomersWithinDistanceFromLocation(String filename, float maxDistance, Location location) 
			throws IOException, ConversionException  {
		List<String> customerLines = null;
		
		try {
			customerLines = FileUtils.readAllLinesOfFile(filename);
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw e;
		}
		
		List<Customer> customerList = JsonStringToObjectConvertor.convertJsonCustomerListToCustomerList(customerLines);
		
		List<Customer>	filteredList = CustomerDistanceFilter.filterByMaxDistanceFromLocation(customerList, location, maxDistance);
		
		Collections.sort(filteredList);
		
		return filteredList;
	}
}
