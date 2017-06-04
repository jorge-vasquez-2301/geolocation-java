package com.example.geolocation;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The GeolocationApp class.
 * @author Jorge Vasquez
 * @since 1.8
 */
public class GeolocationApp {

    private static final GeolocationApp GEOLOCATION_APP = new GeolocationApp();

    /**
     * @return the GeolocationApp
     */
    public static GeolocationApp getGeolocationApp() {
        return GEOLOCATION_APP;
    }

    /**
     * @param students   the students list
     * @param classrooms the classrooms list
     * @return the students that are in classes.
     */
    public List<Student> studentsInClasses(List<Student> students, List<Classroom> classrooms) {
        return students.stream().filter(student -> isStudentInClasses(student, classrooms)).collect(Collectors.toList());
    }

    /**
     * @param student    the student
     * @param classrooms the classrooms list
     * @return true if a student is in classes.
     */
    private boolean isStudentInClasses(Student student, List<Classroom> classrooms) {
        return classrooms.stream().anyMatch(classroom -> isStudentInClass(student, classroom));
    }

    /**
     * @param student   the student
     * @param classroom the classroom
     * @return true if a student is in in the classroom
     */
    private boolean isStudentInClass(Student student, Classroom classroom) {
        Coordinates classroomTopLeftCoordinates = classroom.getCornerCoordinates(Classroom.Corner.TOP_LEFT);
        Coordinates classroomBottomRightCoordinates = classroom.getCornerCoordinates(Classroom.Corner.BOTTOM_RIGHT);
        return (student.getLatitude() < classroomTopLeftCoordinates.getLatitude() &&
                student.getLongitude() > classroomTopLeftCoordinates.getLongitude() &&
                student.getLatitude() > classroomBottomRightCoordinates.getLatitude() &&
                student.getLongitude() < classroomBottomRightCoordinates.getLongitude());
    }
}
