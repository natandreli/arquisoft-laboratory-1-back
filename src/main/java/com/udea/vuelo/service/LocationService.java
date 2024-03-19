package com.udea.vuelo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.vuelo.model.Flight;
import com.udea.vuelo.model.Location;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Service class responsible for handling location-related operations.
 * It provides methods for retrieving information about locations.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
@Service
public class LocationService {
    private final String filePath = "flights.json"; // Path to the JSON file that contains the flight's information.

    /**
     * Reads flight data from a JSON file and returns a list of flights.
     *
     * @param filePath The path to the JSON file containing flight data.
     * @return A list of flights read from the JSON file.
     *         Returns null if the file is not found or cannot be read.
     * @throws RuntimeException If an error occurs while reading the file.
     */
    private List<Flight> readFile(String filePath) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

            if (inputStream != null) {
                Flight[] flights = objectMapper.readValue(inputStream, Flight[].class);
                return Arrays.asList(flights);
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading the file", e);
        }
    }

    /**
     * Retrieves a list of unique origin locations from the flight data.
     *
     * @return A list of Location objects representing unique origin locations.
     */
    public List<Location> getAllOriginLocations() {
        List<Flight> flights = readFile(filePath);

        if (flights == null) {
            return new ArrayList<>();
        }

        Set<String> uniqueOriginLocationNames = new HashSet<>();
        for (Flight flight : flights) {
            uniqueOriginLocationNames.add(flight.getOrigin());
        }

        List<Location> originLocations = new ArrayList<>();
        int id = 1;
        for (String originLocation : uniqueOriginLocationNames) {
            originLocations.add(new Location(id++, originLocation));
        }

        return originLocations;
    }

    /**
     * Retrieves a list of unique destination locations from the flight data.
     *
     * @return A list of Location objects representing unique destination locations.
     */
    public List<Location> getAllDestinationLocations() {
        List<Flight> flights = readFile(filePath);

        if (flights == null) {
            return new ArrayList<>();
        }

        Set<String> uniqueDestinationLocationNames = new HashSet<>();
        for (Flight flight : flights) {
            uniqueDestinationLocationNames.add(flight.getDestination());
        }

        List<Location> destinationLocations = new ArrayList<>();
        int id = 1;
        for (String destinationLocation : uniqueDestinationLocationNames) {
            destinationLocations.add(new Location(id++, destinationLocation));
        }

        return destinationLocations;
    }
}