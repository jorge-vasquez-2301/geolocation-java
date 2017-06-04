package com.example.geolocation;

import java.util.HashMap;
import java.util.Map;

/**
 * The Classroom class.
 * @author Jorge Vasquez
 * @since 1.8
 */
public class Classroom extends Entity {

    public static final int SIZE = 20;

    private final Map<Corner, Coordinates> cornerCoordinatesMap;

    /**
     * Creates a new instance of classroom.
     * @param name        the classroom's name
     * @param coordinates the classroom's coordinates(latitude/longitude)
     */
    Classroom(String name, Coordinates coordinates) {
        super(name, coordinates);
        cornerCoordinatesMap = new HashMap<>();
        ClassroomCoordinatesCalculator classroomCoordinatesCalculator = new ClassroomCoordinatesCalculator(coordinates);
        cornerCoordinatesMap.put(Corner.TOP_LEFT, classroomCoordinatesCalculator.getCornerCoordinates(Corner.TOP_LEFT));
        cornerCoordinatesMap.put(Corner.BOTTOM_RIGHT, classroomCoordinatesCalculator.getCornerCoordinates(Corner.BOTTOM_RIGHT));
    }

    /**
     * Returns the coordinates for a given corner.
     * @param corner the corner of the classroom
     * @return corner's coordinates
     */
    public Coordinates getCornerCoordinates(Corner corner) {
        return cornerCoordinatesMap.get(corner);
    }

    /**
     * The Corner enum.
     */
    public enum Corner {
        TOP_LEFT        (315),
        BOTTOM_RIGHT    (135);

        /** The bearingInDegrees. */
        final int bearingInDegrees;

        Corner(int bearingInDegrees) {
            this.bearingInDegrees = bearingInDegrees;
        }

        /**
         * @return the bearingInDegrees
         */
        public int getBearingInDegrees() {
            return bearingInDegrees;
        }
    }
}
