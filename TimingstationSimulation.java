package sectionpark.timingstation;

import sectionpark.model.TimingstationData;
import sectionpark.model.TimingstationData.CompetitionData;

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
		data = new TimingstationData();
		data.setTimingstationID( inTimingstationID );
		data.setDistance( 1 );
		data.setAltitude( 200 );
		int anzahl = getRandomInt(1,10);
		TimingstationData.CompetitionData comp = new TimingstationData.CompetitionData();
		TimingstationData.CompetitionData.Party[] party = new TimingstationData.CompetitionData.Party[anzahl];
		for(int partys = 0; partys < anzahl; partys++) {
			party[partys] = new TimingstationData.CompetitionData.Party();
			party[partys].setPartyID(getRandomInt(1, 3000));
			String timing="";
			int stunden = getRandomInt(0, 10);
			int minuten = getRandomInt(0, 59);
			int sekunden = getRandomInt(0, 59);
			if(stunden<10){
				timing += "0"+stunden+":";
			}else{
				timing += stunden+":";
			}
			if(minuten<10){
				timing += "0"+minuten+":";
			}else{
				timing += minuten+":";
			}
			if(sekunden<10){
				timing += "0"+sekunden;
			}else{
				timing += sekunden;
			}
			party[partys].setTiming(timing);
			comp.setParty(party);
		}
		data.setCompetition(comp);
		return data;
	}
}