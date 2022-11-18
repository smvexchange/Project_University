package models;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class Statistics {
    @XmlElement(name = "universityProfile")
    @SerializedName("Profile")
    private StudyProfile profile;

    @XmlElement(name = "avgScore")
    @SerializedName("Average exam score")
    private float avrExamScore;

    @XmlTransient
    @SerializedName("Quantity of student by profile")
    private double quantityOfStudentByProfile;

    @XmlTransient
    @SerializedName("Quantity of university by profile")
    private double quantityOfUniversityByProfile;

    @XmlTransient
    @SerializedName("University name")
    private String universityName;

    public Statistics() {
    }

    public StudyProfile getProfile() {
        return profile;
    }

    public void setProfile(StudyProfile profile) {
        this.profile = profile;
    }

    public float getAvrExamScore() {
        return avrExamScore;
    }

    public void setAvrExamScore(float avrExamScore) {
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
