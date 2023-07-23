package main;


import java.util.ArrayList;

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
            double gradeTotal = 0;

            //Ögrencinin aldıgı dersleri tek tek dolastık
            for (CourseGrade courseGrade1 : this.courseGrades) {

                //Bu satırda, her bir dersin aldığı notun sayısal değeri, toplam notlara eklendi.
                gradeTotal += (double) courseGrade1.getGradeTaken().getNumericValue() /
                        (double) this.courseGrades.size();


            }
            //GPA alanına, hesaplanan toplam notlar atandı.
            this.GPA = gradeTotal;
        }else {
            System.out.println("Hata!: CourseGrade nesnesi null olamaz.");
        }
    }

    private void updateGPA() {
        double totalNumericGrade = 0;
        int totalCredits = 0;

        for (CourseGrade courseGrade : courseGrades) {
            totalNumericGrade += courseGrade.getGradeTaken().getNumericValue() * courseGrade.getCourseCredit();
            totalCredits += courseGrade.getCourseCredit();
        }

        if (totalCredits > 0) {
            GPA = totalNumericGrade / totalCredits;
        } else {
            GPA = 0.0;
        }
    }
    @Override
    public String toString() {
        StringBuilder transcriptString = new StringBuilder();
        transcriptString.append("Student ID: ").append(studentId).append("\n");

        for (CourseGrade courseGrade : courseGrades) {
            transcriptString.append(courseGrade.toString()).append("\n");
        }

        transcriptString.append("GPA: ").append(String.format("%.1f", GPA)).append("\n");

        return transcriptString.toString();

    }

}

