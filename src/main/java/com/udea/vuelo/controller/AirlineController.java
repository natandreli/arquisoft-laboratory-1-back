package com.udea.vuelo.controller;

import com.udea.vuelo.model.Airline;
import com.udea.vuelo.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class responsible for handling airline-related HTTP requests.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
@RestController
@RequestMapping("/airlines")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    /**
     * Handles GET requests to retrieve all the airlines.
     *
     * @return ResponseEntity containing either a list of airlines or an error message.
     */
    @GetMapping("/getAllAirlines")
    public ResponseEntity<?> getAllAirlines() {
        try {
            List<Airline> airlines = airlineService.getAllAirlines();

            if (airlines.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There are no airlines available.");
            }

            return ResponseEntity.ok(airlines);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the request.");
        }
    }
}
