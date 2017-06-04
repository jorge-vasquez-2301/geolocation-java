package com.example.geolocation;

/**
 * The Student class.
 * @author Jorge Vasquez
 * @since 1.8
 */
class Student extends AbstractEntity {

    /**
     * Creates a new instance of Student.
     * @param name        the student's name
     * @param coordinates the student's coordinates(latitude/longitude)
     */
    Student(String name, Coordinates coordinates) {
        super(name, coordinates);
    }
}
