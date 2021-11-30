package sectionpark.timingstation;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;
import sectionpark.model.TimingstationData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class TimingstationController {

    @Autowired
    private TimingstationService service;
	
    @RequestMapping("/")
    public String timingstationMain() {
    	String mainPage = "This is the timingstation application! (DEZSYS_MARATHON_REST) <br/><br/>" +
                          "<a href='http://localhost:8080/timingstation/001/data'>Link to timingstation/001/data</a><br/>" +
                          "<a href='http://localhost:8080/timingstation/001/xml'>Link to timingstation/001/xml</a><br/>" +
                          "<a href='http://localhost:8080/timingstation/001/consumer'>Link to timingstation/001/consumer</a><br/>" +
                          "<a href='http://localhost:8080/timingstation/001/transfer'>Link to timingstation/001/transfer</a><br/>";
        return mainPage;
    }
    
    @RequestMapping(value="/timingstation/{timingstationID}/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public TimingstationData timingstationData( @PathVariable String timingstationID ) {
        return service.getTimingstationData( timingstationID );
        //Diese Daten sollen sich beim Refreshen erweitern
    }

    @RequestMapping(value="/timingstation/{timingstationID}/xml",  produces = MediaType.APPLICATION_XML_VALUE)
    public TimingstationData timingstationXML( @PathVariable String timingstationID ){
        return service.getTimingstationData( timingstationID );
    } 

    @RequestMapping(value="/timingstation/{timingstationID}/consumer",  produces = MediaType.TEXT_HTML_VALUE)
    public String timingstationConsumer( @PathVariable String timingstationID ){
        return service.getHTMLData( timingstationID );
    }

    @RequestMapping("/timingstation/{timingstationID}/transfer")
    public String timingstationTransfer( @PathVariable String timingstationID ) {
        return service.getGreetings("Timingstation.Transfer!");
    } 
}