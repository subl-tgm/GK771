package sectionpark.timingstation;

import org.springframework.stereotype.Service;

import sectionpark.model.TimingstationData;

@Service
public class TimingstationService {
	
	public String getGreetings( String inModule ) {
        return "Greetings from " + inModule;
    }

    public TimingstationData getTimingstationData( String inTimingstationID ) {
    	
    	TimingstationSimulation simulation = new TimingstationSimulation();
        return simulation.getData( inTimingstationID );
        
    }
    
    public String getHTMLData( String inTimingstationID ) {
    	
    	TimingstationSimulation simulation = new TimingstationSimulation();
        TimingstationData td = simulation.getData( inTimingstationID );
        return simulation.htmlDaten( td );
        
    }
}