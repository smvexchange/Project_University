public class Student {
    private String fullName;
    private String universityId;
    private double currentCourseNumber;
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
    public String toString() {
        return this.fullName + ", id: "
                + this.universityId + ", current course number: "
                + this.currentCourseNumber + ", exam score: "
                + this.avgExamScore + ".";
    }
}
