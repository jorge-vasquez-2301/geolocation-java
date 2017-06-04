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

    public static GeolocationApp getGeolocationApp() {
        return GEOLOCATION_APP;
    }

    public List<Student> studentsInClasses(List<Student> students, List<Classroom> classrooms) {
        return students.stream().filter(student -> isStudentInClasses(student, classrooms)).collect(Collectors.toList());
    }

    private boolean isStudentInClasses(Student student, List<Classroom> classrooms) {
        return classrooms.stream().anyMatch(classroom -> isStudentInClass(student, classroom));
    }

    private boolean isStudentInClass(Student student, Classroom classroom) {
        Coordinates classroomTopLeftCoordinates = classroom.getCornerCoordinates(Classroom.Corner.TOP_LEFT);
        Coordinates classroomBottomRightCoordinates = classroom.getCornerCoordinates(Classroom.Corner.BOTTOM_RIGHT);
        return (student.getLatitude() < classroomTopLeftCoordinates.getLatitude() &&
                student.getLongitude() > classroomTopLeftCoordinates.getLongitude() &&
                student.getLatitude() > classroomBottomRightCoordinates.getLatitude() &&
                student.getLongitude() < classroomBottomRightCoordinates.getLongitude());
    }
}
