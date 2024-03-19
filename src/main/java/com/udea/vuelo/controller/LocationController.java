package com.udea.vuelo.controller;

import com.udea.vuelo.model.Airline;
import com.udea.vuelo.model.Location;
import com.udea.vuelo.service.AirlineService;
import com.udea.vuelo.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class responsible for handling location-related HTTP requests.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
@RestController
@RequestMapping("/locations")
public class LocationController {

    @Autowired
    private LocationService locationService;

    /**
     * Handles GET requests to retrieve all the origin locations.
     *
     * @return ResponseEntity containing either a list of origin locations or an error message.
     */
    @GetMapping("/getAllOriginLocations")
    public ResponseEntity<?> getAllOriginLocations() {
        try {
            List<Location> originLocations = locationService.getAllOriginLocations();

            if (originLocations.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There are no origin locations available.");
            }

            return ResponseEntity.ok(originLocations);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the request.");
        }
    }

    /**
     * Handles GET requests to retrieve all the destination locations.
     *
     * @return ResponseEntity containing either a list of destination locations or an error message.
     */
    @GetMapping("/getAllDestinationLocations")
    public ResponseEntity<?> getAllDestinationLocations() {
        try {
            List<Location> destinationLocations = locationService.getAllDestinationLocations();

            if (destinationLocations.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There are no destination locations available.");
            }

            return ResponseEntity.ok(destinationLocations);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the request.");
        }
    }
}
