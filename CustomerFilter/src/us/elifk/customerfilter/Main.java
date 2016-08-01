package us.elifk.customerfilter;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import us.elifk.customerfilter.actions.ListCustomersWithinDistanceAction;
import us.elifk.customerfilter.conversion.ConversionException;
import us.elifk.customerfilter.data.Customer;

public class Main {
	private static final Logger logger = LogManager.getLogger(Main.class.getCanonicalName());
	
	
	public static void main(String[] args) {
		try {
			List<Customer> list = ListCustomersWithinDistanceAction.listCustomersWithin100Kms();
			printList(list);
		} catch (IOException | ConversionException e) {
			logger.error(e);
		}
		
	}
	
	private static void printList(List<Customer> list) {
		for (Customer customer : list) {
			System.out.print(String.format("Customer id: %d ",customer.getUserId()));
			System.out.println(String.format("Customer name: %s",customer.getName()));
		}
		
		System.out.println("-----");
	}
}
