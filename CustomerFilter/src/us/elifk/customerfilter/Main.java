package us.elifk.customerfilter;

import java.util.List;

import us.elifk.customerfilter.actions.ListCustomersWithinDistanceAction;
import us.elifk.customerfilter.config.ObjectInitializer;
import us.elifk.customerfilter.data.Customer;

public class Main {

	public static void main(String[] args) {
		ObjectInitializer.init();
		ListCustomersWithinDistanceAction action = ObjectInitializer.getListCustomersWithinDistanceAction();
		
		List<Customer> list = action.listCustomersWithin100Kms();
		printList(list);
	}
	
	private static void printList(List<Customer> list) {
		for (Customer customer : list) {
			System.out.print(String.format("Customer id: %d ",customer.getUserId()));
			System.out.println(String.format("Customer name: %s",customer.getName()));
		}
	}
}
