package us.elifk.customerfilter.actions;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import us.elifk.customerfilter.conversion.JsonStringToObjectConvertor;
import us.elifk.customerfilter.data.Customer;
import us.elifk.customerfilter.data.Location;
import us.elifk.customerfilter.filter.CustomerDistanceFilter;
import us.elifk.customerfilter.utils.FileUtils;

public class ListCustomersWithinDistanceAction {
	//TODO: Move hardcoded string to constants file
    private static final Logger logger = LogManager.getLogger("CustomerFilter");
    
    //Object dependencies
    private JsonStringToObjectConvertor convertor;
    public void setJsonStringToObjectConvertor(JsonStringToObjectConvertor convertor) {
    	this.convertor = convertor;
    }
    
    private CustomerDistanceFilter filter;
    public void setCustomerDistanceFilter(CustomerDistanceFilter filter) {
    	this.filter = filter;
    }
    
	public List<Customer> listCustomersWithin100Kms() {
		String filename = "resources//customers_01-08-2016.txt";
		float distance = 100.0f;
		Location location = new Location(0f,0f);
		
		return listCustomersWithinDistanceFromLocation(filename, distance, location);
	}
	
	private List<Customer> listCustomersWithinDistanceFromLocation(String filename, float distance, Location location)  {
		List<String> customerLines = null;
		
		try {
			customerLines = FileUtils.readFile(filename);
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
		
		List<Customer> customerList = null;
		
		if (customerLines != null) {
			 customerList = this.convertor.readFileIntoCustomerList(customerLines);
		}
		
		List<Customer> filteredList = null;
		
		if (customerList != null) {
			filteredList = this.filter.filterByDistance(customerList, location, distance);
		}
		
		return filteredList;
	}
}
