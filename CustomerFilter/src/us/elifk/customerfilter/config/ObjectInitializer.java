package us.elifk.customerfilter.config;

import us.elifk.customerfilter.actions.ListCustomersWithinDistanceAction;
import us.elifk.customerfilter.conversion.JsonStringToObjectConvertor;
import us.elifk.customerfilter.filter.CustomerDistanceFilter;

public class ObjectInitializer {
	private static ListCustomersWithinDistanceAction action;
	
	public static void init() {
		action = new ListCustomersWithinDistanceAction();
		
		JsonStringToObjectConvertor convertor = new JsonStringToObjectConvertor();
		action.setJsonStringToObjectConvertor(convertor);
		
		CustomerDistanceFilter filter = new CustomerDistanceFilter();
		action.setCustomerDistanceFilter(filter);
	}
	
	public static ListCustomersWithinDistanceAction getListCustomersWithinDistanceAction() {
		return action;
	}
}
