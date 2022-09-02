package comparators.studentComparatorClasses;

import models.Student;

public class AvrExamScoreComparator implements IStudentComparator {
    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student1.getAvgExamScore(), student2.getAvgExamScore());
    }
}
