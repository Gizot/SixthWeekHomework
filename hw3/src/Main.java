

import main.CourseGrade;
import main.GenerateTranscript;
import main.Transcript;
import util.Grade;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Öğrenci kimliğiyle bir Transcript nesnesi oluşturun
        Transcript transcript1 = new Transcript(1112234);

        // Dersleri ve notları temsil eden CourseGrade nesnelerini oluşturun
        CourseGrade course1 = new CourseGrade("CENG", 201, 5, Grade.C);
        CourseGrade course2 = new CourseGrade("CENG", 201, 5, Grade.A);
        CourseGrade course3 = new CourseGrade("CENG", 201, 5, Grade.C);
        CourseGrade course4 = new CourseGrade("CENG", 201, 5, Grade.A);
        CourseGrade course5 = new CourseGrade("CENG", 201, 5, Grade.B);

        // Dersleri Transcript nesnesine ekleyin
        transcript1.addCourseTaken(course1);
        transcript1.addCourseTaken(course2);
        transcript1.addCourseTaken(course3);
        transcript1.addCourseTaken(course4);
        transcript1.addCourseTaken(course5);

        // Transkripti göster
        System.out.println(transcript1.toString());

        Transcript transcript ;

        GenerateTranscript generateTranscript = new GenerateTranscript();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter '1' to take input from user or '2' to take input from a file:");
        // Kullanıcıdan seçim yapmasını isteriz
        int choice = scanner.nextInt();
        scanner.nextLine(); // Yeni satır karakterini tükettik.(nextInt() ardından nextLine() hatasını önlemek için)

        if (choice == 1) {
            // Kullanıcı 1 seçerse, kullanıcıdan veri alarak transkript oluştururuz
            transcript = generateTranscript.takeInputFromUser();
        } else if (choice == 2) {
            System.out.println("Enter filename (or 'endoffile' to finish):");
            // Kullanıcı 2 seçerse, dosya adını alırız
            String filename = scanner.nextLine();
            if (filename.equalsIgnoreCase("endoffile")) {
                // Eğer kullanıcı "endoffile" girerse, geçersiz dosya adı olduğunu belirtiriz ve programı sonlandırırız
                System.out.println("Invalid filename.");
                return;
            }
            // Dosyadan veri alarak transkript oluştururuz
            transcript = generateTranscript.takeInputFromFile(filename);
        } else {
            // Kullanıcı geçersiz bir seçim yaparsa, uygun mesajı gösterir ve programı sonlandırırız
            System.out.println("Invalid choice.");
            return;
        }

        // Oluşturulan transkript nesnesini ekrana yazdırırız (toString metodu otomatik olarak çağrılır)
        if (transcript != null) {
            System.out.println(transcript.toString());
        }


    }
}
