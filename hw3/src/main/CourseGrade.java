package main;


import util.Grade;

public class CourseGrade {
    private String courseDepartment;
    private int courseCode;
    private int courseCredit;
    private Grade gradeTaken;

    //İç içe constructor kullanılarak dört adet constructor oluşturulmuş
    // ve set metotları gerekli kontrolleri yapacak şekilde düzenlenmiştir

    //Aşağıda CourseGrade sınıfında bulunan yapılandırıcılarda
    // constructer chain kullanılmıştır. Her bir yapılandırıcı,
    // daha fazla parametre alan yapılandırıcıyı this anahtar kelimesi
    // ile çağırarak kullanır. En sonunda tüm alanların değerleri belirlenmiş olan yapılandırıcı,
    // işlemi tamamlar ve nesneyi oluşturur.
    public CourseGrade(String courseDepartment) {
        this(courseDepartment, 100, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode) {
        this(courseDepartment, courseCode, 4, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit) {
        this(courseDepartment, courseCode, courseCredit, Grade.F);
    }

    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, Grade gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }
    public CourseGrade(String courseDepartment, int courseCode, int courseCredit, double gradeTaken) {
        setCourseDepartment(courseDepartment);
        setCourseCode(courseCode);
        setCourseCredit(courseCredit);
        setGradeTaken(gradeTaken);
    }

    public String getCourseDepartment() {
        return courseDepartment;
    }

    public void setCourseDepartment(String courseDepartment) {
        String[] validValues = {"CENG", "COMP", "ECE", "ME", "MATH"};
        for (int i = 0; i < validValues.length; i++) {
            if (courseDepartment.toUpperCase().equals(validValues[i])) {
                this.courseDepartment = courseDepartment;
                return;
            }
        }
        this.courseDepartment = "CENG";
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        if (courseCode >= 100 && courseCode <= 599) {
            this.courseCode = courseCode;

        } else {
            this.courseCode = 100; // Default value
        }
    }

    public int getCourseCredit() {
        return courseCredit;
    }


    //Bir ders yalnızca 3 ya da 4 kredili olabilir
    //Eğer bunlardan birine sahip değilse default olarak 4 kredi atanır.
    public void setCourseCredit(int courseCredit) {
        if (courseCredit == 3 || courseCredit == 4) {
            this.courseCredit = courseCredit;
            return;
        } else {
            this.courseCredit = 4; // Default value
        }
    }

    public Grade getGradeTaken() {
        return gradeTaken;
    }

    public void setGradeTaken(double val) {
        //val değeri 0 ile 4 arasında mı kontrolü yapılır,
        // değilse varsayılan değer olarak F verilir.
        if (val >= 0 && val <= 4.0) {
            //0 ile 4 arasındaysa Math kütüphanesinin round özelliği
            // ile en yakın sayıya yuvarlama işlemi gerçekleştirilir.
            int gradeVal = (int) Math.round(val);
            switch (gradeVal) {
                //Yuvarlanan değer hangi harf notuna denk geliyorsa
                //bu belirlenir ve gradeTaken alanına atanır.
                case 4:
                    this.gradeTaken = Grade.A;
                    break;
                case 3:
                    this.gradeTaken = Grade.B;
                    break;
                case 2:
                    this.gradeTaken = Grade.C;
                    break;
                case 1:
                    this.gradeTaken = Grade.D;
                    break;
                default:
                    this.gradeTaken = Grade.F;
                    break;
            }
        } else {
            this.gradeTaken = Grade.F; // Default value
        }
    }

    public void setGradeTaken(Grade grade) {
        this.gradeTaken = grade;
    }

    //toString() metodu, belirtilen formatı kullanarak CourseGrade
    // nesnesinin bilgilerini döndürecek şekilde implemente edilmiştir

    @Override
    public String toString() {
        return "Department: " + this.courseDepartment +
                " Code: " + this.courseCode +
                " Credit: " + this.courseCredit +
                " Grade: " + this.gradeTaken.getStringValue();
    }

}