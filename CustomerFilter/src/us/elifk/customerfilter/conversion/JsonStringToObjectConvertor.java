package us.elifk.customerfilter.conversion;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import us.elifk.customerfilter.data.Customer;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

public class JsonStringToObjectConvertor {
	
	private static final Logger logger = LogManager.getLogger(JsonStringToObjectConvertor.class.getCanonicalName());
	
	/**
	 * Convert a list of Strings containing Json format Customer objects
	 * to a list of Customer objects.
	 * 
	 * @param lineList List of strings, each one containing a Json format customer.
	 * @return the list of Customer objects.
	 */
    public static List<Customer> convertJsonCustomerListToCustomerList(List<String> lineList) throws ConversionException {
    	
    	try {
			List<Customer> customerList = new ArrayList<Customer>(lineList.size());
			
			Gson gson = new Gson();
			
			for (String line : lineList) {
				ExternalCustomer externalCustomer = gson.fromJson(line, ExternalCustomer.class);
				customerList.add(convertExternalCustomerToCustomer(externalCustomer));
			}
			
			return customerList;

    	} catch (JsonParseException e) {
    		logger.error(e);
    		throw new ConversionException("Exception converting Json Customer List to Customer List", e);
    	}
	}
    
    private static Customer convertExternalCustomerToCustomer(ExternalCustomer externalCustomer) {
    	return new Customer(externalCustomer.user_id, externalCustomer.name, 
    			            externalCustomer.latitude, externalCustomer.longitude);
    }
	
		
}
