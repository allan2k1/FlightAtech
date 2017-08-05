package com.websystique.springmvc.controller;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springmvc.model.Flight;
import com.websystique.springmvc.service.FlightService;
 
@RestController
public class FlightRestController {
 
    @Autowired
    FlightService flightService;
 
    
//-------------------Retrieve All Flights--------------------------------------------------------
     
    @RequestMapping(value = "/flight/", method = RequestMethod.GET)
    public ResponseEntity<List<Flight>> listAllFlights() {
        List<Flight> flights = flightService.findAllFlights();
        if(flights.isEmpty()){
            return new ResponseEntity<List<Flight>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Flight>>(flights, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single Flight--------------------------------------------------------
     
    @RequestMapping(value = "/flight/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flight> getFlight(@PathVariable("id") long id) {
        System.out.println("Fetching Flight with id " + id);
        Flight flight = flightService.findById(id);
        if (flight == null) {
            System.out.println("Flight with id " + id + " not found");
            return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Flight>(flight, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a Flight--------------------------------------------------------
     
    @RequestMapping(value = "/flight/", method = RequestMethod.POST)
    public ResponseEntity<Void> createFlight(@RequestBody Flight flight,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Flight " + flight.getPilot());
 
        if (flightService.isFlightExist(flight)) {
            System.out.println("A Flight with name " + flight.getPilot() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
 
        flightService.saveFlight(flight);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/flight/{id}").buildAndExpand(flight.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a Flight --------------------------------------------------------
     
    @RequestMapping(value = "/flight/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Flight> updateFlight(@PathVariable("id") long id, @RequestBody Flight flight) {
        System.out.println("Updating Flight " + id);
         
        Flight currentFlight = flightService.findById(id);
         
        if (currentFlight==null) {
            System.out.println("Flight with id " + id + " not found");
            return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
        }
 
        currentFlight.setOrigin(flight.getOrigin());
        currentFlight.setDestination(flight.getDestination());
        currentFlight.setDepartDate(flight.getDepartDate());
        currentFlight.setReturnDate(flight.getReturnDate());
        currentFlight.setPilot(flight.getPilot());
        currentFlight.setAirplane(flight.getAirplane());
        currentFlight.setStatus(flight.getStatus());
         
        flightService.updateFlight(currentFlight);
        return new ResponseEntity<Flight>(currentFlight, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a Flight --------------------------------------------------------
     
    @RequestMapping(value = "/flight/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Flight> deleteFlight(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Flight with id " + id);
 
        Flight flight = flightService.findById(id);
        if (flight == null) {
            System.out.println("Unable to delete. Flight with id " + id + " not found");
            return new ResponseEntity<Flight>(HttpStatus.NOT_FOUND);
        }
 
        flightService.deleteFlightById(id);
        return new ResponseEntity<Flight>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Flights --------------------------------------------------------
     
    @RequestMapping(value = "/flight/", method = RequestMethod.DELETE)
    public ResponseEntity<Flight> deleteAllFlights() {
        System.out.println("Deleting All Flights");
 
        flightService.deleteAllFlights();
        return new ResponseEntity<Flight>(HttpStatus.NO_CONTENT);
    }
 
}