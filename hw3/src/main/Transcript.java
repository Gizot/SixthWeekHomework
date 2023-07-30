package main;


import java.util.ArrayList;
import java.util.Locale;

public class Transcript {
    private int studentId;
    private ArrayList<CourseGrade> courseGrades;
    private double GPA;

    //constructor (yapıcı metot) oluşturuldu.
    public Transcript(int studentId) {
        this.studentId = studentId;
        this.GPA = 0;
        this.courseGrades = new ArrayList<>();
    }



    public void addCourseTaken(CourseGrade courseGrade) {
        if(courseGrade != null){
            this.courseGrades.add(courseGrade);
            updateGPA();
        } else {
            System.out.println("Hata!: CourseGrade nesnesi null olamaz.");
        }
    }

    private void updateGPA() {
        double totalNumericGrade = 0;
        int totalCredits = 0;

            //Ögrencinin aldıgı dersleri tek tek dolastık
            for (CourseGrade courseGrade : courseGrades) {

                //Bu satırda, her bir dersin aldığı notun sayısal değeri, toplam notlara eklendi.
                totalNumericGrade += courseGrade.getGradeTaken().getNumericValue() * courseGrade.getCourseCredit();
                totalCredits += courseGrade.getCourseCredit();
            }
        if (totalCredits > 0) {
            GPA = totalNumericGrade / totalCredits;
        } else {
            GPA = 0.0;
        }


    }




    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student ID: ").append(this.studentId).append("\n");

        for (CourseGrade courseGrade : this.courseGrades) {
            sb.append(courseGrade.toString()).append("\n");
        }

        sb.append("GPA: ").append(this.GPA).append("\n");
        return sb.toString();
    }
}



