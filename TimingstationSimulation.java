package sectionpark.timingstation;

import sectionpark.model.TimingstationData;

public class TimingstationSimulation {
	
	private double getRandomDouble( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		double rounded = Math.round(number * 100.0) / 100.0; 
		return rounded;
		
	}

	private int getRandomInt( int inMinimum, int inMaximum ) {

		double number = ( Math.random() * ( (inMaximum-inMinimum) + 1 )) + inMinimum; 
		Long rounded = Math.round(number); 
		return rounded.intValue();

	}
	
	public TimingstationData getData( String inTimingstationID ) {
		
		TimingstationData data = new TimingstationData();
		data.setTimingstationID( inTimingstationID );
		data.setDistance( 1 );
		data.setAltitude( 200 );
		data.setPartyID(getRandomInt(1, 3000));
		data.setTiming("00:29:26");
		return data;
		
	}

}
