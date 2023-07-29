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
            System.out.println("DEBUG: Department input: " + department);

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
        File file = new File(filename);
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
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            if (tokens.length == 4) {
                // Parçalardan bölüm, ders kodu, kredi ve harf notunu alırız
                String department = tokens[0];
                int courseCode = Integer.parseInt(tokens[1]);
                int credit = Integer.parseInt(tokens[2]);
                String gradeString = tokens[3].toUpperCase();

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
            }
        }

        // Scanner kapatılır ve oluşturulan transkript nesnesi döndürülür
        scanner.close();
        return transcript;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter '1' to take input from user or '2' to take input from a file:");
        // Kullanıcıdan seçim yapmasını isteriz
        int choice = scanner.nextInt();
        scanner.nextLine(); // Yeni satır karakterini tüketir (nextInt() ardından nextLine() hatasını önlemek için)

        Transcript transcript;

        if (choice == 1) {
            // Kullanıcı 1 seçerse, kullanıcıdan veri alarak transkript oluştururuz
            transcript = takeInputFromUser();
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
            transcript = takeInputFromFile(filename);
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

