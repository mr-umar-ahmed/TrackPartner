package com.healthandstudytracker;

public class HealthRecord {
    private int dailySteps;
    private int sleepHours;
    private int exerciseDuration; // In minutes

    public HealthRecord() {
        this.dailySteps = 0;
        this.sleepHours = 0;
        this.exerciseDuration = 0;
    }

    public void addSteps(int steps) {
        dailySteps += steps;
    }

    public void addSleepHours(int hours) {
        sleepHours += hours;
    }

    public void addExerciseDuration(int minutes) {
        exerciseDuration += minutes;
    }

    // Getters
    public int getDailySteps() {
        return dailySteps;
    }

    public int getSleepHours() {
        return sleepHours;
    }

    public int getExerciseDuration() {
        return exerciseDuration;
    }
}