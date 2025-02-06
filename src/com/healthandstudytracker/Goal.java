package com.healthandstudytracker;

    public class Goal {
        private String description;
        private boolean achieved;

        public Goal(String description) {
            this.description = description;
            this.achieved = false;
        }

        public String getDescription() {
            return description;
        }

        public boolean isAchieved() {
            return achieved;
        }

        public void setAchieved(boolean achieved) {
            this.achieved = achieved;
        }
    }

