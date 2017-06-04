package com.example.geolocation;

import org.apache.commons.math3.util.FastMath;

/**
 * The ClassroomCoordinatesCalculator class.
 * @author Jorge Vasquez
 * @since 1.8
 */
class ClassroomCoordinatesCalculator {

    private static final int EARTHS_RADIUS_IN_METERS = 6_371_000;
    private final Coordinates centerCoordinatesInRadians;
    private final double distanceFromCenterToCorner;

    /**
     * Creates a new instance of ClassroomCoordinatesCalculator.
     * @param classroomCoordinates the coordinates of the classroom
     */
    ClassroomCoordinatesCalculator(Coordinates classroomCoordinates) {
        centerCoordinatesInRadians = new Coordinates(FastMath.toRadians(classroomCoordinates.getLatitude()),
                                                     FastMath.toRadians(classroomCoordinates.getLongitude()));
        distanceFromCenterToCorner = FastMath.sqrt(2 * (Classroom.SIZE / 2) * (Classroom.SIZE / 2));
    }

    /**
     * Return the coordinates for a given corner.
     * @param corner the corner
     * @return corner's coordinates
     */
    Coordinates getCornerCoordinates(Classroom.Corner corner) {
        double bearingInRadians = FastMath.toRadians(corner.getBearingInDegrees());
        double sinOfLatitude = FastMath.sin(centerCoordinatesInRadians.getLatitude());
        double cosOfLatitude = FastMath.cos(centerCoordinatesInRadians.getLatitude());
        double sinOfDistanceEarthRadiusRatio = FastMath.sin(distanceFromCenterToCorner / EARTHS_RADIUS_IN_METERS);
        double cosOfDistanceEarthRadiusRatio = FastMath.cos(distanceFromCenterToCorner / EARTHS_RADIUS_IN_METERS);
        double sinOfBearing = FastMath.sin(bearingInRadians);
        double cosOfBearing = FastMath.cos(bearingInRadians);
        double latitudeInRadians = FastMath.asin(sinOfLatitude * cosOfDistanceEarthRadiusRatio +
                                                         cosOfLatitude * sinOfDistanceEarthRadiusRatio * cosOfBearing);
        double longitudeInRadians = centerCoordinatesInRadians.getLongitude() +
                FastMath.atan2(sinOfBearing * sinOfDistanceEarthRadiusRatio * cosOfLatitude,
                               cosOfDistanceEarthRadiusRatio - sinOfLatitude * FastMath.sin(latitudeInRadians));

        return new Coordinates(FastMath.toDegrees(latitudeInRadians), FastMath.toDegrees(longitudeInRadians));
    }
}
