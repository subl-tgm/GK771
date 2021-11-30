package sectionpark.timingstation;

import sectionpark.model.TimingstationData;
import sectionpark.model.TimingstationData.CompetitionData;

public class TimingstationSimulation {
	
	private TimingstationData.CompetitionData.Party[] array;

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
		int anzahl = 10;
		TimingstationData.CompetitionData comp = new TimingstationData.CompetitionData();
		TimingstationData.CompetitionData.Party[] party = new TimingstationData.CompetitionData.Party[anzahl];
		for(int partys = 0; partys < anzahl; partys++) {
			party[partys] = new TimingstationData.CompetitionData.Party();
			party[partys].setPartyID(getRandomInt(1, 3000));
			String timing="";
			int stunden = getRandomInt(0, -1);
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

	public String htmlDaten( TimingstationData td ){
		TimingstationData data = td;
		String id = data.getTimingstationID();
		String time = data.getTimestamp();
		String daten="<!DOCTYPE html><html><style>table, th, td {border:1px solid black;}</style><body>";
		daten += "<p>TimingstationID: "+id+", Timestamp: "+time+", Distance: 1.0, Altitude: 200.0, unitTiming: hh:mm:ss</p>";
		daten += "<h2>Partys Tabelle</h2>";
		daten += "<table style=\"width:50%\"><tr><th>PartyID</th><th>Timing</th></tr>";
		TimingstationData.CompetitionData comp = td.getCompetition();
		TimingstationData.CompetitionData.Party[] party = comp.getParty();
		int laenge = party.length;
		for(int i=0; i<laenge; i++){
			int partyID = party[i].getPartyID();
			String timing = party[i].getTiming();
			daten += "<tr><td>"+partyID+"</td><td>"+timing+"</td></tr>";
		}
		return daten;
	}
}