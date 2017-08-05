package com.websystique.springmvc.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.websystique.springmvc.model.Flight;

@Service("flightService")
public class FlightServiceImpl implements FlightService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Flight> flights;
	
	static{
		flights= populateDummyFlights();
	}

	public List<Flight> findAllFlights() {
		return flights;
	}
	
	public Flight findById(long id) {
		for(Flight flight : flights){
			if(flight.getId() == id){
				return flight;
			}
		}
		return null;
	}
	
	public Flight findByName(String name) {
		for(Flight flight : flights){
			if(flight.getPilot().equalsIgnoreCase(name)){
				return flight;
			}
		}
		return null;
	}
	
	public void saveFlight(Flight flight) {
		flight.setId(counter.incrementAndGet());
		flights.add(flight);
	}

	public void updateFlight(Flight flight) {
		int index = flights.indexOf(flight);
		flights.set(index, flight);
	}

	public void deleteFlightById(long id) {
		
		for (Iterator<Flight> iterator = flights.iterator(); iterator.hasNext(); ) {
		    Flight flight = iterator.next();
		    if (flight.getId() == id) {
		        iterator.remove();
		    }
		}
	}

	public boolean isFlightExist(Flight flight) {
		return findByName(flight.getPilot())!=null;
	}
	
	public void deleteAllFlights(){
		flights.clear();
	}

	private static List<Flight> populateDummyFlights(){
		List<Flight> flights = new ArrayList<Flight>();
		flights.add(new Flight(counter.incrementAndGet(), "16:45", "19:30", "SJC", "SP", "TAM", "Slash", "Flying"));
		return flights;
	}

}
