package com.udea.vuelo.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

import java.time.LocalDate;

/**
 * Represents a flight entity with its attributes such as id, airline, origin, destination,
 * price, departure date, and arrival date.
 * This class provides getters and setters for accessing and modifying the attributes.
 * Flight objects can be serialized and deserialized using JSON format.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
public class Flight {
    private int id; // The unique identifier of the flight.
    private String airline; // The name of the airline company operating the flight.
    private String origin; // The departure location of the flight.
    private String destination; // The arrival location of the flight.
    private int price; // The price of the flight ticket.
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate departureDate; // The date when the flight departs.
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate arrivalDate; // The date when the flight arrives.

    /**
     * Construct an empty Flight object.
     */
    public Flight() {
    }

    /**
     * Construct a Flight object with specified attributes.
     *
     * @param id The unique identifier of the flight.
     * @param airline The name of the airline company operating the flight.
     * @param origin The departure location of the flight.
     * @param destination The arrival location of the flight.
     * @param price The price of the flight ticket.
     * @param departureDate The date when the flight departs.
     * @param arrivalDate The date when the flight arrives.
     */
    public Flight(int id, String airline, String origin, String destination, int price, LocalDate departureDate, LocalDate arrivalDate) {
        this.id = id;
        this.airline = airline;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
    }

    /**
     * Retrieves the unique identifier of the flight.
     *
     * @return The id of the flight.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the flight.
     *
     * @param id The id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the airline company operating the flight.
     *
     * @return The name of the airline company operating the flight.
     */
    public String getAirline() {
        return airline;
    }

    /**
     * Sets the name of the airline company operating the flight.
     *
     * @param airline The name of the airline company to set.
     */
    public void setAirline(String airline) {
        this.airline = airline;
    }

    /**
     * Retrieves the departure location of the flight.
     *
     * @return The departure location of the flight.
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the departure location of the flight.
     *
     * @param origin The departure location to set.
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * Retrieves the arrival location of the flight.
     *
     * @return The arrival location of the flight.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the arrival location of the flight.
     *
     * @param destination The arrival location to set.
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Retrieves the price of the flight ticket.
     *
     * @return The price of the flight ticket.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets the price of the flight ticket.
     *
     * @param price The flight ticket price to set.
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Retrieves the date when the flight departs.
     *
     * @return The departure date of the flight.
     */
    public LocalDate getDepartureDate() {
        return departureDate;
    }

    /**
     * Sets the date when the flight departs.
     *
     * @param departureDate The departure date to set.
     */
    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * Retrieves the date when the flight arrives.
     *
     * @return The arrival date of the flight.
     */
    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Sets the date when the flight arrives.
     *
     * @param arrivalDate The arrival date to set.
     */
    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
