package comparators.studentComparatorClasses;

import models.Student;

public class CourseNumberComparator implements IStudentComparator {
    @Override
    public int compare(Student student1, Student student2) {
        return Double.compare(student1.getCurrentCourseNumber(), student2.getCurrentCourseNumber());
    }
}
