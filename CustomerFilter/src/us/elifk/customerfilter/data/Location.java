package us.elifk.customerfilter.data;

public class Location {
	private float longitudeDegrees;
	private float latitudeDegrees;
	
	public Location(float latitudeDegrees, float longitudeDegrees) {
		this.longitudeDegrees = longitudeDegrees;
		this.latitudeDegrees = latitudeDegrees;
	}
	
	public float getLongitude() {
		return longitudeDegrees;
	}

	public float getLatitude() {
		return latitudeDegrees;
	}
	
	public float distanceTo(Location other) {
		/**
		 *  a = sin²(Δφ/2) + cos φ1 ⋅ cos φ2 ⋅ sin²(Δλ/2)
		 *	c = 2 ⋅ atan2( √a, √(1−a) )
		 *	d = R ⋅ c
		 *	
		 *	R is radius of earth (mean radius = 6,371km)
		 *	φ is latitude
		 *	λ is longitude
		 */
		float radiusInKms = 6378;
		float latitude1Radians = (float)Math.toRadians(this.getLatitude());
		float latitude2Radians = (float)Math.toRadians(other.getLatitude());
		float longitude1Radians = (float)Math.toRadians(this.getLongitude());
		float longitude2Radians = (float)Math.toRadians(other.getLongitude());
		
		float deltaLatitudeRadians = latitude2Radians - latitude1Radians;
		float deltaLongitudeRadians = longitude2Radians - longitude1Radians;
		
		float sin1 = (float)Math.sin(deltaLatitudeRadians/2.0f);
		float cos1 = (float)Math.cos(latitude1Radians);
		float cos2 = (float)Math.cos(latitude2Radians);
		float sin2 = (float)Math.sin(deltaLongitudeRadians/2.0f);
		
		float a = sin1*sin1 +
					cos1 * cos2 * sin2 * sin2;
		float c = 2 * (float)Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		
		float distance = radiusInKms * c;
		
		return distance;

	}
	
}
