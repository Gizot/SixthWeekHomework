package util;

public class GradeTest {
    public static void main(String[] args) {
        //Grade enum içindeki to string metot belirtildiği şekilde enumda toString metodu ile düzenlenerek
        //GradeTest sınıfı içerisinde toString ile çağırıldı.
        for (Grade grade : Grade.values()) {
            System.out.println(grade.toString());
        }
    }
}
