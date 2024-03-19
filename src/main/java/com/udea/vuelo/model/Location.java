package com.udea.vuelo.model;

/**
 * Represents a location entity with its attributes such as id and name.
 * This class provides constructors, getters, and setters for accessing and modifying the attributes.
 * Location objects are used to represent origin and destination information within the flight application.
 *
 * @author Natalia García
 * @author Héctor Güiza
 * @author Jeisson Barrantes
 * @author Hellen Rubio
 */
public class Location {
    private int id; // The unique identifier of the location.
    private String name; // The name of the location.

    /**
     * Constructs an empty Location object.
     */
    public Location() {
    }

    /**
     * Constructs a Location object with specified attributes.
     *
     * @param id The unique identifier of the location.
     * @param name The name of the location.
     */
    public Location(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Retrieves the unique identifier of the location.
     *
     * @return The id of the location.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the location.
     *
     * @param id The id to set.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retrieves the name of the location.
     *
     * @return The name of the location.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the location.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}