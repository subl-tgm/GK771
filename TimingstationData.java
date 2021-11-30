package sectionpark.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;

public class TimingstationData {
	
	private String timingstationID;
	private String timestamp;

	private double distance;
	private String unitDistance;

	private double altitude;
	private String unitAltitude;
	private CompetitionData comp;

	/**
	 * Constructor
	 */
	public TimingstationData() {
		
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
		this.unitDistance = "m";
		this.unitAltitude = "hm";
		this.comp = new CompetitionData();

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
	
	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	public double getAltitude() {
		return altitude;
	}

	public void setAltitude(double altitude) {
		this.altitude = altitude;
	}

	public CompetitionData getCompetition() {
		return this.comp; 
	}

	public void setCompetition(CompetitionData compd){
		this.comp = compd; 
	}

	/**
	 * Methods
	 */
	@Override
	public String toString() {
		String info = String.format("Timing Station Info: ID = %s, timestamp = %s, distance = %d", 
			timingstationID, timestamp, distance);
		return info;
	}

	public static class CompetitionData {

		private String unitTiming;
		private Party[] party;

		public CompetitionData() {
			this.unitTiming = "hh:mm:ss";
			this.party = new Party[0];
		}

		public String getUnitTiming(){ 
			return this.unitTiming; 
		}

		public Party[] getParty(){ 
			return this.party; 
		}

		public void setParty(Party[] party){
			this.party = party;
		}

		public static class Party {

			private int partyID;
			private String timing;

			public Party() {
				this.partyID = 0;
				this.timing = "";
			}

			public int getPartyID(){
				return this.partyID;
			}

			public void setPartyID(int partyID){
				this.partyID = partyID; 
			}

			public String getTiming(){
				return this.timing;
			}

			public void setTiming(String timing){
				this.timing += timing; 
			}

		}

	}
}