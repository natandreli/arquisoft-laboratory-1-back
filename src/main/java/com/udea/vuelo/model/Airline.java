package com.udea.vuelo.model;

/**
 * Represents an airline entity with its attributes such as id and name.
 * This class provides constructors, getters, and setters for accessing and modifying the attributes.
 * Airline objects are used to represent airline information within the flight application.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
public class Airline {
    private int id; // The unique identifier of the airline.
    private String name; // The name of the airline.

    /**
     * Constructs an empty Airline object.
     */
    public Airline() {
    }

    /**
     * Constructs an Airline object with specified attributes.
     *
     * @param id The unique identifier of the airline.
     * @param name The name of the airline.
     */
    public Airline(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Retrieves the unique identifier of the airline.
     *
     * @return The id of the airline.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the airline.
     *
     * @param id The id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the airline.
     *
     * @return The name of the airline.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the airline.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}