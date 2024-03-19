package com.udea.vuelo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.vuelo.model.Flight;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This class represents the service layer for handling flight-related operations.
 * It provides methods for searching flights within a specified date range.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
@Service
public class FlightService {

    private final String filePath = "flights.json"; // Path to the JSON file that contains the flight's information.

    /**
     * Reads flight data from a JSON file and returns a list of flight lists.
     *
     * @param filePath The path to the JSON file containing flight data.
     * @return A list of flights read from the JSON file.
     *         Returns null if the file is not found or cannot be read.
     * @throws RuntimeException If an error occurs while reading the file.
     */
    private List<Flight> readFile(String filePath)
    {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(filePath);

            if(inputStream != null) {
                Flight[] flights = objectMapper.readValue(inputStream, Flight[].class);
                return Arrays.asList(flights);
            } else {
                return null;
            }
        } catch(IOException e) {
            throw new RuntimeException("Error reading the file", e);
        }
    }

    /**
     * Checks if a date falls within a specified range.
     *
     * @param dateToCheck The date to check.
     * @param startDate The start date of the range.
     * @param endDate The end date of the range.
     * @return true if the date is within the range, false otherwise.
     * @throws IllegalArgumentException If the provided start and end dates are not valid date formats (yyyy-MM-dd).
     */
    private boolean isDateInRange(LocalDate dateToCheck, String startDate, String endDate) {
        try {
            if (!startDate.isEmpty() && !endDate.isEmpty()) {
                LocalDate start = LocalDate.parse(startDate);
                LocalDate end = LocalDate.parse(endDate);
                return (dateToCheck.isEqual(start) || dateToCheck.isAfter(start)) && (dateToCheck.isEqual(end) || dateToCheck.isBefore(end));
            } else if (!startDate.isEmpty()) {
                LocalDate start = LocalDate.parse(startDate);
                return dateToCheck.isEqual(start) || dateToCheck.isAfter(start);
            } else if (!endDate.isEmpty()) {
                LocalDate end = LocalDate.parse(endDate);
                return dateToCheck.isEqual(end) || dateToCheck.isBefore(end);
            }
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please provide dates in yyyy-MM-dd format.", e);
        }

        return false;
    }

    /**
     * Checks if a date falls within a specified range.
     *
     * @param priceToCheck The price to check.
     * @param lowerPrice The lower price of the range.
     * @param highestPrice The highest price of the range.
     * @return true if the price is within the range, false otherwise.
     * @throws IllegalArgumentException If the provided price range values are invalid numeric values.
     */
    private boolean isPriceInRange(int priceToCheck, String lowerPrice, String highestPrice) {
        try {
            if (!lowerPrice.isEmpty() && !highestPrice.isEmpty()) {
                int lower = Integer.parseInt(lowerPrice);
                int highest = Integer.parseInt(highestPrice);
                return priceToCheck >= lower && priceToCheck <= highest;
            } else if (!lowerPrice.isEmpty()) {
                int lower = Integer.parseInt(lowerPrice);
                return priceToCheck >= lower;
            } else if (!highestPrice.isEmpty()) {
                int highest = Integer.parseInt(highestPrice);
                return priceToCheck <= highest;
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format. Please provide a valid numeric value.", e);
        }

        return false;
    }


    /**
     * Searches for flights based on specified criteria.
     *
     * @param airline The airline of the flight for the search. Optional.
     * @param origin The departure location of the flight for the search. Optional.
     * @param destination The arrival location of the flight for the search. Optional.
     * @param startDate The start date (in yyyy-MM-dd format) of the departure date range for the search. Optional.
     * @param endDate The end date (in yyyy-MM-dd format) of the departure date range for the search. Optional.
     * @param lowerPrice The optional lower price bound for the search. Optional.
     * @param highestPrice The optional highest price bound for the search. Optional.
     * @return A list of flight dictionaries matching the specified criteria.
     *         Each dictionary contains information about a flight operated according to the specified criteria.
     * @throws RuntimeException If an error occurs while filtering flights based on the specified criteria.
     */
    public List<Flight> searchFlights(String airline, String origin, String destination, String startDate, String endDate,
                                      String lowerPrice, String highestPrice) {
        try {
            List<Flight> flights = readFile("flights.json");
            if (flights != null) {
                return flights.stream()
                        .filter(flight -> (airline.isEmpty() || flight.getAirline().equalsIgnoreCase(airline)) &&
                                (origin.isEmpty() || flight.getOrigin().equalsIgnoreCase(origin)) &&
                                (destination.isEmpty() || flight.getDestination().equalsIgnoreCase(destination)) &&
                                (highestPrice.isEmpty() && lowerPrice.isEmpty() || isPriceInRange(flight.getPrice(), lowerPrice, highestPrice)) &&
                                (startDate.isEmpty() && endDate.isEmpty() || isDateInRange(flight.getDepartureDate(), startDate, endDate))
                        )
                        .collect(Collectors.toList());
            } else {
                return Collections.emptyList();
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("Error filtering the flights by the specified criteria.", e);
        }
    }
}
