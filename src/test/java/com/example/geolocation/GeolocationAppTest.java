package com.example.geolocation;


import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GeolocationAppTest {

    private final GeolocationApp geolocationApp = GeolocationApp.getGeolocationApp();
    private static List<Classroom> classrooms;

    @BeforeClass
    public static void setup() {
        classrooms = Arrays.asList(new Classroom("Principles of computational geo-location analysis",
                                                 new Coordinates(34.069140, -118.442689)),
                                   new Classroom("Sedimentary Petrology",
                                                 new Coordinates(34.069585, -118.441878)),
                                   new Classroom("Introductory Psychobiology",
                                                 new Coordinates(34.069742, -118.441312)),
                                   new Classroom("Art of Listening",
                                                 new Coordinates(34.070223, -118.440193)),
                                   new Classroom("Art Hitory",
                                                 new Coordinates(34.071528, -118.441211)));
    }

    @Test
    public void testAllStudentsInClasses() {
        List<Student> students = Arrays.asList(new Student("John Wilson", new Coordinates(34.069149, -118.442639)),
                                               new Student("Jane Graham", new Coordinates(34.069601, -118.441862)),
                                               new Student("Pam Bam", new Coordinates(34.071513, -118.441181)));

        assertThat(geolocationApp.studentsInClasses(students, classrooms), containsInAnyOrder(students.toArray()));

    }

    @Test
    public void testOneStudentInClasses() {
        List<Student> students = Arrays.asList(new Student("John Wilson", new Coordinates(34.069849, -118.443539)),
                                               new Student("Jane Graham", new Coordinates(34.069901, -118.441562)),
                                               new Student("Pam Bam", new Coordinates(34.071523, -118.441171)));

        assertThat(geolocationApp.studentsInClasses(students, classrooms), hasSize(1));
        assertThat(geolocationApp.studentsInClasses(students, classrooms), contains(students.get(2)));

    }

    @Test
    public void testNoStudentInClasses() {
        List<Student> students = Arrays.asList(new Student("John Wilson", new Coordinates(35.069849, -118.443539)),
                                               new Student("Jane Graham", new Coordinates(35.069901, -118.441562)),
                                               new Student("Pam Bam", new Coordinates(35.071523, -118.441171)));

        assertThat(geolocationApp.studentsInClasses(students, classrooms), empty());
    }
}
