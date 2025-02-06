package com.healthandstudytracker;

import java.io.*;

public class FileHandler {

    // Method to save academic data to a file
    public static void saveAcademicData(Student student) {
        try (FileWriter writer = new FileWriter("data/academic_data.txt")) {
            for (Subject subject : student.getSubjects()) {
                writer.write("com.healthandstudytracker.Subject: " + subject.getName() + "\n");
                writer.write("Grades: " + subject.getGrades() + "\n");
                writer.write("Total Study Hours: " + subject.getTotalStudyHours() + "\n");
                writer.write("\n");
            }
            System.out.println("Academic data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving academic data.");
        }
    }

    // Method to load academic data from a file
    public static void loadAcademicData(Student student) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/academic_data.txt"))) {
            String line;
            Subject currentSubject = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("com.healthandstudytracker.Subject: ")) {
                    String subjectName = line.replace("com.healthandstudytracker.Subject: ", "");
                    currentSubject = new Subject(subjectName);
                    student.getSubjects().add(currentSubject);
                } else if (line.startsWith("Grades: ")) {
                    String gradesString = line.replace("Grades: ", "");
                    String[] gradeStrings = gradesString.replaceAll("[\\[\\]]", "").split(", ");
                    for (String gradeString : gradeStrings) {
                        if (!gradeString.isEmpty()) {
                            currentSubject.addGrade(Integer.parseInt(gradeString));
                        }
                    }
                } else if (line.startsWith("Total Study Hours: ")) {
                    int studyHours = Integer.parseInt(line.replace("Total Study Hours: ", ""));
                    currentSubject.addStudyHours(studyHours);
                }
            }
            System.out.println("Academic data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading academic data.");
        }
    }
}