package models;

import com.google.gson.annotations.SerializedName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
    @XmlElement(name = "studentName")
    @SerializedName("Full name")
    private String fullName;

    @XmlElement(name = "universityId")
    @SerializedName("University ID")
    private String universityId;

    @XmlTransient
    @SerializedName("Current course number")
    private double currentCourseNumber;

    @XmlElement(name = "avgScore")
    @SerializedName("Average exam score")
    private double avgExamScore;

    public Student() {
        this.fullName = "Иванов Иван Иванович";
        this.universityId = "0";
        this.currentCourseNumber = 1;
        this.avgExamScore = 5;
    }

    public Student(String fullName, String universityId, double currentCourseNumber, double avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public Student setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUniversityId() {
        return universityId;
    }

    public Student setUniversityId(String universityId) {
        this.universityId = universityId;
        return this;
    }

    public double getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public Student setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
        return this;
    }

    public double getAvgExamScore() {
        return avgExamScore;
    }

    public Student setAvgExamScore(double avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Double.compare(student.currentCourseNumber, currentCourseNumber) == 0 && Double.compare(student.avgExamScore, avgExamScore) == 0 && Objects.equals(fullName, student.fullName) && Objects.equals(universityId, student.universityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, universityId, currentCourseNumber, avgExamScore);
    }

    @Override
    public String toString() {
        return this.fullName + ", id: "
                + this.universityId + ", current course number: "
                + this.currentCourseNumber + ", exam score: "
                + this.avgExamScore + ".";
    }
}
