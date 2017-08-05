package com.websystique.springmvc.service;

import java.util.List;

import com.websystique.springmvc.model.Flight;

public interface FlightService {
	
	Flight findById(long id);
	
	Flight findByName(String name);
	
	void saveFlight(Flight flight);
	
	void updateFlight(Flight flight);
	
	void deleteFlightById(long id);

	List<Flight> findAllFlights(); 
	
	void deleteAllFlights();
	
	public boolean isFlightExist(Flight flight);
	
}
