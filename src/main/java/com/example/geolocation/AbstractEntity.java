package com.example.geolocation;

/**
 * The AbstractEntity class.
 * @author Jorge Vasquez
 * @since 1.8
 */
class AbstractEntity {

    private final String name;
    private final Coordinates coordinates;

    /**
     * Constructor for AbstractEntity.
     * @param name        the entity's name
     * @param coordinates the entity's coordinates(latitude/longitude)
     */
    AbstractEntity(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    /**
     * @return the entity's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the entity's coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * @return the entity's latitude in degrees
     */
    public double getLatitude() {
        return coordinates.getLatitude();
    }

    /**
     * @return the entity's longitude in degrees
     */
    public double getLongitude() {
        return coordinates.getLongitude();
    }
}
