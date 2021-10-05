package sectionpark.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimingstationData {
	
	private String timingstationID;
	private String timestamp;

	private double distance;
	private String unitDistance;

	private double altitude;
	private String unitAltitude;

	private int partyID;
	private String timing;

	/**
	 * Constructor
	 */
	public TimingstationData() {
		
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		this.unitDistance = "m";
		this.unitAltitude = "hm";
		
	}
	
	/**
	 * Setter and Getter Methods
	 */
	public String getTimingstationID() {
		return timingstationID;
	}
	
	public void setTimingstationID(String timingstationID) {
		this.timingstationID = timingstationID;
	}
	
	public String getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public int getPartyID() {
		return partyID;
	}

	public void setPartyID(int partyID) {
		this.partyID = partyID;
	}

	public String getTiming() {
		return timing;
	}

	public void setTiming(String timing) {
		this.timing = timing;
	}
	/**
	 * Methods
	 */
	@Override
	public String toString() {
		String info = String.format("Timing Station Info: ID = %s, timestamp = %s, distance = %d", 
			timingstationID, timestamp, distance );
		return info;
	}
}
