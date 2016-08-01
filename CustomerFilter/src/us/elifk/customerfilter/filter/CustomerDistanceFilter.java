package us.elifk.customerfilter.filter;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import us.elifk.customerfilter.data.Customer;
import us.elifk.customerfilter.data.Location;

public class CustomerDistanceFilter {
	private static final Logger logger = LogManager.getLogger(CustomerDistanceFilter.class.getCanonicalName());
	
	
	public static List<Customer> filterByMaxDistanceFromLocation(List<Customer> customerList, Location location, float maxDistance) {
		List<Customer> filteredCustomers = new ArrayList<Customer>();
		
		for (Customer customer : customerList) {
			float distance = customer.getLocation().distanceTo(location); 
			
			if (distance <= maxDistance) {
				filteredCustomers.add(customer);
			}
			
			logger.error(customer + ": " + distance);
			
		}
		
		return filteredCustomers;
	}
	
	
	
}
