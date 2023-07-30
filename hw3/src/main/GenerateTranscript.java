package main;

import main.CourseGrade;
import main.Transcript;
import util.Grade;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GenerateTranscript {

    // Method to take input from the user and create a transcript object
    public static Transcript takeInputFromUser() {
        // Kullanıcıdan veri almak için Scanner sınıfı kullanılır
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Student Id:");
        // Kullanıcıdan öğrenci kimliği alınır
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Yeni satır karakterini tüketir (nextInt() ardından nextLine() hatasını önlemek için)

        // Transkript nesnesi oluşturulur ve öğrenci kimliği ile başlatılır
        Transcript transcript = new Transcript(studentId);

        System.out.println("Enter Department (or press Ctrl+d/Cmd+D to finish):");

        while (scanner.hasNextLine()) {

            // Kullanıcıdan ders bölümü bilgisini alırız
            String department = scanner.nextLine();
            System.out.println("Departman adı : " + department);

            // Ctrl+D (Unix/Linux) veya Ctrl+Z (Windows) tuşlarına basıldığında döngüden çıkarız
            if (department == null || department.isEmpty()) {
                break;
            }

            // Kullanıcıdan ders kodunu, krediyi ve harf notunu alırız
            System.out.println("Enter Course Code:");
            int courseCode = scanner.nextInt();
            scanner.nextLine(); // Yeni satır karakterini tüketir

            System.out.println("Enter Credit:");
            int credit = scanner.nextInt();
            scanner.nextLine(); // Yeni satır karakterini tüketir

            System.out.println("Enter Grade (A, B, C, D, F):");
            String gradeString = scanner.nextLine().toUpperCase();

            Grade grade = Grade.F; // Default value (varsayılan değer)

            // Harf notunu Grade enum sabitine dönüştürürüz
            if (gradeString.equals("A")) {
                grade = Grade.A;
            } else if (gradeString.equals("B")) {
                grade = Grade.B;
            } else if (gradeString.equals("C")) {
                grade = Grade.C;
            } else if (gradeString.equals("D")) {
                grade = Grade.D;
            } else if (gradeString.equals("F")) {
                grade = Grade.F;
            }

            // CourseGrade nesnesini oluşturur ve transkript nesnesine ekleriz
            CourseGrade courseGrade = new CourseGrade(department, courseCode, credit, grade);
            transcript.addCourseTaken(courseGrade);
            System.out.println("Enter Department (or press Ctrl+D to finish):");
        }

        // Scanner kapatılır ve oluşturulan transkript nesnesi döndürülür
        scanner.close();
        return transcript;
    }

    // Method to take input from a text file and create a transcript object
    public static Transcript takeInputFromFile(String filename) {
        // Dosya işlemleri için File ve Scanner sınıflarını kullanırız
        File file = new File(filename + ".txt");
        Scanner scanner;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            // Dosya bulunamazsa hata mesajı verilir ve null döndürülür
            System.out.println("File not found.");
            return null;
        }

        // Dosyadan öğrenci kimliği alınır
        int studentId = scanner.nextInt();
        scanner.nextLine(); // Yeni satır karakterini tüketir

        // Transkript nesnesi oluşturulur ve öğrenci kimliği ile başlatılır
        Transcript transcript = new Transcript(studentId);

        while (scanner.hasNextLine()) {
            // Dosyada bir sonraki satır varsa, satırı alır ve boşluklara göre parçalara böleriz
            String lineData = scanner.nextLine();
            String[] tokens = lineData.split(" ");
            if (tokens.length == 4) {
                // Parçalardan bölüm, ders kodu, kredi ve harf notunu alırız
                String department = tokens[0];
                int courseCode = Integer.parseInt(tokens[1]);
                int credit = Integer.parseInt(tokens[2]);
                double grade = Double.valueOf(tokens[3]);

                // CourseGrade nesnesini oluşturur ve transkript nesnesine ekleriz
                CourseGrade courseGrade = new CourseGrade(department, courseCode, credit, grade);
                transcript.addCourseTaken(courseGrade);
            } else {
                System.out.println("Wrong file format ! Please check file format.");
            }
        }

        // Scanner kapatılır ve oluşturulan transkript nesnesi döndürülür
        scanner.close();
        return transcript;
    }

}

