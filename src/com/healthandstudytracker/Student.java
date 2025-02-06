package com.healthandstudytracker;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Subject> subjects; // Academic tracking
    private HealthRecord healthRecord; // Health monitoring
    private List<Goal> goals; // Shared feature

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
        this.healthRecord = new HealthRecord();
        this.goals = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public HealthRecord getHealthRecord() {
        return healthRecord;
    }

    public List<Goal> getGoals() {
        return goals;
    }
}