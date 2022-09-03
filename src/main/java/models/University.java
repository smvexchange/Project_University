package models;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

import java.util.Objects;

public class University {
    @SerializedName("ID")
    private String id;
    @SerializedName("Full name")
    private String fullName;
    @SerializedName("Short name")
    private String shortName;
    @SerializedName("Year of foundation")
    private int yearOfFoundation;
    @SerializedName("Main profile")
    private StudyProfile mainProfile;

    public University() {
        this.id = "#1";
        this.fullName = "Lomonosov Moscow State models.University ";
        this.shortName = "MSU";
        this.yearOfFoundation = 1755;
        this.mainProfile = StudyProfile.JOURNALISM;
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public University setId(String id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public University setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getShortName() {
        return shortName;
    }

    public University setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public University setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
        return this;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public University setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return yearOfFoundation == that.yearOfFoundation && Objects.equals(id, that.id) && Objects.equals(fullName, that.fullName) && Objects.equals(shortName, that.shortName) && mainProfile == that.mainProfile;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, shortName, yearOfFoundation, mainProfile);
    }

    @Override
    public String toString() {
        return this.id + ", "
                + this.fullName + "("
                + this.shortName + "), year of foundation: "
                + this.yearOfFoundation + ", main profile: "
                + this.mainProfile + ".";
    }
}
