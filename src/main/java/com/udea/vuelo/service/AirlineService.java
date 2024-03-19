package com.udea.vuelo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.vuelo.model.Airline;
import com.udea.vuelo.model.Flight;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Service class responsible for handling airline-related operations.
 * It provides methods for retrieving information about airlines.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
@Service
public class AirlineService {
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
     * Retrieves a list of unique airlines from the flight data.
     *
     * @return A list of Airline objects representing unique airlines.
     */
    public List<Airline> getAllAirlines() {
        List<Flight> flights = readFile(filePath);

        if (flights == null) {
            return new ArrayList<>();
        }

        Set<String> uniqueAirlineNames = new HashSet<>();
        for (Flight flight : flights) {
            uniqueAirlineNames.add(flight.getAirline());
        }

        List<Airline> airlines = new ArrayList<>();
        int id = 1;
        for (String airlineName : uniqueAirlineNames) {
            airlines.add(new Airline(id++, airlineName));
        }

        return airlines;
    }
}