package com.healthandstudytracker;

import java.util.Scanner;

public class TrackPartner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student student = new Student("John Doe");

        // Load saved data when the program starts
        FileHandler.loadAcademicData(student);
        FileHandler.loadHealthData(student);

        while (true) {
            System.out.println("\n--- TrackPartner Menu ---");
            System.out.println("1. Academic Tracking");
            System.out.println("2. Health Monitoring");
            System.out.println("3. Goal Setting");
            System.out.println("4. Save Data");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    academicTracking(scanner, student); // Academic Tracking
                    break;

                case 2:
                    healthMonitoring(scanner, student); // Health Monitoring
                    break;

                case 3:
                    goalSetting(scanner, student); // Goal Setting
                    break;

                case 4:
                    saveData(student); // Save Data
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    return; // Exit the program

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Academic Tracking Functionality
    private static void academicTracking(Scanner scanner, Student student) {
        System.out.println("\n--- Academic Tracking ---");
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
    }

    // Health Monitoring Functionality
    private static void healthMonitoring(Scanner scanner, Student student) {
        System.out.println("\n--- Health Monitoring ---");
        HealthRecord healthRecord = student.getHealthRecord();

        System.out.print("Enter daily steps: ");
        int steps = readIntInput(scanner, "Enter daily steps: ");
        healthRecord.addSteps(steps);

        System.out.print("Enter sleep hours: ");
        int sleepHours = readIntInput(scanner, "Enter sleep hours: ");
        healthRecord.addSleepHours(sleepHours);

        System.out.print("Enter exercise duration (minutes): ");
        int exerciseDuration = readIntInput(scanner, "Enter exercise duration: ");
        healthRecord.addExerciseDuration(exerciseDuration);

        System.out.println("Health data logged successfully.");
    }

    // Goal Setting Functionality
    private static void goalSetting(Scanner scanner, Student student) {
        System.out.println("\n--- Goal Setting ---");
        System.out.print("Enter goal description: ");
        String goalDescription = scanner.nextLine();

        Goal goal = new Goal(goalDescription);
        student.getGoals().add(goal);

        System.out.println("Goal added successfully.");
    }

    // Save Data Functionality
    private static void saveData(Student student) {
        FileHandler.saveAcademicData(student);
        FileHandler.saveHealthData(student);
        System.out.println("Data saved successfully.");
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