package com.healthandstudytracker;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Subject> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}