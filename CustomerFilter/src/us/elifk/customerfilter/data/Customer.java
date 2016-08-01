package us.elifk.customerfilter.data;

public class Customer implements Comparable<Customer>{
	private int userId;
	private String name;
	
	private Location location;
	
	public Customer(int userId, String name, float latitude, float longitude) {
		this.location = new Location(latitude, longitude);
		this.userId = userId;
		this.name = name;
	}
	
	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public float getLatitude() {
		return this.location.getLatitude();
	}
	
	public float getLongitude() {
		return this.location.getLongitude();
	}
	
	public Location getLocation () {
		return this.location;
	}
	
	@Override
	public String toString() {
		return "[" + this.userId + "] " + this.name + "(" + this.location.getLatitude() + ", " + this.location.getLongitude();  
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		
		Customer other = (Customer)obj;
		return this.userId == other.getUserId();
	}

	@Override
	public int compareTo(Customer other) {
		return this.userId - other.getUserId();
	}
	
	@Override
	public int hashCode() {
		return this.userId;
	}
	
}
