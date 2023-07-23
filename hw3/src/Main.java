package main;

import util.Grade;

public class Main {
    public static void main(String[] args) {
        // Öğrenci kimliğiyle bir Transcript nesnesi oluşturun
        Transcript transcript = new Transcript(1112234);

        // Dersleri ve notları temsil eden CourseGrade nesnelerini oluşturun
        CourseGrade course1 = new CourseGrade("CENG", 201, 5, Grade.C);
        CourseGrade course2 = new CourseGrade("CENG", 201, 5, Grade.A);
        CourseGrade course3 = new CourseGrade("CENG", 201, 5, Grade.C);
        CourseGrade course4 = new CourseGrade("CENG", 201, 5, Grade.A);
        CourseGrade course5 = new CourseGrade("CENG", 201, 5, Grade.B);

        // Dersleri Transcript nesnesine ekleyin
        transcript.addCourseTaken(course1);
        transcript.addCourseTaken(course2);
        transcript.addCourseTaken(course3);
        transcript.addCourseTaken(course4);
        transcript.addCourseTaken(course5);

        // Transkripti göster
        System.out.println(transcript.toString());
    }
}
