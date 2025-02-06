package com.healthandstudytracker;

import java.io.*;
import java.util.List;

public class FileHandler {

    // Save academic data
    public static void saveAcademicData(Student student) {
        try (FileWriter writer = new FileWriter("data/academic_data.txt")) {
            for (Subject subject : student.getSubjects()) {
                writer.write("Subject: " + subject.getName() + "\n");
                writer.write("Grades: " + subject.getGrades() + "\n");
                writer.write("Total Study Hours: " + subject.getTotalStudyHours() + "\n");
                writer.write("\n");
            }
            System.out.println("Academic data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving academic data.");
        }
    }

    // Load academic data
    public static void loadAcademicData(Student student) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/academic_data.txt"))) {
            String line;
            Subject currentSubject = null;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Subject: ")) {
                    String subjectName = line.replace("Subject: ", "").trim();
                    currentSubject = new Subject(subjectName);
                    student.getSubjects().add(currentSubject);
                } else if (line.startsWith("Grades: ") && currentSubject != null) {
                    String gradesString = line.replace("Grades: ", "");
                    String[] gradeStrings = gradesString.replaceAll("[\\[\\]]", "").split(", ");
                    for (String gradeString : gradeStrings) {
                        if (!gradeString.isEmpty()) {
                            currentSubject.addGrade(Integer.parseInt(gradeString.trim()));
                        }
                    }
                } else if (line.startsWith("Total Study Hours: ") && currentSubject != null) {
                    int studyHours = Integer.parseInt(line.replace("Total Study Hours: ", "").trim());
                    currentSubject.addStudyHours(studyHours);
                }
            }
            System.out.println("Academic data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading academic data.");
        }
    }

    // Save health data
    public static void saveHealthData(Student student) {
        try (FileWriter writer = new FileWriter("data/health_data.txt")) {
            HealthRecord healthRecord = student.getHealthRecord();
            writer.write("Daily Steps: " + healthRecord.getDailySteps() + "\n");
            writer.write("Sleep Hours: " + healthRecord.getSleepHours() + "\n");
            writer.write("Exercise Duration: " + healthRecord.getExerciseDuration() + "\n");
            System.out.println("Health data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving health data.");
        }
    }

    // Load health data
    public static void loadHealthData(Student student) {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/health_data.txt"))) {
            String line;
            HealthRecord healthRecord = student.getHealthRecord();
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Daily Steps: ")) {
                    healthRecord.addSteps(Integer.parseInt(line.replace("Daily Steps: ", "").trim()));
                } else if (line.startsWith("Sleep Hours: ")) {
                    healthRecord.addSleepHours(Integer.parseInt(line.replace("Sleep Hours: ", "").trim()));
                } else if (line.startsWith("Exercise Duration: ")) {
                    healthRecord.addExerciseDuration(Integer.parseInt(line.replace("Exercise Duration: ", "").trim()));
                }
            }
            System.out.println("Health data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading health data.");
        }
    }
}