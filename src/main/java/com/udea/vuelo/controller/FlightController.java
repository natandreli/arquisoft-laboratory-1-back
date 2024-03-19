package com.udea.vuelo.controller;

import com.udea.vuelo.model.Flight;
import com.udea.vuelo.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * This class represents the controller for handling flight-related HTTP requests.
 * It maps incoming requests to methods for searching flights within a specified date range.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    /**
     * Handles GET requests to search for flights within the specified criteria.
     *
     * @param airline The airline of the flight for the search. Optional.
     * @param origin The departure location of the flight for the search. Optional.
     * @param destination The arrival location of the flight for the search. Optional.
     * @param startDate The start date (in yyyy-MM-dd format) of the departure date range for the search. Optional.
     * @param endDate The end date (in yyyy-MM-dd format) of the departure date range for the search. Optional.
     * @param lowerPrice The lower price bound of the flight for the search. Optional.
     * @param highestPrice The highest price bound of the flight for the search. Optional.
     * @return ResponseEntity containing either a list of flight dictionaries matching the specified criteria,
     *         INTERNAL_SERVER_ERROR if an error occurred while processing the request, or NOT_FOUND if no flights match
     *         the specified criteria.
     */
    @GetMapping("/searchFlights")
    public ResponseEntity<?> searchFlights(
            @RequestParam(name = "airline", required = false) String airline,
            @RequestParam(name = "origin", required = false) String origin,
            @RequestParam(name = "destination", required = false) String destination,
            @RequestParam(name = "startDate", required = false) String startDate,
            @RequestParam(name = "endDate", required = false) String endDate,
            @RequestParam(name = "lowerPrice", required = false) String lowerPrice,
            @RequestParam(name = "highestPrice", required = false) String highestPrice ){
        try {
            List<Flight> filteredFlights = flightService.searchFlights(airline, origin, destination, startDate, endDate,
                    lowerPrice, highestPrice);

            if (filteredFlights.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No flights found with the specified criteria.");
            }

            return ResponseEntity.ok(filteredFlights);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the request.");
        }
    }
}