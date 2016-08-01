package us.elifk.customerfilter.conversion;

import java.util.ArrayList;
import java.util.List;

import us.elifk.customerfilter.data.Customer;

import com.google.gson.Gson;

public class JsonStringToObjectConvertor {
	
    public List<Customer> readFileIntoCustomerList(List<String> lineList) {
		
		List<Customer> customerList = new ArrayList<Customer>(lineList.size());
		
		Gson gson = new Gson();
		
		for (String line : lineList) {
			Customer customer = gson.fromJson(line, Customer.class);
			customerList.add(customer);
		}
		
		return customerList;
	}
	
		
}
