package com.example.geolocation;

/**
 * The Coordinates class.
 * @author Jorge Vasquez
 * @since 1.8
 */
public class Coordinates {

    private final double latitude;
    private final double longitude;

    /**
     * Creates a new instance of Coordinates.
     * @param latitude  the latitude in degrees
     * @param longitude the longitude in degrees
     */
    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * @return the latitude in degrees
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * @return the longitude in degrees
     */
    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Coordinates(" + latitude + ", " + longitude + ")";
    }
}
