package com.healthandstudytracker;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private String name;
    private List<Integer> grades; // List of grades for the subject
    private int totalStudyHours;

    public Subject(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
        this.totalStudyHours = 0;
    }

    // Add a grade
    public void addGrade(int grade) {
        grades.add(grade);
    }

    // Add study hours
    public void addStudyHours(int hours) {
        totalStudyHours += hours;
    }

    // Calculate average grade
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public int getTotalStudyHours() {
        return totalStudyHours;
    }
}