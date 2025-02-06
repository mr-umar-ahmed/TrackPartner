package com.healthandstudytracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student("John Doe");

        // Load saved data when the program starts
        FileHandler.loadAcademicData(student);

        while (true) {
            System.out.println("\n--- Academic Tracker Menu ---");
            System.out.println("1. Add Grade and Study Hours");
            System.out.println("2. View Academic Progress");
            System.out.println("3. Save Data");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add grade and study hours
                    System.out.print("Enter subject name: ");
                    String subjectName = scanner.nextLine();

                    Subject subject = findSubject(student, subjectName);
                    if (subject == null) {
                        subject = new Subject(subjectName);
                        student.getSubjects().add(subject);
                    }

                    System.out.print("Enter grade: ");
                    int grade = readIntInput(scanner, "Enter grade: ");
                    subject.addGrade(grade);

                    System.out.print("Enter study hours: ");
                    int studyHours = readIntInput(scanner, "Enter study hours: ");
                    subject.addStudyHours(studyHours);

                    System.out.println("Data logged successfully.");
                    break;

                case 2:
                    // View academic progress
                    System.out.println("\n--- Academic Progress ---");
                    for (Subject s : student.getSubjects()) {
                        System.out.println("com.healthandstudytracker.Subject: " + s.getName());
                        System.out.println("Grades: " + s.getGrades());
                        System.out.println("Average Grade: " + s.getAverageGrade());
                        System.out.println("Total Study Hours: " + s.getTotalStudyHours());
                        System.out.println();
                    }
                    break;

                case 3:
                    // Save data
                    FileHandler.saveAcademicData(student);
                    System.out.println("Data saved successfully.");
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Exiting program...");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Helper method to find a subject by name
    private static Subject findSubject(Student student, String subjectName) {
        for (Subject subject : student.getSubjects()) {
            if (subject.getName().equalsIgnoreCase(subjectName)) {
                return subject;
            }
        }
        return null;
    }

    // Helper method to read integer input with validation
    private static int readIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
    }
}