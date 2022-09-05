package models;

import enums.StudyProfile;

public class Statistics {
    private StudyProfile profile;
    private double avrExamScore;
    private double quantityOfStudentByProfile;
    private double quantityOfUniversityByProfile;
    private String universityName;

    public Statistics() {
    }

    public StudyProfile getProfile() {
        return profile;
    }

    public void setProfile(StudyProfile profile) {
        this.profile = profile;
    }

    public double getAvrExamScore() {
        return avrExamScore;
    }

    public void setAvrExamScore(double avrExamScore) {
        this.avrExamScore = avrExamScore;
    }

    public double getQuantityOfStudentByProfile() {
        return quantityOfStudentByProfile;
    }

    public void setQuantityOfStudentByProfile(double quantityOfStudentByProfile) {
        this.quantityOfStudentByProfile = quantityOfStudentByProfile;
    }

    public double getQuantityOfUniversityByProfile() {
        return quantityOfUniversityByProfile;
    }

    public void setQuantityOfUniversityByProfile(double quantityOfUniversityByProfile) {
        this.quantityOfUniversityByProfile = quantityOfUniversityByProfile;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
